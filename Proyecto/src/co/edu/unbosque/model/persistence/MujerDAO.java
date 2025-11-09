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
	
	public void ordenarPor(int tipo, int criterio) {

		if (mujeres.isEmpty()) {
			return;
		}

		ArrayList<Mujer> copia = new ArrayList<>();
		for (Mujer p : mujeres) {
			copia.add(p);
		}

		switch (tipo) {
		case 1 -> ordenarQuickSortAscendente(copia, criterio);
		case 2 -> ordenarQuickSortDescendente(copia, criterio);
		case 3 -> ordenarInsercionAscendente(copia, criterio);
		case 4 -> ordenarInsercionDesendente(copia, criterio);
		}
		
		mujeres = copia;
	}

	public int comparar(Mujer a, Mujer b, int criterio) {
		if (criterio == 1)
			return a.getNombre().compareToIgnoreCase(b.getNombre());
		if (criterio == 2)
			return a.getAlias().compareToIgnoreCase(b.getAlias());
		if (criterio == 3)
			return a.getLikesRecibidos() - b.getLikesRecibidos();
		if (criterio == 4)
			return a.getEdad() - b.getEdad();
		return 0;
	}

	public void ordenarQuickSortAscendente(ArrayList<Mujer> lista, int criterio) {
		int izquierda = 0;
		int derecha = lista.size() - 1;
		boolean repetir = true;

		while (repetir) {
			int i = izquierda;
			int j = derecha;
			Mujer pun = lista.get((izquierda + derecha) / 2);

			while (i <= j) {
				while (comparar(lista.get(i), pun, criterio) < 0)
					i++;
				while (comparar(lista.get(j), pun, criterio) > 0)
					j--;
				if (i <= j) {
					Mujer temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
					i++;
					j--;
				}
			}

			if (izquierda < j)
				derecha = j;
			else if (i < derecha)
				izquierda = i;
			else
				repetir = false;
		}
	}

	public void ordenarQuickSortDescendente(ArrayList<Mujer> lista, int criterio) {
		int izquierda = 0;
		int derecha = lista.size() - 1;
		boolean repetir = true;

		while (repetir) {
			int i = izquierda;
			int j = derecha;
			Mujer pun = lista.get((izquierda + derecha) / 2);

			while (i <= j) {
				while (comparar(lista.get(i), pun, criterio) > 0)
					i++; // Cambio: > en lugar de <
				while (comparar(lista.get(j), pun, criterio) < 0)
					j--; // Cambio: < en lugar de >
				if (i <= j) {
					Mujer temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
					i++;
					j--;
				}
			}

			if (izquierda < j)
				derecha = j;
			else if (i < derecha)
				izquierda = i;
			else
				repetir = false;
		}
	}

	public void ordenarInsercionAscendente(ArrayList<Mujer> lista, int criterio) {
		for (int i = 1; i < lista.size(); i++) {
			Mujer actual = lista.get(i);
			int pos = i - 1;
			while (pos >= 0 && comparar(lista.get(pos), actual, criterio) > 0) {
				lista.set(pos + 1, lista.get(pos));
				pos--;
			}
			lista.set(pos + 1, actual);
		}
	}

	public void ordenarInsercionDesendente(ArrayList<Mujer> lista, int criterio) {
		for (int i = 1; i < lista.size(); i++) {
			Mujer actual = lista.get(i);
			int pos = i - 1;
			while (pos >= 0 && comparar(lista.get(pos), actual, criterio) < 0) { // Cambio: < en lugar de >
				lista.set(pos + 1, lista.get(pos));
				pos--;
			}
			lista.set(pos + 1, actual);
		}
	}

	public ArrayList<Mujer> getMujeres() {
		return mujeres;
	}

	public void setMujeres(ArrayList<Mujer> mujeres) {
		this.mujeres = mujeres;
	}

}
