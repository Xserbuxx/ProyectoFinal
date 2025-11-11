package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando un campo de texto es demasiado corto.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class CampoCortoException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public CampoCortoException(String mensaje) {
		super(mensaje);
	}

}