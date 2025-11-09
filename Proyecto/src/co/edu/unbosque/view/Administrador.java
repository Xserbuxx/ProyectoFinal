package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class Administrador extends JPanel {

	private JScrollPane scrollPanel;
	private JPanel panelUsuarios;
	private JButton botonOrdenar;
	private JRadioButton botonAscendente;
	private JRadioButton botonDescendente;
	private JRadioButton botonPorEdad;
	private JRadioButton botonNombre;
	private JRadioButton botonAlias;
	private JRadioButton botonLikes;
	private ButtonGroup grupoOrdenamientos;
	private ButtonGroup grupoCriterios;

	private JRadioButton botonTopLikes;
	private JRadioButton botonTopIngresos;
	private ButtonGroup grupoTop;

	private JButton botonTop;

	private JButton botonPDF;
	private JRadioButton botonEdadPDF;
	private JRadioButton botonLikesPDF;
	private JRadioButton botonIngresosPDF;
	private JRadioButton botonEstaturaPDF;
	private ButtonGroup grupoPDF;

	public Administrador() {
		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));

		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(new Color(36, 41, 46));
		panelUsuarios.setLayout(new GridLayout(0, 1, 10, 10));

		scrollPanel = new JScrollPane(panelUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 60, 900, 640);
		scrollPanel.setBackground(new Color(36, 41, 46));

		botonOrdenar = new JButton();
		botonOrdenar.setBounds(920, 10, 100, 30);
		botonOrdenar.setBackground(Color.blue);
		botonOrdenar.setFocusable(false);
		botonOrdenar.setFocusPainted(false);
		botonOrdenar.setBorderPainted(false);

		botonAscendente = new JRadioButton();
		botonAscendente.setBounds(920, 100, 100, 30);

		botonDescendente = new JRadioButton();
		botonDescendente.setBounds(920, 150, 100, 30);

		grupoOrdenamientos = new ButtonGroup();
		grupoOrdenamientos.add(botonAscendente);
		grupoOrdenamientos.add(botonDescendente);

		botonPorEdad = new JRadioButton();
		botonPorEdad.setBounds(920, 250, 100, 30);

		botonNombre = new JRadioButton();
		botonNombre.setBounds(920, 300, 100, 30);

		botonAlias = new JRadioButton();
		botonAlias.setBounds(920, 350, 100, 30);

		botonLikes = new JRadioButton();
		botonLikes.setBounds(920, 400, 100, 30);

		grupoCriterios = new ButtonGroup();
		grupoCriterios.add(botonPorEdad);
		grupoCriterios.add(botonNombre);
		grupoCriterios.add(botonAlias);
		grupoCriterios.add(botonLikes);

		botonTopLikes = new JRadioButton();
		botonTopLikes.setBounds(1100, 100, 100, 30);

		botonTopIngresos = new JRadioButton();
		botonTopIngresos.setBounds(1100, 150, 120, 30);

		grupoTop = new ButtonGroup();
		grupoTop.add(botonTopLikes);
		grupoTop.add(botonTopIngresos);

		botonTop = new JButton();
		botonTop.setBounds(1100, 10, 200, 30);
		botonTop.setBackground(Color.blue);
		botonTop.setBorderPainted(false);
		botonTop.setFocusPainted(false);
		botonTop.setFocusable(false);

		botonPDF = new JButton();
		botonPDF.setBounds(1100, 250, 100, 30);
		botonPDF.setBackground(Color.blue);
		botonPDF.setBorderPainted(false);
		botonPDF.setFocusPainted(false);
		botonPDF.setFocusable(false);

		botonEdadPDF = new JRadioButton();
		botonEdadPDF.setBounds(1100, 350, 100, 30);

		botonLikesPDF = new JRadioButton();
		botonLikesPDF.setBounds(1100, 400, 100, 30);

		botonIngresosPDF = new JRadioButton();
		botonIngresosPDF.setBounds(1100, 450, 100, 30);

		botonEstaturaPDF = new JRadioButton();
		botonEstaturaPDF.setBounds(1100, 300, 100, 30);

		grupoPDF = new ButtonGroup();
		grupoPDF.add(botonEdadPDF);
		grupoPDF.add(botonLikesPDF);
		grupoPDF.add(botonIngresosPDF);
		grupoPDF.add(botonEstaturaPDF);

		this.add(botonEdadPDF);
		this.add(botonLikesPDF);
		this.add(botonIngresosPDF);
		this.add(botonEstaturaPDF);
		this.add(botonPDF);
		this.add(botonOrdenar);
		this.add(botonAscendente);
		this.add(botonDescendente);
		this.add(botonPorEdad);
		this.add(botonNombre);
		this.add(botonAlias);
		this.add(botonLikes);
		this.add(botonTopLikes);
		this.add(botonTopIngresos);
		this.add(scrollPanel);
		this.add(botonTop);
	}

	public void mostrarTextos(String labelBotonOrdenar, String labelBotonAscendente, String labelBotonDescendente,
			String labelBotonPorEdad, String labelBotonNombre, String labelBotonAlias, String labelBotonLikes,
			String labelBotonTopLikes, String labelBotonTopIngresos, String labelBotonTop, String labelOrdenarPor,
			String labelCriterio, String labelTop, String labelPDF, String labelBotonEdadPDF, String labelBotonLikesPDF,
			String labelBotonIngresosPDF, String labelBotonEstaturaPDF) {
		botonOrdenar.setText(labelBotonOrdenar);
		botonTop.setText(labelBotonTop);
		botonAscendente.setText(labelBotonAscendente);
		botonDescendente.setText(labelBotonDescendente);
		botonPorEdad.setText(labelBotonPorEdad);
		botonNombre.setText(labelBotonNombre);
		botonAlias.setText(labelBotonAlias);
		botonLikes.setText(labelBotonLikes);
		botonTopLikes.setText(labelBotonTopLikes);
		botonTopIngresos.setText(labelBotonTopIngresos);
		botonPDF.setText(labelPDF);
		crearLabel(labelOrdenarPor, Color.WHITE, 920, 50, 300, 30, 24);
		crearLabel(labelCriterio, Color.WHITE, 920, 200, 300, 30, 24);
		crearLabel(labelTop, Color.WHITE, 1100, 50, 300, 30, 24);
		botonEdadPDF.setText(labelBotonEdadPDF);
		botonLikesPDF.setText(labelBotonLikesPDF);
		botonIngresosPDF.setText(labelBotonIngresosPDF);
		botonEstaturaPDF.setText(labelBotonEstaturaPDF);
	}

	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	public void agregarUsuario(String alias, ImageIcon imagen, int edad, float estatura, ActionListener listener) {
		panelUsuarios.add(new PanelUsuarioAdmin(alias, imagen, edad, estatura, listener));
	}

	public void agregarUsuario(String alias, ImageIcon imagen, int edad, float estatura, ActionListener listener,
			String ingresoProm) {
		panelUsuarios.add(new PanelUsuarioAdmin(alias, imagen, edad, estatura, listener, ingresoProm));
	}

	public void limpiarUsuarios() {
		panelUsuarios.removeAll();
		panelUsuarios.revalidate();
		panelUsuarios.repaint();
	}

	public void setOff() {
		scrollPanel.setEnabled(false);
		panelUsuarios.setEnabled(false);
		for (Component comp : panelUsuarios.getComponents()) {
			for (Component com : ((JPanel) comp).getComponents()) {
				if (com instanceof JButton) {
					com.setEnabled(false);
				}
			}
		}
		scrollPanel.revalidate();
		scrollPanel.repaint();
		botonOrdenar.setEnabled(false);
		botonAscendente.setEnabled(false);
		botonDescendente.setEnabled(false);
		botonPorEdad.setEnabled(false);
		botonNombre.setEnabled(false);
		botonAlias.setEnabled(false);
		botonLikes.setEnabled(false);
		botonTopLikes.setEnabled(false);
		botonTopIngresos.setEnabled(false);
		botonTop.setEnabled(false);
	}

	public void setOn() {
		scrollPanel.setEnabled(true);
		panelUsuarios.setEnabled(true);
		scrollPanel.setEnabled(false);
		panelUsuarios.setEnabled(false);
		for (Component comp : panelUsuarios.getComponents()) {
			for (Component com : ((JPanel) comp).getComponents()) {
				if (com instanceof JButton) {
					com.setEnabled(true);
				}
			}
		}
		scrollPanel.revalidate();
		scrollPanel.repaint();
		botonOrdenar.setEnabled(true);
		botonAscendente.setEnabled(true);
		botonDescendente.setEnabled(true);
		botonPorEdad.setEnabled(true);
		botonNombre.setEnabled(true);
		botonAlias.setEnabled(true);
		botonLikes.setEnabled(true);
		botonTopLikes.setEnabled(true);
		botonTopIngresos.setEnabled(true);
		botonTop.setEnabled(true);
	}

	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}

	public void setScrollPanel(JScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}

	public JPanel getPanelUsuarios() {
		return panelUsuarios;
	}

	public void setPanelUsuarios(JPanel panelUsuarios) {
		this.panelUsuarios = panelUsuarios;
	}

	public JButton getBotonOrdenar() {
		return botonOrdenar;
	}

	public void setBotonOrdenar(JButton botonOrdenar) {
		this.botonOrdenar = botonOrdenar;
	}

	public JRadioButton getBotonAscendente() {
		return botonAscendente;
	}

	public void setBotonAscendente(JRadioButton botonAscendente) {
		this.botonAscendente = botonAscendente;
	}

	public JRadioButton getBotonDescendente() {
		return botonDescendente;
	}

	public void setBotonDescendente(JRadioButton botonDescendente) {
		this.botonDescendente = botonDescendente;
	}

	public JRadioButton getBotonPorEdad() {
		return botonPorEdad;
	}

	public void setBotonPorEdad(JRadioButton botonPorEdad) {
		this.botonPorEdad = botonPorEdad;
	}

	public JRadioButton getBotonNombre() {
		return botonNombre;
	}

	public void setBotonNombre(JRadioButton botonNombre) {
		this.botonNombre = botonNombre;
	}

	public JRadioButton getBotonAlias() {
		return botonAlias;
	}

	public void setBotonAlias(JRadioButton botonAlias) {
		this.botonAlias = botonAlias;
	}

	public JRadioButton getBotonLikes() {
		return botonLikes;
	}

	public void setBotonLikes(JRadioButton botonLikes) {
		this.botonLikes = botonLikes;
	}

	public ButtonGroup getGrupoOrdenamientos() {
		return grupoOrdenamientos;
	}

	public void setGrupoOrdenamientos(ButtonGroup grupoOrdenamientos) {
		this.grupoOrdenamientos = grupoOrdenamientos;
	}

	public ButtonGroup getGrupoCriterios() {
		return grupoCriterios;
	}

	public void setGrupoCriterios(ButtonGroup grupoCriterios) {
		this.grupoCriterios = grupoCriterios;
	}

	public JRadioButton getBotonTopLikes() {
		return botonTopLikes;
	}

	public void setBotonTopLikes(JRadioButton botonTopLikes) {
		this.botonTopLikes = botonTopLikes;
	}

	public JRadioButton getBotonTopIngresos() {
		return botonTopIngresos;
	}

	public void setBotonTopIngresos(JRadioButton botonTopIngresos) {
		this.botonTopIngresos = botonTopIngresos;
	}

	public ButtonGroup getGrupoTop() {
		return grupoTop;
	}

	public void setGrupoTop(ButtonGroup grupoTop) {
		this.grupoTop = grupoTop;
	}

	public JButton getBotonTop() {
		return botonTop;
	}

	public void setBotonTop(JButton botonTop) {
		this.botonTop = botonTop;
	}

	public JButton getBotonPDF() {
		return botonPDF;
	}

	public void setBotonPDF(JButton botonPDF) {
		this.botonPDF = botonPDF;
	}
	public JRadioButton getBotonEdadPDF() {
		return botonEdadPDF;
	}

	public JRadioButton getBotonLikesPDF() {
		return botonLikesPDF;
	}

	public void setBotonLikesPDF(JRadioButton botonLikesPDF) {
		this.botonLikesPDF = botonLikesPDF;
	}

	public JRadioButton getBotonIngresosPDF() {
		return botonIngresosPDF;
	}

	public void setBotonIngresosPDF(JRadioButton botonIngresosPDF) {
		this.botonIngresosPDF = botonIngresosPDF;
	}

	public JRadioButton getBotonEstaturaPDF() {
		return botonEstaturaPDF;
	}

	public void setBotonEstaturaPDF(JRadioButton botonEstaturaPDF) {
		this.botonEstaturaPDF = botonEstaturaPDF;
	}

	public ButtonGroup getGrupoPDF() {
		return grupoPDF;
	}

	public void setGrupoPDF(ButtonGroup grupoPDF) {
		this.grupoPDF = grupoPDF;
	}

	public void setBotonEdadPDF(JRadioButton botonEdadPDF) {
		this.botonEdadPDF = botonEdadPDF;
	}
}
