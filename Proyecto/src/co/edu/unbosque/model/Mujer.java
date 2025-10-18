package co.edu.unbosque.model;

import javax.swing.ImageIcon;

public class Mujer extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// datos basicos
	private boolean Divorciada;
	// gustos
	private float ingresosIdeal;

	public Mujer() {
		// TODO Auto-generated constructor stub
	}

	public Mujer(boolean Divorciada, float ingresosIdeal) {
		super();
		this.Divorciada = Divorciada;
		this.ingresosIdeal = ingresosIdeal;
	}

	public Mujer(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, String codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, boolean Divorciada, float ingresosIdeal, int likesRecibidos, boolean incognito) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito);
		this.Divorciada = Divorciada;
		this.ingresosIdeal = ingresosIdeal;
	}

	public Mujer(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, String codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, int likesRecibidos, boolean incognito) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito);
		// TODO Auto-generated constructor stub
	}

	public boolean isDivorciada() {
		return Divorciada;
	}

	public void setDivorciada(boolean Divorciada) {
		this.Divorciada = Divorciada;
	}

	public float getIngresosIdeal() {
		return ingresosIdeal;
	}

	public void setIngresosIdeal(float ingresosIdeal) {
		this.ingresosIdeal = ingresosIdeal;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + Divorciada + ";" + ingresosIdeal;
	}

}
