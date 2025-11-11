package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando un texto contiene caracteres especiales no permitidos.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class CaracteresEspecialesException extends Exception {
	
	/**
	 * Constructor de la excepción con un mensaje personalizado.
	 * 
	 * @param mensaje El mensaje descriptivo de la excepción
	 */
	public CaracteresEspecialesException(String mensaje) {
		super(mensaje);
	}

}