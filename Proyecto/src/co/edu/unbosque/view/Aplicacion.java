package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Aplicacion extends JPanel {

	private JPanel barraLateral;
	private JScrollPane scrollPanel;
	private JPanel panelUsuarios;
	private JButton botonPerfil;
	private JButton botonVolver;
	private JLabel logo;
	private Color colorTinder = new Color(255, 51, 102);
	public Aplicacion() {
		setLayout(null);
		setBackground(new Color(59, 59, 59));

		// 🔹 Barra lateral
		barraLateral = new JPanel();
		barraLateral.setLayout(null);
		barraLateral.setBackground(new Color(255, 51, 102));
		barraLateral.setBounds(0, 0, 350, 720);

		 ImageIcon imgVolver = new ImageIcon("Resources/volver3.png");
		    botonVolver = new JButton(new ImageIcon(imgVolver.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		    botonVolver.setBounds(10, 10, 40, 40);
		    botonVolver.setContentAreaFilled(false);
		    botonVolver.setBorderPainted(false);
		    botonVolver.setFocusPainted(false);
		    barraLateral.add(botonVolver);

		    ImageIcon imgLogo = new ImageIcon("Resources/logo.png"); // Asegúrate del nombre correcto del archivo
		    JLabel logo = new JLabel(new ImageIcon(imgLogo.getImage().getScaledInstance(180, 60, Image.SCALE_SMOOTH)));
		    logo.setBounds(60, -10, 180, 75); // subido arriba y más largo
		    barraLateral.add(logo);


		botonPerfil = new JButton("Perfil");
		botonPerfil.setBounds(1130, 10, 100, 40);
		CampoRedondeado.aplicarRedondeado(botonPerfil, 25, colorTinder, Color.WHITE);
		
		panelUsuarios = new JPanel(null);
		panelUsuarios.setBackground(new Color(59, 59, 59));
		panelUsuarios.setPreferredSize(new Dimension(1180, 0));

		// 🔹 Scroll principal
		scrollPanel = new JScrollPane(panelUsuarios);
		scrollPanel.setBounds(350, 60, 1180, 640);
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
		scrollPanel.setBorder(null);

		barraLateral.add(botonVolver);
		add(barraLateral);
		add(scrollPanel);
		add(botonPerfil);
	}	public void agregarUsuario(String alias, ImageIcon imagen, int edad, float estatura, int likes, boolean like,
			ActionListener listener) {

		PanelUsuario tarjeta = new PanelUsuario(alias, imagen, edad, estatura, likes, like, listener);
		tarjeta.setBounds(235, panelUsuarios.getComponentCount() * 580, 380, 540);
		panelUsuarios.add(tarjeta);
		panelUsuarios.setPreferredSize(new Dimension(1180, panelUsuarios.getComponentCount() * 580));
	}

	public void agregarUsuario(String alias, ImageIcon imagen, int edad, float estatura, int likes, boolean like,
			ActionListener listener, String ingresoProm) {

		PanelUsuario tarjeta = new PanelUsuario(alias, imagen, edad, estatura, likes, like, listener, ingresoProm);
		tarjeta.setBounds(235, panelUsuarios.getComponentCount() * 580, 380, 540);
		panelUsuarios.add(tarjeta);
		panelUsuarios.setPreferredSize(new Dimension(1180, panelUsuarios.getComponentCount() * 580));
	}
	public void limpiarUsuarios() {
		panelUsuarios.removeAll();
		panelUsuarios.setPreferredSize(new Dimension(1180, 0));
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

