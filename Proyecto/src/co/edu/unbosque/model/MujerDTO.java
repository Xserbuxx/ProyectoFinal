package co.edu.unbosque.model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class MujerDTO extends Persona {

	// datos basicos
	private boolean Divorciada;
	// gustos
	private float ingresosIdeal;

	public MujerDTO() {
		// TODO Auto-generated constructor stub
	}

	public MujerDTO(boolean Divorciada, float ingresosIdeal) {
		super();
		this.Divorciada = Divorciada;
		this.ingresosIdeal = ingresosIdeal;
	}

	public MujerDTO(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, int codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, boolean Divorciada, float ingresosIdeal, int likesRecibidos, boolean incognito, ArrayList<String> likesDados, boolean verificado) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito, likesDados, verificado);
		this.Divorciada = Divorciada;
		this.ingresosIdeal = ingresosIdeal;
	}

	public MujerDTO(String nombre, String alias, int edad, String fechaNacimiento, float estatura, String correo,
			ImageIcon imagen, boolean disponibilidad, String contrasena, int codigo, int edadMaxima, int edadMinima,
			float estaturaIdeal, int likesRecibidos, boolean incognito, ArrayList<String> likesDados, boolean verificado) {
		super(nombre, alias, edad, fechaNacimiento, estatura, correo, imagen, disponibilidad, contrasena, codigo,
				edadMaxima, edadMinima, estaturaIdeal, likesRecibidos, incognito, likesDados, verificado);
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
