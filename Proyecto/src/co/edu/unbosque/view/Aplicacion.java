package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Aplicacion extends JPanel{
	
	JButton botonIncognito;
	JScrollPane scrollPanel;
	JPanel panelUsuarios;
	
	public Aplicacion() {
		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));
		
		botonIncognito = new JButton();
		botonIncognito.setBounds(0, 0, 330, 50);
		botonIncognito.setForeground(Color.white);
		botonIncognito.setBackground(new Color(255, 0, 0));
		botonIncognito.setFocusable(false);
		botonIncognito.setFocusPainted(false);
		botonIncognito.setBorderPainted(false);
		
		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(new Color(36, 41, 46));
		panelUsuarios.setLayout(new GridLayout(0, 1, 10, 10));
		
		scrollPanel = new JScrollPane(panelUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 60, 1260, 640);
		scrollPanel.setBackground(new Color(36, 41, 46));
		
		this.add(scrollPanel);
		this.add(botonIncognito);
	}
	
	public void cambiarBotonIncognito(boolean estado) {
		if(!estado) {
			botonIncognito.setBackground(new Color(255, 0, 0));
		} else {
			botonIncognito.setBackground(new Color(0, 255, 0));
		}
	}
	
	public void agregarUsuario(String alias, ImageIcon imagen, int edad, float estatura,int likes, boolean like, ActionListener listener) {
		panelUsuarios.add(new PanelUsuario(alias, imagen, edad, estatura, likes,like,listener));
	}

	public JButton getBotonIncognito() {
		return botonIncognito;
	}

	public void setBotonIncognito(JButton botonIncognito) {
		this.botonIncognito = botonIncognito;
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
}
