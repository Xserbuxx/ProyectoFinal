package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;

public class CampoRedondeado extends JTextField {

	private int radio;

	public CampoRedondeado(int columnas, int radio) {
		super(columnas);
		this.radio = radio;
		setOpaque(false);

		setBorder(new BordeRedondeado(radio, new Color(255, 255, 255, 180)));

		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radio, radio);

		super.paintComponent(g);
		g2.dispose();
	}

	private static class BordeRedondeado implements Border {
		private int radio;
		private Color color;

		public BordeRedondeado(int radio, Color color) {
			this.radio = radio;
			this.color = color;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(color);
			g2.drawRoundRect(x, y, width - 1, height - 1, radio, radio);
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(5, 10, 5, 10);
		}

		@Override
		public boolean isBorderOpaque() {
			return false;
		}
	}

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