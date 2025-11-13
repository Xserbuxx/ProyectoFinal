package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * Clase que extiende JTextField para crear campos de texto con bordes redondeados.
 * Proporciona un método estático para aplicar estilo redondeado a otros componentes Swing.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class CampoRedondeado extends JTextField {

	/** Radio de las esquinas redondeadas */
	private int radio;

	/**
	 * Constructor que crea un campo de texto redondeado.
	 * 
	 * @param columnas El número de columnas del campo de texto
	 * @param radio El radio de las esquinas redondeadas
	 */
	public CampoRedondeado(int columnas, int radio) {
		super(columnas);
		this.radio = radio;
		setOpaque(false);

		setBorder(new BordeRedondeado(radio, new Color(255, 255, 255, 180)));

		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
	}

	/**
	 * Sobrescribe el método para pintar el componente con esquinas redondeadas.
	 * 
	 * @param g El contexto gráfico
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radio, radio);

		super.paintComponent(g);
		g2.dispose();
	}

	/**
	 * Método estático que aplica un estilo redondeado a cualquier componente Swing.
	 * Funciona especialmente bien con JButton.
	 * 
	 * @param componente El componente al que se le aplicará el estilo
	 * @param radio El radio de las esquinas redondeadas
	 * @param colorFondo El color de fondo del componente
	 * @param colorTexto El color del texto del componente
	 */
	public static void aplicarRedondeado(JComponent componente, int radio, Color colorFondo, Color colorTexto) {
		componente.setOpaque(false);
		componente.setBackground(colorFondo);
		componente.setForeground(colorTexto);
		componente.setBorder(BorderFactory.createEmptyBorder());
		componente.setFont(new Font("SansSerif", Font.BOLD, 14));

		if (componente instanceof JButton) {
			JButton boton = (JButton) componente;

			boton.setUI(new BasicButtonUI() {
				@Override
				public void paint(Graphics g, JComponent c) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

					g2.setColor(c.getBackground());
					g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), radio, radio);

					FontMetrics fm = g2.getFontMetrics();
					String texto = boton.getText();
					int x = (c.getWidth() - fm.stringWidth(texto)) / 2;
					int y = (c.getHeight() + fm.getAscent() - fm.getDescent()) / 2;
					g2.setColor(c.getForeground());
					g2.drawString(texto, x, y);

					g2.dispose();
				}
			});
		}
	}
}