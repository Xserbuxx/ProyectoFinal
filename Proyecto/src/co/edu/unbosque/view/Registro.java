package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Registro extends JPanel {

	private JScrollPane scroll;
	private JPanel izquierda;

	private JButton botonConfirmar;
	private JButton botonIniciarSesion;

	private JButton botonSexoHombre;
	private JButton botonSexoMujer;

	private JRadioButton disponible;
	private JRadioButton noDisponible;
	private ButtonGroup group;

	private JTextField campoNombre;
	private JTextField campoAlias;
	private JTextField campoEdad;
	private JTextField campoFechaNacimiento;
	private JTextField campoEstatura;
	private JTextField campoCorreo;
	private JTextField campoImagen;
	private JTextField campoContrasena;

	private JTextField campoIngresoProm;

	private JTextField campoDivorciada;

	public Registro() {
		// paramentros ventana
		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));
		// parametros panel derecho
		JPanel derecha = new JPanel();

		derecha.setBounds(640, 0, 640, 720);
		derecha.setBackground(new Color(30, 31, 34));
		// parametros para la seleccion de disponibilidad
		disponible = new JRadioButton();

		disponible.setBounds(50, 670, 200, 20);
		disponible.setBackground(new Color(36, 41, 46));
		disponible.setForeground(Color.WHITE);
		disponible.setFocusable(false);
		disponible.setFocusPainted(false);
		disponible.setBorderPainted(false);

		noDisponible = new JRadioButton();

		noDisponible.setBounds(50, 700, 200, 20);
		noDisponible.setBackground(new Color(36, 41, 46));
		noDisponible.setForeground(Color.WHITE);
		noDisponible.setFocusable(false);
		noDisponible.setFocusPainted(false);
		noDisponible.setBorderPainted(false);

		group = new ButtonGroup();
		group.add(disponible);
		group.add(noDisponible);

		// parametros panel izquierdo
		izquierda = new JPanel();

		izquierda.setLayout(null);
		izquierda.setPreferredSize(new Dimension(640, 1280));
		izquierda.setBackground(new Color(36, 41, 46));

		scroll = new JScrollPane(izquierda, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBounds(0, 0, 640, 682);
		scroll.getVerticalScrollBar().setBackground(new Color(36, 41, 46));
		scroll.setBorder(null);

		botonConfirmar = new JButton();
		botonConfirmar.setBounds(150, 900, 330, 50);
		botonConfirmar.setBackground(new Color(3, 102, 214));
		botonConfirmar.setForeground(Color.white);
		botonConfirmar.setFocusable(false);
		botonConfirmar.setFocusPainted(false);
		botonConfirmar.setBorderPainted(false);

		botonIniciarSesion = new JButton();
		botonIniciarSesion.setBounds(135, 970, 200, 14);
		botonIniciarSesion.setFont(new Font("Arial", Font.BOLD, 14));
		botonIniciarSesion.setForeground(new Color(0, 102, 204));
		botonIniciarSesion.setHorizontalAlignment(JLabel.LEFT);
		botonIniciarSesion.setContentAreaFilled(false);
		botonIniciarSesion.setBorderPainted(false);
		botonIniciarSesion.setFocusPainted(false);

		botonSexoHombre = new JButton("♂");
		botonSexoHombre.setBounds(250, 50, 50, 30);
		botonSexoHombre.setBackground(new Color(3, 102, 214));
		botonSexoHombre.setForeground(Color.white);
		botonSexoHombre.setFocusable(false);
		botonSexoHombre.setFocusPainted(false);
		botonSexoHombre.setBorderPainted(false);

		botonSexoMujer = new JButton("♀");
		botonSexoMujer.setBounds(320, 50, 50, 30);
		botonSexoMujer.setBackground(new Color(255, 0, 102));
		botonSexoMujer.setForeground(Color.white);
		botonSexoMujer.setFocusable(false);
		botonSexoMujer.setFocusPainted(false);
		botonSexoMujer.setBorderPainted(false);

		campoIngresoProm = new JTextField();
		campoDivorciada = new JTextField();

		// campos de texto
		campoNombre = new JTextField();
		campoNombre.setBounds(50, 130, 540, 30);

		campoAlias = new JTextField();
		campoAlias.setBounds(50, 210, 540, 30);

		campoEdad = new JTextField();
		campoEdad.setBounds(50, 290, 540, 30);

		campoFechaNacimiento = new JTextField();
		campoFechaNacimiento.setBounds(50, 370, 540, 30);

		campoEstatura = new JTextField();
		campoEstatura.setBounds(50, 450, 540, 30);

		campoCorreo = new JTextField();
		campoCorreo.setBounds(50, 530, 540, 30);

		campoImagen = new JTextField();
		campoImagen.setBounds(50, 610, 540, 30);

		campoContrasena = new JTextField();
		campoContrasena.setBounds(50, 750, 540, 30);

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
		izquierda.add(botonIniciarSesion);
		izquierda.add(botonConfirmar);
		izquierda.add(disponible);
		izquierda.add(noDisponible);
		this.add(scroll);
		this.add(derecha);
	}

	public void mostrarTextos(String labelRegistro, String labelNombre, String labelAlias, String labelEdad,
			String labelFechaNacimiento, String labelEstatura, String labelCorreo, String labelImagen,
			String labelDisponibilidad, String labelDisponible, String labelNoDisponible, String labelContrasena,
			String labelBotonConfirmar, String labelBotonIniciarSesionTexto, String labelYaCuenta, String labelSexo) {

		crearLabel(labelRegistro, Color.WHITE, 200, 20, 300, 50, 30);
		crearLabel(labelNombre, Color.WHITE, 50, 100, 200, 30, 20);
		crearLabel(labelAlias, Color.WHITE, 50, 180, 200, 30, 20);
		crearLabel(labelEdad, Color.WHITE, 50, 260, 200, 30, 20);
		crearLabel(labelFechaNacimiento, Color.WHITE, 50, 340, 200, 30, 20);
		crearLabel(labelEstatura, Color.WHITE, 50, 420, 200, 30, 20);
		crearLabel(labelCorreo, Color.WHITE, 50, 500, 200, 30, 20);
		crearLabel(labelImagen, Color.WHITE, 50, 580, 200, 30, 20);
		crearLabel(labelDisponibilidad, Color.WHITE, 50, 640, 300, 30, 20);
		crearLabel(labelContrasena, Color.WHITE, 50, 720, 200, 30, 20);
		crearLabel(labelYaCuenta, Color.WHITE, 50, 800, 200, 30, 20);
		crearLabel(labelSexo, Color.WHITE, 50, 45, 200, 30, 20);

		botonConfirmar.setText(labelBotonConfirmar);
		botonIniciarSesion.setText(labelBotonIniciarSesionTexto);

		disponible.setText(labelDisponible);
		noDisponible.setText(labelNoDisponible);
	}

	public void mostrarCampoHombre(String labelIngresoProm) {
		campoDivorciada.setVisible(false);
		campoDivorciada.setEnabled(false);
		campoIngresoProm.setVisible(true);
		campoIngresoProm.setEnabled(true);

		campoIngresoProm.setBounds(50, 830, 540, 30);
		crearLabel(labelIngresoProm, Color.WHITE, 50, 780, 300, 30, 20);
		izquierda.add(campoIngresoProm);
		izquierda.setComponentZOrder(campoIngresoProm, 0);
	}

	public void mostrarCampoMujer(String labelDivorciada) {
		campoIngresoProm.setVisible(false);
		campoIngresoProm.setEnabled(false);
		campoDivorciada.setVisible(true);
		campoDivorciada.setEnabled(true);

		campoDivorciada.setBounds(50, 810, 540, 30);
		crearLabel(labelDivorciada, Color.WHITE, 50, 780, 300, 30, 20);
		izquierda.add(campoDivorciada);
		izquierda.setComponentZOrder(campoDivorciada, 0);
	}

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

	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
		izquierda.add(label);
		izquierda.setComponentZOrder(label, 0);
	}

}
