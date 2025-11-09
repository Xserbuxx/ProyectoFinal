package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

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
		vf.getSg().getBotonConfirmar().addActionListener(this);
		vf.getSg().getBotonConfirmar().setActionCommand("BotonConfirmarGustos");
		vf.getApp().getBotonPerfil().addActionListener(this);
		vf.getApp().getBotonPerfil().setActionCommand("BotonPerfil");
		vf.getPer().getBotonIncognito().addActionListener(this);
		vf.getPer().getBotonIncognito().setActionCommand("BotonIncognito");
		vf.getPer().getBotonVolver().addActionListener(this);
		vf.getPer().getBotonVolver().setActionCommand("BotonVolverPerfil");
		vf.getInfoUsuario().getBotonVolver().addActionListener(this);
		vf.getInfoUsuario().getBotonVolver().setActionCommand("BotonVolverInfo");
		vf.getConfirmarBaja().getBotonVolver().addActionListener(this);
		vf.getConfirmarBaja().getBotonVolver().setActionCommand("BotonVolverCB");
		vf.getAdmin().getBotonOrdenar().addActionListener(this);
		vf.getAdmin().getBotonOrdenar().setActionCommand("BotonOrdenarUsuarios");
		vf.getAdmin().getBotonTop().addActionListener(this);
		vf.getAdmin().getBotonTop().setActionCommand("BotonTopUsuarios");
		vf.getAdmin().getBotonPDF().addActionListener(this);
		vf.getAdmin().getBotonPDF().setActionCommand("BotonGenerarPDF");
		vf.getPer().getCambiarModo().addActionListener(this);
		vf.getPer().getCambiarModo().setActionCommand("BotonCambiarModo");
		vf.getAdmin().getCambiarModo().addActionListener(this);
		vf.getAdmin().getCambiarModo().setActionCommand("BotonCambiarModo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().contains("BotonLike-")) {
			JButton botonLike = (JButton) e.getSource();
			if (botonLike.getForeground() == Color.red) {
				botonLike.setForeground(Color.gray);
				botonLike.setText("\u2764 " + (Integer.parseInt(botonLike.getText().split(" ")[1]) - 1));
				usuarioActual.getLikesDados().remove(botonLike.getActionCommand().split("-")[1]);
				mf.getPersonas().forEach(persona -> {
					if (persona.getAlias().equals(botonLike.getActionCommand().split("-")[1])) {
						persona.setLikesRecibidos(persona.getLikesRecibidos() - 1);
					}
				});
				mf.actualizarPersonas();
			} else {
				botonLike.setForeground(Color.red);
				botonLike.setText("\u2764 " + (Integer.parseInt(botonLike.getText().split(" ")[1]) + 1));
				usuarioActual.getLikesDados().add(botonLike.getActionCommand().split("-")[1]);
				mf.getPersonas().forEach(persona -> {
					if (persona.getAlias().equals(botonLike.getActionCommand().split("-")[1])) {
						persona.setLikesRecibidos(persona.getLikesRecibidos() + 1);
					}
				});
				mf.actualizarPersonas();
			}
		}

		if (e.getActionCommand().contains("botonInfo-")) {
			vf.mostrarPanel("infoUsuario");

			vf.getInfoUsuario().limpiarLabels();

			Persona usuarioInfo = null;

			for (Persona persona : mf.getPersonas()) {
				if (persona.getAlias().equals(e.getActionCommand().split("-")[1])) {
					usuarioInfo = persona;
					break;
				}
			}

			if (usuarioInfo instanceof Hombre) {
				vf.getInfoUsuario().mostrarTextosHombre(prop.getProperty("ventana.perfil.nombreUsuario"),
						prop.getProperty("ventana.perfil.alias"), prop.getProperty("ventana.perfil.edad"),
						prop.getProperty("ventana.perfil.fechaNacimiento"), prop.getProperty("ventana.perfil.estatura"),
						prop.getProperty("ventana.perfil.correo"), prop.getProperty("ventana.perfil.ingresoProm"),
						prop.getProperty("ventana.perfil.estadoDivorcio"),
						prop.getProperty("ventana.perfil.edadMinima"), prop.getProperty("ventana.perfil.edadMaxima"),
						prop.getProperty("ventana.perfil.estaturaIdeal"),
						prop.getProperty("ventana.perfil.likesRecibidos"));
				vf.getInfoUsuario().mostrarPerfilHombre(usuarioInfo.getNombre(), usuarioInfo.getAlias(),
						usuarioInfo.getEdad() + "", usuarioInfo.getFechaNacimiento(), usuarioInfo.getEstatura() + "",
						usuarioInfo.getCorreo(),
						String.format(Locale.US, "%.2f%n",
								convertirUSDAmoneda(((Hombre) usuarioInfo).getIngresoProm())),
						((Hombre) usuarioInfo).isEstadoDivorcio() + "", usuarioInfo.getEdadMinima() + "",
						usuarioInfo.getEdadMaxima() + "", usuarioInfo.getEstaturaIdeal() + "",
						usuarioInfo.getLikesRecibidos() + "", usuarioInfo.getImagen());
			} else {
				vf.getInfoUsuario().mostrarTextosMujer(prop.getProperty("ventana.perfil.nombreUsuario"),
						prop.getProperty("ventana.perfil.alias"), prop.getProperty("ventana.perfil.edad"),
						prop.getProperty("ventana.perfil.fechaNacimiento"), prop.getProperty("ventana.perfil.estatura"),
						prop.getProperty("ventana.perfil.correo"), prop.getProperty("ventana.perfil.estadoCivil"),
						prop.getProperty("ventana.perfil.ingresoProm"), prop.getProperty("ventana.perfil.edadMinima"),
						prop.getProperty("ventana.perfil.edadMaxima"), prop.getProperty("ventana.perfil.estaturaIdeal"),
						prop.getProperty("ventana.perfil.likesRecibidos"));
				vf.getInfoUsuario().mostrarPerfilMujer(usuarioInfo.getNombre(), usuarioInfo.getAlias(),
						usuarioInfo.getEdad() + "", usuarioInfo.getFechaNacimiento(), usuarioInfo.getEstatura() + "",
						usuarioInfo.getCorreo(), ((Mujer) usuarioInfo).isDivorciada() + "",
						String.format(Locale.US, "%.2f%n",
								convertirUSDAmoneda(((Mujer) usuarioInfo).getIngresosIdeal())),
						usuarioInfo.getEdadMinima() + "", usuarioInfo.getEdadMaxima() + "",
						usuarioInfo.getEstaturaIdeal() + "", usuarioInfo.getLikesRecibidos() + "",
						usuarioInfo.getImagen());
			}
		}

		if (e.getActionCommand().contains("botonBaja-")) {
			vf.getAdmin().add(vf.getConfirmarBaja());
			vf.getAdmin().setComponentZOrder(vf.getConfirmarBaja(), 0);
			vf.getAdmin().setEnabled(false);
			vf.getAdmin().setOff();
			vf.getConfirmarBaja().setEnabled(true);
			vf.getConfirmarBaja().setVisible(true);

			vf.getConfirmarBaja().mostrarTextos(
					prop.getProperty("ventana.baja.confirmar") + " " + e.getActionCommand().split("-")[1],
					prop.getProperty("ventana.baja.botonConfirmar"));
			vf.getConfirmarBaja().getBotonConfirmar()
					.setActionCommand("botonConfirmarBaja-" + e.getActionCommand().split("-")[1]);
			vf.getConfirmarBaja().getBotonConfirmar().addActionListener(this);
		}

		if (e.getActionCommand().contains("botonConfirmarBaja-")) {
			for (Persona p : mf.getPersonas()) {
				if (p.getAlias().equals(e.getActionCommand().split("-")[1])) {
					mf.eliminarPersona(p);
					break;
				}
			}
			agregarUsuariosVentanaAdmin();
			vf.getConfirmarBaja().setEnabled(false);
			vf.getConfirmarBaja().setVisible(false);
			vf.getAdmin().remove(vf.getConfirmarBaja());
			vf.getAdmin().setEnabled(true);
			vf.getAdmin().setOn();

		}

		switch (e.getActionCommand()) {
		case "ConfirmarIdioma":
			/////////////////////////////////////////////////////////////////
			switch (vf.getIdm().getComboBox().getSelectedItem().toString()) {
			case "Español":
				prop = FileHandler.cargarArchivoDePropiedades("es.properties");
				break;
			case "English":
				prop = FileHandler.cargarArchivoDePropiedades("en.properties");
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

				if (usuarioActual.getAlias().equals("admin")) {
					vf.mostrarPanel("administrador");
					agregarUsuariosVentanaAdmin();
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
						.mostrarMensaje(prop.getProperty("mensaje.bienvenida") + " " + usuarioActual.getNombre());
				if (usuarioActual.getEstaturaIdeal() == 0) {
					mostrarVentanaGustos();
				} else {
					vf.mostrarPanel("aplicacion");
					agregarUsuariosVentanaAplicacion();
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

					mostrarVentanaGustos();

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
		case "BotonConfirmarGustos":
			if (!registrarGustosUsuario()) {
				break;
			}
			mf.actualizarPersonas();
			vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.gustosGuardados"));
			vf.mostrarPanel("aplicacion");
			agregarUsuariosVentanaAplicacion();
			break;
		case "BotonIncognito":
			if (usuarioActual.isIncognito()) {
				usuarioActual.setIncognito(false);
				vf.getPer().getBotonIncognito().setText(prop.getProperty("ventana.aplicacion.modoIncognito.off"));
				vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.modoIncognito.off"));
				vf.getPer().cambiarBotonIncognito(false);
				mf.actualizarPersonas();
			} else {
				usuarioActual.setIncognito(true);
				vf.getPer().getBotonIncognito().setText(prop.getProperty("ventana.aplicacion.modoIncognito.on"));
				vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.modoIncognito.on"));
				vf.getPer().cambiarBotonIncognito(true);
				mf.actualizarPersonas();
			}
			break;
		case "BotonPerfil":
			vf.mostrarPanel("perfil");

			if (usuarioActual.isIncognito()) {
				vf.getPer().getBotonIncognito().setText(prop.getProperty("ventana.aplicacion.modoIncognito.on"));
				vf.getPer().cambiarBotonIncognito(true);
			} else {
				vf.getPer().getBotonIncognito().setText(prop.getProperty("ventana.aplicacion.modoIncognito.off"));
				vf.getPer().cambiarBotonIncognito(false);
			}

			vf.getPer().limpiarLabels();

			if (usuarioActual instanceof Hombre) {
				vf.getPer().mostrarTextosHombre(prop.getProperty("ventana.perfil.nombreUsuario"),
						prop.getProperty("ventana.perfil.alias"), prop.getProperty("ventana.perfil.edad"),
						prop.getProperty("ventana.perfil.fechaNacimiento"), prop.getProperty("ventana.perfil.estatura"),
						prop.getProperty("ventana.perfil.correo"), prop.getProperty("ventana.perfil.ingresoProm"),
						prop.getProperty("ventana.perfil.estadoDivorcio"),
						prop.getProperty("ventana.perfil.edadMinima"), prop.getProperty("ventana.perfil.edadMaxima"),
						prop.getProperty("ventana.perfil.estaturaIdeal"),
						prop.getProperty("ventana.perfil.likesRecibidos"));
				vf.getPer().mostrarPerfilHombre(usuarioActual.getNombre(), usuarioActual.getAlias(),
						usuarioActual.getEdad() + "", usuarioActual.getFechaNacimiento(),
						usuarioActual.getEstatura() + "", usuarioActual.getCorreo(),
						String.format(Locale.US, "%.2f%n",
								convertirUSDAmoneda(((Hombre) usuarioActual).getIngresoProm())),
						((Hombre) usuarioActual).isEstadoDivorcio() + "", usuarioActual.getEdadMinima() + "",
						usuarioActual.getEdadMaxima() + "", usuarioActual.getEstaturaIdeal() + "",
						usuarioActual.getLikesRecibidos() + "", usuarioActual.getImagen());
			} else {
				vf.getPer().mostrarTextosMujer(prop.getProperty("ventana.perfil.nombreUsuario"),
						prop.getProperty("ventana.perfil.alias"), prop.getProperty("ventana.perfil.edad"),
						prop.getProperty("ventana.perfil.fechaNacimiento"), prop.getProperty("ventana.perfil.estatura"),
						prop.getProperty("ventana.perfil.correo"), prop.getProperty("ventana.perfil.estadoCivil"),
						prop.getProperty("ventana.perfil.ingresoProm"), prop.getProperty("ventana.perfil.edadMinima"),
						prop.getProperty("ventana.perfil.edadMaxima"), prop.getProperty("ventana.perfil.estaturaIdeal"),
						prop.getProperty("ventana.perfil.likesRecibidos"));
				vf.getPer().mostrarPerfilMujer(usuarioActual.getNombre(), usuarioActual.getAlias(),
						usuarioActual.getEdad() + "", usuarioActual.getFechaNacimiento(),
						usuarioActual.getEstatura() + "", usuarioActual.getCorreo(),
						((Mujer) usuarioActual).isDivorciada() + "",
						String.format(Locale.US, "%.2f%n",
								convertirUSDAmoneda(((Mujer) usuarioActual).getIngresosIdeal())),
						usuarioActual.getEdadMinima() + "", usuarioActual.getEdadMaxima() + "",
						usuarioActual.getEstaturaIdeal() + "", usuarioActual.getLikesRecibidos() + "",
						usuarioActual.getImagen());
			}

			break;
		case "BotonVolverPerfil":
			vf.mostrarPanel("aplicacion");
			break;
		case "BotonVolverInfo":
			vf.mostrarPanel("administrador");
			break;
		case "BotonVolverCB":
			vf.getConfirmarBaja().setEnabled(false);
			vf.getConfirmarBaja().setVisible(false);
			vf.getAdmin().remove(vf.getConfirmarBaja());
			vf.getAdmin().setEnabled(true);
			vf.getAdmin().setOn();
			break;
		case "BotonOrdenarUsuarios":
			int criterio = 0;
			int orden = 0;
			if (vf.getAdmin().getBotonAscendente().isSelected()) {
				switch (ran.nextInt(1)) {
				case 0:
					orden = 1;
					break;
				case 1:
					orden = 3;
					break;
				default:
					break;
				}
			} else if (vf.getAdmin().getBotonDescendente().isSelected()) {
				switch (ran.nextInt(1)) {
				case 0:
					orden = 2;
					break;
				case 1:
					orden = 4;
					break;
				default:
					break;
				}
			} else {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.ordenNoSeleccionado"));
				break;
			}

			if (vf.getAdmin().getBotonNombre().isSelected()) {
				criterio = 1;
			} else if (vf.getAdmin().getBotonAlias().isSelected()) {
				criterio = 2;
			} else if (vf.getAdmin().getBotonLikes().isSelected()) {
				criterio = 3;
			} else if (vf.getAdmin().getBotonPorEdad().isSelected()) {
				criterio = 4;
			} else {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.criterioNoSeleccionado"));
				break;
			}

			mf.ordenarPor(orden, criterio);
			;

			agregarUsuariosVentanaAdmin();
			break;
		case "BotonTopUsuarios":

			int seleccionTop = 0;

			if (vf.getAdmin().getBotonTopLikes().isSelected()) {
				mf.ordenarPor(2, 3);
				seleccionTop = 1;
			} else if (vf.getAdmin().getBotonTopIngresos().isSelected()) {
				mf.getHombreDAO().ordenarPor(2, 5);
				seleccionTop = 2;
			} else {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.topCriterioNoSeleccionado"));
				break;
			}

			agregarTopUsuariosVentanaAdmin(seleccionTop);

			break;
		case "BotonGenerarPDF":

			if (vf.getAdmin().getBotonLikesPDF().isSelected()) {
				
				double[] likes = new double[mf.getPersonas().size()];
				int idx = 0;
				for (Persona p : mf.getPersonas()) {
					likes[idx++] = p.getLikesRecibidos();
				}

				generarInforme(likes, "informe_likes");
				
			} else if (vf.getAdmin().getBotonIngresosPDF().isSelected()) {
				
				double[] ingreso = new double[mf.getHombreDAO().getHombres().size()];
				int idx = 0;
				for (Persona p : mf.getHombreDAO().getHombres()) {
					ingreso[idx++] = ((Hombre) p).getIngresoProm();
				}

				generarInforme(ingreso, "informe_ingresos");
				
			} else if (vf.getAdmin().getBotonEstaturaPDF().isSelected()) {

				double[] estatura = new double[mf.getPersonas().size()];
				int idx = 0;
				for (Persona p : mf.getPersonas()) {
					estatura[idx++] = p.getEstatura();
				}

				generarInforme(estatura, "informe_estatura");

			} else if (vf.getAdmin().getBotonEdadPDF().isSelected()) {
				double[] edades = new double[mf.getPersonas().size()];
				int idx = 0;
				for (Persona p : mf.getPersonas()) {
					edades[idx++] = p.getEdad();
				}

				generarInforme(edades, "informe_edades");
			} else {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.pdfCriterioNoSeleccionado"));
			}

			break;
		default:
			break;
		}

	}

	private float convertirMonedaAUSD(float cantidad) {
		switch (prop.getProperty("idioma")) {
		case "Español":
			return cantidad * 0.00026f;
		case "Português":
			return cantidad * 0.19f;
		case "Русский":
			return cantidad * 0.012f;
		case "中国人":
			return cantidad * 0.14f;
		case "עברית":
			return cantidad * 0.31f;
		}
		return cantidad;
	}

	private float convertirUSDAmoneda(float cantidad) {
		switch (prop.getProperty("idioma")) {
		case "Español":
			return cantidad / 0.00026f;
		case "Português":
			return cantidad / 0.19f;
		case "Русский":
			return cantidad / 0.012f;
		case "中国人":
			return cantidad / 0.14f;
		case "עברית":
			return cantidad / 0.31f;
		}
		return cantidad;
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
				ingresoProm = convertirMonedaAUSD(Float.parseFloat(vf.getReg().getCampoIngresoProm().getText()));
				LanzadorExcepciones.verificarRangoNumero(ingresoProm, 244.85f, 1000000f);
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
				mf.actualizarPersonas();
				vf.mostrarPanel("inicioSesion");
				vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.registroExitoso"));
			} else {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.usuarioExistente"));
			}

		} catch (CampoVacioException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoVacio") + e.getMessage());
			return;
		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoNumero"));
			return;
		} catch (CaracteresEspecialesException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.caracteresEspeciales") + e.getMessage());
			return;
		} catch (FormatoCorreoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoCorreo"));
			return;
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
			return;
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
			return;
		} catch (ContieneEspaciosException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.contieneEspacios") + " " + e.getMessage());
			return;
		} catch (CampoCortoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoCorto") + e.getMessage());
			return;
		} catch (CampoLargoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoLargo") + e.getMessage());
			return;
		} catch (ImagenException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.rutaImagen"));
			return;
		} catch (Exception e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.registrarUsuario") + e.getMessage());
			return;
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
				mf.actualizarPersonas();
				vf.mostrarPanel("inicioSesion");
				vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.registroExitoso"));
			} else {
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.usuarioExistente"));
			}

		} catch (CampoVacioException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoVacio") + e.getMessage());
			return;
		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoNumero"));
			return;
		} catch (CaracteresEspecialesException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.caracteresEspeciales") + e.getMessage());
			return;
		} catch (FormatoCorreoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoCorreo"));
			return;
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
			return;
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
			return;
		} catch (ContieneEspaciosException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.contieneEspacios") + " " + e.getMessage());
			return;
		} catch (CampoCortoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoCorto") + e.getMessage());
			return;
		} catch (CampoLargoException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.campoLargo") + e.getMessage());
			return;
		} catch (ImagenException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.rutaImagen"));
			return;
		} catch (Exception e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.registrarUsuario") + e.getMessage());
			return;
		}

	}

	private boolean registrarGustosUsuario() {
		if (usuarioActual == null) {
			return false;
		}

		if (usuarioActual instanceof Hombre) {
			return registrarGustosHombre();
		}

		else if (usuarioActual instanceof Mujer) {
			return registrarGustosMujer();
		}

		return false;
	}

	private boolean registrarGustosHombre() {
		int edadMinima = 0;
		int edadMaxima = 0;
		float estaturaIdeal = 0f;

		try {
			edadMinima = Integer.parseInt(vf.getSg().getCampoEdadMinima().getText());
			LanzadorExcepciones.verificarRangoNumero(edadMinima, 18, 130);

		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(
					prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.seleccionGustos.edadmin"));
			return false;
		} catch (RangoNumeroException e) {
			switch (e.getMessage()) {
			case "min":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.min"));
				return false;
			case "max":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.max"));
				return false;
			}
		}

		try {
			edadMaxima = Integer.parseInt(vf.getSg().getCampoEdadMaxima().getText());
			LanzadorExcepciones.verificarRangoNumero(edadMaxima, 18, 130);

		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(
					prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.seleccionGustos.edadmax"));
			return false;
		} catch (RangoNumeroException e) {
			switch (e.getMessage()) {
			case "min":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.min"));
				return false;
			case "max":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.max"));
				return false;
			}
		}

		try {
			estaturaIdeal = Float.parseFloat(vf.getSg().getCampoEstaturaIdeal().getText());
			LanzadorExcepciones.verificarRangoNumero(estaturaIdeal, 50f, 250f);

		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoNumero")
					+ prop.getProperty("ventana.seleccionGustos.estaturaIdeal"));
			return false;
		} catch (RangoNumeroException e) {
			switch (e.getMessage()) {
			case "min":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.estatura.min"));
				return false;
			case "max":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.estatura.max"));
				return false;
			}
		}

		boolean divorciada = false;

		if (vf.getSg().getEstadoDivorcio().getSelection() == null) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.divorciadaNoSeleccionada"));
			return false;
		}

		if (vf.getSg().getDivorciada().isSelected()) {
			divorciada = true;
		}

		if (vf.getSg().getNoDivorciada().isSelected()) {
			divorciada = false;
		}

		usuarioActual.setEdadMinima(edadMinima);
		usuarioActual.setEdadMaxima(edadMaxima);
		usuarioActual.setEstaturaIdeal(estaturaIdeal);
		((Hombre) usuarioActual).setEstadoDivorcio(divorciada);
		return true;
	}

	private boolean registrarGustosMujer() {
		int edadMinima = 0;
		int edadMaxima = 0;
		float estaturaIdeal = 0f;
		float ingresoIdeal = 0f;

		try {
			edadMinima = Integer.parseInt(vf.getSg().getCampoEdadMinima().getText());
			LanzadorExcepciones.verificarRangoNumero(edadMinima, 18, 130);

		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(
					prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.seleccionGustos.edadmin"));
			return false;
		} catch (RangoNumeroException e) {
			switch (e.getMessage()) {
			case "min":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.min"));
				return false;
			case "max":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.max"));
				return false;
			}
		}

		try {
			edadMaxima = Integer.parseInt(vf.getSg().getCampoEdadMaxima().getText());
			LanzadorExcepciones.verificarRangoNumero(edadMaxima, 18, 130);

		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(
					prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.seleccionGustos.edadmax"));
			return false;
		} catch (RangoNumeroException e) {
			switch (e.getMessage()) {
			case "min":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.min"));
				return false;
			case "max":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.edad.max"));
				return false;
			}
		}

		try {
			estaturaIdeal = Float.parseFloat(vf.getSg().getCampoEstaturaIdeal().getText());
			LanzadorExcepciones.verificarRangoNumero(estaturaIdeal, 50f, 250f);

		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.formatoNumero")
					+ prop.getProperty("ventana.seleccionGustos.estaturaIdeal"));
			return false;
		} catch (RangoNumeroException e) {
			switch (e.getMessage()) {
			case "min":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.estatura.min"));
				return false;
			case "max":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.estatura.max"));
				return false;
			}
		}

		try {
			ingresoIdeal = convertirMonedaAUSD(Float.parseFloat(vf.getSg().getCampoIngresoIdeal().getText()));
			LanzadorExcepciones.verificarRangoNumero(ingresoIdeal, 0f, 100000000f);

		} catch (NumberFormatException e) {
			vf.getVentanaPrincipal().mostrarError(
					prop.getProperty("error.formatoNumero") + prop.getProperty("ventana.seleccionGustos.ingresoIdeal"));
			return false;
		} catch (RangoNumeroException e) {
			switch (e.getMessage()) {
			case "min":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.ingresoProm.min"));
				return false;
			case "max":
				vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.ingresoProm.max"));
				return false;
			}
		}

		usuarioActual.setEdadMinima(edadMinima);
		usuarioActual.setEdadMaxima(edadMaxima);
		usuarioActual.setEstaturaIdeal(estaturaIdeal);
		((Mujer) usuarioActual).setIngresosIdeal(ingresoIdeal);
		return true;
	}

	private void mostrarVentanaGustos() {
		if (usuarioActual == null) {
			return;
		}

		if (usuarioActual instanceof Hombre) {
			vf.getSg().eliminarLabelGustos(prop.getProperty("ventana.seleccionGustos.ingresoIdeal"),
					prop.getProperty("ventana.seleccionGustos.divorciada"));
			vf.getSg().limpiarCampos();
			vf.getSg().mostrarCamposHombre(prop.getProperty("ventana.seleccionGustos.divorciada"));
			vf.mostrarPanel("seleccionGustos");
		} else if (usuarioActual instanceof Mujer) {
			vf.getSg().eliminarLabelGustos(prop.getProperty("ventana.seleccionGustos.ingresoIdeal"),
					prop.getProperty("ventana.seleccionGustos.divorciada"));
			vf.getSg().limpiarCampos();
			vf.getSg().mostrarCamposMujer(prop.getProperty("ventana.seleccionGustos.ingresoIdeal"));
			vf.mostrarPanel("seleccionGustos");
		}
	}

	private void agregarUsuariosVentanaAplicacion() {
		vf.getApp().limpiarUsuarios();
		ArrayList<Persona> usuarios = mf.getPersonas();
		usuarios.removeIf(p -> p.getAlias().equals(usuarioActual.getAlias()));
		usuarios.removeIf(p -> p.getEstatura() > usuarioActual.getEstaturaIdeal() + 15
				|| p.getEstatura() < usuarioActual.getEstaturaIdeal() - 15);
		usuarios.removeIf(
				p -> p.getEdad() > usuarioActual.getEdadMaxima() || p.getEdad() < usuarioActual.getEdadMinima());
		usuarios.removeIf(p -> p instanceof Hombre && usuarioActual instanceof Hombre);
		usuarios.removeIf(p -> p instanceof Mujer && usuarioActual instanceof Mujer);
		usuarios.removeIf(p -> !p.isDisponibilidad());
		usuarios.removeIf(p -> p.isIncognito());

		Iterator<Persona> iterator = usuarios.iterator();
		while (iterator.hasNext()) {
			Persona p = iterator.next();
			if (p instanceof Hombre) {
				if (((Hombre) p).getIngresoProm() < ((Mujer) usuarioActual).getIngresosIdeal()) {
					iterator.remove();
				}
			}
			if (p instanceof Mujer) {
				if (((Mujer) p).isDivorciada() && !((Hombre) usuarioActual).isEstadoDivorcio()) {
					iterator.remove();
				}
				if (!((Mujer) p).isDivorciada() && ((Hombre) usuarioActual).isEstadoDivorcio()) {
					iterator.remove();
				}
			}
		}

		for (Persona p : usuarios) {
			if (usuarioActual instanceof Hombre) {
				if (usuarioActual.getLikesDados().contains(p.getAlias())) {
					vf.getApp().agregarUsuario(p.getAlias(), p.getImagen(), p.getEdad(), p.getEstatura(),
							p.getLikesRecibidos(), true, this);
				} else {
					vf.getApp().agregarUsuario(p.getAlias(), p.getImagen(), p.getEdad(), p.getEstatura(),
							p.getLikesRecibidos(), false, this);
				}
			} else {
				if (usuarioActual.getLikesDados().contains(p.getAlias())) {
					vf.getApp().agregarUsuario(p.getAlias(), p.getImagen(), p.getEdad(), p.getEstatura(),
							p.getLikesRecibidos(), true, this,
							String.format(Locale.US, "%.2f%n", convertirUSDAmoneda(((Hombre) p).getIngresoProm())));
				} else {
					vf.getApp().agregarUsuario(p.getAlias(), p.getImagen(), p.getEdad(), p.getEstatura(),
							p.getLikesRecibidos(), false, this,
							String.format(Locale.US, "%.2f%n", convertirUSDAmoneda(((Hombre) p).getIngresoProm())));
				}
			}
		}

	}

	private void agregarUsuariosVentanaAdmin() {

		vf.getAdmin().limpiarUsuarios();

		ArrayList<Persona> usuarios = mf.getPersonas();

		usuarios.removeIf(p -> p.getAlias().equals("admin"));

		for (Persona p : usuarios) {

			if (p instanceof Hombre) {
				vf.getAdmin().agregarUsuario(p.getAlias(), p.getImagen(), p.getEdad(), p.getEstatura(), this,
						String.format(Locale.US, "%.2f%n", convertirUSDAmoneda(((Hombre) p).getIngresoProm())));
			} else {
				vf.getAdmin().agregarUsuario(p.getAlias(), p.getImagen(), p.getEdad(), p.getEstatura(), this);

			}
		}
	}

	private void agregarTopUsuariosVentanaAdmin(int seleccionTop) {
		if (seleccionTop == 1) {

			vf.getAdmin().limpiarUsuarios();

			ArrayList<Persona> usuarios = mf.getPersonas();

			usuarios.removeIf(p -> p.getAlias().equals("admin"));

			for (int i = 0; i < 10; i++) {
				Persona p = usuarios.get(i);
				if (p instanceof Hombre) {
					vf.getAdmin().agregarUsuario(p.getAlias(), p.getImagen(), p.getEdad(), p.getEstatura(), this,
							String.format(Locale.US, "%.2f%n", convertirUSDAmoneda(((Hombre) p).getIngresoProm())));
				} else {
					vf.getAdmin().agregarUsuario(p.getAlias(), p.getImagen(), p.getEdad(), p.getEstatura(), this);
				}
			}
		}

		if (seleccionTop == 2) {

			vf.getAdmin().limpiarUsuarios();

			ArrayList<Persona> usuarios = mf.getPersonas();

			usuarios.removeIf(p -> p.getAlias().equals("admin"));

			for (int i = 0; i < 10; i++) {

				Persona p = mf.getHombreDAO().getHombres().get(i);

				vf.getAdmin().agregarUsuario(p.getAlias(), p.getImagen(), p.getEdad(), p.getEstatura(), this,
						String.format(Locale.US, "%.2f%n", convertirUSDAmoneda(((Hombre) p).getIngresoProm())));

			}

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

	private double[] ordenarInsercionAscendente(double[] datos) {
		if (datos == null || datos.length == 0) {
			return datos;
		}

		double[] datosOrdenados = new double[datos.length];
		for (int i = 0; i < datos.length; i++) {
			datosOrdenados[i] = datos[i];
		}

		for (int i = 1; i < datosOrdenados.length; i++) {
			double actual = datosOrdenados[i];
			int pos = i - 1;

			while (pos >= 0 && datosOrdenados[pos] > actual) {
				datosOrdenados[pos + 1] = datosOrdenados[pos];
				pos--;
			}

			datosOrdenados[pos + 1] = actual;
		}

		return datosOrdenados;
	}

	private int contarOcurrencias(double[] datos, double valor) {
		if (datos == null || datos.length == 0) {
			return 0;
		}

		int contador = 0;
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] == valor) {
				contador++;
			}
		}

		return contador;
	}

	private double calcularMedia(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}
		double suma = 0;
		for (double dato : datos) {
			suma += dato;
		}
		return suma / datos.length;
	}

	private double calcularMediana(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}

		double[] datosOrdenados = ordenarInsercionAscendente(datos);
		int n = datosOrdenados.length;

		if (n % 2 != 0) {
			return datosOrdenados[n / 2];
		} else {
			int medio1 = n / 2 - 1;
			int medio2 = n / 2;
			return (datosOrdenados[medio1] + datosOrdenados[medio2]) / 2.0;
		}
	}

	private double[] calcularModa(double[] datos) {
		if (datos == null || datos.length == 0) {
			return new double[] { 0 };
		}

		double[] valoresUnicos = new double[datos.length];
		int cantidadUnicos = 0;

		for (int i = 0; i < datos.length; i++) {
			boolean encontrado = false;

			for (int j = 0; j < cantidadUnicos; j++) {
				if (valoresUnicos[j] == datos[i]) {
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				valoresUnicos[cantidadUnicos] = datos[i];
				cantidadUnicos++;
			}
		}

		int[] frecuencias = new int[cantidadUnicos];
		for (int i = 0; i < cantidadUnicos; i++) {
			frecuencias[i] = contarOcurrencias(datos, valoresUnicos[i]);
		}

		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		if (maxFrecuencia == 1) {
			return new double[] { 0 };
		}

		int cantidadModas = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				cantidadModas++;
			}
		}

		double[] modas = new double[cantidadModas];
		int indiceModas = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				modas[indiceModas] = valoresUnicos[i];
				indiceModas++;
			}
		}

		return modas;
	}

	private double calcularVarianza(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}

		double media = calcularMedia(datos);
		double sumaDiferenciasCuadrado = 0;

		for (double dato : datos) {
			double diferencia = dato - media;
			double diferenciaAlCuadrado = diferencia * diferencia;
			sumaDiferenciasCuadrado += diferenciaAlCuadrado;
		}

		return sumaDiferenciasCuadrado / datos.length;
	}

	private double calcularDesviacion(double[] datos) {
		double varianza = calcularVarianza(datos);
		return Math.sqrt(varianza);
	}

	private double calcularMinimo(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}
		double minimo = datos[0];
		for (double dato : datos) {
			if (dato < minimo) {
				minimo = dato;
			}
		}
		return minimo;
	}

	private double calcularMaximo(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}
		double maximo = datos[0];
		for (double dato : datos) {
			if (dato > maximo) {
				maximo = dato;
			}
		}
		return maximo;
	}

	private double calcularRango(double[] datos) {
		return calcularMaximo(datos) - calcularMinimo(datos);
	}

	private String convertirModasAString(double[] modas) {
		if (modas == null || modas.length == 0) {
			return prop.getProperty("generarPDF.sinModa");
		}

		if (modas.length == 1 && modas[0] == 0) {
			return prop.getProperty("generarPDF.sinModa");
		}

		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < modas.length; i++) {
			sb.append(formatearNumero(modas[i]));
			if (i < modas.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	private String formatearNumero(double numero) {
		return String.format(Locale.US, "%.4f", numero);
	}

	public void generarInforme(double[] datos, String nombreArchivo) {
		if (datos == null || datos.length == 0) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.generarPdf.faltaDatos"));
			return;
		}

		try {
			File dirGraficos = new File("graficos_temp");
			if (!dirGraficos.exists()) {
				dirGraficos.mkdir();
			}

			File graficoBarras = crearGraficoBarras(datos, "graficos_temp/barras.png");
			File histograma = crearHistograma(datos, "graficos_temp/histograma.png");
			File graficoLinea = crearGraficoLinea(datos, "graficos_temp/linea.png");

			String rutaPDF = nombreArchivo + ".pdf";
			PdfWriter writer = new PdfWriter(rutaPDF);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);

			Paragraph titulo = new Paragraph(prop.getProperty("generarPDF.titulo")).setFontSize(20)
					.setTextAlignment(TextAlignment.CENTER);
			document.add(titulo);

			LocalDateTime ahora = LocalDateTime.now();
			Paragraph fechaHora = new Paragraph(prop.getProperty("generarPDF.generado") + " "
					+ ahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).setFontSize(10)
					.setTextAlignment(TextAlignment.RIGHT);
			document.add(fechaHora);

			document.add(new Paragraph("\n"));

			Table tabla = new Table(2);
			tabla.setWidth(UnitValue.createPercentValue(60));

			// Encabezados
			tabla.addHeaderCell(prop.getProperty("generarPDF.medida"));
			tabla.addHeaderCell(prop.getProperty("generarPDF.valor"));

			// Datos
			tabla.addCell(prop.getProperty("generarPDF.media"));
			tabla.addCell(formatearNumero(calcularMedia(datos)));

			tabla.addCell(prop.getProperty("generarPDF.mediana"));
			tabla.addCell(formatearNumero(calcularMediana(datos)));

			tabla.addCell(prop.getProperty("generarPDF.moda"));
			tabla.addCell(convertirModasAString(calcularModa(datos)));

			tabla.addCell(prop.getProperty("generarPDF.desviacion"));
			tabla.addCell(formatearNumero(calcularDesviacion(datos)));

			tabla.addCell(prop.getProperty("generarPDF.varianza"));
			tabla.addCell(formatearNumero(calcularVarianza(datos)));

			tabla.addCell(prop.getProperty("generarPDF.minimo"));
			tabla.addCell(formatearNumero(calcularMinimo(datos)));

			tabla.addCell(prop.getProperty("generarPDF.maximo"));
			tabla.addCell(formatearNumero(calcularMaximo(datos)));

			tabla.addCell(prop.getProperty("generarPDF.rango"));
			tabla.addCell(formatearNumero(calcularRango(datos)));

			tabla.addCell(prop.getProperty("generarPDF.cantidad"));
			tabla.addCell(String.valueOf(datos.length));

			document.add(tabla);
			document.add(new Paragraph("\n"));

			if (graficoBarras != null) {
				document.add(new Paragraph(prop.getProperty("generarPDF.grafico.barras")).setFontSize(14));
				Image imgBarras = new Image(ImageDataFactory.create(graficoBarras.getAbsolutePath()));
				imgBarras.setWidth(UnitValue.createPercentValue(80));
				document.add(imgBarras);
				document.add(new Paragraph("\n"));
			}

			if (histograma != null) {
				document.add(new Paragraph(prop.getProperty("generarPDF.grafico.histograma")).setFontSize(14));
				Image imgHisto = new Image(ImageDataFactory.create(histograma.getAbsolutePath()));
				imgHisto.setWidth(UnitValue.createPercentValue(80));
				document.add(imgHisto);
				document.add(new Paragraph("\n"));
			}

			if (graficoLinea != null) {
				document.add(new Paragraph(prop.getProperty("generarPDF.grafico.linea")).setFontSize(14));
				Image imgLinea = new Image(ImageDataFactory.create(graficoLinea.getAbsolutePath()));
				imgLinea.setWidth(UnitValue.createPercentValue(80));
				document.add(imgLinea);
			}

			document.close();

			limpiarArchivosTemporales(dirGraficos);

			vf.getVentanaPrincipal().mostrarMensaje(prop.getProperty("mensaje.generarPDF.exito") + " " + rutaPDF);

		} catch (Exception e) {
			vf.getVentanaPrincipal().mostrarError(prop.getProperty("error.generarPDF.creacion") + " " + e.getMessage());
		}
	}

	private File crearGraficoBarras(double[] datos, String rutaArchivo) {
		try {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			dataset.addValue(calcularMedia(datos), prop.getProperty("generarPDF.valor"),
					prop.getProperty("generarPDF.media"));
			dataset.addValue(calcularMediana(datos), prop.getProperty("generarPDF.valor"),
					prop.getProperty("generarPDF.mediana"));
			dataset.addValue(calcularDesviacion(datos), prop.getProperty("generarPDF.valor"),
					prop.getProperty("generarPDF.desviacion1"));
			dataset.addValue(calcularVarianza(datos), prop.getProperty("generarPDF.valor"),
					prop.getProperty("generarPDF.varianza"));

			JFreeChart chart = ChartFactory.createBarChart(prop.getProperty("generarPDF.estadisticasDescriptivas"),
					prop.getProperty("generarPDF.medida"), prop.getProperty("generarPDF.valor"), dataset,
					PlotOrientation.VERTICAL, true, true, false);

			File chartFile = new File(rutaArchivo);
			ChartUtils.saveChartAsPNG(chartFile, chart, 600, 400);
			return chartFile;
		} catch (Exception e) {
			vf.getVentanaPrincipal()
					.mostrarError(prop.getProperty("error.generarPDF.grafico.barras") + " " + e.getMessage());
			return null;
		}
	}

	private File crearHistograma(double[] datos, String rutaArchivo) {
		try {
			HistogramDataset dataset = new HistogramDataset();
			dataset.addSeries(prop.getProperty("generarPDF.frecuencia"), datos, 10);

			JFreeChart chart = ChartFactory.createHistogram(prop.getProperty("generarPDF.distribucion"),
					prop.getProperty("generarPDF.valores"), prop.getProperty("generarPDF.frecuencia"), dataset,
					PlotOrientation.VERTICAL, true, true, false);

			File chartFile = new File(rutaArchivo);
			ChartUtils.saveChartAsPNG(chartFile, chart, 600, 400);
			return chartFile;
		} catch (Exception e) {
			vf.getVentanaPrincipal()
					.mostrarError(prop.getProperty("error.generarPDF.grafico.histograma") + " " + e.getMessage());
			return null;
		}
	}

	private File crearGraficoLinea(double[] datos, String rutaArchivo) {
		try {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			for (int i = 0; i < datos.length; i++) {
				dataset.addValue(datos[i], prop.getProperty("generarPDF.datos"), String.valueOf(i + 1));
			}

			JFreeChart chart = ChartFactory.createLineChart(prop.getProperty("generarPDF.tendencia"),
					prop.getProperty("generarPDF.indice"), prop.getProperty("generarPDF.valor"), dataset,
					PlotOrientation.VERTICAL, true, true, false);

			File chartFile = new File(rutaArchivo);
			ChartUtils.saveChartAsPNG(chartFile, chart, 600, 400);
			return chartFile;
		} catch (Exception e) {
			vf.getVentanaPrincipal()
					.mostrarError(prop.getProperty("error.generarPDF.grafico.linea") + " " + e.getMessage());
			return null;
		}
	}

	private void limpiarArchivosTemporales(File directorio) {
		if (directorio != null && directorio.isDirectory()) {
			File[] archivos = directorio.listFiles();
			if (archivos != null) {
				for (File archivo : archivos) {
					if (archivo.isFile()) {
						archivo.delete();
					}
				}
			}
			directorio.delete();
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
		vf.getPer().mostrarTextos(prop.getProperty("ventana.perfil.botonCambiarModo"));
		vf.getAdmin().mostrarTextos(prop.getProperty("ventana.admin.botonOrdenarPor"),
				prop.getProperty("ventana.admin.botonAscendente"), prop.getProperty("ventana.admin.botonDescendente"),
				prop.getProperty("ventana.admin.porEdad"), prop.getProperty("ventana.admin.porNombre"),
				prop.getProperty("ventana.admin.porAlias"), prop.getProperty("ventana.admin.porLikes"),
				prop.getProperty("ventana.admin.porLikes"), prop.getProperty("ventana.admin.porIngreso"),
				prop.getProperty("ventana.admin.botonTop"), prop.getProperty("ventana.admin.ordenarPor"),
				prop.getProperty("ventana.admin.criterio"), prop.getProperty("ventana.admin.labelTop"),
				prop.getProperty("ventana.admin.pdf"), prop.getProperty("ventana.admin.porEdad"),
				prop.getProperty("ventana.admin.porLikes"), prop.getProperty("ventana.admin.porIngreso"),
				prop.getProperty("ventana.admin.porEstatura"),prop.getProperty("ventana.perfil.botonCambiarModo"));
	}
}
