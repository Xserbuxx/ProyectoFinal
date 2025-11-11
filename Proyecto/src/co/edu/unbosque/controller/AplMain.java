package co.edu.unbosque.controller;

/**
 * Clase principal de la aplicación que contiene el método main.
 * Esta clase es el punto de entrada del programa.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class AplMain {

	/**
	 * Método principal que inicia la ejecución del programa.
	 * Crea una instancia del controlador y ejecuta el método run.
	 * 
	 * @param args Argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		Controlador con = new Controlador();
		con.run();
		//
	}

}