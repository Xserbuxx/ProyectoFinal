package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controlador {
	
	private ModelFacade mf;
	private ViewFacade vf;
	
	public Controlador() {
		mf = new ModelFacade();
		vf = new ViewFacade();
	}
	
	public void run() {
		
	}
	
}
