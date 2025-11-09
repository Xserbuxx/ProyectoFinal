package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmarBaja extends JPanel {
	
	private JButton botonConfirmar;
	
	public ConfirmarBaja() {
		this.setBackground(new Color(36, 41, 46,200));
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(40, 45, 50));
		panelCentral.setBounds(300, 200, 600, 300);
		
		botonConfirmar = new JButton();
		botonConfirmar.setBounds(500, 350, 150, 50);
		botonConfirmar.setBackground(new Color(70, 130, 180));
		botonConfirmar.setForeground(Color.white);
		botonConfirmar.setFont(new Font("Sans", Font.BOLD, 18));
		botonConfirmar.setFocusPainted(false);
		botonConfirmar.setBorderPainted(false);
		botonConfirmar.setFocusable(false);
		
		this.add(botonConfirmar);
		this.add(panelCentral);
	}
	
	public void mostrarTextos(String texto, String labelBotonConfirmar) {
		botonConfirmar.setText(labelBotonConfirmar);
		crearLabel(texto, Color.white, 350, 250, 500, 50, 12);
	}

	
	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	public JButton getBotonConfirmar() {
		return botonConfirmar;
	}

	public void setBotonConfirmar(JButton botonConfirmar) {
		this.botonConfirmar = botonConfirmar;
	}
	
}
