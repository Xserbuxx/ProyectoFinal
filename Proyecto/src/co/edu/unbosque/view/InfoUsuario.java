package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel de información detallada de un usuario.
 * Muestra el perfil completo de un usuario seleccionado desde el panel de administración.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class InfoUsuario extends JPanel {

	/** Botón para volver al menú anterior */
	private JButton botonVolver;
	
	/** Botón para cambiar entre modo claro y oscuro */
	private JButton cambiarModo;

	/**
	 * Constructor que inicializa el panel de información de usuario.
	 * Crea la interfaz con los botones de navegación.
	 */
	public InfoUsuario() {
		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));

		JPanel barraLateral = new JPanel();
		barraLateral.setLayout(null);
		barraLateral.setBackground(new Color(255, 51, 102));
		barraLateral.setBounds(0, 0, 350, 720);

		ImageIcon imgLogo = new ImageIcon("Resources/logo.png");
		JLabel logo = new JLabel(new ImageIcon(imgLogo.getImage().getScaledInstance(180, 60, Image.SCALE_SMOOTH)));
		logo.setBounds(60, 0, 180, 75);
		barraLateral.add(logo);
		
		ImageIcon imagenVolver = new ImageIcon("Resources/volver3.png");
		Image imagenRedimensionadaVolver = imagenVolver.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionada = new ImageIcon(imagenRedimensionadaVolver);

		botonVolver = new JButton(imagenRedimensionada);
		botonVolver.setBounds(10, 10, 50, 50);
		botonVolver.setBackground(new Color(255, 51, 102));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setFocusable(false);

		cambiarModo = new JButton();
		cambiarModo.setBounds(1060, 15, 180, 40);
		CampoRedondeado.aplicarRedondeado(cambiarModo, 25, new Color(255, 51, 102), Color.WHITE);

		this.add(botonVolver);
		this.add(cambiarModo);
		this.add(barraLateral);
	}

	/**
	 * Muestra el perfil completo de un usuario hombre.
	 * 
	 * @param labelNombreUsuario El nombre del usuario
	 * @param labelAlias El alias del usuario
	 * @param labelEdad La edad del usuario
	 * @param labelFechaNacimiento La fecha de nacimiento
	 * @param labelEstatura La estatura
	 * @param labelCorreo El correo electrónico
	 * @param ingresoPromedio El ingreso promedio
	 * @param estadoDivorcio La preferencia de estado civil
	 * @param edadMinima La edad mínima deseada
	 * @param edadMaxima La edad máxima deseada
	 * @param estaturaIdeal La estatura ideal
	 * @param labelLikesRecibidos Los likes recibidos
	 * @param imagenUsuario La imagen de perfil
	 * @param labelDatos Texto de la sección "Datos"
	 * @param labelGustos Texto de la sección "Gustos"
	 */
	public void mostrarPerfilHombre(String labelNombreUsuario, String labelAlias, String labelEdad,
			String labelFechaNacimiento, String labelEstatura, String labelCorreo, String ingresoPromedio,
			String estadoDivorcio, String edadMinima, String edadMaxima, String estaturaIdeal,
			String labelLikesRecibidos, ImageIcon imagenUsuario, String labelDatos, String labelGustos) {

		crearLabel(labelGustos, Color.WHITE, 800, 50, 400, 50, 22);
		crearLabel(labelDatos, Color.WHITE, 400, 50, 400, 50, 22);
		crearLabel(labelNombreUsuario, Color.WHITE, 400, 125, 400, 30, 18);
		crearLabel(labelAlias, Color.WHITE, 400, 175, 400, 30, 18);
		crearLabel(labelEdad, Color.WHITE, 400, 225, 400, 30, 18);
		crearLabel(labelFechaNacimiento, Color.WHITE, 400, 275, 400, 30, 18);
		crearLabel(labelEstatura + " cm", Color.WHITE, 400, 325, 400, 30, 18);
		crearLabel(labelCorreo, Color.WHITE, 400, 375, 400, 30, 18);
		crearLabel(ingresoPromedio, Color.WHITE, 400, 425, 400, 30, 18);
		crearLabel(estadoDivorcio, Color.WHITE, 800, 125, 400, 30, 18);
		crearLabel(edadMinima, Color.WHITE, 800, 175, 400, 30, 18);
		crearLabel(edadMaxima, Color.WHITE, 800, 225, 400, 30, 18);
		crearLabel(estaturaIdeal + " cm", Color.WHITE, 800, 275, 400, 30, 18);
		crearLabel(labelLikesRecibidos, Color.WHITE, 400, 475, 400, 30, 18);

		ImageIcon imagenEscalada = new ImageIcon(
				imagenUsuario.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		JLabel labelImagen = new JLabel(imagenEscalada);
		labelImagen.setBounds(75, 100, 200, 200);
		this.add(labelImagen);
		this.setComponentZOrder(labelImagen, 0);
	}

	/**
	 * Muestra las etiquetas traducidas para el perfil de hombre.
	 * 
	 * @param labelNombre Etiqueta "Nombre"
	 * @param labelAlias Etiqueta "Alias"
	 * @param labelEdad Etiqueta "Edad"
	 * @param labelFechaNacimiento Etiqueta "Fecha de Nacimiento"
	 * @param labelEstatura Etiqueta "Estatura"
	 * @param labelCorreo Etiqueta "Correo"
	 * @param labelIngresoPromedio Etiqueta "Ingreso Promedio"
	 * @param labelEstadoDivorcio Etiqueta "Estado de Divorcio"
	 * @param labelEdadMinima Etiqueta "Edad Mínima"
	 * @param labelEdadMaxima Etiqueta "Edad Máxima"
	 * @param labelEstaturaIdeal Etiqueta "Estatura Ideal"
	 * @param labelLikesRecibidos Etiqueta "Likes Recibidos"
	 */
	public void mostrarTextosHombre(String labelNombre, String labelAlias, String labelEdad,
			String labelFechaNacimiento, String labelEstatura, String labelCorreo, String labelIngresoPromedio,
			String labelEstadoDivorcio, String labelEdadMinima, String labelEdadMaxima, String labelEstaturaIdeal,
			String labelLikesRecibidos) {
		crearLabel(labelNombre, Color.LIGHT_GRAY, 400, 100, 400, 30, 16);
		crearLabel(labelAlias, Color.LIGHT_GRAY, 400, 150, 400, 30, 16);
		crearLabel(labelEdad, Color.LIGHT_GRAY, 400, 200, 400, 30, 16);
		crearLabel(labelFechaNacimiento, Color.LIGHT_GRAY, 400, 250, 400, 30, 16);
		crearLabel(labelEstatura, Color.LIGHT_GRAY, 400, 300, 400, 30, 16);
		crearLabel(labelCorreo, Color.LIGHT_GRAY, 400, 350, 400, 30, 16);
		crearLabel(labelIngresoPromedio, Color.LIGHT_GRAY, 400, 400, 400, 30, 16);
		crearLabel(labelEstadoDivorcio, Color.LIGHT_GRAY, 800, 100, 400, 30, 16);
		crearLabel(labelEdadMinima, Color.LIGHT_GRAY, 800, 150, 400, 30, 16);
		crearLabel(labelEdadMaxima, Color.LIGHT_GRAY, 800, 200, 400, 30, 16);
		crearLabel(labelEstaturaIdeal, Color.LIGHT_GRAY, 800, 250, 400, 30, 16);
		crearLabel(labelLikesRecibidos, Color.LIGHT_GRAY, 400, 450, 400, 30, 16);

	}

	/**
	 * Muestra el perfil completo de una usuario mujer.
	 * 
	 * @param labelNombreUsuario El nombre del usuario
	 * @param labelAlias El alias del usuario
	 * @param labelEdad La edad del usuario
	 * @param labelFechaNacimiento La fecha de nacimiento
	 * @param labelEstatura La estatura
	 * @param labelCorreo El correo electrónico
	 * @param labelEstadoDivorcio El estado de divorcio
	 * @param ingresoPromedio El ingreso ideal deseado
	 * @param labelEdadMinima La edad mínima deseada
	 * @param labelEdadMaxima La edad máxima deseada
	 * @param labelEstaturaIdeal La estatura ideal
	 * @param labelLikesRecibidos Los likes recibidos
	 * @param imagenUsuario La imagen de perfil
	 * @param labelDatos Texto de la sección "Datos"
	 * @param labelGustos Texto de la sección "Gustos"
	 */
	public void mostrarPerfilMujer(String labelNombreUsuario, String labelAlias, String labelEdad,
			String labelFechaNacimiento, String labelEstatura, String labelCorreo, String labelEstadoDivorcio,
			String ingresoPromedio, String labelEdadMinima, String labelEdadMaxima, String labelEstaturaIdeal,
			String labelLikesRecibidos, ImageIcon imagenUsuario, String labelDatos, String labelGustos) {

		crearLabel(labelGustos, Color.WHITE, 800, 50, 400, 50, 22);
		crearLabel(labelDatos, Color.WHITE, 400, 50, 400, 50, 22);
		crearLabel(labelNombreUsuario, Color.WHITE, 400, 125, 400, 30, 18);
		crearLabel(labelAlias, Color.WHITE, 400, 175, 400, 30, 18);
		crearLabel(labelEdad, Color.WHITE, 400, 225, 400, 30, 18);
		crearLabel(labelFechaNacimiento, Color.WHITE, 400, 275, 400, 30, 18);
		crearLabel(labelEstatura + " cm", Color.WHITE, 400, 325, 400, 30, 18);
		crearLabel(labelCorreo, Color.WHITE, 400, 375, 400, 30, 18);
		crearLabel(labelEstadoDivorcio, Color.WHITE, 400, 425, 400, 30, 16);
		crearLabel(ingresoPromedio, Color.WHITE, 800, 125, 400, 30, 18);
		crearLabel(labelEdadMinima, Color.WHITE, 800, 175, 400, 30, 18);
		crearLabel(labelEdadMaxima, Color.WHITE, 800, 225, 400, 30, 18);
		crearLabel(labelEstaturaIdeal + " cm", Color.WHITE, 800, 275, 400, 30, 18);
		crearLabel(labelLikesRecibidos, Color.WHITE, 400, 475, 400, 30, 18);

		ImageIcon imagenEscalada = new ImageIcon(
				imagenUsuario.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		JLabel labelImagen = new JLabel(imagenEscalada);
		labelImagen.setBounds(75, 100, 200, 200);
		this.add(labelImagen);
		this.setComponentZOrder(labelImagen, 0);
	}

	/**
	 * Muestra las etiquetas traducidas para el perfil de mujer.
	 * 
	 * @param labelNombre Etiqueta "Nombre"
	 * @param labelAlias Etiqueta "Alias"
	 * @param labelEdad Etiqueta "Edad"
	 * @param labelFechaNacimiento Etiqueta "Fecha de Nacimiento"
	 * @param labelEstatura Etiqueta "Estatura"
	 * @param labelCorreo Etiqueta "Correo"
	 * @param labelEstadoDivorcio Etiqueta "Estado de Divorcio"
	 * @param labelIngresoPromedio Etiqueta "Ingreso Promedio"
	 * @param labelEdadMinima Etiqueta "Edad Mínima"
	 * @param labelEdadMaxima Etiqueta "Edad Máxima"
	 * @param labelEstaturaIdeal Etiqueta "Estatura Ideal"
	 * @param labelLikesRecibidos Etiqueta "Likes Recibidos"
	 */
	public void mostrarTextosMujer(String labelNombre, String labelAlias, String labelEdad, String labelFechaNacimiento,
			String labelEstatura, String labelCorreo, String labelEstadoDivorcio, String labelIngresoPromedio,
			String labelEdadMinima, String labelEdadMaxima, String labelEstaturaIdeal, String labelLikesRecibidos) {

		crearLabel(labelNombre, Color.LIGHT_GRAY, 400, 100, 400, 30, 16);
		crearLabel(labelAlias, Color.LIGHT_GRAY, 400, 150, 400, 30, 16);
		crearLabel(labelEdad, Color.LIGHT_GRAY, 400, 200, 400, 30, 16);
		crearLabel(labelFechaNacimiento, Color.LIGHT_GRAY, 400, 250, 400, 30, 16);
		crearLabel(labelEstatura, Color.LIGHT_GRAY, 400, 300, 400, 30, 16);
		crearLabel(labelCorreo, Color.LIGHT_GRAY, 400, 350, 400, 30, 16);
		crearLabel(labelEstadoDivorcio, Color.LIGHT_GRAY, 400, 400, 400, 30, 16);
		crearLabel(labelIngresoPromedio, Color.LIGHT_GRAY, 800, 100, 400, 30, 16);
		crearLabel(labelEdadMinima, Color.LIGHT_GRAY, 800, 150, 400, 30, 16);
		crearLabel(labelEdadMaxima, Color.LIGHT_GRAY, 800, 200, 400, 30, 16);
		crearLabel(labelEstaturaIdeal, Color.LIGHT_GRAY, 800, 250, 400, 30, 16);
		crearLabel(labelLikesRecibidos, Color.LIGHT_GRAY, 400, 450, 400, 30, 16);

	}

	/**
	 * Cambia el modo visual del panel entre claro y oscuro.
	 */
	public void cambiarModo() {
		Color fondo = this.getBackground();
		if (fondo.equals(new Color(36, 41, 46))) {
			this.setBackground(Color.WHITE);
		} else {
			this.setBackground(new Color(36, 41, 46));
		}

		for (Component c : this.getComponents()) {
			if (c instanceof JLabel) {
				JLabel label = (JLabel) c;
				if (fondo.equals(new Color(36, 41, 46))) {
					label.setForeground(Color.BLACK);
				} else {
					label.setForeground(Color.WHITE);
				}
			}

		}

		this.revalidate();
		this.repaint();
	}

	/**
	 * Muestra los textos traducidos en el panel.
	 * 
	 * @param labelBotonCambiarModo Texto del botón cambiar modo
	 */
	public void mostrarTextos(String labelBotonCambiarModo) {
		cambiarModo.setText(labelBotonCambiarModo);
	}

	/**
	 * Elimina todas las etiquetas del panel.
	 */
	public void limpiarLabels() {
		for (Component c : this.getComponents()) {
			if (c instanceof JLabel) {
				this.remove(c);
			}
		}
		this.revalidate();
		this.repaint();

	}

	/**
	 * Crea y agrega una etiqueta de texto al panel.
	 * 
	 * @param texto El texto a mostrar
	 * @param colorFondo El color del texto
	 * @param x Posición X
	 * @param y Posición Y
	 * @param ancho Ancho de la etiqueta
	 * @param alto Alto de la etiqueta
	 * @param tamanoLetra Tamaño de la fuente
	 */
	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	/**
	 * Obtiene el botón volver.
	 * 
	 * @return El botón volver
	 */
	public JButton getBotonVolver() {
		return botonVolver;
	}

	/**
	 * Establece el botón volver.
	 * 
	 * @param botonVolver El nuevo botón volver
	 */
	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
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
	 * @param cambiarModo El nuevo botón cambiar modo
	 */
	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

}