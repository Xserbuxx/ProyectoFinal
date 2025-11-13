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

/**
 * Panel para verificar el código de confirmación enviado al correo del usuario.
 * Permite ingresar y validar el código de 6 dígitos.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class VerificarCodigo extends JPanel {

	/** Campo de texto para ingresar el código de verificación */
	private JTextField campoCodigo;

	/** Botón para confirmar el código ingresado */
	private JButton botonConfirmar;

	/** Botón para cambiar entre modo claro y oscuro */
	private JButton cambiarModo;

	/** Panel con borde decorativo */
	private JPanel panelBorde;

	/**
	 * Constructor que inicializa el panel de verificación de código. Crea la
	 * interfaz con un campo de texto para el código y botones de acción.
	 */
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

	/**
	 * Cambia el modo visual del panel entre claro y oscuro. Alterna los colores de
	 * fondo y texto de todos los componentes.
	 */
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

	/**
	 * Muestra los textos traducidos en el panel según el idioma seleccionado.
	 * 
	 * @param labelVerificarCodigo	Texto del título principal
	 * @param labelInstrucciones  	Texto de las instrucciones
	 * @param labelCodigo         	Texto de la etiqueta del código
	 * @param labelBotonConfirmar 	Texto del botón confirmar
	 * @param labelCambiarModo    	Texto del botón cambiar modo
	 */
	public void mostrarTextos(String labelVerificarCodigo, String labelInstrucciones, String labelCodigo,
			String labelBotonConfirmar, String labelCambiarModo) {

		crearLabel(labelVerificarCodigo, Color.WHITE, 435, 180, 400, 50, 30);
		crearLabel(labelInstrucciones, Color.WHITE, 285, 230, 700, 50, 20);

		crearLabel(labelCodigo, Color.WHITE, 435, 310, 400, 30, 20);

		botonConfirmar.setText(labelBotonConfirmar);

		cambiarModo.setText(labelCambiarModo);

	}

	/**
	 * Crea y agrega una etiqueta de texto al panel con el estilo especificado.
	 * 
	 * @param texto       El texto a mostrar
	 * @param colorTexto  El color del texto
	 * @param x           Posición X
	 * @param y           Posición Y
	 * @param ancho       Ancho de la etiqueta
	 * @param alto        Alto de la etiqueta
	 * @param tamanoLetra Tamaño de la fuente
	 */
	public void crearLabel(String texto, Color colorTexto, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto, SwingConstants.CENTER);
		label.setForeground(new Color(200, 200, 200));
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Segoe UI", Font.PLAIN, tamanoLetra - 4));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	/**
	 * Limpia el contenido del campo de código.
	 */
	public void limpiarCampos() {
		campoCodigo.setText("");
	}

	/**
	 * Obtiene el campo de texto del código.
	 * 
	 * @return El campo código
	 */
	public JTextField getCampoCodigo() {
		return campoCodigo;
	}

	/**
	 * Establece el campo de texto del código.
	 * 
	 * @param campoCodigo El nuevo campo código
	 */
	public void setCampoCodigo(JTextField campoCodigo) {
		this.campoCodigo = campoCodigo;
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
	 * Obtiene el botón de cambiar modo.
	 * 
	 * @return El botón cambiar modo
	 */
	public JButton getCambiarModo() {
		return cambiarModo;
	}

	/**
	 * Establece el botón de cambiar modo.
	 * 
	 * @param cambiarModo El nuevo botón cambiar modo
	 */
	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

	/**
	 * Obtiene el panel con borde decorativo.
	 * 
	 * @return El panel borde
	 */
	public JPanel getPanelBorde() {
		return panelBorde;
	}

	/**
	 * Establece el panel con borde decorativo.
	 * 
	 * @param panelBorde El nuevo panel borde
	 */
	public void setPanelBorde(JPanel panelBorde) {
		this.panelBorde = panelBorde;
	}
}