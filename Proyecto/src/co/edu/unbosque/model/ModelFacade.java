package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

public class ModelFacade {

	private HombreDAO hombreDAO;
	private MujerDAO mujerDAO;
	
	private ArrayList<Persona> personas;

	public ModelFacade() {
		hombreDAO = new HombreDAO();
		mujerDAO = new MujerDAO();
		personas = new ArrayList<>();
	}
	
	public void actualizarPersonas() {
		personas.clear();
		personas = new ArrayList<>();
		personas.addAll(hombreDAO.getHombres());
		personas.addAll(mujerDAO.getMujeres());
		hombreDAO.escribirArchivoSerializado();
		mujerDAO.escribirArchivoSerializado();
	}
	
	public void eliminarPersona(Persona p) {
		if (p instanceof Hombre) {
			hombreDAO.borrar((Hombre) p);
			personas.remove(p);
		} else if (p instanceof Mujer) {
			mujerDAO.borrar((Mujer) p);
			personas.remove(p);
		}
	}

	public HombreDAO getHombreDAO() {
		return hombreDAO;
	}

	public void setHombreDAO(HombreDAO hombreDAO) {
		this.hombreDAO = hombreDAO;
	}

	public MujerDAO getMujerDAO() {
		return mujerDAO;
	}

	public void setMujerDAO(MujerDAO mujerDAO) {
		this.mujerDAO = mujerDAO;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
}
