package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando un código de verificación no cumple con el formato esperado.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class CodigoException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public CodigoException(String mensaje) {
		super(mensaje);
	}	
	
}