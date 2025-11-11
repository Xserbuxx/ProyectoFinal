package co.edu.unbosque.model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Clase DTO (Data Transfer Object) para transferir datos de una usuario mujer.
 * Extiende de Persona e incluye atributos específicos para mujeres.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class MujerDTO extends Persona {

	// datos basicos
	private boolean Divorciada;
	// gustos
	private float ingresosIdeal;

	/**
	 * Constructor por defecto de la clase MujerDTO.
	 */
	public MujerDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con atributos específicos de MujerDTO.
	 * 
	 * @param Divorciada Indica si está divorciada
	 * @param ingresosIdeal El ingreso ideal deseado en una pareja
	 */
	public MujerDTO(boolean Divorciada, float ingresosIdeal) {
		super();
		this.Divorciada = Divorciada;
		this.ingresosIdeal = ingresosIdeal;
	}

	/**
	 * Constructor completo de la clase MujerDTO.
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
	 * @param Divorciada Indica si está divorciada
	 * @param ingresosIdeal El ingreso ideal deseado en una pareja
	 * @param likesRecibidos El número de likes recibidos
	 * @param incognito Indica si está en modo incógnito
	 * @param likesDados Lista de alias a los que se les ha dado like
	 * @param verificado Indica si la cuenta está verificada
	 */
	public MujerDTO(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, int codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, boolean Divorciada, float ingresosIdeal, int likesRecibidos, boolean incognito, ArrayList<String> likesDados, boolean verificado) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito, likesDados, verificado);
		this.Divorciada = Divorciada;
		this.ingresosIdeal = ingresosIdeal;
	}

	/**
	 * Constructor de la clase MujerDTO sin atributos específicos.
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
	public MujerDTO(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, int codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, int likesRecibidos, boolean incognito, ArrayList<String> likesDados, boolean verificado) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito, likesDados, verificado);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Verifica si la mujer está divorciada.
	 * 
	 * @return true si está divorciada, false en caso contrario
	 */
	public boolean isDivorciada() {
		return Divorciada;
	}

	/**
	 * Establece el estado civil de divorcio de la mujer.
	 * 
	 * @param Divorciada El estado de divorcio a establecer
	 */
	public void setDivorciada(boolean Divorciada) {
		this.Divorciada = Divorciada;
	}

	/**
	 * Obtiene el ingreso ideal deseado en una pareja.
	 * 
	 * @return El ingreso ideal deseado
	 */
	public float getIngresosIdeal() {
		return ingresosIdeal;
	}

	/**
	 * Establece el ingreso ideal deseado en una pareja.
	 * 
	 * @param ingresosIdeal El ingreso ideal a establecer
	 */
	public void setIngresosIdeal(float ingresosIdeal) {
		this.ingresosIdeal = ingresosIdeal;
	}

	/**
	 * Convierte el objeto MujerDTO a una representación de texto.
	 * 
	 * @return Una cadena con los datos de la mujer separados por punto y coma
	 */
	@Override
	public String toString() {
		return super.toString() + ";" + Divorciada + ";" + ingresosIdeal;
	}

}