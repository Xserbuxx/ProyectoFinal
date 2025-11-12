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

public class PanelUsuario extends JPanel {
    private Color colorTinder = new Color(255, 51, 102);
    private JPanel barraLateral;

    public PanelUsuario(String alias, ImageIcon imagen, int edad, float estatura, int likes, boolean like,
            ActionListener listener) {
        this.setBackground(new Color(59, 59, 59));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(575, 120));
        
        barraLateral = new JPanel();
        barraLateral.setBackground(colorTinder);
        barraLateral.setBounds(0, 0, 158, 120);
        this.add(barraLateral);

        Image imagenEscalada = imagen.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
        labelImagen.setBounds(175, 20, 80, 80);
        this.add(labelImagen);

        // 🔹 Datos del usuario
        crearLabel(alias, Color.black, 275, 20, 200, 25, 16);
        crearLabel(edad + "", Color.black, 275, 45, 200, 25, 16);
        crearLabel(estatura + "", Color.black, 275, 70, 200, 25, 16);

        JButton botonLike = new JButton("\u2764 " + likes);
        botonLike.setBounds(435, 35, 100, 40);
        botonLike.setBackground(Color.white);
        botonLike.setFont(new Font("Sans", Font.PLAIN, 22));
        botonLike.setFocusable(false);
        botonLike.setContentAreaFilled(false);
        botonLike.setFocusPainted(false);
        botonLike.setBorderPainted(false);

        botonLike.setForeground(like ? Color.red : Color.gray);
        botonLike.setActionCommand("BotonLike-" + alias);
        botonLike.addActionListener(listener);

        this.add(botonLike);
    }

    public PanelUsuario(String alias, ImageIcon imagen, int edad, float estatura, int likes, boolean like,
            ActionListener listener, String ingresoProm) {
        this.setBackground(new Color(59, 59, 59));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(575, 120));

        barraLateral = new JPanel();
        barraLateral.setBackground(colorTinder);
        barraLateral.setBounds(0, 0, 158, 120);
        this.add(barraLateral);

        Image imagenEscalada = imagen.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
        labelImagen.setBounds(175, 20, 80, 80);
        this.add(labelImagen);

        crearLabel(alias, Color.black, 275, 20, 200, 25, 16);
        crearLabel(edad + "", Color.black, 275, 45, 200, 25, 16);
        crearLabel(estatura + "", Color.black, 275, 70, 200, 25, 16);
        crearLabel(ingresoProm, Color.black, 275, 90, 200, 20, 13);

        JButton botonLike = new JButton("\u2764 " + likes);
        botonLike.setBounds(435, 35, 100, 40);
        botonLike.setBackground(Color.white);
        botonLike.setFont(new Font("Sans", Font.PLAIN, 22));
        botonLike.setFocusable(false);
        botonLike.setContentAreaFilled(false);
        botonLike.setFocusPainted(false);
        botonLike.setBorderPainted(false);

        botonLike.setForeground(like ? Color.red : Color.gray);
        botonLike.setActionCommand("BotonLike-" + alias);
        botonLike.addActionListener(listener);

        this.add(botonLike);
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