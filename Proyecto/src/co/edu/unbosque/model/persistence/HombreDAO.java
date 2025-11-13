package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;

/**
 * Clase DAO (Data Access Object) para gestionar la persistencia de objetos Hombre.
 * Implementa la interfaz DAO y proporciona operaciones CRUD y de ordenamiento.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class HombreDAO implements DAO<HombreDTO, Hombre> {

	/** Nombre del archivo serializado para almacenar los hombres */
	private String SERIAL_FILE_NAME = "hombres.bin";
	
	/** Lista de todos los hombres en el sistema */
	private ArrayList<Hombre> hombres;

	/**
	 * Constructor de la clase HombreDAO.
	 * Carga automáticamente los datos desde el archivo serializado.
	 */
	public HombreDAO() {
		cargarArchivoSerializado();
	}

	/**
	 * Crea un nuevo registro de hombre a partir de un DTO.
	 * 
	 * @param nuevoDato El DTO con los datos del nuevo hombre
	 * @return true si se creó exitosamente, false si ya existe
	 */
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
	
	/**
	 * Crea un nuevo registro de hombre directamente desde una entidad.
	 * 
	 * @param nuevoDato La entidad Hombre a crear
	 * @return true si se creó exitosamente, false si ya existe
	 */
	public boolean crear(Hombre nuevoDato) {
		if (encontrar(nuevoDato) == null) {
			hombres.add(nuevoDato);
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Elimina un registro de hombre a partir de un DTO.
	 * 
	 * @param datoAEliminar El DTO del hombre a eliminar
	 * @return true si se eliminó exitosamente, false si no existe
	 */
	@Override
	public boolean borrar(HombreDTO datoAEliminar) {
		if (encontrar(DataMapper.HombreDTOAHombre(datoAEliminar)) != null) {
			hombres.remove(encontrar(DataMapper.HombreDTOAHombre(datoAEliminar)));
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina un registro de hombre directamente desde una entidad.
	 * 
	 * @param datoAEliminar La entidad Hombre a eliminar
	 */
	public void borrar(Hombre datoAEliminar) {
		hombres.remove(datoAEliminar);
		escribirArchivoSerializado();
	}

	/**
	 * Actualiza un registro de hombre existente con nuevos datos.
	 * 
	 * @param datoAnterior El DTO con los datos anteriores
	 * @param nuevoDato El DTO con los nuevos datos
	 * @return true si se actualizó exitosamente, false si no existe
	 */
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
	
	/**
	 * Actualiza un registro de hombre existente con nuevos datos de entidad.
	 * 
	 * @param datoAnterior La entidad con los datos anteriores
	 * @param nuevoDato La entidad con los nuevos datos
	 * @return true si se actualizó exitosamente, false si no existe
	 */
	public boolean actualizar(Hombre datoAnterior, Hombre nuevoDato) {
		if (encontrar(nuevoDato) != null) {
			hombres.remove(nuevoDato);
			hombres.add(nuevoDato);
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Busca y retorna un hombre específico por su alias.
	 * 
	 * @param datoAEncontrar El hombre a buscar
	 * @return El hombre encontrado, o null si no existe
	 */
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

	/**
	 * Retorna una representación en texto de todos los hombres.
	 * 
	 * @return Una cadena con todos los hombres
	 */
	@Override
	public String mostrar() {
		String lista = "";

		for (Hombre h : hombres) {
			lista += h.toString() + "\n";
		}

		return lista;
	}

	/**
	 * Carga los datos de hombres desde el archivo serializado.
	 */
	@Override
	public void cargarArchivoSerializado() {
		Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			hombres = (ArrayList<Hombre>) contenido;
		} else {
			hombres = new ArrayList<>();
		}
	}

	/**
	 * Escribe los datos actuales de hombres en el archivo serializado.
	 */
	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, hombres);
	}

	/**
	 * Ordena la lista de hombres según el tipo y criterio especificados.
	 * 
	 * @param tipo El tipo de ordenamiento (1: QuickSort ascendente, 2: QuickSort descendente, 3: Inserción ascendente, 4: Inserción descendente)
	 * @param criterio El criterio de comparación (1: nombre, 2: alias, 3: likes, 4: edad, 5: ingresos)
	 */
	public void ordenarPor(int tipo, int criterio) {
	    if (hombres.isEmpty()) {
	        return;
	    }

	    ArrayList<Hombre> copia = new ArrayList<>();
	    for (Hombre p : hombres) {
	        copia.add(p);
	    }

	    switch (tipo) {
	        case 1 -> ordenarQuickSortAscendente(copia, 0, copia.size() - 1, criterio);
	        case 2 -> ordenarQuickSortDescendente(copia, 0, copia.size() - 1, criterio);
	        case 3 -> ordenarInsercionAscendente(copia, criterio);
	        case 4 -> ordenarInsercionDescendente(copia, criterio);
	    }
	    
	    hombres = copia;
	}

	/**
	 * Compara dos hombres según el criterio especificado.
	 * 
	 * @param a El primer hombre a comparar
	 * @param b El segundo hombre a comparar
	 * @param criterio El criterio de comparación
	 * @return Un valor negativo si a < b, cero si son iguales, positivo si a > b
	 */
	public int comparar(Hombre a, Hombre b, int criterio) {
	    if (criterio == 1)
	        return a.getNombre().compareToIgnoreCase(b.getNombre());
	    if (criterio == 2)
	        return a.getAlias().compareToIgnoreCase(b.getAlias());
	    if (criterio == 3)
	        return Integer.compare(a.getLikesRecibidos(), b.getLikesRecibidos());
	    if (criterio == 4)
	        return Integer.compare(a.getEdad(), b.getEdad());
	    if (criterio == 5)
	        return Float.compare(a.getIngresoProm(), b.getIngresoProm());
	    return 0;
	}

	/**
	 * Ordena una lista de hombres en orden ascendente usando el algoritmo QuickSort.
	 * 
	 * @param lista La lista de hombres a ordenar
	 * @param izquierda El índice inicial del rango a ordenar
	 * @param derecha El índice final del rango a ordenar
	 * @param criterio El criterio de comparación
	 */
	public void ordenarQuickSortAscendente(ArrayList<Hombre> lista, int izquierda, int derecha, int criterio) {
	    if (izquierda >= derecha) {
	        return;
	    }
	    
	    int i = izquierda;
	    int j = derecha;
	    Hombre pivote = lista.get((izquierda + derecha) / 2);

	    while (i <= j) {
	        while (comparar(lista.get(i), pivote, criterio) < 0) {
	            i++;
	        }
	        while (comparar(lista.get(j), pivote, criterio) > 0) {
	            j--;
	        }
	        if (i <= j) {
	            Hombre temp = lista.get(i);
	            lista.set(i, lista.get(j));
	            lista.set(j, temp);
	            i++;
	            j--;
	        }
	    }

	    // RECURSIÓN - esto es lo que faltaba
	    if (izquierda < j) {
	        ordenarQuickSortAscendente(lista, izquierda, j, criterio);
	    }
	    if (i < derecha) {
	        ordenarQuickSortAscendente(lista, i, derecha, criterio);
	    }
	}

	/**
	 * Ordena una lista de hombres en orden descendente usando el algoritmo QuickSort.
	 * 
	 * @param lista La lista de hombres a ordenar
	 * @param izquierda El índice inicial del rango a ordenar
	 * @param derecha El índice final del rango a ordenar
	 * @param criterio El criterio de comparación
	 */
	public void ordenarQuickSortDescendente(ArrayList<Hombre> lista, int izquierda, int derecha, int criterio) {
	    if (izquierda >= derecha) {
	        return;
	    }
	    
	    int i = izquierda;
	    int j = derecha;
	    Hombre pivote = lista.get((izquierda + derecha) / 2);

	    while (i <= j) {
	        while (comparar(lista.get(i), pivote, criterio) > 0) {
	            i++;
	        }
	        while (comparar(lista.get(j), pivote, criterio) < 0) {
	            j--;
	        }
	        if (i <= j) {
	            Hombre temp = lista.get(i);
	            lista.set(i, lista.get(j));
	            lista.set(j, temp);
	            i++;
	            j--;
	        }
	    }

	    // RECURSIÓN - esto es lo que faltaba
	    if (izquierda < j) {
	        ordenarQuickSortDescendente(lista, izquierda, j, criterio);
	    }
	    if (i < derecha) {
	        ordenarQuickSortDescendente(lista, i, derecha, criterio);
	    }
	}

	/**
	 * Ordena una lista de hombres en orden ascendente usando el algoritmo de inserción.
	 * 
	 * @param lista La lista de hombres a ordenar
	 * @param criterio El criterio de comparación
	 */
	public void ordenarInsercionAscendente(ArrayList<Hombre> lista, int criterio) {
	    for (int i = 1; i < lista.size(); i++) {
	        Hombre actual = lista.get(i);
	        int pos = i - 1;
	        while (pos >= 0 && comparar(lista.get(pos), actual, criterio) > 0) {
	            lista.set(pos + 1, lista.get(pos));
	            pos--;
	        }
	        lista.set(pos + 1, actual);
	    }
	}

	/**
	 * Ordena una lista de hombres en orden descendente usando el algoritmo de inserción.
	 * 
	 * @param lista La lista de hombres a ordenar
	 * @param criterio El criterio de comparación
	 */
	public void ordenarInsercionDescendente(ArrayList<Hombre> lista, int criterio) {
	    for (int i = 1; i < lista.size(); i++) {
	        Hombre actual = lista.get(i);
	        int pos = i - 1;
	        while (pos >= 0 && comparar(lista.get(pos), actual, criterio) < 0) {
	            lista.set(pos + 1, lista.get(pos));
	            pos--;
	        }
	        lista.set(pos + 1, actual);
	    }
	}

	/**
	 * Obtiene la lista de todos los hombres.
	 * 
	 * @return La lista de hombres
	 */
	public ArrayList<Hombre> getHombres() {
		return hombres;
	}

	/**
	 * Establece la lista de hombres.
	 * 
	 * @param hombres La lista de hombres a establecer
	 */
	public void setHombres(ArrayList<Hombre> hombres) {
		this.hombres = hombres;
	}

}