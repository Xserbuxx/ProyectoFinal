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
	        this.setBackground(new Color(36, 41, 46));

	        
	        disponible = new JRadioButton();
	        disponible.setBounds(370, 940, 200, 20);
	        disponible.setBackground(new Color(36, 41, 46));
	        disponible.setForeground(Color.WHITE);
	        disponible.setFocusable(false);
	        disponible.setFocusPainted(false);
	        disponible.setBorderPainted(false);

	        noDisponible = new JRadioButton();
	        noDisponible.setBounds(370, 970, 200, 20);
	        noDisponible.setBackground(new Color(36, 41, 46));
	        noDisponible.setForeground(Color.WHITE);
	        noDisponible.setFocusable(false);
	        noDisponible.setFocusPainted(false);
	        noDisponible.setBorderPainted(false);

	        grupoDisponibilidad = new ButtonGroup();
	        grupoDisponibilidad.add(disponible);
	        grupoDisponibilidad.add(noDisponible);

	      
	        divorciada = new JRadioButton();
	        divorciada.setBounds(370, 1140, 200, 20);
	        divorciada.setBackground(new Color(36, 41, 46));
	        divorciada.setForeground(Color.WHITE);
	        divorciada.setFocusable(false);
	        divorciada.setFocusPainted(false);
	        divorciada.setBorderPainted(false);
	        divorciada.setVisible(false);
	        divorciada.setEnabled(false);

	        noDivorciada = new JRadioButton();
	        noDivorciada.setBounds(370, 1170, 200, 20);
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

	        
	        izquierda = new JPanel();
	        izquierda.setLayout(null);
	        izquierda.setPreferredSize(new Dimension(1280, 1380));
	        izquierda.setBackground(new Color(36, 41, 46));

	        scroll = new JScrollPane(izquierda, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scroll.setBounds(0, 0, 1280, 720);
	        scroll.getVerticalScrollBar().setBackground(new Color(36, 41, 46));
	        scroll.setBorder(null);

	      
	        Color colorTinder = new Color(255, 51, 102);
	        botonConfirmar = new JButton();
	        botonConfirmar.setBounds(470, 1220, 330, 50);
	        botonConfirmar.setBackground(colorTinder);
	        botonConfirmar.setForeground(Color.white);
	        botonConfirmar.setFocusable(false);
	        botonConfirmar.setFocusPainted(false);
	        botonConfirmar.setBorderPainted(false);

	        botonIniciarSesion = new JButton();
	        botonIniciarSesion.setBounds(540, 1300, 200, 14);
	        botonIniciarSesion.setFont(new Font("Arial", Font.BOLD, 14));
	        botonIniciarSesion.setForeground(new Color(255, 51, 102));
	        botonIniciarSesion.setHorizontalAlignment(JLabel.LEFT);
	        botonIniciarSesion.setContentAreaFilled(false);
	        botonIniciarSesion.setBorderPainted(false);
	        botonIniciarSesion.setFocusPainted(false);

	        botonSexoHombre = new JButton("♂");
	        botonSexoHombre.setFont(new Font("Sans", Font.BOLD, 20));
	        botonSexoHombre.setBounds(370, 150, 50, 30);
	        botonSexoHombre.setBackground(new Color(3, 102, 214));
	        botonSexoHombre.setForeground(Color.white);
	        botonSexoHombre.setFocusable(false);
	        botonSexoHombre.setFocusPainted(false);
	        botonSexoHombre.setBorderPainted(false);

	        botonSexoMujer = new JButton("♀");
	        botonSexoMujer.setFont(new Font("Sans", Font.BOLD, 20));
	        botonSexoMujer.setBounds(430, 150, 50, 30);
	        botonSexoMujer.setBackground(new Color(255, 0, 102));
	        botonSexoMujer.setForeground(Color.white);
	        botonSexoMujer.setFocusable(false);
	        botonSexoMujer.setFocusPainted(false);
	        botonSexoMujer.setBorderPainted(false);

	       
	        campoNombre = new CampoRedondeado(10, 30);
	        campoNombre.setBounds(370, 250, 540, 30);

	        campoAlias = new CampoRedondeado(10, 30);
	        campoAlias.setBounds(370, 350, 540, 30);

	        campoEdad = new CampoRedondeado(10, 30);
	        campoEdad.setBounds(370, 450, 540, 30);

	        campoFechaNacimiento = new CampoRedondeado(10, 30);
	        campoFechaNacimiento.setBounds(370, 550, 540, 30);

	        campoEstatura = new CampoRedondeado(10, 30);
	        campoEstatura.setBounds(370, 650, 540, 30);

	        campoCorreo = new CampoRedondeado(10, 30);
	        campoCorreo.setBounds(370, 750, 540, 30);

	        campoImagen = new JTextField(); 
	        campoImagen.setBounds(370, 850, 540, 30);
	        campoImagen.setEditable(false);

	        campoContrasena = new CampoRedondeado(10, 30);
	        campoContrasena.setBounds(370, 1050, 540, 30);

	        campoIngresoProm = new CampoRedondeado(10, 30);
	        campoIngresoProm.setBounds(370, 1150, 540, 30);
	        campoIngresoProm.setVisible(false);
	        campoIngresoProm.setEnabled(false);

	        botonExaminar = new JButton();
	        botonExaminar.setBounds(770, 810, 140, 30);
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
	    }
	public void mostrarTextos(String labelRegistro, String labelNombre, String labelAlias, String labelEdad,
			String labelFechaNacimiento, String labelEstatura, String labelCorreo, String labelImagen,
			String labelDisponibilidad, String labelDisponible, String labelNoDisponible, String labelContrasena,
			String labelBotonConfirmar, String labelBotonIniciarSesionTexto, String labelYaCuenta, String labelSexo,
			String labelDivorciada, String labelNoDivorciada, String labelBotonExaminar) {
		
		int xCampo = 370; // inicio de los campos
		int anchoLabel = 540; // mismo ancho del campo

		crearLabel(labelRegistro, Color.WHITE, 520, 20, 300, 50, 30); // título principal centrado
		crearLabel(labelSexo, Color.WHITE, xCampo, 120, anchoLabel, 30, 20);

		crearLabel(labelNombre, Color.WHITE, xCampo, 220, anchoLabel, 30, 20);
		crearLabel(labelAlias, Color.WHITE, xCampo, 320, anchoLabel, 30, 20);
		crearLabel(labelEdad, Color.WHITE, xCampo, 420, anchoLabel, 30, 20);
		crearLabel(labelFechaNacimiento, Color.WHITE, xCampo, 520, anchoLabel, 30, 20);
		crearLabel(labelEstatura, Color.WHITE, xCampo, 620, anchoLabel, 30, 20);
		crearLabel(labelCorreo, Color.WHITE, xCampo, 720, anchoLabel, 30, 20);
		crearLabel(labelImagen, Color.WHITE, xCampo, 820, anchoLabel, 30, 20);
		crearLabel(labelDisponibilidad, Color.WHITE, xCampo, 920, anchoLabel, 30, 20);
		crearLabel(labelContrasena, Color.WHITE, xCampo, 1020, anchoLabel, 30, 20);
		crearLabel(labelYaCuenta, Color.WHITE, 520, 1270, 300, 30, 14);

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
