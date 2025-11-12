package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Aplicacion extends JPanel {

	private JScrollPane scrollPanel;
	private JPanel panelUsuarios;
	private JButton botonPerfil;
	private JButton botonVolver;

	public Aplicacion() {
		this.setLayout(null);
		this.setBackground(new Color(59, 59, 59));

		
		ImageIcon imagenPerfil = new ImageIcon("Resources/perfil.png");
		Image imagenRedimensionadaPerfil = imagenPerfil.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionada = new ImageIcon(imagenRedimensionadaPerfil);

		botonPerfil = new JButton(imagenRedimensionada);
		botonPerfil.setBounds(600, 0, 50, 50);
		botonPerfil.setBackground(new Color(0, 0, 0, 0));
		botonPerfil.setContentAreaFilled(false);
		botonPerfil.setBorderPainted(false);
		botonPerfil.setFocusPainted(false);
		botonPerfil.setFocusable(false);
		
		ImageIcon imagenVolver = new ImageIcon("Resources/volver.png");
		Image imagenRedimensionadaVolver = imagenVolver.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionadaVolverv = new ImageIcon(imagenRedimensionadaVolver);

		botonVolver = new JButton(imagenRedimensionadaVolverv);
		botonVolver.setBounds(10, 10, 50, 50);
		botonVolver.setBackground(Color.red);
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setFocusable(false);

		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(Color.WHITE);
		panelUsuarios.setLayout(new GridLayout(0, 1, 10, 10));

		scrollPanel = new JScrollPane(panelUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 60, 1260, 640);
		scrollPanel.setBackground(new Color(36, 41, 46));
		
		this.add(botonVolver);
		this.add(botonPerfil);
		this.add(scrollPanel);
	}
	
	public void cambiarModo() {
		Color fondo;
		Color texto;
		if (this.getBackground().equals(Color.WHITE)) {
			fondo = new Color(36, 41, 46);
			texto = Color.WHITE;
		} else {
			fondo = Color.WHITE;
			texto = Color.BLACK;
		}
		this.setBackground(fondo);
		panelUsuarios.setBackground(fondo);
		for (int i = 0; i < panelUsuarios.getComponentCount(); i++) {
			Component comp = panelUsuarios.getComponent(i);
			if (comp instanceof PanelUsuario) {
				((PanelUsuario) comp).cambiarModo(fondo, texto);
			}
		}
	}

	public void agregarUsuario(String alias, ImageIcon imagen, int edad, float estatura, int likes, boolean like,
			ActionListener listener) {
		panelUsuarios.add(new PanelUsuario(alias, imagen, edad, estatura, likes, like, listener));
	}
	
	public void agregarUsuario(String alias, ImageIcon imagen, int edad, float estatura, int likes, boolean like,
			ActionListener listener, String ingresoProm) {
		panelUsuarios.add(new PanelUsuario(alias, imagen, edad, estatura, likes, like, listener, ingresoProm));
	}
	
	public void limpiarUsuarios() {
		panelUsuarios.removeAll();
		panelUsuarios.revalidate();
		panelUsuarios.repaint();
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

	public JButton getBotonPerfil() {
		return botonPerfil;
	}

	public void setBotonPerfil(JButton botonPerfil) {
		this.botonPerfil = botonPerfil;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}
	
}
