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
	
	public InfoUsuario() {
		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));

		ImageIcon imagenPerfil = new ImageIcon("Resources/volver.png");
		Image imagenRedimensionadaPerfil = imagenPerfil.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionada = new ImageIcon(imagenRedimensionadaPerfil);

		botonVolver = new JButton(imagenRedimensionada);
		botonVolver.setBounds(10, 10, 50, 50);
		botonVolver.setBackground(Color.red);
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setFocusable(false);
		
		this.add(botonVolver);
	}
	
	public void mostrarPerfilHombre(String nombreUsuario, String alias, String edad, String fechaNacimiento,
			String estatura, String correo, String ingresoPromedio, String estadoDivorcio, String edadMinima,
			String edadMaxima, String estaturaIdeal, String likesRecibidos, ImageIcon imagenUsuario) {

		crearLabel(nombreUsuario, Color.WHITE, 300, 100, 400, 30, 18);
		crearLabel(alias, Color.WHITE, 300, 150, 400, 30, 18);
		crearLabel(edad, Color.WHITE, 300, 200, 400, 30, 18);
		crearLabel(fechaNacimiento, Color.WHITE, 300, 250, 400, 30, 18);
		crearLabel(estatura + " cm", Color.WHITE, 300, 300, 400, 30, 18);
		crearLabel(correo, Color.WHITE, 300, 350, 400, 30, 18);
		crearLabel(ingresoPromedio, Color.WHITE, 300, 400, 400, 30, 18);
		crearLabel(estadoDivorcio, Color.WHITE, 300, 450, 400, 30, 18);
		crearLabel(edadMinima, Color.WHITE, 300, 500, 400, 30, 18);
		crearLabel(edadMaxima, Color.WHITE, 300, 550, 400, 30, 18);
		crearLabel(estaturaIdeal + " cm", Color.WHITE, 300, 600, 400, 30, 18);
		crearLabel(likesRecibidos, Color.WHITE, 300, 650, 400, 30, 18);

		ImageIcon imagenEscalada = new ImageIcon(
				imagenUsuario.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		JLabel labelImagen = new JLabel(imagenEscalada);
		labelImagen.setBounds(50, 75, 200, 200);
		this.add(labelImagen);
		this.setComponentZOrder(labelImagen, 0);
	}

	public void mostrarTextosHombre(String labelNombre, String labelAlias, String labelEdad,
			String labelFechaNacimiento, String labelEstatura, String labelCorreo, String labelIngresoPromedio,
			String labelEstadoDivorcio, String labelEdadMinima, String labelEdadMaxima, String labelEstaturaIdeal,
			String labelLikesRecibidos) {
		crearLabel(labelNombre, Color.LIGHT_GRAY, 300, 75, 400, 30, 16);
		crearLabel(labelAlias, Color.LIGHT_GRAY, 300, 125, 400, 30, 16);
		crearLabel(labelEdad, Color.LIGHT_GRAY, 300, 175, 400, 30, 16);
		crearLabel(labelFechaNacimiento, Color.LIGHT_GRAY, 300, 225, 400, 30, 16);
		crearLabel(labelEstatura, Color.LIGHT_GRAY, 300, 275, 400, 30, 16);
		crearLabel(labelCorreo, Color.LIGHT_GRAY, 300, 325, 400, 30, 16);
		crearLabel(labelIngresoPromedio, Color.LIGHT_GRAY, 300, 375, 400, 30, 16);
		crearLabel(labelEstadoDivorcio, Color.LIGHT_GRAY, 300, 425, 400, 30, 16);
		crearLabel(labelEdadMinima, Color.LIGHT_GRAY, 300, 475, 400, 30, 16);
		crearLabel(labelEdadMaxima, Color.LIGHT_GRAY, 300, 525, 400, 30, 16);
		crearLabel(labelEstaturaIdeal, Color.LIGHT_GRAY, 300, 575, 400, 30, 16);
		crearLabel(labelLikesRecibidos, Color.LIGHT_GRAY, 300, 625, 400, 30, 16);

	}

	public void mostrarPerfilMujer(String labelNombreUsuario, String labelAlias, String labelEdad,
			String labelFechaNacimiento, String labelEstatura, String labelCorreo, String labelEstadoDivorcio,String ingresoPromedio,
			String labelEdadMinima, String labelEdadMaxima, String labelEstaturaIdeal, String labelLikesRecibidos,
			ImageIcon imagenUsuario) {

		crearLabel(labelNombreUsuario, Color.WHITE, 300, 100, 400, 30, 18);
		crearLabel(labelAlias, Color.WHITE, 300, 150, 400, 30, 18);
		crearLabel(labelEdad, Color.WHITE, 300, 200, 400, 30, 18);
		crearLabel(labelFechaNacimiento, Color.WHITE, 300, 250, 400, 30, 18);
		crearLabel(labelEstatura + " cm", Color.WHITE, 300, 300, 400, 30, 18);
		crearLabel(labelCorreo, Color.WHITE, 300, 350, 400, 30, 18);
		crearLabel(labelEstadoDivorcio, Color.WHITE, 300, 400, 400, 30, 16);
		crearLabel(ingresoPromedio, Color.WHITE, 300, 450, 400, 30, 18);
		crearLabel(labelEdadMinima, Color.WHITE, 300, 500, 400, 30, 18);
		crearLabel(labelEdadMaxima, Color.WHITE, 300, 550, 400, 30, 18);
		crearLabel(labelEstaturaIdeal + " cm", Color.WHITE, 300, 600, 400, 30, 18);
		crearLabel(labelLikesRecibidos, Color.WHITE, 300, 650, 400, 30, 18);

		ImageIcon imagenEscalada = new ImageIcon(
				imagenUsuario.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		JLabel labelImagen = new JLabel(imagenEscalada);
		labelImagen.setBounds(50, 75, 200, 200);
		this.add(labelImagen);
		this.setComponentZOrder(labelImagen, 0);
	}

	public void mostrarTextosMujer(String labelNombre, String labelAlias, String labelEdad, String labelFechaNacimiento,
			String labelEstatura, String labelCorreo, String labelEstadoDivorcio, String labelIngresoPromedio, String labelEdadMinima,
			String labelEdadMaxima, String labelEstaturaIdeal, String labelLikesRecibidos) {

		crearLabel(labelNombre, Color.LIGHT_GRAY, 300, 75, 400, 30, 16);
		crearLabel(labelAlias, Color.LIGHT_GRAY, 300, 125, 400, 30, 16);
		crearLabel(labelEdad, Color.LIGHT_GRAY, 300, 175, 400, 30, 16);
		crearLabel(labelFechaNacimiento, Color.LIGHT_GRAY, 300, 225, 400, 30, 16);
		crearLabel(labelEstatura, Color.LIGHT_GRAY, 300, 275, 400, 30, 16);
		crearLabel(labelCorreo, Color.LIGHT_GRAY, 300, 325, 400, 30, 16);
		crearLabel(labelEstadoDivorcio, Color.LIGHT_GRAY, 300, 375, 400, 30, 16);
		crearLabel(labelIngresoPromedio, Color.LIGHT_GRAY, 300, 425, 400, 30, 16);
		crearLabel(labelEdadMinima, Color.LIGHT_GRAY, 300, 475, 400, 30, 16);
		crearLabel(labelEdadMaxima, Color.LIGHT_GRAY, 300, 525, 400, 30, 16);
		crearLabel(labelEstaturaIdeal, Color.LIGHT_GRAY, 300, 575, 400, 30, 16);
		crearLabel(labelLikesRecibidos, Color.LIGHT_GRAY, 300, 625, 400, 30, 16);

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
	
}
