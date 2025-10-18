package co.edu.unbosque.model;

import javax.swing.ImageIcon;

public class Hombre extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// datos basicos
	private float ingresoProm;
	// gustos
	private boolean estadoDivorcio;

	public Hombre() {
		// TODO Auto-generated constructor stub
	}

	public Hombre(float ingresoProm, boolean estadoDivorcio) {
		super();
		this.ingresoProm = ingresoProm;
		this.estadoDivorcio = estadoDivorcio;
	}

	public Hombre(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, String codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, float ingresoProm, boolean estadoDivorcio, int likesRecibidos, boolean incognito) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito);
		this.ingresoProm = ingresoProm;
		this.estadoDivorcio = estadoDivorcio;
	}

	public Hombre(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, String codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, int likesRecibidos, boolean incognito) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito);
		// TODO Auto-generated constructor stub
	}

	public float getIngresoProm() {
		return ingresoProm;
	}

	public void setIngresoProm(float ingresoProm) {
		this.ingresoProm = ingresoProm;
	}

	public boolean isEstadoDivorcio() {
		return estadoDivorcio;
	}

	public void setEstadoDivorcio(boolean estadoDivorcio) {
		this.estadoDivorcio = estadoDivorcio;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + ingresoProm + ";" + estadoDivorcio;
	}

}
