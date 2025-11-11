package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

/**
 * Clase utilitaria para el manejo de archivos de texto, serializados y archivos de propiedades.
 * Proporciona métodos estáticos para leer y escribir diferentes tipos de archivos.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class FileHandler {

	// texto
	public static File archivo;
	public static PrintWriter escritor;
	public static Scanner lector;
	// serializado
	public static FileInputStream fis;
	public static ObjectInputStream ois;
	public static FileOutputStream fos;
	public static ObjectOutputStream oos;
	public static Properties prop;

	/**
	 * Escribe contenido en un archivo de texto.
	 * Crea el archivo si no existe.
	 * 
	 * @param url La ruta del archivo
	 * @param contenido El contenido a escribir
	 */
	public static void escribirEnArchivoTexto(String url, String contenido) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al crear y escribir el archivode texto" + "\n" + e.getMessage());
		}
	}

	/**
	 * Lee el contenido completo de un archivo de texto.
	 * Crea el archivo si no existe.
	 * 
	 * @param url La ruta del archivo
	 * @return El contenido del archivo como cadena de texto
	 */
	public static String leerArchivoTexto(String url) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lector = new Scanner(archivo);

			String contenido = "";

			while (lector.hasNext()) {
				contenido += lector.nextLine() + "\n";
			}

			lector.close();
			return contenido;

		} catch (IOException e) {
			System.out.println("Error al crear y leer el archivo de texto" + "\n" + e.getMessage());
			return null;
		}
	}

	/**
	 * Escribe un objeto en un archivo serializado.
	 * 
	 * @param url La ruta del archivo
	 * @param contenido El objeto a serializar
	 */
	public static void escribirArchivoSerializado(String url, Object contenido) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("Error al crear y escribir el archivo serializado" + "\n");
			e.printStackTrace();
		}
	}

	/**
	 * Lee un objeto desde un archivo serializado.
	 * 
	 * @param url La ruta del archivo
	 * @return El objeto deserializado
	 */
	public static Object leerArchivoSerializado(String url) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			Object contenido = ois.readObject();
			ois.close();
			fis.close();
			return contenido;

		} catch (IOException e) {
			System.out.println("Error al leer archivo deserializado" + "\n");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al deserializar los datos del archivo: " + "\n");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Carga un archivo de propiedades (.properties).
	 * 
	 * @param url La ruta del archivo de propiedades
	 * @return El objeto Properties con las propiedades cargadas
	 */
	public static Properties cargarArchivoDePropiedades(String url) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			prop = new Properties();
			prop.load(new FileInputStream(archivo));
			return prop;
		} catch (Exception e) {
			System.out.println("Error al cargar el archivo de propiedades");
			e.printStackTrace();
		}
		return null;
	}

}