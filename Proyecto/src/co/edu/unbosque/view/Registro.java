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

		disponible.setBounds(50, 940, 200, 20);
		disponible.setBackground(new Color(36, 41, 46));
		disponible.setForeground(Color.WHITE);
		disponible.setFocusable(false);
		disponible.setFocusPainted(false);
		disponible.setBorderPainted(false);

		noDisponible = new JRadioButton();

		noDisponible.setBounds(50, 970, 200, 20);
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
		izquierda.setPreferredSize(new Dimension(640, 1380));
		izquierda.setBackground(new Color(36, 41, 46));

		scroll = new JScrollPane(izquierda, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBounds(0, 0, 640, 682);
		scroll.getVerticalScrollBar().setBackground(new Color(36, 41, 46));
		scroll.setBorder(null);

		botonConfirmar = new JButton();
		botonConfirmar.setBounds(150, 1220, 330, 50);
		botonConfirmar.setBackground(new Color(3, 102, 214));
		botonConfirmar.setForeground(Color.white);
		botonConfirmar.setFocusable(false);
		botonConfirmar.setFocusPainted(false);
		botonConfirmar.setBorderPainted(false);

		botonIniciarSesion = new JButton();
		botonIniciarSesion.setBounds(135, 1300, 200, 14);
		botonIniciarSesion.setFont(new Font("Arial", Font.BOLD, 14));
		botonIniciarSesion.setForeground(new Color(0, 102, 204));
		botonIniciarSesion.setHorizontalAlignment(JLabel.LEFT);
		botonIniciarSesion.setContentAreaFilled(false);
		botonIniciarSesion.setBorderPainted(false);
		botonIniciarSesion.setFocusPainted(false);

		botonSexoHombre = new JButton("♂");
		botonSexoHombre.setFont(new Font("Sans", Font.BOLD, 20));
		botonSexoHombre.setBounds(50, 150, 50, 30);
		botonSexoHombre.setBackground(new Color(3, 102, 214));
		botonSexoHombre.setForeground(Color.white);
		botonSexoHombre.setFocusable(false);
		botonSexoHombre.setFocusPainted(false);
		botonSexoHombre.setBorderPainted(false);

		botonSexoMujer = new JButton("♀");
		botonSexoMujer.setFont(new Font("Sans", Font.BOLD, 20));
		botonSexoMujer.setBounds(100, 150, 50, 30);
		botonSexoMujer.setBackground(new Color(255, 0, 102));
		botonSexoMujer.setForeground(Color.white);
		botonSexoMujer.setFocusable(false);
		botonSexoMujer.setFocusPainted(false);
		botonSexoMujer.setBorderPainted(false);

		campoIngresoProm = new JTextField();
		campoDivorciada = new JTextField();

		// campos de texto
		campoNombre = new JTextField();
		campoNombre.setBounds(50, 250, 540, 30);

		campoAlias = new JTextField();
		campoAlias.setBounds(50, 350, 540, 30);

		campoEdad = new JTextField();
		campoEdad.setBounds(50, 450, 540, 30);

		campoFechaNacimiento = new JTextField();
		campoFechaNacimiento.setBounds(50, 550, 540, 30);

		campoEstatura = new JTextField();
		campoEstatura.setBounds(50, 650, 540, 30);

		campoCorreo = new JTextField();
		campoCorreo.setBounds(50, 750, 540, 30);

		campoImagen = new JTextField();
		campoImagen.setBounds(50, 850, 540, 30);

		campoContrasena = new JTextField();
		campoContrasena.setBounds(50, 1050, 540, 30);

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
		crearLabel(labelNombre, Color.WHITE, 50, 200, 200, 30, 20);
		crearLabel(labelAlias, Color.WHITE, 50, 300, 200, 30, 20);
		crearLabel(labelEdad, Color.WHITE, 50, 400, 200, 30, 20);
		crearLabel(labelFechaNacimiento, Color.WHITE, 50, 500, 200, 30, 20);
		crearLabel(labelEstatura, Color.WHITE, 50, 600, 200, 30, 20);
		crearLabel(labelCorreo, Color.WHITE, 50, 700, 200, 30, 20);
		crearLabel(labelImagen, Color.WHITE, 50, 800, 200, 30, 20);
		crearLabel(labelDisponibilidad, Color.WHITE, 50, 900, 300, 30, 20);
		crearLabel(labelContrasena, Color.WHITE, 50, 1000, 200, 30, 20);
		crearLabel(labelYaCuenta, Color.WHITE, 150, 1270, 200, 30, 14);
		crearLabel(labelSexo, Color.WHITE, 50, 100, 200, 30, 20);

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

		campoIngresoProm.setBounds(50, 1150, 540, 30);
		crearLabel(labelIngresoProm, Color.WHITE, 50, 1100, 300, 30, 20);
		izquierda.add(campoIngresoProm);
		izquierda.setComponentZOrder(campoIngresoProm, 0);
	}

	public void mostrarCampoMujer(String labelDivorciada) {
		campoIngresoProm.setVisible(false);
		campoIngresoProm.setEnabled(false);
		campoDivorciada.setVisible(true);
		campoDivorciada.setEnabled(true);

		campoDivorciada.setBounds(50, 1150, 540, 30);
		crearLabel(labelDivorciada, Color.WHITE, 50, 1100, 300, 30, 20);
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
