package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal() {
		this.setSize(1280, 720);
		this.setTitle("BOSTINDER");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public void mostrarVentana() {
		this.setVisible(true);
	}
	
	/**
	 * Fuerza la actualización visual de la ventana.
	 */
	public void actualizar() {
		this.revalidate();
		this.repaint();
	}

	/**
	 * Muestra un cuadro de diálogo de error con el mensaje dado.
	 */
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Muestra un cuadro de diálogo informativo con el mensaje dado.
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
