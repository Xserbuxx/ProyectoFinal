package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelUsuario extends JPanel {

    public PanelUsuario(String alias, ImageIcon imagen, String edad, String estatura, int likes, boolean like,
            ActionListener listener) {
        this.setBackground(new Color(59, 59, 59));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(900, 300));

        Image imagenEscalada = imagen.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
        labelImagen.setBounds(400, 20, 80, 80);
        this.add(labelImagen);
        
        JPanel borde = new JPanel();
        borde.setBackground(new Color(0,0,0,0));
        borde.setBounds(225, 10, 400, 280);
        borde.setBorder(BorderFactory.createLineBorder(Color.black));

        crearLabel(alias, Color.black, 325, 120, 600, 25, 16);
        crearLabel(edad + "", Color.black, 325, 150, 600, 25, 16);
        crearLabel(estatura + "", Color.black, 325, 180, 600, 25, 16);

        JButton botonLike = new JButton("\u2764 " + likes);
        botonLike.setBounds(400, 240, 100, 40);
        botonLike.setBackground(Color.white);
        botonLike.setFont(new Font("Sans", Font.PLAIN, 22));
        botonLike.setFocusable(false);
        botonLike.setContentAreaFilled(false);
        botonLike.setFocusPainted(false);
        botonLike.setBorderPainted(false);

        botonLike.setForeground(like ? Color.red : Color.gray);
        botonLike.setActionCommand("BotonLike-" + alias);
        botonLike.addActionListener(listener);
        
        this.add(borde);
        this.add(botonLike);
        
        this.setComponentZOrder(borde, this.getComponentCount() - 1);
    }
    
    public void cambiarModo(Color colorFondo, Color colorTexto) {
		this.setBackground(colorFondo);
		for (int i = 0; i < this.getComponentCount(); i++) {
			if (this.getComponent(i) instanceof JLabel) {
				((JLabel) this.getComponent(i)).setForeground(colorTexto);
			}
		}
	}

    public PanelUsuario(String alias, ImageIcon imagen, String edad, String estatura, int likes, boolean like,
            ActionListener listener, String ingresoProm) {
        this.setBackground(new Color(59, 59, 59));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(900, 300));

        Image imagenEscalada = imagen.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
        labelImagen.setBounds(400, 20, 80, 80);
        this.add(labelImagen);
        
        JPanel borde = new JPanel();
        borde.setBackground(new Color(0,0,0,0));
        borde.setBounds(225, 10, 400, 280);
        borde.setBorder(BorderFactory.createLineBorder(Color.black));

        crearLabel(alias, Color.black, 325, 120, 600, 25, 16);
        crearLabel(edad + "", Color.black, 325, 150, 600, 25, 16);
        crearLabel(estatura + "", Color.black, 325, 180, 600, 25, 16);
        crearLabel(ingresoProm, Color.black, 325, 210, 600, 25, 16);

        JButton botonLike = new JButton("\u2764 " + likes);
        botonLike.setBounds(400, 240, 100, 40);
        botonLike.setBackground(Color.white);
        botonLike.setFont(new Font("Sans", Font.PLAIN, 22));
        botonLike.setFocusable(false);
        botonLike.setContentAreaFilled(false);
        botonLike.setFocusPainted(false);
        botonLike.setBorderPainted(false);

        botonLike.setForeground(like ? Color.red : Color.gray);
        botonLike.setActionCommand("BotonLike-" + alias);
        botonLike.addActionListener(listener);
        
        this.add(borde);
        this.add(botonLike);
        
        this.setComponentZOrder(borde, this.getComponentCount() - 1);
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