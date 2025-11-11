package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Clase abstracta que representa una persona en el sistema de citas.
 * Contiene los datos básicos y preferencias de cada usuario.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public abstract class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	// datos basicos
	private String nombre;
	private String alias;
	private int edad;
	private String fechaNacimiento;
	private float estatura;
	private String correo;
	private ImageIcon imagen;
	private boolean disponibilidad;
	private String contrasena;
	private int codigo;
	private int likesRecibidos;
	private boolean incognito;
	private ArrayList<String> likesDados;
	private boolean verificado;
	// gustos
	private int edadMaxima;
	private int edadMinima;
	private float estaturaIdeal;

	/**
	 * Constructor por defecto de la clase Persona.
	 */
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor completo de la clase Persona.
	 * 
	 * @param nombre El nombre completo de la persona
	 * @param alias El nombre de usuario o alias
	 * @param edad La edad de la persona
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
	public Persona(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, int codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, int likesRecibidos, boolean incognito, ArrayList<String> likesDados, boolean verificado) {
		super();
		this.nombre = nombre;
		this.alias = alias;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.estatura = estatura;
		this.correo = correo;
		this.imagen = imagen;
		this.disponibilidad = disponibilidad;
		this.contrasena = contrasena;
		this.codigo = codigo;
		this.edadMaxima = edadMaxima;
		this.edadMinima = edadMinima;
		this.estaturaIdeal = estaturaIdeal;
		this.likesRecibidos = likesRecibidos;
		this.incognito = incognito;
		this.likesDados = likesDados;
		this.verificado = verificado;
	}

	/**
	 * Obtiene el nombre de la persona.
	 * 
	 * @return El nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la persona.
	 * 
	 * @param nombre El nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el alias de la persona.
	 * 
	 * @return El alias de la persona
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Establece el alias de la persona.
	 * 
	 * @param alias El alias a establecer
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Obtiene la edad de la persona.
	 * 
	 * @return La edad de la persona
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece la edad de la persona.
	 * 
	 * @param edad La edad a establecer
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene la fecha de nacimiento de la persona.
	 * 
	 * @return La fecha de nacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Establece la fecha de nacimiento de la persona.
	 * 
	 * @param fechaNacimiento La fecha de nacimiento a establecer
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Obtiene la estatura de la persona.
	 * 
	 * @return La estatura en centímetros
	 */
	public float getEstatura() {
		return estatura;
	}

	/**
	 * Establece la estatura de la persona.
	 * 
	 * @param estatura La estatura a establecer en centímetros
	 */
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	/**
	 * Obtiene el correo electrónico de la persona.
	 * 
	 * @return El correo electrónico
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Establece el correo electrónico de la persona.
	 * 
	 * @param correo El correo electrónico a establecer
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Obtiene la imagen de perfil de la persona.
	 * 
	 * @return La imagen de perfil
	 */
	public ImageIcon getImagen() {
		return imagen;
	}

	/**
	 * Establece la imagen de perfil de la persona.
	 * 
	 * @param imagen La imagen de perfil a establecer
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el estado de disponibilidad de la persona.
	 * 
	 * @return true si está disponible, false en caso contrario
	 */
	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	/**
	 * Establece el estado de disponibilidad de la persona.
	 * 
	 * @param disponibilidad El estado de disponibilidad a establecer
	 */
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	/**
	 * Obtiene la contraseña de la persona.
	 * 
	 * @return La contraseña
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Establece la contraseña de la persona.
	 * 
	 * @param contrasena La contraseña a establecer
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Obtiene el código de verificación de la persona.
	 * 
	 * @return El código de verificación
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Establece el código de verificación de la persona.
	 * 
	 * @param codigo El código de verificación a establecer
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene la edad máxima deseada en una pareja.
	 * 
	 * @return La edad máxima deseada
	 */
	public int getEdadMaxima() {
		return edadMaxima;
	}

	/**
	 * Establece la edad máxima deseada en una pareja.
	 * 
	 * @param edadMaxima La edad máxima a establecer
	 */
	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	/**
	 * Obtiene la edad mínima deseada en una pareja.
	 * 
	 * @return La edad mínima deseada
	 */
	public int getEdadMinima() {
		return edadMinima;
	}

	/**
	 * Establece la edad mínima deseada en una pareja.
	 * 
	 * @param edadMinima La edad mínima a establecer
	 */
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	/**
	 * Obtiene la estatura ideal deseada en una pareja.
	 * 
	 * @return La estatura ideal en centímetros
	 */
	public float getEstaturaIdeal() {
		return estaturaIdeal;
	}

	/**
	 * Establece la estatura ideal deseada en una pareja.
	 * 
	 * @param estaturaIdeal La estatura ideal a establecer en centímetros
	 */
	public void setEstaturaIdeal(float estaturaIdeal) {
		this.estaturaIdeal = estaturaIdeal;
	}

	/**
	 * Obtiene el número de likes recibidos.
	 * 
	 * @return El número de likes recibidos
	 */
	public int getLikesRecibidos() {
		return likesRecibidos;
	}

	/**
	 * Establece el número de likes recibidos.
	 * 
	 * @param likesRecibidos El número de likes a establecer
	 */
	public void setLikesRecibidos(int likesRecibidos) {
		this.likesRecibidos = likesRecibidos;
	}

	/**
	 * Verifica si la persona está en modo incógnito.
	 * 
	 * @return true si está en modo incógnito, false en caso contrario
	 */
	public boolean isIncognito() {
		return incognito;
	}

	/**
	 * Establece el modo incógnito de la persona.
	 * 
	 * @param incognito El estado del modo incógnito a establecer
	 */
	public void setIncognito(boolean incognito) {
		this.incognito = incognito;
	}
	
	/**
	 * Obtiene la lista de alias a los que se les ha dado like.
	 * 
	 * @return La lista de alias con likes dados
	 */
	public ArrayList<String> getLikesDados() {
		return likesDados;
	}

	/**
	 * Establece la lista de alias a los que se les ha dado like.
	 * 
	 * @param likesDados La lista de alias a establecer
	 */
	public void setLikesDados(ArrayList<String> likesDados) {
		this.likesDados = likesDados;
	}
	
	/**
	 * Verifica si la cuenta está verificada.
	 * 
	 * @return true si la cuenta está verificada, false en caso contrario
	 */
	public boolean isVerificado() {
		return verificado;
	}

	/**
	 * Establece el estado de verificación de la cuenta.
	 * 
	 * @param verificado El estado de verificación a establecer
	 */
	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}

	/**
	 * Convierte el objeto Persona a una representación de texto.
	 * 
	 * @return Una cadena con los datos de la persona separados por punto y coma
	 */
	@Override
	public String toString() {
		return nombre + ";" + alias + ";" + edad + ";" + fechaNacimiento + ";" + estatura + ";" + correo + ";" + imagen
				+ ";" + disponibilidad + ";" + contrasena + ";" + codigo + ";" + edadMaxima + ";" + edadMinima + ";"
				+ estaturaIdeal + ";" + likesRecibidos + ";" + incognito + ";" + likesDados.toString() + ";" + verificado;
	}

}