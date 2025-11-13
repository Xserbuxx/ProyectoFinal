package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase que representa la ventana principal de la aplicación.
 * Extiende de JFrame y proporciona la configuración básica de la ventana.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class VentanaPrincipal extends JFrame{
	
	/**
	 * Constructor que configura la ventana principal.
	 * Establece el tamaño, título, y comportamientos básicos de la ventana.
	 */
	public VentanaPrincipal() {
		this.setSize(1280, 720);
		this.setTitle("BOSTINDER");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Hace visible la ventana principal.
	 */
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
	 * 
	 * @param mensaje El mensaje de error a mostrar
	 */
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Muestra un cuadro de diálogo informativo con el mensaje dado.
	 * 
	 * @param mensaje El mensaje informativo a mostrar
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
	}
	
}