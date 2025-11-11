package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando un texto contiene espacios donde no debería.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class ContieneEspaciosException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public ContieneEspaciosException(String mensaje) {
		super(mensaje);
	}

}