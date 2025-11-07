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
import javax.swing.filechooser.FileNameExtensionFilter;

public class Registro extends JPanel {

	private JScrollPane scroll;
	private JPanel izquierda;

	private JButton botonConfirmar;
	private JButton botonIniciarSesion;

	private JButton botonSexoHombre;
	private JButton botonSexoMujer;

	private JRadioButton disponible;
	private JRadioButton noDisponible;
	private ButtonGroup grupoDisponibilidad;

	private JRadioButton divorciada;
	private JRadioButton noDivorciada;
	private ButtonGroup grupoSexo;

	private JButton botonExaminar;

	private JTextField campoNombre;
	private JTextField campoAlias;
	private JTextField campoEdad;
	private JTextField campoFechaNacimiento;
	private JTextField campoEstatura;
	private JTextField campoCorreo;
	private JTextField campoImagen;
	private JTextField campoContrasena;

	private JTextField campoIngresoProm;

	private JFileChooser fileChooser;

	public Registro() {
		
		this.setLayout(null);
		this.setBackground(new Color(59, 59, 59));
		
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

		grupoDisponibilidad = new ButtonGroup();
		grupoDisponibilidad.add(disponible);
		grupoDisponibilidad.add(noDisponible);
		// parametros para divorciada
		divorciada = new JRadioButton();

		divorciada.setBounds(50, 1140, 200, 20);
		divorciada.setBackground(new Color(36, 41, 46));
		divorciada.setForeground(Color.WHITE);
		divorciada.setFocusable(false);
		divorciada.setFocusPainted(false);
		divorciada.setBorderPainted(false);

		divorciada.setVisible(false);
		divorciada.setEnabled(false);

		noDivorciada = new JRadioButton();

		noDivorciada.setBounds(50, 1170, 200, 20);
		noDivorciada.setBackground(new Color(36, 41, 46));
		noDivorciada.setForeground(Color.WHITE);
		noDivorciada.setFocusable(false);
		noDivorciada.setFocusPainted(false);
		noDivorciada.setBorderPainted(false);

		noDivorciada.setVisible(false);
		noDivorciada.setEnabled(false);

		grupoSexo = new ButtonGroup();
		grupoSexo.add(divorciada);
		grupoSexo.add(noDivorciada);
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
		

        Color colorTinder = new Color(255, 51, 102); 
		botonConfirmar = new JButton();
		botonConfirmar.setBounds(150, 1220, 330, 50);
		botonConfirmar.setBackground(colorTinder);
		botonConfirmar.setForeground(Color.white);
		botonConfirmar.setFocusable(false);
		botonConfirmar.setFocusPainted(false);
		botonConfirmar.setBorderPainted(false);

		botonIniciarSesion = new JButton();
		botonIniciarSesion.setBounds(135, 1300, 200, 14);
		botonIniciarSesion.setFont(new Font("Arial", Font.BOLD, 14));
		botonIniciarSesion.setForeground(new Color(255, 51, 102));
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
		campoIngresoProm.setBounds(50, 1150, 540, 30);
		campoIngresoProm.setVisible(false);
		campoIngresoProm.setEnabled(false);
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
		campoImagen.setEditable(false);

		campoContrasena = new JTextField();
		campoContrasena.setBounds(50, 1050, 540, 30);

		botonExaminar = new JButton();
		botonExaminar.setBounds(450, 810, 140, 30);
		botonExaminar.setFont(new Font("Sans", Font.BOLD, 12));
		botonExaminar.setBackground(new Color(3, 102, 214));
		botonExaminar.setForeground(Color.white);
		botonExaminar.setFocusable(false);
		botonExaminar.setFocusPainted(false);
		botonExaminar.setBorderPainted(false);

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
		izquierda.add(botonIniciarSesion);
		izquierda.add(botonConfirmar);
		izquierda.add(disponible);
		izquierda.add(noDisponible);
		izquierda.add(divorciada);
		izquierda.add(noDivorciada);
		izquierda.add(campoIngresoProm);
		this.add(scroll);
		this.add(derecha);
	}

	public void mostrarTextos(String labelRegistro, String labelNombre, String labelAlias, String labelEdad,
			String labelFechaNacimiento, String labelEstatura, String labelCorreo, String labelImagen,
			String labelDisponibilidad, String labelDisponible, String labelNoDisponible, String labelContrasena,
			String labelBotonConfirmar, String labelBotonIniciarSesionTexto, String labelYaCuenta, String labelSexo,
			String labelDivorciada, String labelNoDivorciada, String labelBotonExaminar) {

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

		divorciada.setText(labelDivorciada);
		noDivorciada.setText(labelNoDivorciada);

		botonExaminar.setText(labelBotonExaminar);
	}

	public void mostrarCampoHombre(String labelIngresoProm) {
		divorciada.setVisible(false);
		divorciada.setEnabled(false);
		noDivorciada.setVisible(false);
		noDivorciada.setEnabled(false);
		campoIngresoProm.setVisible(true);
		campoIngresoProm.setEnabled(true);
		grupoSexo.clearSelection();

		crearLabel(labelIngresoProm, Color.WHITE, 50, 1100, 300, 30, 20);
	}

	public void mostrarCampoMujer(String labelDivorciada) {
		campoIngresoProm.setVisible(false);
		campoIngresoProm.setEnabled(false);
		divorciada.setVisible(true);
		divorciada.setEnabled(true);
		noDivorciada.setVisible(true);
		noDivorciada.setEnabled(true);
		campoIngresoProm.setText("");

		crearLabel(labelDivorciada, Color.WHITE, 50, 1100, 300, 30, 20);
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

	public void obtenerRutaImagen() {
		fileChooser = new JFileChooser();

		fileChooser.setFileFilter(new FileNameExtensionFilter("Files (jpg)", "jpg"));

		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			campoImagen.setText(fileChooser.getSelectedFile().getAbsolutePath());
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

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JPanel getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(JPanel izquierda) {
		this.izquierda = izquierda;
	}

	public JButton getBotonConfirmar() {
		return botonConfirmar;
	}

	public void setBotonConfirmar(JButton botonConfirmar) {
		this.botonConfirmar = botonConfirmar;
	}

	public JButton getBotonIniciarSesion() {
		return botonIniciarSesion;
	}

	public void setBotonIniciarSesion(JButton botonIniciarSesion) {
		this.botonIniciarSesion = botonIniciarSesion;
	}

	public JButton getBotonSexoHombre() {
		return botonSexoHombre;
	}

	public void setBotonSexoHombre(JButton botonSexoHombre) {
		this.botonSexoHombre = botonSexoHombre;
	}

	public JButton getBotonSexoMujer() {
		return botonSexoMujer;
	}

	public void setBotonSexoMujer(JButton botonSexoMujer) {
		this.botonSexoMujer = botonSexoMujer;
	}

	public JRadioButton getDisponible() {
		return disponible;
	}

	public void setDisponible(JRadioButton disponible) {
		this.disponible = disponible;
	}

	public JRadioButton getNoDisponible() {
		return noDisponible;
	}

	public void setNoDisponible(JRadioButton noDisponible) {
		this.noDisponible = noDisponible;
	}

	public ButtonGroup getGrupoDisponibilidad() {
		return grupoDisponibilidad;
	}

	public void setGrupoDisponibilidad(ButtonGroup grupoDisponibilidad) {
		this.grupoDisponibilidad = grupoDisponibilidad;
	}

	public JTextField getCampoNombre() {
		return campoNombre;
	}

	public void setCampoNombre(JTextField campoNombre) {
		this.campoNombre = campoNombre;
	}

	public JTextField getCampoAlias() {
		return campoAlias;
	}

	public void setCampoAlias(JTextField campoAlias) {
		this.campoAlias = campoAlias;
	}

	public JTextField getCampoEdad() {
		return campoEdad;
	}

	public void setCampoEdad(JTextField campoEdad) {
		this.campoEdad = campoEdad;
	}

	public JTextField getCampoFechaNacimiento() {
		return campoFechaNacimiento;
	}

	public void setCampoFechaNacimiento(JTextField campoFechaNacimiento) {
		this.campoFechaNacimiento = campoFechaNacimiento;
	}

	public JTextField getCampoEstatura() {
		return campoEstatura;
	}

	public void setCampoEstatura(JTextField campoEstatura) {
		this.campoEstatura = campoEstatura;
	}

	public JTextField getCampoCorreo() {
		return campoCorreo;
	}

	public void setCampoCorreo(JTextField campoCorreo) {
		this.campoCorreo = campoCorreo;
	}

	public JTextField getCampoImagen() {
		return campoImagen;
	}

	public void setCampoImagen(JTextField campoImagen) {
		this.campoImagen = campoImagen;
	}

	public JTextField getCampoContrasena() {
		return campoContrasena;
	}

	public void setCampoContrasena(JTextField campoContrasena) {
		this.campoContrasena = campoContrasena;
	}

	public JTextField getCampoIngresoProm() {
		return campoIngresoProm;
	}

	public void setCampoIngresoProm(JTextField campoIngresoProm) {
		this.campoIngresoProm = campoIngresoProm;
	}

	public JRadioButton getDivorciada() {
		return divorciada;
	}

	public void setDivorciada(JRadioButton divorciada) {
		this.divorciada = divorciada;
	}

	public JRadioButton getNoDivorciada() {
		return noDivorciada;
	}

	public void setNoDivorciada(JRadioButton noDivorciada) {
		this.noDivorciada = noDivorciada;
	}

	public ButtonGroup getGrupoSexo() {
		return grupoSexo;
	}

	public void setGrupoSexo(ButtonGroup grupoSexo) {
		this.grupoSexo = grupoSexo;
	}

	public JButton getBotonExaminar() {
		return botonExaminar;
	}

	public void setBotonExaminar(JButton botonExaminar) {
		this.botonExaminar = botonExaminar;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

}
