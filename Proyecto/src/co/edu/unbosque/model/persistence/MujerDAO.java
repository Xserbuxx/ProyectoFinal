package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

public class MujerDAO implements DAO<MujerDTO, Mujer> {

	private String SERIAL_FILE_NAME = "mujeres.bin";
	private ArrayList<Mujer> mujeres;

	public MujerDAO() {
		cargarArchivoSerializado();
	}

	@Override
	public boolean crear(MujerDTO nuevoDato) {
		if (encontrar(DataMapper.MujerDTOAMujer(nuevoDato)) == null) {
			mujeres.add(DataMapper.MujerDTOAMujer(nuevoDato));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean borrar(MujerDTO datoAEliminar) {
		if (encontrar(DataMapper.MujerDTOAMujer(datoAEliminar)) != null) {
			mujeres.remove(DataMapper.MujerDTOAMujer(datoAEliminar));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}
	
	public void borrar(Mujer datoAEliminar) {
		mujeres.remove(datoAEliminar);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(MujerDTO datoAnterior, MujerDTO nuevoDato) {
		if (encontrar(DataMapper.MujerDTOAMujer(nuevoDato)) != null) {
			mujeres.remove(DataMapper.MujerDTOAMujer(nuevoDato));
			mujeres.add(DataMapper.MujerDTOAMujer(nuevoDato));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Mujer encontrar(Mujer datoAEncontrar) {
		if (mujeres.isEmpty()) {
			return null;
		}
		
		for (Mujer mujer : mujeres) {
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

		for (Mujer m : mujeres) {
			lista += m.toString() + "\n";
		}

		return lista;
	}

	@Override
	public void cargarArchivoSerializado() {
		Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			mujeres = (ArrayList<Mujer>) contenido;
		} else {
			mujeres = new ArrayList<>();
		}
	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, mujeres);
	}

	public ArrayList<Mujer> getMujeres() {
		return mujeres;
	}

	public void setMujeres(ArrayList<Mujer> mujeres) {
		mujeres = mujeres;
	}

}
