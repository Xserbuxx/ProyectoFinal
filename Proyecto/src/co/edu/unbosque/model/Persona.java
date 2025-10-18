package co.edu.unbosque.model;

import java.io.Serializable;

import javax.swing.ImageIcon;

public abstract class Persona implements Serializable {

	/**
	 * 
	 */
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
	private String codigo;
	private int likesRecibidos;
	private boolean incognito;
	// gustos
	private int edadMaxima;
	private int edadMinima;
	private float estaturaIdeal;

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, String codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, int likesRecibidos, boolean incognito) {
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
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public float getEstaturaIdeal() {
		return estaturaIdeal;
	}

	public void setEstaturaIdeal(float estaturaIdeal) {
		this.estaturaIdeal = estaturaIdeal;
	}
	public int getLikesRecibidos() {
		return likesRecibidos;
	}
	public void setLikesRecibidos(int likesRecibidos) {
		this.likesRecibidos = likesRecibidos;
	}
	public boolean isIncognito() {
		return incognito;
	}
	public void setIncognito(boolean incognito) {
		this.incognito = incognito;
	}

	@Override
	public String toString() {
		return nombre + ";" + alias + ";" + edad + ";" + fechaNacimiento + ";" + estatura + ";" + correo + ";" + imagen
				+ ";" + disponibilidad + ";" + contrasena + ";" + codigo + ";" + edadMaxima + ";" + edadMinima + ";"
				+ estaturaIdeal + ";" + likesRecibidos + ";" + incognito;
	}

}
