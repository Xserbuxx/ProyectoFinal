package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Idioma extends JPanel {
	
	private JComboBox<String> comboBox;
	private JButton confirmar;

	public Idioma() {
		
		Color negroClaro = new Color(36,41,46);
		
		this.setLayout(null);
		this.setBackground(negroClaro);

		JPanel panel = new JPanel();

		panel.setBounds(150, 130, 950, 420);
		panel.setBackground( new Color(30,31,34));

		JLabel selecIdioma = new JLabel("Select the language");

		selecIdioma.setBounds(390, 200, 1000, 60);
		selecIdioma.setForeground(new Color(255, 255, 255, 200));
		selecIdioma.setFont(new Font("Arial", Font.BOLD, 50));

		String[] idiomas = { "Español", "Português", "\u0420\u0443\u0441\u0441\u043A\u0438\u0439", "\u4E2D\u56FD\u4EBA", "\u05E2\u05B4\u05D1\u05E8\u05B4\u05D9\u05EA" };

		comboBox = new JComboBox<>(idiomas);
		comboBox.setBounds(400, 320, 450, 60);
		comboBox.setBackground(negroClaro);
		comboBox.setForeground(new Color(255, 255, 255, 200));
		comboBox.setFocusable(false);
		comboBox.setFont(new Font("Sans", Font.BOLD, 20));
		
		confirmar = new JButton("Confirm");
		confirmar.setBounds(420, 440, 400, 60);
		confirmar.setForeground(Color.white);
		confirmar.setBackground(new Color(3,102,214));
		confirmar.setFont(new Font("Arial", Font.BOLD, 25));
		confirmar.setFocusable(false);
		confirmar.setFocusPainted(false);
		confirmar.setBorderPainted(false);
		
		this.add(confirmar);
		this.add(selecIdioma);
		this.add(comboBox);
		this.add(panel);
	}
}
