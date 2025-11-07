package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Idioma extends JPanel {

	private JComboBox<String> comboBox;
	private JButton confirmar;
	private JPanel panelEncabezado;
	private JLabel imagenLogo;
	private JLabel textoEncabezado;
	private JPanel panelContenido;

	public Idioma() {
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);

		panelEncabezado = new JPanel();
		panelEncabezado.setLayout(null);
		panelEncabezado.setBounds(0, 0, 1280, 100);

		ImageIcon headerIcon = new ImageIcon("Resources/fondoEncabezado.png");
		Image headerImg = headerIcon.getImage().getScaledInstance(1280, 100, Image.SCALE_SMOOTH);
		JLabel headerBg = new JLabel(new ImageIcon(headerImg));
		headerBg.setLayout(null);
		headerBg.setBounds(0, 0, 1280, 100);

		imagenLogo = new JLabel(new ImageIcon("Resources/logo.png"));
		imagenLogo.setBounds(0, 5, 250, 80);
		headerBg.add(imagenLogo);

		panelEncabezado.add(headerBg);
		this.add(panelEncabezado);

		panelContenido = new JPanel();
		panelContenido.setLayout(null);
		panelContenido.setBounds(0, 100, 1280, 620);
		panelContenido.setBackground(new Color(59, 59, 59));
		this.add(panelContenido);

		Color colorTinder = new Color(255, 51, 102);
		textoEncabezado = new JLabel("¿Estás preparado para encontrar tu match perfecto?",JLabel.CENTER);
		textoEncabezado.setFont(new Font("Sans Serif", Font.BOLD, 30));
		textoEncabezado.setForeground(Color.WHITE); 
		textoEncabezado.setBounds(100, 40, 1080, 50);
		panelContenido.add(textoEncabezado);

		JPanel panelRecuadro = new JPanel();

		panelRecuadro.setLayout(null);
		panelRecuadro.setBounds(400, 160, 480, 260);
		panelRecuadro.setBackground(new Color(255, 255, 255, 20));
		panelRecuadro.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
		panelContenido.add(panelRecuadro);

		JLabel selecIdioma = new JLabel("Seleccione  idioma", JLabel.CENTER);
		selecIdioma.setBounds(0, 10, 480, 40);
		selecIdioma.setFont(new Font("Arial", Font.BOLD, 26));
		selecIdioma.setForeground(Color.WHITE);
		panelRecuadro.add(selecIdioma);


		JPanel panelComboDecorado = new JPanel();
		panelComboDecorado.setLayout(null);
		panelComboDecorado.setBounds(40, 70, 400, 50);
		panelComboDecorado.setBackground(new Color(59, 59, 59));
		panelComboDecorado.setBorder(javax.swing.BorderFactory.createLineBorder(colorTinder, 2, true));
		panelRecuadro.add(panelComboDecorado);

		JLabel iconoMundo = new JLabel("🌐");
		iconoMundo.setBounds(355, 5, 40, 40);
		iconoMundo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
		iconoMundo.setForeground(Color.WHITE);
		panelComboDecorado.add(iconoMundo);

		String[] idiomas = { "Español", "Português", "Русский", "中文", "עברית" };
		comboBox = new JComboBox<>(idiomas);
		comboBox.setBounds(10, 5, 340, 40);
		comboBox.setFont(new Font("Sans", Font.PLAIN, 20));
		comboBox.setBackground(new Color(59, 59, 59));
		comboBox.setForeground(Color.WHITE);
		comboBox.setFocusable(false);
		comboBox.setBorder(null);
		panelComboDecorado.add(comboBox);

		confirmar = new JButton("Confirmar");
		confirmar.setBounds(90, 150, 300, 50);
		confirmar.setFont(new Font("Arial", Font.BOLD, 22));
		confirmar.setBackground(colorTinder);
		confirmar.setForeground(Color.WHITE);
		confirmar.setFocusPainted(false);
		panelRecuadro.add(confirmar);

	}

	public JButton getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(JButton confirmar) {
		this.confirmar = confirmar;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

}
