package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;

public class HombreDAO implements DAO<HombreDTO, Hombre> {

	private String SERIAL_FILE_NAME = "hombres.bin";
	private ArrayList<Hombre> hombres;

	public HombreDAO() {
		cargarArchivoSerializado();
	}

	@Override
	public boolean crear(HombreDTO nuevoDato) {
		if (encontrar(DataMapper.HombreDTOAHombre(nuevoDato)) == null) {
			hombres.add(DataMapper.HombreDTOAHombre(nuevoDato));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean borrar(HombreDTO datoAEliminar) {
		if (encontrar(DataMapper.HombreDTOAHombre(datoAEliminar)) != null) {
			hombres.remove(DataMapper.HombreDTOAHombre(datoAEliminar));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}
	
	public void borrar(Hombre datoAEliminar) {
		hombres.remove(datoAEliminar);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(HombreDTO datoAnterior, HombreDTO nuevoDato) {
		if (encontrar(DataMapper.HombreDTOAHombre(nuevoDato)) != null) {
			hombres.remove(DataMapper.HombreDTOAHombre(nuevoDato));
			hombres.add(DataMapper.HombreDTOAHombre(nuevoDato));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Hombre encontrar(Hombre datoAEncontrar) {
		if (hombres.isEmpty()) {
			return null;
		}

		for (Hombre hombre : hombres) {
			if (hombre.getAlias().equals(datoAEncontrar.getAlias())) {
				return hombre;
			} else {
				continue;
			}
		}

		return null;
	}

	@Override
	public String mostrar() {
		String lista = "";

		for (Hombre h : hombres) {
			lista += h.toString() + "\n";
		}

		return lista;
	}

	@Override
	public void cargarArchivoSerializado() {
		Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			hombres = (ArrayList<Hombre>) contenido;
		} else {
			hombres = new ArrayList<>();
		}
	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, hombres);
	}

	public ArrayList<Hombre> getHombres() {
		return hombres;
	}

	public void setHombres(ArrayList<Hombre> hombres) {
		this.hombres = hombres;
	}
}
