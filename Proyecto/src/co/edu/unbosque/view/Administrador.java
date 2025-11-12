package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
	private JButton cambiarModo;
	
	private JButton botonVolver;
	
	private JTextField txtBuscar;
	private JButton botonBuscar;

	public Administrador() {
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

		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(new Color(36, 41, 46));
		panelUsuarios.setLayout(new GridLayout(0, 1, 10, 10));

		scrollPanel = new JScrollPane(panelUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(350, 60, 900, 640);
		scrollPanel.setBackground(new Color(36, 41, 46));

		botonOrdenar = new JButton();
		botonOrdenar.setBounds(10, 100, 100, 30);
		CampoRedondeado.aplicarRedondeado(botonOrdenar, 25, new Color(74,144,226), Color.WHITE);

		botonAscendente = new JRadioButton();
		botonAscendente.setBounds(10, 200, 140, 30);
		botonAscendente.setBackground(new Color(255, 51, 102));

		botonDescendente = new JRadioButton();
		botonDescendente.setBounds(10, 250, 140, 30);
		botonDescendente.setBackground(new Color(255, 51, 102));

		grupoOrdenamientos = new ButtonGroup();
		grupoOrdenamientos.add(botonAscendente);
		grupoOrdenamientos.add(botonDescendente);

		botonPorEdad = new JRadioButton();
		botonPorEdad.setBounds(10, 350, 100, 30);
		botonPorEdad.setBackground(new Color(255, 51, 102));

		botonNombre = new JRadioButton();
		botonNombre.setBounds(10, 400, 100, 30);
		botonNombre.setBackground(new Color(255, 51, 102));

		botonAlias = new JRadioButton();
		botonAlias.setBounds(10, 450, 100, 30);
		botonAlias.setBackground(new Color(255, 51, 102));

		botonLikes = new JRadioButton();
		botonLikes.setBounds(10, 500, 100, 30);
		botonLikes.setBackground(new Color(255, 51, 102));

		grupoCriterios = new ButtonGroup();
		grupoCriterios.add(botonPorEdad);
		grupoCriterios.add(botonNombre);
		grupoCriterios.add(botonAlias);
		grupoCriterios.add(botonLikes);

		botonTopLikes = new JRadioButton();
		botonTopLikes.setBounds(150, 200, 200, 30);
		botonTopLikes.setBackground(new Color(255, 51, 102));

		botonTopIngresos = new JRadioButton();
		botonTopIngresos.setBounds(150, 250, 120, 30);
		botonTopIngresos.setBackground(new Color(255, 51, 102));

		grupoTop = new ButtonGroup();
		grupoTop.add(botonTopLikes);
		grupoTop.add(botonTopIngresos);

		botonTop = new JButton();
		botonTop.setBounds(150, 100, 200, 30);
		CampoRedondeado.aplicarRedondeado(botonTop, 25, new Color(74,144,226), Color.WHITE);

		botonPDF = new JButton();
		botonPDF.setBounds(150, 350, 150, 30);
		CampoRedondeado.aplicarRedondeado(botonPDF, 25, new Color(74,144,226), Color.WHITE);

		botonEdadPDF = new JRadioButton();
		botonEdadPDF.setBounds(150, 400, 100, 30);
		botonEdadPDF.setBackground(new Color(255, 51, 102));

		botonLikesPDF = new JRadioButton();
		botonLikesPDF.setBounds(150, 450, 200, 30);
		botonLikesPDF.setBackground(new Color(255, 51, 102));

		botonIngresosPDF = new JRadioButton();
		botonIngresosPDF.setBounds(150, 500, 100, 30);
		botonIngresosPDF.setBackground(new Color(255, 51, 102));

		botonEstaturaPDF = new JRadioButton();
		botonEstaturaPDF.setBounds(150, 550, 100, 30);
		botonEstaturaPDF.setBackground(new Color(255, 51, 102));

		grupoPDF = new ButtonGroup();
		grupoPDF.add(botonEdadPDF);
		grupoPDF.add(botonLikesPDF);
		grupoPDF.add(botonIngresosPDF);
		grupoPDF.add(botonEstaturaPDF);
		
		cambiarModo = new JButton();
		cambiarModo.setBounds(1060, 15, 180, 40);
		CampoRedondeado.aplicarRedondeado(cambiarModo, 25, new Color(255, 51, 102), Color.WHITE);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(400, 15, 400, 40);
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(820, 15, 100, 40);
		CampoRedondeado.aplicarRedondeado(botonBuscar, 25, new Color(74,144,226), Color.WHITE);
		
		this.add(txtBuscar);
		this.add(botonBuscar);
		this.add(botonVolver);
		this.add(cambiarModo);
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
		this.add(barraLateral);
	}

	public void mostrarTextos(String labelBotonOrdenar, String labelBotonAscendente, String labelBotonDescendente,
			String labelBotonPorEdad, String labelBotonNombre, String labelBotonAlias, String labelBotonLikes,
			String labelBotonTopLikes, String labelBotonTopIngresos, String labelBotonTop, String labelOrdenarPor,
			String labelCriterio, String labelTop, String labelPDF, String labelBotonEdadPDF, String labelBotonLikesPDF,
			String labelBotonIngresosPDF, String labelBotonEstaturaPDF, String labelCambiarModo, String labelBotonBuscar) {
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
		crearLabel(labelOrdenarPor, Color.WHITE, 10, 150, 300, 30, 24);
		crearLabel(labelCriterio, Color.WHITE, 10, 300, 300, 30, 24);
		crearLabel(labelTop, Color.WHITE, 150, 150, 300, 30, 24);
		botonEdadPDF.setText(labelBotonEdadPDF);
		botonLikesPDF.setText(labelBotonLikesPDF);
		botonIngresosPDF.setText(labelBotonIngresosPDF);
		botonEstaturaPDF.setText(labelBotonEstaturaPDF);
		cambiarModo.setText(labelCambiarModo);
		botonBuscar.setText(labelBotonBuscar);
	}
	
	public void cambiarModo() {
		Color fondo;
		Color texto;
		Color fondoI;
		Color textoI;
		if (this.getBackground().equals(Color.WHITE)) {
			fondo = new Color(36, 41, 46);
			fondoI = Color.WHITE;
			texto = Color.WHITE;
			textoI = Color.BLACK;
		} else {
			fondo = Color.WHITE;
			fondoI = new Color(36, 41, 46);
			texto = Color.BLACK;
			textoI = Color.WHITE;
		}
		this.setBackground(fondo);
		panelUsuarios.setBackground(fondo);
		for (int i = 0; i < panelUsuarios.getComponentCount(); i++) {
			Component comp = panelUsuarios.getComponent(i);
			if (comp instanceof PanelUsuarioAdmin) {
				((PanelUsuarioAdmin) comp).cambiarModo(fondo, texto);
			}
		}
		txtBuscar.setBackground(fondoI);
		txtBuscar.setForeground(textoI);
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

	public void agregarUsuario(String alias, ImageIcon imagen, String edad, String estatura, ActionListener listener) {
		panelUsuarios.add(new PanelUsuarioAdmin(alias, imagen, edad, estatura, listener));
	}

	public void agregarUsuario(String alias, ImageIcon imagen, String edad, String estatura, ActionListener listener,
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
		botonPDF.setEnabled(false);
		botonEdadPDF.setEnabled(false);
		botonLikesPDF.setEnabled(false);
		botonIngresosPDF.setEnabled(false);
		botonEstaturaPDF.setEnabled(false);
		cambiarModo.setEnabled(false);
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
		botonPDF.setEnabled(true);
		botonEdadPDF.setEnabled(true);
		botonLikesPDF.setEnabled(true);
		botonIngresosPDF.setEnabled(true);
		botonEstaturaPDF.setEnabled(true);
		cambiarModo.setEnabled(true);
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

	public JButton getCambiarModo() {
		return cambiarModo;
	}

	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}

	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	public void setTxtBuscar(JTextField txtBuscar) {
		this.txtBuscar = txtBuscar;
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}
	
}
