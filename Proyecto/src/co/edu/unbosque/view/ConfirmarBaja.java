package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmarBaja extends JPanel {

	private JButton botonConfirmar;
	private JButton botonVolver;
	private JPanel panelCentral;

	public ConfirmarBaja() {
		this.setBackground(new Color(36, 41, 46, 200));
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);

		panelCentral = new JPanel();
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

		ImageIcon imagenVolver = new ImageIcon("Resources/volver.png");
		Image imagenRedimensionadaVolver = imagenVolver.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionada = new ImageIcon(imagenRedimensionadaVolver);

		botonVolver = new JButton(imagenRedimensionada);
		botonVolver.setBounds(10, 10, 50, 50);
		botonVolver.setBackground(Color.red);
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setFocusable(false);

		this.add(botonVolver);
		this.add(botonConfirmar);
		this.add(panelCentral);
	}

	public void cambiarModo() {
		if (panelCentral.getBackground().equals(new Color(40, 45, 50))) {
			panelCentral.setBackground(Color.white);
			for (Component c : this.getComponents()) {
				if (c instanceof JLabel) {
					((JLabel) c).setForeground(Color.black);
				}
			}
		} else {
			panelCentral.setBackground(new Color(40, 45, 50));
			for (Component c : this.getComponents()) {
				if (c instanceof JLabel) {
					((JLabel) c).setForeground(Color.white);
				}
			}
		}
	}

	public void mostrarTextos(String texto, String labelBotonConfirmar) {
		limpiarLabels();
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

	public void limpiarLabels() {
		for (Component c : this.getComponents()) {
			if (c instanceof JLabel) {
				this.remove(c);
			}

		}
	}

	public JButton getBotonConfirmar() {
		return botonConfirmar;
	}

	public void setBotonConfirmar(JButton botonConfirmar) {
		this.botonConfirmar = botonConfirmar;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}

}
