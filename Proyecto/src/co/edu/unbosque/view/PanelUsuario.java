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

public class PanelUsuario extends JPanel{
	
	public PanelUsuario(String alias, ImageIcon imagen, int edad , float estatura, int likes, boolean like ,ActionListener listener) {
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800,150));
		
		Image imagenEscalada = imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
		labelImagen.setBounds(20, 20, 100, 100);
		
		crearLabel(alias, Color.black, 200, 20, 200, 30, 20);
		crearLabel(edad+"", Color.black, 200, 50, 200, 30, 20);
		crearLabel(estatura+"", Color.black, 200, 80, 200, 30, 20);
		
		JButton botonLike = new JButton("\u2764 " + likes);
		botonLike.setBounds(650, 50, 150, 50);
		botonLike.setBackground(Color.white);
		botonLike.setFont(new Font("Sans", Font.PLAIN, 30));
		botonLike.setFocusable(false);
		botonLike.setContentAreaFilled(false);
		botonLike.setFocusPainted(false);
		botonLike.setBorderPainted(false);
		
		if (like) {
			botonLike.setForeground(Color.red);
		} else {
			botonLike.setForeground(Color.gray);
		}
		
		botonLike.setActionCommand("BotonLike-"+alias);
		botonLike.addActionListener(listener);
		
		this.add(botonLike);
		this.add(labelImagen);
	}
	
	public PanelUsuario(String alias, ImageIcon imagen, int edad , float estatura, int likes, boolean like ,ActionListener listener, String ingresoProm) {
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800,150));
		
		Image imagenEscalada = imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
		labelImagen.setBounds(20, 20, 100, 100);
		
		crearLabel(alias, Color.black, 200, 20, 200, 30, 20);
		crearLabel(edad+"", Color.black, 200, 50, 200, 30, 20);
		crearLabel(estatura+"", Color.black, 200, 80, 200, 30, 20);
		crearLabel(ingresoProm, Color.black, 200, 110, 200, 30, 15);
		
		JButton botonLike = new JButton("\u2764 " + likes);
		botonLike.setBounds(650, 50, 150, 50);
		botonLike.setBackground(Color.white);
		botonLike.setFont(new Font("Sans", Font.PLAIN, 30));
		botonLike.setFocusable(false);
		botonLike.setContentAreaFilled(false);
		botonLike.setFocusPainted(false);
		botonLike.setBorderPainted(false);
		
		if (like) {
			botonLike.setForeground(Color.red);
		} else {
			botonLike.setForeground(Color.gray);
		}
		
		botonLike.setActionCommand("BotonLike-"+alias);
		botonLike.addActionListener(listener);
		
		this.add(botonLike);
		this.add(labelImagen);
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
