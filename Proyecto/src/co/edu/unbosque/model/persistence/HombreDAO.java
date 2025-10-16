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

		Hombre found = null;
		if (!hombres.isEmpty()) {
			for (Hombre Hombre : hombres) {
				if (Hombre.getAlias().equals(datoAEncontrar.getAlias())) {
					found = Hombre;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}

		return null;
	}

	private String lista;
	private int n;

	@Override
	public String mostrar() {
		lista = "";
		n = 0;

		hombres.forEach((hombre) -> {
			lista += hombre.toString() + "\n";
			n++;
		});

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
