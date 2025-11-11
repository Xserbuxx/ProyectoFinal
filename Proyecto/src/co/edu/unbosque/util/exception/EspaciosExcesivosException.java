package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando un texto tiene espacios excesivos o mal ubicados.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class EspaciosExcesivosException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public EspaciosExcesivosException(String mensaje) {
		super(mensaje);
	}

}