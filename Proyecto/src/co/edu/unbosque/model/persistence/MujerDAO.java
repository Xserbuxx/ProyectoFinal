package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

/**
 * Clase DAO (Data Access Object) para gestionar la persistencia de objetos Mujer.
 * Implementa la interfaz DAO y proporciona operaciones CRUD y de ordenamiento.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class MujerDAO implements DAO<MujerDTO, Mujer> {

	private String SERIAL_FILE_NAME = "mujeres.bin";
	private ArrayList<Mujer> mujeres;

	/**
	 * Constructor de la clase MujerDAO.
	 * Carga automáticamente los datos desde el archivo serializado.
	 */
	public MujerDAO() {
		cargarArchivoSerializado();
	}

	/**
	 * Crea un nuevo registro de mujer a partir de un DTO.
	 * 
	 * @param nuevoDato El DTO con los datos de la nueva mujer
	 * @return true si se creó exitosamente, false si ya existe
	 */
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
	
	/**
	 * Crea un nuevo registro de mujer directamente desde una entidad.
	 * 
	 * @param nuevoDato La entidad Mujer a crear
	 * @return true si se creó exitosamente, false si ya existe
	 */
	public boolean crear(Mujer nuevoDato) {
		if (encontrar(nuevoDato) == null) {
			mujeres.add(nuevoDato);
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Elimina un registro de mujer a partir de un DTO.
	 * 
	 * @param datoAEliminar El DTO de la mujer a eliminar
	 * @return true si se eliminó exitosamente, false si no existe
	 */
	@Override
	public boolean borrar(MujerDTO datoAEliminar) {
		if (encontrar(DataMapper.MujerDTOAMujer(datoAEliminar)) != null) {
			mujeres.remove(encontrar(DataMapper.MujerDTOAMujer(datoAEliminar)));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Elimina un registro de mujer directamente desde una entidad.
	 * 
	 * @param datoAEliminar La entidad Mujer a eliminar
	 */
	public void borrar(Mujer datoAEliminar) {
		mujeres.remove(datoAEliminar);
		escribirArchivoSerializado();
	}

	/**
	 * Actualiza un registro de mujer existente con nuevos datos.
	 * 
	 * @param datoAnterior El DTO con los datos anteriores
	 * @param nuevoDato El DTO con los nuevos datos
	 * @return true si se actualizó exitosamente, false si no existe
	 */
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

	/**
	 * Busca y retorna una mujer específica por su alias.
	 * 
	 * @param datoAEncontrar La mujer a buscar
	 * @return La mujer encontrada, o null si no existe
	 */
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

	/**
	 * Retorna una representación en texto de todas las mujeres.
	 * 
	 * @return Una cadena con todas las mujeres
	 */
	@Override
	public String mostrar() {
		String lista = "";

		for (Mujer m : mujeres) {
			lista += m.toString() + "\n";
		}

		return lista;
	}

	/**
	 * Carga los datos de mujeres desde el archivo serializado.
	 */
	@Override
	public void cargarArchivoSerializado() {
		Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			mujeres = (ArrayList<Mujer>) contenido;
		} else {
			mujeres = new ArrayList<>();
		}
	}

	/**
	 * Escribe los datos actuales de mujeres en el archivo serializado.
	 */
	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, mujeres);
	}
	
	/**
	 * Ordena la lista de mujeres según el tipo y criterio especificados.
	 * 
	 * @param tipo El tipo de ordenamiento (1: QuickSort ascendente, 2: QuickSort descendente, 3: Inserción ascendente, 4: Inserción descendente)
	 * @param criterio El criterio de comparación (1: nombre, 2: alias, 3: likes, 4: edad)
	 */
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

	/**
	 * Compara dos mujeres según el criterio especificado.
	 * 
	 * @param a La primera mujer a comparar
	 * @param b La segunda mujer a comparar
	 * @param criterio El criterio de comparación
	 * @return Un valor negativo si a < b, cero si son iguales, positivo si a > b
	 */
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

	/**
	 * Ordena una lista de mujeres en orden ascendente usando el algoritmo QuickSort.
	 * 
	 * @param lista La lista de mujeres a ordenar
	 * @param criterio El criterio de comparación
	 */
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

	/**
	 * Ordena una lista de mujeres en orden descendente usando el algoritmo QuickSort.
	 * 
	 * @param lista La lista de mujeres a ordenar
	 * @param criterio El criterio de comparación
	 */
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

	/**
	 * Ordena una lista de mujeres en orden ascendente usando el algoritmo de inserción.
	 * 
	 * @param lista La lista de mujeres a ordenar
	 * @param criterio El criterio de comparación
	 */
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

	/**
	 * Ordena una lista de mujeres en orden descendente usando el algoritmo de inserción.
	 * 
	 * @param lista La lista de mujeres a ordenar
	 * @param criterio El criterio de comparación
	 */
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

	/**
	 * Obtiene la lista de todas las mujeres.
	 * 
	 * @return La lista de mujeres
	 */
	public ArrayList<Mujer> getMujeres() {
		return mujeres;
	}

	/**
	 * Establece la lista de mujeres.
	 * 
	 * @param mujeres La lista de mujeres a establecer
	 */
	public void setMujeres(ArrayList<Mujer> mujeres) {
		this.mujeres = mujeres;
	}

}