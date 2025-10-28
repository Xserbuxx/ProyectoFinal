package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelUsuario extends JPanel{
	
	public PanelUsuario(String alias) {
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800,150));
		
		crearLabel(alias, Color.black, 20, 20, 200, 30, 20);
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
