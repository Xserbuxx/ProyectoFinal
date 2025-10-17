package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.view.ViewFacade;

public class Controlador implements ActionListener {

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

		prop = FileHandler.cargarArchivoDePropiedades("es.properties");

		agregarIdioma();
		vf.getVentanaPrincipal().actualizar();
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

	private void agregarIdioma() {
		vf.getIs().mostrarTextos(prop.getProperty("ventana.iniciarSesion.titulo"),
				prop.getProperty("ventana.iniciarSesion.usuario"), prop.getProperty("ventana.iniciarSesion.contrasena"),
				prop.getProperty("ventana.iniciarSesion.botonConfirmar"),
				prop.getProperty("ventana.iniciarSesion.botonRegistrarse"),
				prop.getProperty("ventana.iniciarSesion.sinCuenta"));
		vf.getReg().mostrarTextos(prop.getProperty("ventana.registro.titulo"),
				prop.getProperty("ventana.registro.nombre"), prop.getProperty("ventana.registro.usuario"),
				prop.getProperty("ventana.registro.edad"), prop.getProperty("ventana.registro.fechaNacimiento"),
				prop.getProperty("ventana.registro.estatura"), prop.getProperty("ventana.registro.correo"),
				prop.getProperty("ventana.registro.imagen"), prop.getProperty("ventana.registro.disponibilidad"),
				prop.getProperty("ventana.registro.disponible"), prop.getProperty("ventana.registro.noDisponible"),
				prop.getProperty("ventana.registro.contrasena"), prop.getProperty("ventana.registro.botonConfirmar"),
				prop.getProperty("ventana.registro.botonIniciarSesion"), prop.getProperty("ventana.registro.yaCuenta"),
				prop.getProperty("ventana.registro.sexo"));
	}
}
