package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando un campo de texto está vacío.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class CampoVacioException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public CampoVacioException(String mensaje) {
		super(mensaje);
	}

}