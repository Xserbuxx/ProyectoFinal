package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que representa el panel de registro de usuarios en la aplicación.
 * Proporciona una interfaz gráfica para que los usuarios ingresen sus datos personales
 * y preferencias para crear una cuenta en el sistema.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class Registro extends JPanel {

	/** Scroll pane que contiene el panel izquierda */
	private JScrollPane scroll;
	
	/** Panel principal que contiene todos los componentes del formulario */
	private JPanel izquierda;

	/** Botón para confirmar el registro */
	private JButton botonConfirmar;
	
	/** Botón para redirigir al inicio de sesión */
	private JButton botonIniciarSesion;

	/** Botón para seleccionar el sexo masculino */
	private JButton botonSexoHombre;
	
	/** Botón para seleccionar el sexo femenino */
	private JButton botonSexoMujer;

	/** Radio button para indicar disponibilidad */
	private JRadioButton disponible;
	
	/** Radio button para indicar no disponibilidad */
	private JRadioButton noDisponible;
	
	/** Grupo de botones para la disponibilidad */
	private ButtonGroup grupoDisponibilidad;

	/** Radio button para indicar estado divorciada */
	private JRadioButton divorciada;
	
	/** Radio button para indicar estado no divorciada */
	private JRadioButton noDivorciada;
	
	/** Grupo de botones para el estado civil */
	private ButtonGroup grupoSexo;

	/** Botón para examinar y seleccionar una imagen */
	private JButton botonExaminar;

	/** Campo de texto para ingresar el nombre */
	private JTextField campoNombre;
	
	/** Campo de texto para ingresar el alias */
	private JTextField campoAlias;
	
	/** Campo de texto para ingresar la edad */
	private JTextField campoEdad;
	
	/** Campo de texto para ingresar la fecha de nacimiento */
	private JTextField campoFechaNacimiento;
	
	/** Campo de texto para ingresar la estatura */
	private JTextField campoEstatura;
	
	/** Campo de texto para ingresar el correo electrónico */
	private JTextField campoCorreo;
	
	/** Campo de texto para mostrar la ruta de la imagen seleccionada */
	private JTextField campoImagen;
	
	/** Campo de texto para ingresar la contraseña */
	private JTextField campoContrasena;

	/** Campo de texto para ingresar el ingreso promedio (solo para hombres) */
	private JTextField campoIngresoProm;

	/** Selector de archivos para elegir la imagen de perfil */
	private JFileChooser fileChooser;
	
	/** Botón para cambiar entre modo claro y oscuro */
	private JButton cambiarModo;

	/**
	 * Constructor de la clase Registro.
	 * Inicializa todos los componentes gráficos del panel de registro,
	 * configura sus propiedades visuales y los agrega al panel.
	 */
	public Registro() {
		this.setLayout(null);

		Color colorTinder = new Color(255, 51, 102);
		disponible = new JRadioButton();
		disponible.setBounds(370, 770, 140, 25);
		disponible.setBackground(new Color(59, 59, 59));
		disponible.setForeground(Color.WHITE);
		disponible.setFocusable(false);
		disponible.setFocusPainted(false);
		disponible.setBorderPainted(false);

		noDisponible = new JRadioButton();
		noDisponible.setBounds(520, 770, 160, 25);
		noDisponible.setBackground(new Color(59, 59, 59));
		noDisponible.setForeground(Color.WHITE);
		noDisponible.setFocusable(false);
		noDisponible.setFocusPainted(false);
		noDisponible.setBorderPainted(false);

		grupoDisponibilidad = new ButtonGroup();
		grupoDisponibilidad.add(disponible);
		grupoDisponibilidad.add(noDisponible);

		divorciada = new JRadioButton();
		divorciada.setBounds(370, 890, 200, 20);
		divorciada.setBackground(new Color(59, 59, 59));
		divorciada.setForeground(Color.WHITE);
		divorciada.setFocusable(false);
		divorciada.setFocusPainted(false);
		divorciada.setBorderPainted(false);
		divorciada.setVisible(false);
		divorciada.setEnabled(false);

		noDivorciada = new JRadioButton();
		noDivorciada.setBounds(370, 915, 200, 20);
		noDivorciada.setBackground(new Color(59, 59, 59));
		noDivorciada.setForeground(Color.WHITE);
		noDivorciada.setFocusable(false);
		noDivorciada.setFocusPainted(false);
		noDivorciada.setBorderPainted(false);
		noDivorciada.setVisible(false);
		noDivorciada.setEnabled(false);

		grupoSexo = new ButtonGroup();
		grupoSexo.add(divorciada);
		grupoSexo.add(noDivorciada);

		izquierda = new JPanel();
		izquierda.setLayout(null);
		izquierda.setPreferredSize(new Dimension(1280, 1400));
		izquierda.setBackground(new Color(59, 59, 59));

		scroll = new JScrollPane(izquierda, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 0, 1280, 720);
		scroll.getVerticalScrollBar().setBackground(new Color(36, 41, 46));
		scroll.getVerticalScrollBar().setUnitIncrement(24);

		botonSexoHombre = new JButton("♂");
		botonSexoHombre.setBounds(370, 200, 50, 30);
		CampoRedondeado.aplicarRedondeado(botonSexoHombre, 20, new Color(3, 102, 214), Color.WHITE);

		botonSexoMujer = new JButton("♀");
		botonSexoMujer.setBounds(430, 200, 50, 30);
		CampoRedondeado.aplicarRedondeado(botonSexoMujer, 20, colorTinder, Color.WHITE);

		Font campoFuente = new Font("Sans", Font.PLAIN, 14);

		campoNombre = new CampoRedondeado(15, 45);
		campoNombre.setBounds(370, 250, 500, 45);
		campoNombre.setFont(campoFuente);

		campoAlias = new CampoRedondeado(15, 45);
		campoAlias.setBounds(370, 320, 500, 45);
		campoAlias.setFont(campoFuente);

		campoEdad = new CampoRedondeado(15, 45);
		campoEdad.setBounds(370, 390, 500, 45);
		campoEdad.setFont(campoFuente);

		campoFechaNacimiento = new CampoRedondeado(15, 45);
		campoFechaNacimiento.setBounds(370, 460, 500, 45);
		campoFechaNacimiento.setFont(campoFuente);

		campoEstatura = new CampoRedondeado(15, 45);
		campoEstatura.setBounds(370, 530, 500, 45);
		campoEstatura.setFont(campoFuente);

		campoCorreo = new CampoRedondeado(15, 45);
		campoCorreo.setBounds(370, 600, 500, 45);
		campoCorreo.setFont(campoFuente);

		campoImagen = new CampoRedondeado(15, 45);
		campoImagen.setBounds(370, 670, 380, 45);
		campoImagen.setFont(campoFuente);
		campoImagen.setEditable(false);

		botonExaminar = new JButton();
		botonExaminar.setBounds(760, 670, 110, 45);
		botonExaminar.setFont(new Font("Sans", Font.BOLD, 12));
		CampoRedondeado.aplicarRedondeado(botonExaminar, 25, colorTinder, Color.WHITE);

		campoContrasena = new CampoRedondeado(15, 45);
		campoContrasena.setBounds(370, 830, 500, 45);
		campoContrasena.setFont(campoFuente);

		campoIngresoProm = new CampoRedondeado(15, 45);
		campoIngresoProm.setBounds(370, 890, 500, 45);
		campoIngresoProm.setFont(campoFuente);
		campoIngresoProm.setVisible(false);
		campoIngresoProm.setEnabled(false);

		botonConfirmar = new JButton();
		botonConfirmar.setBounds(470, 1020, 330, 50);
		CampoRedondeado.aplicarRedondeado(botonConfirmar, 25, colorTinder, Color.WHITE);

		botonIniciarSesion = new JButton();
		botonIniciarSesion.setBounds(460, 1100, 200, 18);
		botonIniciarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		botonIniciarSesion.setFont(new Font("Sans", Font.BOLD, 14));
		botonIniciarSesion.setForeground(colorTinder);
		botonIniciarSesion.setContentAreaFilled(false);
		botonIniciarSesion.setBorderPainted(false);
		botonIniciarSesion.setFocusPainted(false);
		
		cambiarModo = new JButton();
		cambiarModo.setBounds(10, 10, 180, 40);
		CampoRedondeado.aplicarRedondeado(cambiarModo, 25, new Color(255, 51, 102), Color.WHITE);
		
		izquierda.add(cambiarModo);
		izquierda.add(botonExaminar);
		izquierda.add(botonSexoMujer);
		izquierda.add(botonSexoHombre);
		izquierda.add(campoNombre);
		izquierda.add(campoAlias);
		izquierda.add(campoEdad);
		izquierda.add(campoFechaNacimiento);
		izquierda.add(campoEstatura);
		izquierda.add(campoCorreo);
		izquierda.add(campoImagen);
		izquierda.add(campoContrasena);
		izquierda.add(disponible);
		izquierda.add(noDisponible);
		izquierda.add(divorciada);
		izquierda.add(noDivorciada);
		izquierda.add(campoIngresoProm);
		izquierda.add(botonConfirmar);
		izquierda.add(botonIniciarSesion);

		this.add(scroll);

	}

	/**
	 * Muestra todos los textos de las etiquetas del formulario de registro.
	 * Este método es utilizado para la internacionalización de la interfaz.
	 * 
	 * @param labelRegistro Texto del título de registro
	 * @param labelNombre Texto de la etiqueta de nombre
	 * @param labelAlias Texto de la etiqueta de alias
	 * @param labelEdad Texto de la etiqueta de edad
	 * @param labelFechaNacimiento Texto de la etiqueta de fecha de nacimiento
	 * @param labelEstatura Texto de la etiqueta de estatura
	 * @param labelCorreo Texto de la etiqueta de correo
	 * @param labelImagen Texto de la etiqueta de imagen
	 * @param labelDisponibilidad Texto de la etiqueta de disponibilidad
	 * @param labelDisponible Texto para la opción disponible
	 * @param labelNoDisponible Texto para la opción no disponible
	 * @param labelContrasena Texto de la etiqueta de contraseña
	 * @param labelBotonConfirmar Texto del botón confirmar
	 * @param labelBotonIniciarSesionTexto Texto del botón iniciar sesión
	 * @param labelYaCuenta Texto para "ya tiene cuenta"
	 * @param labelSexo Texto de la etiqueta de sexo
	 * @param labelDivorciada Texto para la opción divorciada
	 * @param labelNoDivorciada Texto para la opción no divorciada
	 * @param labelBotonExaminar Texto del botón examinar
	 * @param labelCambiarModo Texto del botón cambiar modo
	 */
	public void mostrarTextos(String labelRegistro, String labelNombre, String labelAlias, String labelEdad,
			String labelFechaNacimiento, String labelEstatura, String labelCorreo, String labelImagen,
			String labelDisponibilidad, String labelDisponible, String labelNoDisponible, String labelContrasena,
			String labelBotonConfirmar, String labelBotonIniciarSesionTexto, String labelYaCuenta, String labelSexo,
			String labelDivorciada, String labelNoDivorciada, String labelBotonExaminar, String labelCambiarModo) {

		Color colorTinder = new Color(255, 51, 102);
		int xCampo = 370;
		int anchoLabel = 540;

		crearLabel(labelRegistro, colorTinder, 520, 90, 300, 50, 30);

		crearLabel(labelSexo, Color.WHITE, xCampo, 170, anchoLabel, 30, 20);
		crearLabel(labelNombre, Color.WHITE, xCampo, 225, anchoLabel, 30, 20);
		crearLabel(labelAlias, Color.WHITE, xCampo, 295, anchoLabel, 30, 20);
		crearLabel(labelEdad, Color.WHITE, xCampo, 365, anchoLabel, 30, 20);
		crearLabel(labelFechaNacimiento, Color.WHITE, xCampo, 435, anchoLabel, 30, 20);
		crearLabel(labelEstatura, Color.WHITE, xCampo, 505, anchoLabel, 30, 20);
		crearLabel(labelCorreo, Color.WHITE, xCampo, 575, anchoLabel, 30, 20);

		crearLabel(labelImagen, Color.WHITE, xCampo, 645, anchoLabel, 30, 20);
		crearLabel(labelDisponibilidad, Color.WHITE, xCampo, 745, anchoLabel, 30, 20);
		crearLabel(labelContrasena, Color.WHITE, xCampo, 805, anchoLabel, 30, 20);

		crearLabel(labelYaCuenta,  new Color(255, 255, 255, 200), 470, 1070, 200, 30, 18);

		botonConfirmar.setText(labelBotonConfirmar);
		botonIniciarSesion.setText(labelBotonIniciarSesionTexto);

		disponible.setText(labelDisponible);
		noDisponible.setText(labelNoDisponible);

		divorciada.setText(labelDivorciada);
		noDivorciada.setText(labelNoDivorciada);

		botonExaminar.setText(labelBotonExaminar);
		
		cambiarModo.setText(labelCambiarModo);
	}

	/**
	 * Muestra el campo específico para usuarios hombres (ingreso promedio).
	 * Oculta los campos específicos de mujeres.
	 * 
	 * @param labelIngresoProm Texto de la etiqueta de ingreso promedio
	 */
	public void mostrarCampoHombre(String labelIngresoProm) {

		divorciada.setVisible(false);
		divorciada.setEnabled(false);
		noDivorciada.setVisible(false);
		noDivorciada.setEnabled(false);

		campoIngresoProm.setVisible(true);
		campoIngresoProm.setEnabled(true);
		campoIngresoProm.setBounds(370, 930, 500, 45);
		grupoSexo.clearSelection();

		crearLabel(labelIngresoProm, Color.WHITE, 370, 900, 500, 30, 20);
	}

	/**
	 * Muestra los campos específicos para usuarios mujeres (estado civil).
	 * Oculta los campos específicos de hombres.
	 * 
	 * @param labelDivorciada Texto de la etiqueta de estado divorciada
	 */
	public void mostrarCampoMujer(String labelDivorciada) {

		campoIngresoProm.setVisible(false);
		campoIngresoProm.setEnabled(false);
		campoIngresoProm.setText("");
		divorciada.setVisible(true);
		divorciada.setEnabled(true);
		divorciada.setBounds(370, 930, 250, 20);

		noDivorciada.setVisible(true);
		noDivorciada.setEnabled(true);
		noDivorciada.setBounds(370, 960, 350, 20);

		crearLabel(labelDivorciada, Color.WHITE, 370, 900, 300, 30, 20);

	}

	/**
	 * Elimina las etiquetas relacionadas con los campos específicos de sexo.
	 * 
	 * @param labelIngresoProm Texto de la etiqueta de ingreso promedio
	 * @param labelDivorciada Texto de la etiqueta de estado divorciada
	 */
	public void eliminarLabelSexos(String labelIngresoProm, String labelDivorciada) {
		for (Component c : izquierda.getComponents()) {
			if (!(c instanceof JLabel)) {
				continue;
			}
			if (((JLabel) c).getText().equals(labelIngresoProm) || ((JLabel) c).getText().equals(labelDivorciada)) {
				izquierda.remove(c);
				izquierda.revalidate();
				izquierda.repaint();
			}

		}
	}

	/**
	 * Abre un cuadro de diálogo para seleccionar una imagen de perfil.
	 * Solo permite archivos con extensión .jpg
	 */
	public void obtenerRutaImagen() {
		fileChooser = new JFileChooser();

		fileChooser.setFileFilter(new FileNameExtensionFilter("Files (jpg)", "jpg"));

		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			campoImagen.setText(fileChooser.getSelectedFile().getAbsolutePath());
		}
	}

	/**
	 * Cambia entre el modo oscuro y modo claro de la interfaz.
	 * Alterna los colores de fondo y texto de todos los componentes.
	 */
	public void cambiarModo() {
		Color fondo;
		Color texto;
		Color fondoI;
		Color textoI;

		if (izquierda.getBackground().equals(Color.WHITE)) {
			fondo = new Color(59, 59, 59);
			fondoI = Color.WHITE;
			texto = Color.WHITE;
			textoI = Color.BLACK;
		} else {
			fondo = Color.WHITE;
			fondoI = new Color(59, 59, 59);
			texto = Color.BLACK;
			textoI = Color.WHITE;
		}

		izquierda.setBackground(fondo);

		for (Component c : izquierda.getComponents()) {
			if (c instanceof JLabel) {
				c.setForeground(texto);
			} else if (c instanceof JRadioButton) {
				((JRadioButton) c).setBackground(fondo);
				((JRadioButton) c).setForeground(texto);
			} else if (c instanceof JTextField) {
				((JTextField) c).setBackground(fondoI);
				((JTextField) c).setForeground(textoI);
			}
		}
		
		izquierda.revalidate();
		izquierda.repaint();	
	}

	/**
	 * Crea y agrega una etiqueta al panel con las propiedades especificadas.
	 * 
	 * @param texto Texto a mostrar en la etiqueta
	 * @param colorFondo Color del fondo (no utilizado actualmente)
	 * @param x Posición X de la etiqueta
	 * @param y Posición Y de la etiqueta
	 * @param ancho Ancho de la etiqueta
	 * @param alto Alto de la etiqueta
	 * @param tamanoLetra Tamaño de la fuente
	 */
	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(new Color(200, 200, 200));
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Segoe UI", Font.BOLD, tamanoLetra - 4));
		izquierda.add(label);
	}

	/**
	 * Limpia todos los campos del formulario y restablece las selecciones.
	 * Oculta los campos específicos de sexo.
	 */
	public void limpiarCampos() {
		campoNombre.setText("");
		campoAlias.setText("");
		campoEdad.setText("");
		campoFechaNacimiento.setText("");
		campoEstatura.setText("");
		campoCorreo.setText("");
		campoImagen.setText("");
		campoContrasena.setText("");
		campoIngresoProm.setText("");
		grupoDisponibilidad.clearSelection();
		grupoSexo.clearSelection();
		divorciada.setVisible(false);
		divorciada.setEnabled(false);
		noDivorciada.setVisible(false);
		noDivorciada.setEnabled(false);
		campoIngresoProm.setVisible(false);
		campoIngresoProm.setEnabled(false);
	}

	/**
	 * Obtiene el scroll pane del panel.
	 * 
	 * @return El scroll pane
	 */
	public JScrollPane getScroll() {
		return scroll;
	}

	/**
	 * Establece el scroll pane del panel.
	 * 
	 * @param scroll El scroll pane a establecer
	 */
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	/**
	 * Obtiene el panel izquierda que contiene el formulario.
	 * 
	 * @return El panel izquierda
	 */
	public JPanel getIzquierda() {
		return izquierda;
	}

	/**
	 * Establece el panel izquierda.
	 * 
	 * @param izquierda El panel a establecer
	 */
	public void setIzquierda(JPanel izquierda) {
		this.izquierda = izquierda;
	}

	/**
	 * Obtiene el botón de confirmar registro.
	 * 
	 * @return El botón confirmar
	 */
	public JButton getBotonConfirmar() {
		return botonConfirmar;
	}

	/**
	 * Establece el botón de confirmar registro.
	 * 
	 * @param botonConfirmar El botón a establecer
	 */
	public void setBotonConfirmar(JButton botonConfirmar) {
		this.botonConfirmar = botonConfirmar;
	}

	/**
	 * Obtiene el botón de iniciar sesión.
	 * 
	 * @return El botón iniciar sesión
	 */
	public JButton getBotonIniciarSesion() {
		return botonIniciarSesion;
	}

	/**
	 * Establece el botón de iniciar sesión.
	 * 
	 * @param botonIniciarSesion El botón a establecer
	 */
	public void setBotonIniciarSesion(JButton botonIniciarSesion) {
		this.botonIniciarSesion = botonIniciarSesion;
	}

	/**
	 * Obtiene el botón de selección de sexo hombre.
	 * 
	 * @return El botón sexo hombre
	 */
	public JButton getBotonSexoHombre() {
		return botonSexoHombre;
	}

	/**
	 * Establece el botón de selección de sexo hombre.
	 * 
	 * @param botonSexoHombre El botón a establecer
	 */
	public void setBotonSexoHombre(JButton botonSexoHombre) {
		this.botonSexoHombre = botonSexoHombre;
	}

	/**
	 * Obtiene el botón de selección de sexo mujer.
	 * 
	 * @return El botón sexo mujer
	 */
	public JButton getBotonSexoMujer() {
		return botonSexoMujer;
	}

	/**
	 * Establece el botón de selección de sexo mujer.
	 * 
	 * @param botonSexoMujer El botón a establecer
	 */
	public void setBotonSexoMujer(JButton botonSexoMujer) {
		this.botonSexoMujer = botonSexoMujer;
	}

	/**
	 * Obtiene el radio button de disponible.
	 * 
	 * @return El radio button disponible
	 */
	public JRadioButton getDisponible() {
		return disponible;
	}

	/**
	 * Establece el radio button de disponible.
	 * 
	 * @param disponible El radio button a establecer
	 */
	public void setDisponible(JRadioButton disponible) {
		this.disponible = disponible;
	}

	/**
	 * Obtiene el radio button de no disponible.
	 * 
	 * @return El radio button no disponible
	 */
	public JRadioButton getNoDisponible() {
		return noDisponible;
	}

	/**
	 * Establece el radio button de no disponible.
	 * 
	 * @param noDisponible El radio button a establecer
	 */
	public void setNoDisponible(JRadioButton noDisponible) {
		this.noDisponible = noDisponible;
	}

	/**
	 * Obtiene el grupo de botones de disponibilidad.
	 * 
	 * @return El grupo de disponibilidad
	 */
	public ButtonGroup getGrupoDisponibilidad() {
		return grupoDisponibilidad;
	}

	/**
	 * Establece el grupo de botones de disponibilidad.
	 * 
	 * @param grupoDisponibilidad El grupo a establecer
	 */
	public void setGrupoDisponibilidad(ButtonGroup grupoDisponibilidad) {
		this.grupoDisponibilidad = grupoDisponibilidad;
	}

	/**
	 * Obtiene el campo de texto del nombre.
	 * 
	 * @return El campo nombre
	 */
	public JTextField getCampoNombre() {
		return campoNombre;
	}

	/**
	 * Establece el campo de texto del nombre.
	 * 
	 * @param campoNombre El campo a establecer
	 */
	public void setCampoNombre(JTextField campoNombre) {
		this.campoNombre = campoNombre;
	}

	/**
	 * Obtiene el campo de texto del alias.
	 * 
	 * @return El campo alias
	 */
	public JTextField getCampoAlias() {
		return campoAlias;
	}

	/**
	 * Establece el campo de texto del alias.
	 * 
	 * @param campoAlias El campo a establecer
	 */
	public void setCampoAlias(JTextField campoAlias) {
		this.campoAlias = campoAlias;
	}

	/**
	 * Obtiene el campo de texto de la edad.
	 * 
	 * @return El campo edad
	 */
	public JTextField getCampoEdad() {
		return campoEdad;
	}

	/**
	 * Establece el campo de texto de la edad.
	 * 
	 * @param campoEdad El campo a establecer
	 */
	public void setCampoEdad(JTextField campoEdad) {
		this.campoEdad = campoEdad;
	}

	/**
	 * Obtiene el campo de texto de la fecha de nacimiento.
	 * 
	 * @return El campo fecha de nacimiento
	 */
	public JTextField getCampoFechaNacimiento() {
		return campoFechaNacimiento;
	}

	/**
	 * Establece el campo de texto de la fecha de nacimiento.
	 * 
	 * @param campoFechaNacimiento El campo a establecer
	 */
	public void setCampoFechaNacimiento(JTextField campoFechaNacimiento) {
		this.campoFechaNacimiento = campoFechaNacimiento;
	}

	/**
	 * Obtiene el campo de texto de la estatura.
	 * 
	 * @return El campo estatura
	 */
	public JTextField getCampoEstatura() {
		return campoEstatura;
	}

	/**
	 * Establece el campo de texto de la estatura.
	 * 
	 * @param campoEstatura El campo a establecer
	 */
	public void setCampoEstatura(JTextField campoEstatura) {
		this.campoEstatura = campoEstatura;
	}

	/**
	 * Obtiene el campo de texto del correo electrónico.
	 * 
	 * @return El campo correo
	 */
	public JTextField getCampoCorreo() {
		return campoCorreo;
	}

	/**
	 * Establece el campo de texto del correo electrónico.
	 * 
	 * @param campoCorreo El campo a establecer
	 */
	public void setCampoCorreo(JTextField campoCorreo) {
		this.campoCorreo = campoCorreo;
	}

	/**
	 * Obtiene el campo de texto de la imagen.
	 * 
	 * @return El campo imagen
	 */
	public JTextField getCampoImagen() {
		return campoImagen;
	}

	/**
	 * Establece el campo de texto de la imagen.
	 * 
	 * @param campoImagen El campo a establecer
	 */
	public void setCampoImagen(JTextField campoImagen) {
		this.campoImagen = campoImagen;
	}

	/**
	 * Obtiene el campo de texto de la contraseña.
	 * 
	 * @return El campo contraseña
	 */
	public JTextField getCampoContrasena() {
		return campoContrasena;
	}

	/**
	 * Establece el campo de texto de la contraseña.
	 * 
	 * @param campoContrasena El campo a establecer
	 */
	public void setCampoContrasena(JTextField campoContrasena) {
		this.campoContrasena = campoContrasena;
	}

	/**
	 * Obtiene el campo de texto del ingreso promedio.
	 * 
	 * @return El campo ingreso promedio
	 */
	public JTextField getCampoIngresoProm() {
		return campoIngresoProm;
	}

	/**
	 * Establece el campo de texto del ingreso promedio.
	 * 
	 * @param campoIngresoProm El campo a establecer
	 */
	public void setCampoIngresoProm(JTextField campoIngresoProm) {
		this.campoIngresoProm = campoIngresoProm;
	}

	/**
	 * Obtiene el radio button de divorciada.
	 * 
	 * @return El radio button divorciada
	 */
	public JRadioButton getDivorciada() {
		return divorciada;
	}

	/**
	 * Establece el radio button de divorciada.
	 * 
	 * @param divorciada El radio button a establecer
	 */
	public void setDivorciada(JRadioButton divorciada) {
		this.divorciada = divorciada;
	}

	/**
	 * Obtiene el radio button de no divorciada.
	 * 
	 * @return El radio button no divorciada
	 */
	public JRadioButton getNoDivorciada() {
		return noDivorciada;
	}

	/**
	 * Establece el radio button de no divorciada.
	 * 
	 * @param noDivorciada El radio button a establecer
	 */
	public void setNoDivorciada(JRadioButton noDivorciada) {
		this.noDivorciada = noDivorciada;
	}

	/**
	 * Obtiene el grupo de botones de sexo.
	 * 
	 * @return El grupo de sexo
	 */
	public ButtonGroup getGrupoSexo() {
		return grupoSexo;
	}

	/**
	 * Establece el grupo de botones de sexo.
	 * 
	 * @param grupoSexo El grupo a establecer
	 */
	public void setGrupoSexo(ButtonGroup grupoSexo) {
		this.grupoSexo = grupoSexo;
	}

	/**
	 * Obtiene el botón examinar.
	 * 
	 * @return El botón examinar
	 */
	public JButton getBotonExaminar() {
		return botonExaminar;
	}

	/**
	 * Establece el botón examinar.
	 * 
	 * @param botonExaminar El botón a establecer
	 */
	public void setBotonExaminar(JButton botonExaminar) {
		this.botonExaminar = botonExaminar;
	}

	/**
	 * Obtiene el selector de archivos.
	 * 
	 * @return El file chooser
	 */
	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	/**
	 * Establece el selector de archivos.
	 * 
	 * @param fileChooser El file chooser a establecer
	 */
	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	/**
	 * Obtiene el botón cambiar modo.
	 * 
	 * @return El botón cambiar modo
	 */
	public JButton getCambiarModo() {
		return cambiarModo;
	}

	/**
	 * Establece el botón cambiar modo.
	 * 
	 * @param cambiarModo El botón a establecer
	 */
	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}
	
}