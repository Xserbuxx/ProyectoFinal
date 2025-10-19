package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VerificarCodigo extends JPanel{
	
	private JTextField campoCodigo;
	
	private JButton botonConfirmar;
	
	public VerificarCodigo() {
		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));
		
		JPanel panel = new JPanel();
		
		panel.setBounds(150, 130, 950, 420);
		panel.setBackground( new Color(30,31,34));
		
		campoCodigo = new JTextField();
		
		campoCodigo.setBounds(300, 350, 400, 50);
		campoCodigo.setFont(new Font("Sans", Font.PLAIN, 20));
		
		botonConfirmar = new JButton();
		
		botonConfirmar.setBounds(450, 450, 300, 50);
		botonConfirmar.setFont(new Font("Sans", Font.BOLD, 25));
		botonConfirmar.setBackground(new Color(3, 102, 214));
		botonConfirmar.setForeground(Color.white);
		botonConfirmar.setFocusable(false);
		botonConfirmar.setFocusPainted(false);
		botonConfirmar.setBorderPainted(false);
		
		this.add(botonConfirmar);
		this.add(campoCodigo);
		this.add(panel);
	}
	
	public void mostrarTextos(String labelVerificarCodigo, String labelInstrucciones, String labelCodigo, String labelBotonConfirmar) {
		crearLabel(labelVerificarCodigo, Color.WHITE, 500, 180, 400, 50, 30);
		crearLabel(labelInstrucciones, Color.WHITE, 300, 220, 800, 50, 20);
		crearLabel(labelCodigo, Color.WHITE, 300, 310, 300, 30, 20);
		
		botonConfirmar.setText(labelBotonConfirmar);
	}
	
	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	public JTextField getCampoCodigo() {
		return campoCodigo;
	}

	public void setCampoCodigo(JTextField campoCodigo) {
		this.campoCodigo = campoCodigo;
	}

	public JButton getBotonConfirmar() {
		return botonConfirmar;
	}

	public void setBotonConfirmar(JButton botonConfirmar) {
		this.botonConfirmar = botonConfirmar;
	}
	
}
