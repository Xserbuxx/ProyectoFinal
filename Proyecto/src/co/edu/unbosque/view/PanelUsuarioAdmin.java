package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelUsuarioAdmin extends JPanel {

	public PanelUsuarioAdmin(String alias, ImageIcon imagen, String edad, String estatura, ActionListener listener) {
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800, 150));

		if (imagen != null) {
			Image imagenEscalada = imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
			labelImagen.setBounds(20, 20, 100, 100);
			this.add(labelImagen);
		}

		crearLabel(alias, Color.black, 200, 20, 200, 30, 20);
		crearLabel(edad + "", Color.black, 200, 50, 200, 30, 20);
		crearLabel(estatura + "", Color.black, 200, 80, 200, 30, 20);

		ImageIcon infoI = new ImageIcon("Resources/info.png");
		Image imagenEscaladaInfo = infoI.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		JButton botonInfo = new JButton(new ImageIcon(imagenEscaladaInfo));
		botonInfo.setBounds(650, 50, 50, 50);
		botonInfo.setBackground(new Color(0, 0, 0, 0));
		botonInfo.setFont(new Font("Sans", Font.PLAIN, 30));
		botonInfo.setFocusable(false);
		botonInfo.setContentAreaFilled(false);
		botonInfo.setFocusPainted(false);
		botonInfo.setBorderPainted(false);

		botonInfo.setActionCommand("botonInfo-" + alias);
		botonInfo.addActionListener(listener);
		
		ImageIcon baja = new ImageIcon("Resources/baja.png");
		Image imagenEscaladaBaja = baja.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		JButton botonBaja = new JButton(new ImageIcon(imagenEscaladaBaja));
		botonBaja.setBounds(750, 50, 50, 50);
		botonBaja.setBackground(new Color(0, 0, 0, 0));
		botonBaja.setFont(new Font("Sans", Font.PLAIN, 30));
		botonBaja.setFocusable(false);
		botonBaja.setContentAreaFilled(false);
		botonBaja.setFocusPainted(false);
		botonBaja.setBorderPainted(false);

		botonBaja.setActionCommand("botonBaja-" + alias);
		botonBaja.addActionListener(listener);
		
		this.add(botonInfo);
		this.add(botonBaja);
	}
	
	public void cambiarModo(Color colorFondo, Color colorTexto) {
		this.setBackground(colorFondo);
		for (int i = 0; i < this.getComponentCount(); i++) {
			if (this.getComponent(i) instanceof JLabel) {
				((JLabel) this.getComponent(i)).setForeground(colorTexto);
			}
		}
	}

	public PanelUsuarioAdmin(String alias, ImageIcon imagen, String edad, String estatura, ActionListener listener,
			String ingresoProm) {
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800, 150));

		if (imagen != null) {
			Image imagenEscalada = imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
			labelImagen.setBounds(20, 20, 100, 100);
			this.add(labelImagen);
		}

		crearLabel(alias, Color.black, 200, 20, 200, 30, 20);
		crearLabel(edad + "", Color.black, 200, 50, 200, 30, 20);
		crearLabel(estatura + "", Color.black, 200, 80, 200, 30, 20);
		crearLabel(ingresoProm, Color.black, 200, 110, 200, 30, 15);

		ImageIcon infoI = new ImageIcon("Resources/info.png");
		Image imagenEscaladaInfo = infoI.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		JButton botonInfo = new JButton(new ImageIcon(imagenEscaladaInfo));
		botonInfo.setBounds(650, 50, 50, 50);
		botonInfo.setBackground(new Color(0, 0, 0, 0));
		botonInfo.setFont(new Font("Sans", Font.PLAIN, 30));
		botonInfo.setFocusable(false);
		botonInfo.setContentAreaFilled(false);
		botonInfo.setFocusPainted(false);
		botonInfo.setBorderPainted(false);

		botonInfo.setActionCommand("botonInfo-" + alias);
		botonInfo.addActionListener(listener);

		ImageIcon baja = new ImageIcon("Resources/baja.png");
		Image imagenEscaladaBaja = baja.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		JButton botonBaja = new JButton(new ImageIcon(imagenEscaladaBaja));
		botonBaja.setBounds(750, 50, 50, 50);
		botonBaja.setBackground(new Color(0, 0, 0, 0));
		botonBaja.setFont(new Font("Sans", Font.PLAIN, 30));
		botonBaja.setFocusable(false);
		botonBaja.setContentAreaFilled(false);
		botonBaja.setFocusPainted(false);
		botonBaja.setBorderPainted(false);

		botonBaja.setActionCommand("botonBaja-" + alias);
		botonBaja.addActionListener(listener);
		
		this.add(botonInfo);
		this.add(botonBaja);
	}

	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

}
