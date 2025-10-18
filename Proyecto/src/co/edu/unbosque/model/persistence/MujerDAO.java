package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

public class MujerDAO implements DAO<MujerDTO, Mujer> {

	private String SERIAL_FILE_NAME = "Mujeres.bin";
	private ArrayList<Mujer> Mujeres;

	public MujerDAO() {
		cargarArchivoSerializado();
	}

	@Override
	public boolean crear(MujerDTO nuevoDato) {
		if (encontrar(DataMapper.MujerDTOAMujer(nuevoDato)) == null) {
			Mujeres.add(DataMapper.MujerDTOAMujer(nuevoDato));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean borrar(MujerDTO datoAEliminar) {
		if (encontrar(DataMapper.MujerDTOAMujer(datoAEliminar)) != null) {
			Mujeres.remove(DataMapper.MujerDTOAMujer(datoAEliminar));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean actualizar(MujerDTO datoAnterior, MujerDTO nuevoDato) {
		if (encontrar(DataMapper.MujerDTOAMujer(nuevoDato)) != null) {
			Mujeres.remove(DataMapper.MujerDTOAMujer(nuevoDato));
			Mujeres.add(DataMapper.MujerDTOAMujer(nuevoDato));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Mujer encontrar(Mujer datoAEncontrar) {
		if (Mujeres.isEmpty()) {
			return null;
		}
		
		for (Mujer mujer : Mujeres) {
			if (mujer.getAlias().equals(datoAEncontrar.getAlias())) {
				return mujer;
			} else {
				continue;
			}
		}

		return null;
	}

	@Override
	public String mostrar() {
		String lista = "";

		for (Mujer m : Mujeres) {
			lista += m.toString() + "\n";
		}

		return lista;
	}

	@Override
	public void cargarArchivoSerializado() {
		Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			Mujeres = (ArrayList<Mujer>) contenido;
		} else {
			Mujeres = new ArrayList<>();
		}
	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, Mujeres);
	}

	public ArrayList<Mujer> getMujeres() {
		return Mujeres;
	}

	public void setMujeres(ArrayList<Mujer> mujeres) {
		Mujeres = mujeres;
	}

}
