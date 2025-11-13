package co.edu.unbosque.model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Clase que representa a un usuario hombre en el sistema de citas.
 * Extiende de Persona e incluye atributos específicos para hombres.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class Hombre extends Persona {

	/** Identificador de versión para la serialización */
	private static final long serialVersionUID = 1L;
	
	/** Ingreso promedio mensual del hombre */
	private float ingresoProm;
	
	/** Preferencia sobre el estado civil de la pareja (divorciada o no) */
	private boolean estadoDivorcio;

	/**
	 * Constructor por defecto de la clase Hombre.
	 */
	public Hombre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con atributos específicos de Hombre.
	 * 
	 * @param ingresoProm El ingreso promedio mensual
	 * @param estadoDivorcio Preferencia sobre el estado civil (divorciada o no)
	 */
	public Hombre(float ingresoProm, boolean estadoDivorcio) {
		super();
		this.ingresoProm = ingresoProm;
		this.estadoDivorcio = estadoDivorcio;
	}

	/**
	 * Constructor completo de la clase Hombre.
	 * 
	 * @param nombre El nombre completo
	 * @param alias El nombre de usuario
	 * @param edad La edad
	 * @param fechaNacimiento La fecha de nacimiento
	 * @param estatura La estatura en centímetros
	 * @param correo El correo electrónico
	 * @param imagen La imagen de perfil
	 * @param disponibilidad Indica si está disponible para citas
	 * @param contrasena La contraseña de la cuenta
	 * @param codigo El código de verificación
	 * @param edadMaxima La edad máxima deseada en una pareja
	 * @param edadMinima La edad mínima deseada en una pareja
	 * @param estaturaIdeal La estatura ideal deseada en una pareja
	 * @param ingresoProm El ingreso promedio mensual
	 * @param estadoDivorcio Preferencia sobre el estado civil
	 * @param likesRecibidos El número de likes recibidos
	 * @param incognito Indica si está en modo incógnito
	 * @param likesDados Lista de alias a los que se les ha dado like
	 * @param verificado Indica si la cuenta está verificada
	 */
	public Hombre(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, int codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, float ingresoProm, boolean estadoDivorcio, int likesRecibidos, boolean incognito,
			ArrayList<String> likesDados, boolean verificado) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito, likesDados, verificado);
		this.ingresoProm = ingresoProm;
		this.estadoDivorcio = estadoDivorcio;
	}

	/**
	 * Constructor de la clase Hombre sin atributos específicos.
	 * 
	 * @param nombre El nombre completo
	 * @param alias El nombre de usuario
	 * @param edad La edad
	 * @param fechaNacimiento La fecha de nacimiento
	 * @param estatura La estatura en centímetros
	 * @param correo El correo electrónico
	 * @param imagen La imagen de perfil
	 * @param disponibilidad Indica si está disponible para citas
	 * @param contrasena La contraseña de la cuenta
	 * @param codigo El código de verificación
	 * @param edadMaxima La edad máxima deseada en una pareja
	 * @param edadMinima La edad mínima deseada en una pareja
	 * @param estaturaIdeal La estatura ideal deseada en una pareja
	 * @param likesRecibidos El número de likes recibidos
	 * @param incognito Indica si está en modo incógnito
	 * @param likesDados Lista de alias a los que se les ha dado like
	 * @param verificado Indica si la cuenta está verificada
	 */
	public Hombre(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, int codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, int likesRecibidos, boolean incognito, ArrayList<String> likesDados,
			boolean verificado) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito, likesDados, verificado);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el ingreso promedio mensual del hombre.
	 * 
	 * @return El ingreso promedio mensual
	 */
	public float getIngresoProm() {
		return ingresoProm;
	}

	/**
	 * Establece el ingreso promedio mensual del hombre.
	 * 
	 * @param ingresoProm El ingreso promedio a establecer
	 */
	public void setIngresoProm(float ingresoProm) {
		this.ingresoProm = ingresoProm;
	}

	/**
	 * Obtiene la preferencia sobre el estado civil de la pareja deseada.
	 * 
	 * @return true si prefiere divorciadas, false en caso contrario
	 */
	public boolean isEstadoDivorcio() {
		return estadoDivorcio;
	}

	/**
	 * Establece la preferencia sobre el estado civil de la pareja deseada.
	 * 
	 * @param estadoDivorcio La preferencia de estado civil a establecer
	 */
	public void setEstadoDivorcio(boolean estadoDivorcio) {
		this.estadoDivorcio = estadoDivorcio;
	}

	/**
	 * Convierte el objeto Hombre a una representación de texto.
	 * 
	 * @return Una cadena con los datos del hombre separados por punto y coma
	 */
	@Override
	public String toString() {
		return super.toString() + ";" + ingresoProm + ";" + estadoDivorcio;
	}

}