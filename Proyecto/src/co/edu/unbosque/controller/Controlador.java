package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controlador implements ActionListener{
	
	private ModelFacade mf;
	private ViewFacade vf;
	private Properties prop;
	
	public Controlador() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		prop = new Properties();
	}
	
	public void run() {
		agregarOyentes();
	}
	
	private void agregarOyentes() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "":
			
			break;

		default:
			break;
		}
		
	}
	
}
