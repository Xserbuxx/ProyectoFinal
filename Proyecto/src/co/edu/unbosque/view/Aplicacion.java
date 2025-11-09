package co.edu.unbosque.view;

import java.awt.Color;
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

	public Aplicacion() {
		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));

		ImageIcon imagenPerfil = new ImageIcon("Resources/perfil.png");
		Image imagenRedimensionadaPerfil = imagenPerfil.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionada = new ImageIcon(imagenRedimensionadaPerfil);

		botonPerfil = new JButton(imagenRedimensionada);
		botonPerfil.setBounds(0, 0, 50, 50);
		botonPerfil.setBackground(new Color(0, 0, 0, 0));
		botonPerfil.setContentAreaFilled(false);
		botonPerfil.setBorderPainted(false);
		botonPerfil.setFocusPainted(false);
		botonPerfil.setFocusable(false);

		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(new Color(36, 41, 46));
		panelUsuarios.setLayout(new GridLayout(0, 1, 10, 10));

		scrollPanel = new JScrollPane(panelUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 60, 1260, 640);
		scrollPanel.setBackground(new Color(36, 41, 46));

		this.add(botonPerfil);
		this.add(scrollPanel);
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
}
