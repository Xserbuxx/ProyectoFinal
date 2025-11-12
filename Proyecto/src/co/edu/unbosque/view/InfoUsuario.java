package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoUsuario extends JPanel {

	private JButton botonVolver;
	private JButton cambiarModo;

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

	public void mostrarTextos(String labelBotonCambiarModo) {
		cambiarModo.setText(labelBotonCambiarModo);
	}

	public void limpiarLabels() {
		for (Component c : this.getComponents()) {
			if (c instanceof JLabel) {
				this.remove(c);
			}
		}
		this.revalidate();
		this.repaint();

	}

	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}


	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}


	public JButton getCambiarModo() {
		return cambiarModo;
	}

	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

}
