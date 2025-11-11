package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando un número está fuera del rango permitido.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class RangoNumeroException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public RangoNumeroException(String mensaje) {
		super(mensaje);
	}

}