package co.edu.unbosque.view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelUsuario extends JPanel {

    private Color colorTinder = new Color(255, 51, 102);
    private JPanel barraLateral;

    public PanelUsuario(String alias, ImageIcon imagen, int edad, float estatura, int likes, boolean like,
            ActionListener listener) {
    	  setLayout(null);
          setBackground(Color.WHITE);
          setPreferredSize(new Dimension(420, 520)); // tamaño fijo tipo tarjeta
          setBorder(BorderFactory.createCompoundBorder(
                  BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                  new EmptyBorder(10, 10, 10, 10)
          ));

          // 🔹 Imagen del usuario
          Image imagenEscalada = imagen.getImage().getScaledInstance(320, 320, Image.SCALE_SMOOTH);
          JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
          labelImagen.setBounds(50, 20, 320, 320); // centrada dentro de la tarjeta
          add(labelImagen);

          // 🔹 Alias
          JLabel lblAlias = new JLabel(alias, SwingConstants.CENTER);
          lblAlias.setFont(new Font("SansSerif", Font.BOLD, 20));
          lblAlias.setBounds(0, 350, 420, 25);
          add(lblAlias);

          // 🔹 Edad
          JLabel lblEdad = new JLabel(edad + " años", SwingConstants.CENTER);
          lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 16));
          lblEdad.setBounds(0, 380, 420, 20);
          add(lblEdad);

          // 🔹 Estatura
          JLabel lblEstatura = new JLabel("Estatura: " + estatura + " cm", SwingConstants.CENTER);
          lblEstatura.setFont(new Font("SansSerif", Font.PLAIN, 15));
          lblEstatura.setBounds(0, 405, 420, 20);
          add(lblEstatura);

          // 🔹 Botón de Like
          JButton botonLike = new JButton("\u2764 " + likes);
          botonLike.setFont(new Font("SansSerif", Font.PLAIN, 26));
          botonLike.setBounds(165, 445, 90, 50); // centrado horizontalmente
          botonLike.setFocusable(false);
          botonLike.setContentAreaFilled(false);
          botonLike.setFocusPainted(false);
          botonLike.setBorderPainted(false);
          botonLike.setForeground(like ? colorTinder : Color.LIGHT_GRAY);
          botonLike.setActionCommand("BotonLike-" + alias);
          botonLike.addActionListener(listener);
          add(botonLike);
      }

      // 🔹 Constructor con ingresoProm
      public PanelUsuario(String alias, ImageIcon imagen, int edad, float estatura, int likes, boolean like,
              ActionListener listener, String ingresoProm) {

          setLayout(null);
          setBackground(Color.WHITE);
          setPreferredSize(new Dimension(420, 540)); // mismo tamaño de tarjeta
          setBorder(BorderFactory.createCompoundBorder(
                  BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                  new EmptyBorder(10, 10, 10, 10)
          ));

          Image imagenEscalada = imagen.getImage().getScaledInstance(320, 320, Image.SCALE_SMOOTH);
          JLabel labelImagen = new JLabel(new ImageIcon(imagenEscalada));
          labelImagen.setBounds(50, 20, 320, 320);
          add(labelImagen);

          JLabel lblAlias = new JLabel(alias, SwingConstants.CENTER);
          lblAlias.setFont(new Font("SansSerif", Font.BOLD, 20));
          lblAlias.setBounds(0, 350, 420, 25);
          add(lblAlias);

          JLabel lblEdad = new JLabel(edad + " años", SwingConstants.CENTER);
          lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 16));
          lblEdad.setBounds(0, 380, 420, 20);
          add(lblEdad);

          JLabel lblEstatura = new JLabel("Estatura: " + estatura + " cm", SwingConstants.CENTER);
          lblEstatura.setFont(new Font("SansSerif", Font.PLAIN, 15));
          lblEstatura.setBounds(0, 405, 420, 20);
          add(lblEstatura);

          JLabel lblIngreso = new JLabel("Ingreso: " + ingresoProm, SwingConstants.CENTER);
          lblIngreso.setFont(new Font("SansSerif", Font.ITALIC, 13));
          lblIngreso.setBounds(0, 430, 420, 20);
          add(lblIngreso);

          JButton botonLike = new JButton("\u2764 " + likes);
          botonLike.setFont(new Font("SansSerif", Font.PLAIN, 26));
          botonLike.setBounds(165, 465, 90, 50);
          botonLike.setFocusable(false);
          botonLike.setContentAreaFilled(false);
          botonLike.setFocusPainted(false);
          botonLike.setBorderPainted(false);
          botonLike.setForeground(like ? colorTinder : Color.LIGHT_GRAY);
          botonLike.setActionCommand("BotonLike-" + alias);
          botonLike.addActionListener(listener);
          add(botonLike);
      }

    public void crearLabel(String texto, Color color, int x, int y, int ancho, int alto, int tamanoLetra) {
        JLabel label = new JLabel(texto);
        label.setForeground(color);
        label.setBounds(x, y, ancho, alto);
        label.setFont(new Font("SansSerif", Font.BOLD, tamanoLetra));
        add(label);
    }
}