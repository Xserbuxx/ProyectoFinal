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
		hombreDAO.getHombres().forEach(h -> personas.add(h));
		mujerDAO.getMujeres().forEach(m -> personas.add(m));
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
