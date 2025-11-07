package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * CampoRedondeado
 * Clase personalizada que extiende JTextField para dibujar
 * un fondo y borde con esquinas redondeadas.
 * Solo modifica el estilo visual, no la lógica del programa.
 */
public class CampoRedondeado extends JTextField {

    private int radio; // radio de redondez

    public CampoRedondeado(int columnas, int radio) {
        super(columnas);
        this.radio = radio;

        // Permite ver el fondo redondeado
        setOpaque(false);

        // Borde personalizado (color blanco con transparencia)
        setBorder(new BordeRedondeado(radio, new Color(255, 255, 255, 180)));

        // Color del fondo del campo
        setBackground(Color.WHITE);

        // Color del texto
        setForeground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Activa antialiasing para bordes suaves
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el fondo redondeado
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radio, radio);

        super.paintComponent(g);
        g2.dispose();
    }

    // Clase interna que define el borde redondeado
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
}


