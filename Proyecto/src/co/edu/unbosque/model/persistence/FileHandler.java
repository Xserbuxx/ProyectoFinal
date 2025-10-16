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

	// texto
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

	// serializado
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

	//propiedades
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
