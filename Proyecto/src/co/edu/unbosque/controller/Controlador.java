package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.swing.ImageIcon;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.Persona;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.exception.*;
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

		prop = FileHandler.cargarArchivoDePropiedades("es.properties");
		agregarIdioma();
	}

	public void run() {
		agregarOyentes();
		mf.actualizarPersonas();
		vf.getVentanaPrincipal().mostrarVentana();
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
		vf.getReg().getBotonExaminar().addActionListener(this);
		vf.getReg().getBotonExaminar().setActionCommand("BotonExaminar");
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
			vf.getReg().limpiarCampos();
			vf.getReg().eliminarLabelSexos(prop.getProperty("ventana.registro.ingresoProm"),
					prop.getProperty("ventana.registro.divorciada"));
			vf.mostrarPanel("registro");
			break;
		case "BotonIniciarSesion":
			vf.getIs().limpiarCampos();
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
			try {
				LanzadorExcepciones.verificarCampoVacio(vf.getIs().getCampoUsuario().getText(),
						prop.getProperty("ventana.iniciarSesion.usuario"));

				LanzadorExcepciones.verificarCampoVacio(vf.getIs().getCampoContrasena().getText(),
						prop.getProperty("ventana.iniciarSesion.contrasena"));

				usuarioActual = null;

				mf.getPersonas().forEach(persona -> {
					if (persona.getAlias().equals(vf.getIs().getCampoUsuario().getText())
							&& persona.getContrasena().equals(vf.getIs().getCampoContrasena().getText())) {
						vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.inicioSesionExitoso"));
						usuarioActual = persona;
						vf.getIs().limpiarCampos();
					}
				});

				if (usuarioActual == null) {
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.usuarioIncorrecto"));
					break;
				}

				if (!usuarioActual.isVerificado()) {
					vf.getVentanaPrincipal().mostrarMensaje(
							prop.getProperty("mensaje.verificarCorreo") + " " + usuarioActual.getCorreo());
					enviarCodigoVerificacion(usuarioActual.getCorreo(), usuarioActual.getCodigo());
					vf.mostrarPanel("verificarCodigo");
					break;
				}

				vf.getVentanaPrincipal()
						.mostrarMensaje(prop.getProperty("mensaje.bienvenida") + " " + usuarioActual.getAlias());
				if (usuarioActual.getEstaturaIdeal() == 0) {
					mostrarVentanaGustos();
				} else {
					// mostrar ventana principal del aplicativo
				}
			} catch (CampoVacioException ex) {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoVacio") + ex.getMessage());
			}
			break;
		case "BotonConfirmarVerificacion":
			////////////////////////////////////////////////////////////////////////////////
			try {
				int codigo = Integer.parseInt(vf.getVc().getCampoCodigo().getText());
				LanzadorExcepciones.verificarNumeroNegativo(codigo);
				LanzadorExcepciones.verificarCodigo(codigo);
				if (usuarioActual.getCodigo() == codigo) {
					usuarioActual.setVerificado(true);
					mf.actualizarPersonas();
					vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.cuentaVerificada"));
					if (usuarioActual.getEstaturaIdeal() == 0) {
						mostrarVentanaGustos();
					} else {
						// mostrar ventana principal del aplicativo
					}
				} else {
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.codigoInvalido"));

				}
			} catch (NumeroNegativoException ex) {
				////////////////////////////
				switch (ex.getMessage()) {
				case "Numero Debajo de Cero":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.numeroDebajoCero"));
					break;
				case "Numero Igual a Cero":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.numeroIgualCero"));
					break;
				}
				////////////////////////////
			} catch (CodigoException ex) {
				////////////////////////////
				switch (ex.getMessage()) {
				case "Numero Debajo de 6 Digitos":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.codigo.numeroDebajo6"));
					break;
				case "Numero Encima de 6 Digitos":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.codigo.numeroEncima6"));
					break;
				}
				////////////////////////////
			} catch (NumberFormatException ex) {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoNumero"));
			}
			////////////////////////////////////////////////////////////////////////////////
			break;
		case "BotonExaminar":
			vf.getReg().obtenerRutaImagen();
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

		vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.generoNoSeleccionado"));
	}

	private void registrarUsuarioHombre() {

		try {
			String nombre = vf.getReg().getCampoNombre().getText();
			LanzadorExcepciones.verificarCampoVacio(nombre, prop.getProperty("ventana.registro.nombre"));
			LanzadorExcepciones.verificarCaracterEspecial(nombre, prop.getProperty("ventana.registro.nombre"));
			LanzadorExcepciones.verificarEspaciosExcesivos(nombre, prop.getProperty("ventana.registro.nombre"));
			LanzadorExcepciones.verificarCampoMuyCorto(nombre, prop.getProperty("ventana.registro.nombre"));

			String alias = vf.getReg().getCampoAlias().getText();
			LanzadorExcepciones.verificarCampoVacio(alias, prop.getProperty("ventana.registro.usuario"));
			LanzadorExcepciones.verificarCaracterEspecial(alias, prop.getProperty("ventana.registro.usuario"));
			LanzadorExcepciones.verificarEspaciosExcesivos(alias, prop.getProperty("ventana.registro.usuario"));
			LanzadorExcepciones.verificarCampoMuyCorto(alias, prop.getProperty("ventana.registro.usuario"));
			LanzadorExcepciones.verificarCampoMuyLargo(alias, prop.getProperty("ventana.registro.usuario"));

			int edad = 0;

			try {
				edad = Integer.parseInt(vf.getReg().getCampoEdad().getText());
				LanzadorExcepciones.verificarRangoNumero(edad, 18, 130);
			} catch (NumberFormatException e) {
				vf.getVentanaPrincipal().mostrarError(
						prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.registro.edad"));
				return;
			} catch (RangoNumeroException e) {
				switch (e.getMessage()) {
				case "min":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.min"));
					return;
				case "max":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.max"));
					return;
				}
			}

			String fechaNacimiento = vf.getReg().getCampoFechaNacimiento().getText();
			LanzadorExcepciones.verificarCampoVacio(fechaNacimiento,
					prop.getProperty("ventana.registro.fechaNacimiento"));
			LanzadorExcepciones.verificarEspacios(fechaNacimiento,
					prop.getProperty("ventana.registro.fechaNacimiento"));
			LanzadorExcepciones.verificarFormatoFecha(fechaNacimiento, edad);

			float estatura = 0.0f;

			try {
				estatura = Float.parseFloat(vf.getReg().getCampoEstatura().getText());
				LanzadorExcepciones.verificarRangoNumero(estatura, 50f, 250f);
			} catch (NumberFormatException e) {
				vf.getVentanaPrincipal().mostrarError(
						prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.registro.estatura"));
				return;
			} catch (RangoNumeroException e) {
				switch (e.getMessage()) {
				case "min":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.estatura.min"));
					return;
				case "max":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.estatura.max"));
					return;
				}
			}

			String correo = vf.getReg().getCampoCorreo().getText();
			LanzadorExcepciones.verificarCampoVacio(correo, prop.getProperty("ventana.registro.correo"));
			LanzadorExcepciones.verificarFormatoCorreo(correo);
			LanzadorExcepciones.verificarEspacios(correo, prop.getProperty("ventana.registro.correo"));
			LanzadorExcepciones.verificarCampoMuyCorto(correo, prop.getProperty("ventana.registro.correo"));
			LanzadorExcepciones.verificarCampoMuyLargo(correo, prop.getProperty("ventana.registro.correo"));

			String rutaImagen = vf.getReg().getCampoImagen().getText();
			LanzadorExcepciones.verificarCampoVacio(rutaImagen, prop.getProperty("ventana.registro.imagen"));
			LanzadorExcepciones.verificarImagen(rutaImagen);

			ImageIcon imagenIcon = new ImageIcon(rutaImagen);

			boolean disponibilidad = false;

			if (vf.getReg().getGrupoDisponibilidad().getSelection() == null) {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.disponibilidadNoSeleccionada"));
				return;
			}

			if (vf.getReg().getDisponible().isSelected()) {
				disponibilidad = true;
			}

			if (vf.getReg().getNoDisponible().isSelected()) {
				disponibilidad = false;
			}

			String contrasena = vf.getReg().getCampoContrasena().getText();
			LanzadorExcepciones.verificarCampoVacio(contrasena, prop.getProperty("ventana.registro.contrasena"));
			LanzadorExcepciones.verificarCampoMuyCorto(contrasena, prop.getProperty("ventana.registro.contrasena"));
			LanzadorExcepciones.verificarCampoMuyLargo(contrasena, prop.getProperty("ventana.registro.contrasena"));

			int codigo = ran.nextInt(100000, 999999);

			float ingresoProm = 0.0f;

			try {
				ingresoProm = Float.parseFloat(vf.getReg().getCampoIngresoProm().getText());
				LanzadorExcepciones.verificarRangoNumero(ingresoProm, 0f, 100000000f);
			} catch (NumberFormatException e) {
				vf.getVentanaPrincipal().mostrarError(
						prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.registro.ingresoProm"));
				return;
			} catch (RangoNumeroException e) {
				switch (e.getMessage()) {
				case "min":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.ingresoProm.min"));
					return;
				case "max":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.ingresoProm.max"));
					return;
				}
			}

			////////

			if (mf.getHombreDAO()
					.crear(new HombreDTO(nombre, alias, edad, fechaNacimiento, estatura, correo, imagenIcon,
							disponibilidad, contrasena, codigo, 0, 0, 0.0f, ingresoProm, false, 0, false,
							new ArrayList<String>(), false))) {
				vf.mostrarPanel("inicioSesion");
				vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.registroExitoso"));
			} else {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.usuarioExistente"));
			}

		} catch (CampoVacioException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoVacio") + e.getMessage());
		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoNumero"));
		} catch (CaracteresEspecialesException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.caracteresEspeciales") + e.getMessage());
		} catch (FormatoCorreoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoCorreo"));
		} catch (FormatoFechaException e) {
			/////////////////////////////////////////////
			switch (e.getMessage()) {
			case "Formato Incorrecto":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoFecha.invalido"));
				break;
			case "Incoherencia":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoFecha.incoherencia"));
				break;
			case "Futuro":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoFecha.futuro"));
				break;
			}
			/////////////////////////////////////////////
		} catch (EspaciosExcesivosException e) {
			switch (e.getMessage().split("_")[1]) {
			case "Inicio-Fin":
				vf.getVentanaPrincipal()
						.mostrarError(prop.getProperty("error.espacioInicioFin") + e.getMessage().split("_")[0]);
				break;

			case "Exceso":
				vf.getVentanaPrincipal()
						.mostrarError(prop.getProperty("error.espaciosExcesivos") + e.getMessage().split("_")[0]);
				break;
			}
		} catch (ContieneEspaciosException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.contieneEspacios") + " " + e.getMessage());
		} catch (CampoCortoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoCorto") + e.getMessage());
		} catch (CampoLargoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoLargo") + e.getMessage());
		} catch (ImagenException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.rutaImagen"));
		} catch (Exception e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.registrarUsuario") + e.getMessage());
		}

	}

	private void registrarUsuarioMujer() {
		try {
			String nombre = vf.getReg().getCampoNombre().getText();
			LanzadorExcepciones.verificarCampoVacio(nombre, prop.getProperty("ventana.registro.nombre"));
			LanzadorExcepciones.verificarCaracterEspecial(nombre, prop.getProperty("ventana.registro.nombre"));
			LanzadorExcepciones.verificarEspaciosExcesivos(nombre, prop.getProperty("ventana.registro.nombre"));
			LanzadorExcepciones.verificarCampoMuyCorto(nombre, prop.getProperty("ventana.registro.nombre"));

			String alias = vf.getReg().getCampoAlias().getText();
			LanzadorExcepciones.verificarCampoVacio(alias, prop.getProperty("ventana.registro.usuario"));
			LanzadorExcepciones.verificarCaracterEspecial(alias, prop.getProperty("ventana.registro.usuario"));
			LanzadorExcepciones.verificarEspaciosExcesivos(alias, prop.getProperty("ventana.registro.usuario"));
			LanzadorExcepciones.verificarCampoMuyCorto(alias, prop.getProperty("ventana.registro.usuario"));
			LanzadorExcepciones.verificarCampoMuyLargo(alias, prop.getProperty("ventana.registro.usuario"));

			int edad = 0;

			try {
				edad = Integer.parseInt(vf.getReg().getCampoEdad().getText());
				LanzadorExcepciones.verificarRangoNumero(edad, 18, 130);
			} catch (NumberFormatException e) {
				vf.getVentanaPrincipal().mostrarError(
						prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.registro.edad"));
				return;
			} catch (RangoNumeroException e) {
				switch (e.getMessage()) {
				case "min":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.min"));
					return;
				case "max":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.max"));
					return;
				}
			}

			String fechaNacimiento = vf.getReg().getCampoFechaNacimiento().getText();
			LanzadorExcepciones.verificarCampoVacio(fechaNacimiento,
					prop.getProperty("ventana.registro.fechaNacimiento"));
			LanzadorExcepciones.verificarEspacios(fechaNacimiento,
					prop.getProperty("ventana.registro.fechaNacimiento"));
			LanzadorExcepciones.verificarFormatoFecha(fechaNacimiento, edad);

			float estatura = 0.0f;

			try {
				estatura = Float.parseFloat(vf.getReg().getCampoEstatura().getText());
				LanzadorExcepciones.verificarRangoNumero(estatura, 50f, 250f);
			} catch (NumberFormatException e) {
				vf.getVentanaPrincipal().mostrarError(
						prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.registro.estatura"));
				return;
			} catch (RangoNumeroException e) {
				switch (e.getMessage()) {
				case "min":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.estatura.min"));
					return;
				case "max":
					vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.estatura.max"));
					return;
				}
			}

			String correo = vf.getReg().getCampoCorreo().getText();
			LanzadorExcepciones.verificarCampoVacio(correo, prop.getProperty("ventana.registro.correo"));
			LanzadorExcepciones.verificarFormatoCorreo(correo);
			LanzadorExcepciones.verificarEspacios(correo, prop.getProperty("ventana.registro.correo"));
			LanzadorExcepciones.verificarCampoMuyCorto(correo, prop.getProperty("ventana.registro.correo"));
			LanzadorExcepciones.verificarCampoMuyLargo(correo, prop.getProperty("ventana.registro.correo"));

			String rutaImagen = vf.getReg().getCampoImagen().getText();
			LanzadorExcepciones.verificarCampoVacio(rutaImagen, prop.getProperty("ventana.registro.imagen"));
			LanzadorExcepciones.verificarImagen(rutaImagen);

			ImageIcon imagenIcon = new ImageIcon(rutaImagen);

			boolean disponibilidad = false;

			if (vf.getReg().getGrupoDisponibilidad().getSelection() == null) {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.disponibilidadNoSeleccionada"));
				return;
			}

			if (vf.getReg().getDisponible().isSelected()) {
				disponibilidad = true;
			}

			if (vf.getReg().getNoDisponible().isSelected()) {
				disponibilidad = false;
			}

			String contrasena = vf.getReg().getCampoContrasena().getText();
			LanzadorExcepciones.verificarCampoVacio(contrasena, prop.getProperty("ventana.registro.contrasena"));
			LanzadorExcepciones.verificarCampoMuyCorto(contrasena, prop.getProperty("ventana.registro.contrasena"));
			LanzadorExcepciones.verificarCampoMuyLargo(contrasena, prop.getProperty("ventana.registro.contrasena"));

			int codigo = ran.nextInt(100000, 999999);

			boolean divorciada = false;

			if (vf.getReg().getGrupoSexo().getSelection() == null) {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.divorciadaNoSeleccionada"));
				return;
			}

			if (vf.getReg().getDivorciada().isSelected()) {
				divorciada = true;
			}

			if (vf.getReg().getNoDivorciada().isSelected()) {
				divorciada = false;
			}

			////////

			if (mf.getMujerDAO()
					.crear(new MujerDTO(nombre, alias, edad, fechaNacimiento, estatura, correo, imagenIcon,
							disponibilidad, contrasena, codigo, 0, 0, 0.0f, divorciada, 0, 0, false,
							new ArrayList<String>(), false))) {
				vf.mostrarPanel("inicioSesion");
				vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.registroExitoso"));
			} else {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.usuarioExistente"));
			}

		} catch (CampoVacioException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoVacio") + e.getMessage());
		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoNumero"));
		} catch (CaracteresEspecialesException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.caracteresEspeciales") + e.getMessage());
		} catch (FormatoCorreoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoCorreo"));
		} catch (FormatoFechaException e) {
			/////////////////////////////////////////////
			switch (e.getMessage()) {
			case "Formato Incorrecto":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoFecha.invalido"));
				break;
			case "Incoherencia":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoFecha.incoherencia"));
				break;
			case "Futuro":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoFecha.futuro"));
				break;
			}
			/////////////////////////////////////////////
		} catch (EspaciosExcesivosException e) {
			switch (e.getMessage().split("_")[1]) {
			case "Inicio-Fin":
				vf.getVentanaPrincipal()
						.mostrarError(prop.getProperty("error.espacioInicioFin") + e.getMessage().split("_")[0]);
				break;

			case "Exceso":
				vf.getVentanaPrincipal()
						.mostrarError(prop.getProperty("error.espaciosExcesivos") + e.getMessage().split("_")[0]);
				break;
			}
		} catch (ContieneEspaciosException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.contieneEspacios") + " " + e.getMessage());
		} catch (CampoCortoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoCorto") + e.getMessage());
		} catch (CampoLargoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoLargo") + e.getMessage());
		} catch (ImagenException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.rutaImagen"));
		} catch (Exception e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.registrarUsuario") + e.getMessage());
		}

	}

	private void mostrarVentanaGustos() {
		if (usuarioActual == null) {
			return;
		}

		if (usuarioActual instanceof Hombre) {
			vf.getSg().eliminarLabelGustos(prop.getProperty("ventana.seleccionGustos.ingresoIdeal"),
					prop.getProperty("ventana.seleccionGustos.divorciada"));
			vf.getSg().mostrarCamposHombre(prop.getProperty("ventana.seleccionGustos.divorciada"));
			vf.mostrarPanel("seleccionGustos");
		} else if (usuarioActual instanceof Mujer) {
			vf.getSg().eliminarLabelGustos(prop.getProperty("ventana.seleccionGustos.ingresoIdeal"),
					prop.getProperty("ventana.seleccionGustos.divorciada"));
			vf.getSg().mostrarCamposMujer(prop.getProperty("ventana.seleccionGustos.ingresoIdeal"));
			vf.mostrarPanel("seleccionGustos");
		}
	}

	private void enviarCodigoVerificacion(String correo, int codigo) {

		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", String.valueOf(587));

			props.put("mail.smtp.ssl.enable", "false");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.starttls.required", "true");

			Session session = Session.getInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("bostinderueb@gmail.com", "flfy qotq qggz ktlx");
				}
			});

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bostinderueb@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
			message.setSubject("Código de Seguridad de tu Cuenta", "UTF-8");

			// cambiar mensaje por un properties
			message.setContent("Buen dia. "
					+ "\nle hablamos desde BOSTINDER. \nsu correo electronico fue registrado en uno de nuestros perfiles. \nSu codigo de seguridad es: "
					+ codigo + "\n\nSi no solicito este código, ignore este correo ", "text/plain; charset=UTF-8");

			Transport.send(message);
		} catch (MessagingException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.enviarCorreo") + " " + correo);
		}
	}

	private void agregarIdioma() {
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
				prop.getProperty("ventana.registro.noDivorciada"), prop.getProperty("ventana.registro.botonExaminar"));
		vf.getVc().mostrarTextos(prop.getProperty("ventana.verificarCodigo.titulo"),
				prop.getProperty("ventana.verificarCodigo.instrucciones"),
				prop.getProperty("ventana.verificarCodigo.codigo"),
				prop.getProperty("ventana.verificarCodigo.botonConfirmar"));
		vf.getSg().mostrarTextos(prop.getProperty("ventana.seleccionGustos.edadmin"),
				prop.getProperty("ventana.seleccionGustos.edadmax"),
				prop.getProperty("ventana.seleccionGustos.estaturaIdeal"),
				prop.getProperty("ventana.seleccionGustos.siDivorciada"),
				prop.getProperty("ventana.seleccionGustos.noDivorciada"),
				prop.getProperty("ventana.seleccionGustos.botonConfirmar"),
				prop.getProperty("ventana.seleccionGustos.edad"));
	}
}
