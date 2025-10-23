package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SeleccionGustos extends JPanel {

	JTextField campoEdadMinima;
	JTextField campoEdadMaxima;
	JTextField campoEstaturaIdeal;
	JTextField campoIngresoIdeal;

	JButton botonConfirmar;

	JRadioButton divorciada;
	JRadioButton noDivorciada;

	ButtonGroup estadoDivorcio;

	public SeleccionGustos() {

		this.setBackground(new Color(36, 41, 46));
		this.setLayout(null);

		JPanel panel = new JPanel();

		panel.setBounds(150, 130, 950, 420);
		panel.setBackground(new Color(30, 31, 34));
		// botones de estado de divorcio
		divorciada = new JRadioButton();

		divorciada.setBounds(600, 350, 200, 20);
		divorciada.setBackground(new Color(30, 31, 34));
		divorciada.setForeground(Color.WHITE);
		divorciada.setFocusable(false);
		divorciada.setFocusPainted(false);
		divorciada.setBorderPainted(false);

		divorciada.setVisible(false);
		divorciada.setEnabled(false);

		noDivorciada = new JRadioButton();

		noDivorciada.setBounds(600, 370, 200, 20);
		noDivorciada.setBackground(new Color(30, 31, 34));
		noDivorciada.setForeground(Color.WHITE);
		noDivorciada.setFocusable(false);
		noDivorciada.setFocusPainted(false);
		noDivorciada.setBorderPainted(false);

		noDivorciada.setVisible(false);
		noDivorciada.setEnabled(false);

		estadoDivorcio = new ButtonGroup();
		estadoDivorcio.add(divorciada);
		estadoDivorcio.add(noDivorciada);
		// campos
		campoEdadMinima = new JTextField();
		campoEdadMinima.setBounds(200, 300, 100, 30);
		campoEdadMinima.setBackground(new Color(50, 50, 50));
		campoEdadMinima.setForeground(Color.WHITE);
		campoEdadMinima.setBorder(null);

		campoEdadMaxima = new JTextField();
		campoEdadMaxima.setBounds(350, 300, 100, 30);
		campoEdadMaxima.setBackground(new Color(50, 50, 50));
		campoEdadMaxima.setForeground(Color.WHITE);
		campoEdadMaxima.setBorder(null);

		campoEstaturaIdeal = new JTextField();
		campoEstaturaIdeal.setBounds(200, 400, 200, 30);
		campoEstaturaIdeal.setBackground(new Color(50, 50, 50));
		campoEstaturaIdeal.setForeground(Color.WHITE);
		campoEstaturaIdeal.setBorder(null);

		campoIngresoIdeal = new JTextField();
		campoIngresoIdeal.setBounds(600, 300, 200, 30);
		campoIngresoIdeal.setBackground(new Color(50, 50, 50));
		campoIngresoIdeal.setForeground(Color.WHITE);
		campoIngresoIdeal.setBorder(null);
		campoIngresoIdeal.setVisible(false);
		campoIngresoIdeal.setEnabled(false);

		botonConfirmar = new JButton();
		botonConfirmar.setBounds(425, 380, 100, 30);
		botonConfirmar.setBackground(new Color(70, 130, 180));
		botonConfirmar.setForeground(Color.WHITE);
		botonConfirmar.setFocusable(false);
		botonConfirmar.setFocusPainted(false);
		botonConfirmar.setBorderPainted(false);

		this.add(divorciada);
		this.add(noDivorciada);
		this.add(campoEdadMinima);
		this.add(campoEdadMaxima);
		this.add(campoEstaturaIdeal);
		this.add(campoIngresoIdeal);
		this.add(botonConfirmar);
		this.add(panel);
	}

	public void mostrarCamposMujer(String labelIngresoIdeal) {
		campoIngresoIdeal.setVisible(true);
		campoIngresoIdeal.setEnabled(true);
		divorciada.setVisible(false);
		divorciada.setEnabled(false);
		noDivorciada.setVisible(false);
		noDivorciada.setEnabled(false);
		estadoDivorcio.clearSelection();

		crearLabel(labelIngresoIdeal, Color.WHITE, 600, 270, 200, 30, 16);
	}

	public void mostrarCamposHombre(String labelDivorciada) {
		campoIngresoIdeal.setVisible(false);
		campoIngresoIdeal.setEnabled(false);
		divorciada.setVisible(true);
		divorciada.setEnabled(true);
		noDivorciada.setVisible(true);
		noDivorciada.setEnabled(true);
		campoIngresoIdeal.setText("");

		crearLabel(labelDivorciada, Color.WHITE, 600, 270, 200, 30, 16);
	}

	public void mostrarTextos(String labelEdadMinima, String labelEdadMaxima, String labelEstaturaIdeal,
			String labelDivorciada, String labelNoDivorciada, String labelConfirmar, String labelEdad) {
		crearLabel(labelEdadMinima, Color.WHITE, 200, 250, 200, 30, 16);
		crearLabel(labelEdadMaxima, Color.WHITE, 400, 250, 200, 30, 16);
		crearLabel(labelEstaturaIdeal, Color.WHITE, 200, 350, 200, 30, 16);
		crearLabel(labelEdad, Color.WHITE, 200, 200, 200, 30, 16);

		divorciada.setText(labelDivorciada);
		noDivorciada.setText(labelNoDivorciada);
		botonConfirmar.setText(labelConfirmar);
	}

	public void eliminarLabelGustos(String labelIngresoProm, String labelEstadoDivorcio) {
		for (Component c : this.getComponents()) {
			if (!(c instanceof JLabel)) {
				continue;
			}
			if (((JLabel) c).getText().equals(labelIngresoProm) || ((JLabel) c).getText().equals(labelEstadoDivorcio)) {
				this.remove(c);
				this.revalidate();
				this.repaint();
			}

		}
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
