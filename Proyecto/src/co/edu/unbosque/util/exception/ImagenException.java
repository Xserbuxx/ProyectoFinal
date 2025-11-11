package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando hay un problema con la ruta o formato de una imagen.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class ImagenException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public ImagenException(String mensaje) {
		super(mensaje);
	}

}