package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando se ingresa un número en formato no válido.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class NumeroException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public NumeroException(String mensaje) {
		super(mensaje);
	}

}