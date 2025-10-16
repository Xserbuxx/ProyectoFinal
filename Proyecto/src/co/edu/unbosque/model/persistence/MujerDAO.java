package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

public class MujerDAO implements DAO<MujerDTO,Mujer>{
	
	String SERIAL_FILE_NAME = "Mujeres.bin";
	ArrayList<Mujer> Mujeres;

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

		Mujer found = null;
		if (!Mujeres.isEmpty()) {
			for (Mujer Mujer : Mujeres) {
				if (Mujer.getAlias().equals(datoAEncontrar.getAlias())) {
					found = Mujer;
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
	
	String lista;
	int n;
	
	@Override
	public String mostrar() {
		lista = "";
		n = 0;

		Mujeres.forEach((Mujer) -> {
			lista +=  Mujer.toString() + "\n";
			n++;
		});

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

	
}
