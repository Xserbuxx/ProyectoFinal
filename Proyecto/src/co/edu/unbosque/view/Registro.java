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
	
	private JButton cambiarModo;

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

	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(new Color(200, 200, 200));
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Segoe UI", Font.BOLD, tamanoLetra - 4));
		izquierda.add(label);
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

	public JButton getCambiarModo() {
		return cambiarModo;
	}

	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}
	
}
