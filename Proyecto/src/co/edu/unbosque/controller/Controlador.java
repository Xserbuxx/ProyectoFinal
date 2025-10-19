package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.swing.ImageIcon;

import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Persona;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.view.ViewFacade;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Controlador implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;
	private Properties prop;
	private Random ran;

	private Persona usuarioActual;

	public Controlador() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		prop = new Properties();
		ran = new Random();
	}

	public void run() {
		agregarOyentes();
		mf.actualizarPersonas();
		agregarIdioma(); // borrar
		vf.getVentanaPrincipal().actualizar();
	}

	private void agregarOyentes() {
		vf.getIdm().getConfirmar().addActionListener(this);
		vf.getIdm().getConfirmar().setActionCommand("ConfirmarIdioma");
		vf.getIs().getBotonConfirmar().addActionListener(this);
		vf.getIs().getBotonConfirmar().setActionCommand("BotonConfirmarInicioSesion");
		vf.getIs().getBotonRegistrarse().addActionListener(this);
		vf.getIs().getBotonRegistrarse().setActionCommand("BotonRegistrarse");
		vf.getReg().getBotonIniciarSesion().addActionListener(this);
		vf.getReg().getBotonIniciarSesion().setActionCommand("BotonIniciarSesion");
		vf.getReg().getBotonSexoHombre().addActionListener(this);
		vf.getReg().getBotonSexoHombre().setActionCommand("BotonSexoHombre");
		vf.getReg().getBotonSexoMujer().addActionListener(this);
		vf.getReg().getBotonSexoMujer().setActionCommand("BotonSexoMujer");
		vf.getReg().getBotonConfirmar().addActionListener(this);
		vf.getReg().getBotonConfirmar().setActionCommand("BotonConfirmarRegistro");
		vf.getVc().getBotonConfirmar().addActionListener(this);
		vf.getVc().getBotonConfirmar().setActionCommand("BotonConfirmarVerificacion");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ConfirmarIdioma":
			/////////////////////////////////////////////////////////////////
			switch (vf.getIdm().getComboBox().getSelectedItem().toString()) {
			case "Español":
				prop = FileHandler.cargarArchivoDePropiedades("es.properties");
				break;
			case "Português":
				prop = FileHandler.cargarArchivoDePropiedades("pt.properties");
				break;
			case "\u0420\u0443\u0441\u0441\u043A\u0438\u0439":
				prop = FileHandler.cargarArchivoDePropiedades("ru.properties");
				break;
			case "\u4E2D\u56FD\u4EBA":
				prop = FileHandler.cargarArchivoDePropiedades("ch.properties");
				break;
			case "\u05E2\u05B4\u05D1\u05E8\u05B4\u05D9\u05EA":
				prop = FileHandler.cargarArchivoDePropiedades("he.properties");
				break;
			default:
				break;
			}

			agregarIdioma();
			vf.mostrarPanel("inicioSesion");
			/////////////////////////////////////////////////////////////////
			break;

		case "BotonRegistrarse":
			vf.getIs().limpiarCampos();
			vf.getReg().eliminarLabelSexos(prop.getProperty("ventana.registro.ingresoProm"),
					prop.getProperty("ventana.registro.divorciada"));
			vf.mostrarPanel("registro");
			break;
		case "BotonIniciarSesion":
			vf.getReg().limpiarCampos();
			vf.mostrarPanel("inicioSesion");
			break;
		case "BotonSexoHombre":
			vf.getReg().eliminarLabelSexos(prop.getProperty("ventana.registro.ingresoProm"),
					prop.getProperty("ventana.registro.divorciada"));
			vf.getReg().mostrarCampoHombre(prop.getProperty("ventana.registro.ingresoProm"));
			break;
		case "BotonSexoMujer":
			vf.getReg().eliminarLabelSexos(prop.getProperty("ventana.registro.ingresoProm"),
					prop.getProperty("ventana.registro.divorciada"));
			vf.getReg().mostrarCampoMujer(prop.getProperty("ventana.registro.divorciada"));
			break;
		case "BotonConfirmarRegistro":
			registrarUsuario();
			mf.actualizarPersonas();
			break;
		case "BotonConfirmarInicioSesion":
			mf.getPersonas().forEach(persona -> {
				if (persona.getAlias().equals(vf.getIs().getCampoUsuario().getText())
						&& persona.getContrasena().equals(vf.getIs().getCampoContrasena().getText())) {
					vf.getVentanaPrincipal().mostrarMensaje("Inicio de sesion exitoso"); // hardcode
					usuarioActual = persona;
					vf.getIs().limpiarCampos();
				}
			});

			if (usuarioActual == null) {
				vf.getVentanaPrincipal().mostrarError("Usuario o contrasena incorrectos"); // hardcode
				break;
			}

			if (!usuarioActual.isVerificado()) {
				vf.getVentanaPrincipal()
						.mostrarMensaje("Por favor verifique su cuenta con el codigo enviado a su correo"); // hardcode
				enviarCodigoVerificacion(usuarioActual.getCorreo(), usuarioActual.getCodigo());
				vf.mostrarPanel("verificarCodigo");
				break;
			}

			vf.getVentanaPrincipal().mostrarMensaje("Bienvenido " + usuarioActual.getAlias()); // hardcode
			vf.mostrarPanel("idioma"); // cambiar por panel principal
			break;
		case "BotonConfirmarVerificacion":
			if (vf.getVc().getCampoCodigo().getText().equals(usuarioActual.getCodigo() + "")) {
				usuarioActual.setVerificado(true);
				vf.getVentanaPrincipal().mostrarMensaje("Cuenta verificada con exito"); // hardcode
				vf.mostrarPanel("idioma"); // cambiar por panel principal
			} else {
				vf.getVentanaPrincipal().mostrarError("Codigo incorrecto"); // hardcode

			}
			break;
		default:
			break;
		}

	}

	private void registrarUsuario() {
		if (vf.getReg().getDivorciada().isEnabled()) {
			registrarUsuarioMujer();
			return;
		}

		if (vf.getReg().getCampoIngresoProm().isEnabled()) {
			registrarUsuarioHombre();
			return;
		}

		vf.getVentanaPrincipal().mostrarError("Ningun Genero Seleccionado"); // hardcode
	}

	private void registrarUsuarioHombre() {

		try {
			String nombre = vf.getReg().getCampoNombre().getText();

			String alias = vf.getReg().getCampoAlias().getText();

			int edad = Integer.parseInt(vf.getReg().getCampoEdad().getText());

			String fechaNacimiento = vf.getReg().getCampoFechaNacimiento().getText();

			float estatura = Float.parseFloat(vf.getReg().getCampoEstatura().getText());

			String correo = vf.getReg().getCampoCorreo().getText();

			// ImageIcon Imagen = new ImageIcon(vf.getReg().getCampoImagen().getText());

			boolean disponibilidad = false;

			if (vf.getReg().getGrupoDisponibilidad().getSelection() == null) {
				vf.getVentanaPrincipal().mostrarError("Debe seleccionar su disponibilidad"); // hardcode
				return;
			}

			switch (vf.getReg().getGrupoDisponibilidad().getSelection().toString()) {
			case "Disponible":
				disponibilidad = true;
				break;
			case "No Disponible":
				disponibilidad = false;
				break;
			}

			String contrasena = vf.getReg().getCampoContrasena().getText();

			int codigo = ran.nextInt(100000, 999999);

			float ingresoProm = Float.parseFloat(vf.getReg().getCampoIngresoProm().getText());

			if (mf.getHombreDAO()
					.crear(new HombreDTO(nombre, alias, edad, fechaNacimiento, estatura, correo, null, disponibilidad,
							contrasena, codigo, 0, 0, 0.0f, ingresoProm, false, 0, false, new ArrayList<String>(),
							false))) {
				vf.mostrarPanel("inicioSesion");
				vf.getVentanaPrincipal().mostrarMensaje("Usuario registrado con exito, Inicie Sesion Para Continuar"); // hardcode
			}

		} catch (Exception e) {
			vf.getVentanaPrincipal().mostrarError("Error al registrar usuario " + e.getMessage()); // hardcode
		}

	}

	private void registrarUsuarioMujer() {
		try {

		} catch (Exception e) {
			vf.getVentanaPrincipal().mostrarError("Error al registrar usuario"); // hardcode
		}
	}

	private void enviarCodigoVerificacion(String correo, int codigo) {

		String smtpHost = "smtp.gmail.com"; // Host SMTP del proveedor
	    int smtpPort = 587; // Puerto SMTP (587 para STARTTLS, 465 para SSL)
	    String emailRemitente = "sergio.che2107@gmail.com"; // Email desde el que enviarás los correos
	    String contraseña = "amsd bfnt rfau ldig"; // App Password si es Gmail con 2FA
	    boolean usarSSL = false; // false para STARTTLS (587), true para SSL (465)

	    try {
	        // Configurar propiedades SMTP
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", smtpHost);
	        props.put("mail.smtp.port", String.valueOf(smtpPort));
	        
	        if (usarSSL) {
	            props.put("mail.smtp.ssl.enable", "true");
	            props.put("mail.smtp.starttls.enable", "false");
	        } else {
	            props.put("mail.smtp.ssl.enable", "false");
	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.starttls.required", "true");
	        }
	        
	        // Crear sesión con autenticación
	        Session session = Session.getInstance(props, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(emailRemitente, contraseña);
	            }
	        });
	        
	        // Crear mensaje
	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(emailRemitente));
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
	        message.setSubject("Código de Seguridad de tu Cuenta", "UTF-8");
	        
	        // Establecer contenido HTML con el código
	        message.setContent(
	            "<!DOCTYPE html>" +
	            "<html lang='es'>" +
	            "<head>" +
	            "    <meta charset='UTF-8'>" +
	            "    <style>" +
	            "        body { font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 0; }" +
	            "        .container { max-width: 600px; margin: 20px auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }" +
	            "        .header { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); padding: 30px; text-align: center; color: white; }" +
	            "        .header h1 { margin: 0; font-size: 24px; }" +
	            "        .content { padding: 40px 30px; }" +
	            "        .content p { margin: 0 0 15px 0; line-height: 1.6; color: #333; font-size: 14px; }" +
	            "        .codigo-box { background-color: #f0f4ff; border-left: 4px solid #667eea; padding: 25px; margin: 25px 0; text-align: center; border-radius: 4px; }" +
	            "        .codigo-box p { margin: 0 0 10px 0; color: #666; font-size: 13px; text-transform: uppercase; }" +
	            "        .codigo { font-size: 48px; font-weight: bold; color: #667eea; letter-spacing: 8px; margin: 10px 0; font-family: 'Courier New', monospace; }" +
	            "        .alerta { background-color: #fff3cd; border: 1px solid #ffc107; border-radius: 4px; padding: 15px; margin: 20px 0; font-size: 13px; color: #856404; }" +
	            "        .footer { background-color: #f9f9f9; padding: 20px 30px; border-top: 1px solid #eee; font-size: 12px; color: #999; text-align: center; }" +
	            "        .footer p { margin: 5px 0; }" +
	            "    </style>" +
	            "</head>" +
	            "<body>" +
	            "    <div class='container'>" +
	            "        <div class='header'>" +
	            "            <h1>🔐 Código de Seguridad</h1>" +
	            "        </div>" +
	            "        <div class='content'>" +
	            "            <p>Hola,</p>" +
	            "            <p>El código de seguridad de tu cuenta es:</p>" +
	            "            <div class='codigo-box'>" +
	            "                <p>Tu código de seguridad es:</p>" +
	            "                <div class='codigo'>" + String.format("%06d", codigo) + "</div>" +
	            "            </div>" +
	            "            <div class='alerta'>" +
	            "                <strong>⚠️ Importante:</strong> Este código expira en 10 minutos. No compartas este código con nadie." +
	            "            </div>" +
	            "            <p>Si no solicitaste este código, ignora este correo.</p>" +
	            "        </div>" +
	            "        <div class='footer'>" +
	            "            <p>Este es un correo automático generado por nuestro sistema.</p>" +
	            "            <p>© 2025 Tu Empresa. Todos los derechos reservados.</p>" +
	            "        </div>" +
	            "    </div>" +
	            "</body>" +
	            "</html>",
	            "text/html; charset=UTF-8"
	        );
	        
	        // Enviar mensaje
	        Transport.send(message);
	        
	        System.out.println("✓ Correo de seguridad enviado a: " + correo);
	        
	    } catch (MessagingException e) {
	        System.err.println("✗ Error al enviar correo: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	private void agregarIdioma() {
		prop = FileHandler.cargarArchivoDePropiedades("es.properties"); // borrar
		vf.getIs().mostrarTextos(prop.getProperty("ventana.iniciarSesion.titulo"),
				prop.getProperty("ventana.iniciarSesion.usuario"), prop.getProperty("ventana.iniciarSesion.contrasena"),
				prop.getProperty("ventana.iniciarSesion.botonConfirmar"),
				prop.getProperty("ventana.iniciarSesion.botonRegistrarse"),
				prop.getProperty("ventana.iniciarSesion.sinCuenta"));
		vf.getReg().mostrarTextos(prop.getProperty("ventana.registro.titulo"),
				prop.getProperty("ventana.registro.nombre"), prop.getProperty("ventana.registro.usuario"),
				prop.getProperty("ventana.registro.edad"), prop.getProperty("ventana.registro.fechaNacimiento"),
				prop.getProperty("ventana.registro.estatura"), prop.getProperty("ventana.registro.correo"),
				prop.getProperty("ventana.registro.imagen"), prop.getProperty("ventana.registro.disponibilidad"),
				prop.getProperty("ventana.registro.disponible"), prop.getProperty("ventana.registro.noDisponible"),
				prop.getProperty("ventana.registro.contrasena"), prop.getProperty("ventana.registro.botonConfirmar"),
				prop.getProperty("ventana.registro.botonIniciarSesion"), prop.getProperty("ventana.registro.yaCuenta"),
				prop.getProperty("ventana.registro.sexo"), prop.getProperty("ventana.registro.siDivorciada"),
				prop.getProperty("ventana.registro.noDivorciada"));
		vf.getVc().mostrarTextos(prop.getProperty("ventana.verificarCodigo.titulo"),
				prop.getProperty("ventana.verificarCodigo.instrucciones"),
				prop.getProperty("ventana.verificarCodigo.codigo"),
				prop.getProperty("ventana.verificarCodigo.botonConfirmar"));
	}
}
