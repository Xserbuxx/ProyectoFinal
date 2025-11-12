package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VerificarCodigo extends JPanel {

	private JTextField campoCodigo;

	private JButton botonConfirmar;

	private JButton cambiarModo;
	
	private JPanel panelBorde;

	public VerificarCodigo() {
		this.setLayout(null);
		this.setBackground(new Color(59, 59, 59));

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 720);
		panel.setBackground(new Color(59, 59, 59));
		panel.setLayout(null);

		Font campoFuente = new Font("Segoe UI", Font.PLAIN, 14);
		Color colorTinder = new Color(255, 51, 102);

		panelBorde = new JPanel();
		panelBorde.setLayout(null);
		panelBorde.setBounds(355, 140, 570, 400);
		panelBorde.setBackground(new Color(59, 59, 59));
		panelBorde.setBorder(new LineBorder(new Color(255, 51, 102), 4, true));

		campoCodigo = new CampoRedondeado(15, 45);
		campoCodigo.setBounds(85, 200, 400, 50);
		campoCodigo.setFont(campoFuente);

		botonConfirmar = new JButton();
		botonConfirmar.setBounds(135, 270, 300, 50);
		CampoRedondeado.aplicarRedondeado(botonConfirmar, 25, colorTinder, Color.WHITE);

		cambiarModo = new JButton();
		cambiarModo.setBounds(1060, 15, 180, 40);
		CampoRedondeado.aplicarRedondeado(cambiarModo, 25, new Color(255, 51, 102), Color.WHITE);

		this.add(cambiarModo);
		panelBorde.add(campoCodigo);
		panelBorde.add(botonConfirmar);
		panel.add(panelBorde);
		this.add(panel);
	}

	public void cambiarModo() {
		if (this.getBackground().equals(new Color(59, 59, 59))) {
			this.setBackground(Color.WHITE);
			for (Component c : this.getComponents()) {
				if (c instanceof JPanel) {
					c.setBackground(Color.WHITE);
				}

				if (c instanceof JLabel) {
					c.setForeground(Color.BLACK);
				}

			}
			
			panelBorde.setBackground(Color.WHITE);
			
			for (Component c : panelBorde.getComponents()) {
				if (c instanceof JTextField) {
					c.setBackground(new Color(59, 59, 59));
					c.setForeground(Color.WHITE);
				}
			}
			
		} else {
			this.setBackground(new Color(59, 59, 59));
			for (Component c : this.getComponents()) {
				if (c instanceof JPanel) {
					c.setBackground(new Color(59, 59, 59));
				}

				if (c instanceof JLabel) {
					c.setForeground(Color.WHITE);
				}

			}
			
			panelBorde.setBackground(new Color(59, 59, 59));
			
			for (Component c : panelBorde.getComponents()) {
				if (c instanceof JTextField) {
					c.setBackground(Color.WHITE);
					c.setForeground(Color.BLACK);
				}
			}

		}
	}

	public void mostrarTextos(String labelVerificarCodigo, String labelInstrucciones, String labelCodigo,
			String labelBotonConfirmar, String labelCambiarModo) {

		crearLabel(labelVerificarCodigo, Color.WHITE, 435, 180, 400, 50, 30);
		crearLabel(labelInstrucciones, Color.WHITE, 285, 230, 700, 50, 20);
		crearLabel(labelCodigo, Color.WHITE, 435, 310, 400, 30, 20);

		botonConfirmar.setText(labelBotonConfirmar);
		
		cambiarModo.setText(labelCambiarModo);
	}

	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto, SwingConstants.CENTER);
		label.setForeground(new Color(200, 200, 200));
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Segoe UI", Font.PLAIN, tamanoLetra - 4));
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

	public JButton getCambiarModo() {
		return cambiarModo;
	}

	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

}
