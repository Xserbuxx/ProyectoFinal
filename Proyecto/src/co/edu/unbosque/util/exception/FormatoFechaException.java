package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando el formato de una fecha es inválido.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class FormatoFechaException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public FormatoFechaException(String mensaje) {
		super(mensaje);
	}

}