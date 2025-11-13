package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel de confirmación para dar de baja una cuenta de usuario.
 * Muestra un mensaje de confirmación y permite confirmar o cancelar la acción.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class ConfirmarBaja extends JPanel {

	/** Botón para confirmar la baja */
	private JButton botonConfirmar;
	
	/** Botón para volver/cancelar */
	private JButton botonVolver;
	
	/** Panel central que contiene el mensaje */
	private JPanel panelCentral;

	/**
	 * Constructor que inicializa el panel de confirmación de baja.
	 * Crea la interfaz con un mensaje y botones de confirmación.
	 */
	public ConfirmarBaja() {
		this.setBackground(new Color(36, 41, 46, 200));
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);

		panelCentral = new JPanel();
		panelCentral.setBackground(new Color(40, 45, 50));
		panelCentral.setBounds(300, 200, 600, 300);

		botonConfirmar = new JButton();
		botonConfirmar.setBounds(500, 370, 200, 50);
		botonConfirmar.setBackground(new Color(70, 130, 180));
		botonConfirmar.setForeground(Color.white);
		botonConfirmar.setFont(new Font("Sans", Font.BOLD, 18));
		botonConfirmar.setFocusPainted(false);
		botonConfirmar.setBorderPainted(false);
		botonConfirmar.setFocusable(false);

		ImageIcon imagenVolver = new ImageIcon("Resources/volver3.png");
		Image imagenRedimensionadaVolver = imagenVolver.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionada = new ImageIcon(imagenRedimensionadaVolver);

		botonVolver = new JButton(imagenRedimensionada);
		botonVolver.setBounds(10, 10, 50, 50);
		botonVolver.setBackground(new Color(255, 51, 102));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setFocusable(false);

		this.add(botonVolver);
		this.add(botonConfirmar);
		this.add(panelCentral);
	}

	/**
	 * Cambia el modo visual del panel entre claro y oscuro.
	 * Alterna los colores de fondo y texto de todos los componentes.
	 */
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

	/**
	 * Muestra los textos traducidos en el panel según el idioma seleccionado.
	 * 
	 * @param texto Texto del mensaje de confirmación
	 * @param labelBotonConfirmar Texto del botón confirmar
	 */
	public void mostrarTextos(String texto, String labelBotonConfirmar) {
		limpiarLabels();
		botonConfirmar.setText(labelBotonConfirmar);
		crearLabel(texto, Color.white, 350, 250, 500, 50, 16);
	}

	/**
	 * Crea y agrega una etiqueta de texto al panel con el estilo especificado.
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

	/**
	 * Elimina todas las etiquetas del panel.
	 */
	public void limpiarLabels() {
		for (Component c : this.getComponents()) {
			if (c instanceof JLabel) {
				this.remove(c);
			}

		}
	}

	/**
	 * Obtiene el botón de confirmación.
	 * 
	 * @return El botón confirmar
	 */
	public JButton getBotonConfirmar() {
		return botonConfirmar;
	}

	/**
	 * Establece el botón de confirmación.
	 * 
	 * @param botonConfirmar El nuevo botón confirmar
	 */
	public void setBotonConfirmar(JButton botonConfirmar) {
		this.botonConfirmar = botonConfirmar;
	}

	/**
	 * Obtiene el botón de volver.
	 * 
	 * @return El botón volver
	 */
	public JButton getBotonVolver() {
		return botonVolver;
	}

	/**
	 * Establece el botón de volver.
	 * 
	 * @param botonVolver El nuevo botón volver
	 */
	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}

	/**
	 * Obtiene el panel central.
	 * 
	 * @return El panel central
	 */
	public JPanel getPanelCentral() {
		return panelCentral;
	}

	/**
	 * Establece el panel central.
	 * 
	 * @param panelCentral El nuevo panel central
	 */
	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}
}