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

/**
 * Panel que representa la tarjeta de un usuario en la lista principal.
 * Muestra información básica del usuario y permite dar like.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class PanelUsuario extends JPanel {

    /**
     * Constructor que crea un panel de usuario para mujeres.
     * 
     * @param alias El alias del usuario
     * @param imagen La imagen de perfil
     * @param edad La edad del usuario
     * @param estatura La estatura del usuario
     * @param likes Cantidad de likes recibidos
     * @param like Si el usuario actual ya dio like
     * @param listener Listener para el botón de like
     */
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
    
    /**
     * Cambia el modo visual del panel entre claro y oscuro.
     * 
     * @param colorFondo Color de fondo a aplicar
     * @param colorTexto Color de texto a aplicar
     */
    public void cambiarModo(Color colorFondo, Color colorTexto) {
		this.setBackground(colorFondo);
		for (int i = 0; i < this.getComponentCount(); i++) {
			if (this.getComponent(i) instanceof JLabel) {
				((JLabel) this.getComponent(i)).setForeground(colorTexto);
			}
		}
	}

    /**
     * Constructor que crea un panel de usuario para hombres.
     * Incluye información adicional del ingreso promedio.
     * 
     * @param alias El alias del usuario
     * @param imagen La imagen de perfil
     * @param edad La edad del usuario
     * @param estatura La estatura del usuario
     * @param likes Cantidad de likes recibidos
     * @param like Si el usuario actual ya dio like
     * @param listener Listener para el botón de like
     * @param ingresoProm El ingreso promedio del usuario
     */
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

    /**
     * Crea y agrega una etiqueta de texto al panel.
     * 
     * @param texto El texto a mostrar
     * @param colorFondo El color del texto
     * @param x Posición X
     * @param y Posición Y
     * @param ancho Ancho de la etiqueta
     * @param alto Alto de la etiqueta
     * @param tamanoLetra Tamaño de la fuente
     */
    public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
        JLabel label = new JLabel(texto);
        label.setForeground(colorFondo);
        label.setBounds(x, y, ancho, alto);
        label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
        this.add(label);
        this.setComponentZOrder(label, 0);
    }
}