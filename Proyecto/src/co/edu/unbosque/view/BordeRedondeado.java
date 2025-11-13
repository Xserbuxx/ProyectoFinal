package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.Border;

/**
 * Clase que implementa un borde redondeado personalizado para componentes Swing.
 * Permite crear bordes con esquinas redondeadas y color personalizable.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class BordeRedondeado implements Border {
	/** Radio de las esquinas redondeadas */
	private int radio;
	
	/** Color del borde */
	private Color color;

	/**
	 * Constructor que inicializa el borde redondeado.
	 * 
	 * @param radio El radio de las esquinas redondeadas
	 * @param color El color del borde
	 */
	public BordeRedondeado(int radio, Color color) {
		this.radio = radio;
		this.color = color;
	}

	/**
	 * Dibuja el borde redondeado alrededor del componente.
	 * 
	 * @param c El componente al que se le aplica el borde
	 * @param g El contexto gráfico
	 * @param x La coordenada x del borde
	 * @param y La coordenada y del borde
	 * @param width El ancho del borde
	 * @param height La altura del borde
	 */
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.drawRoundRect(x, y, width - 1, height - 1, radio, radio);
	}

	/**
	 * Retorna los márgenes internos del borde.
	 * 
	 * @param c El componente
	 * @return Los márgenes internos
	 */
	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(5, 10, 5, 10);
	}

	/**
	 * Indica si el borde es opaco.
	 * 
	 * @return false ya que el borde es transparente
	 */
	@Override
	public boolean isBorderOpaque() {
		return false;
	}
}