package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

/**
 * Clase fachada del modelo que centraliza el acceso a los DAOs y operaciones de ordenamiento.
 * Implementa el patrón Facade para simplificar la interacción con el modelo de datos.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class ModelFacade {

	/** DAO para gestionar usuarios hombres */
	private HombreDAO hombreDAO;
	
	/** DAO para gestionar usuarios mujeres */
	private MujerDAO mujerDAO;
	
	/** Lista combinada de todas las personas del sistema */
	private ArrayList<Persona> personas;

	/**
	 * Constructor de la clase ModelFacade.
	 * Inicializa los DAOs y la lista de personas.
	 */
	public ModelFacade() {
		hombreDAO = new HombreDAO();
		mujerDAO = new MujerDAO();
		personas = new ArrayList<>();
	}
	
	/**
	 * Actualiza la lista de personas combinando hombres y mujeres de los DAOs.
	 * También guarda los datos en archivos serializados.
	 */
	public void actualizarPersonas() {
		personas.clear();
		personas = new ArrayList<>();
		personas.addAll(hombreDAO.getHombres());
		personas.addAll(mujerDAO.getMujeres());
		hombreDAO.escribirArchivoSerializado();
		mujerDAO.escribirArchivoSerializado();
	}
	
	/**
	 * Elimina una persona del sistema según su tipo (Hombre o Mujer).
	 * 
	 * @param p La persona a eliminar
	 */
	public void eliminarPersona(Persona p) {
		if (p instanceof Hombre) {
			hombreDAO.borrar((Hombre) p);
			personas.remove(p);
		} else if (p instanceof Mujer) {
			mujerDAO.borrar((Mujer) p);
			personas.remove(p);
		}
	}
	
	/**
	 * Ordena la lista de personas según el tipo de ordenamiento y criterio especificados.
	 * 
	 * @param tipo El tipo de ordenamiento (1: QuickSort ascendente, 2: QuickSort descendente, 3: Inserción ascendente, 4: Inserción descendente)
	 * @param criterio El criterio de comparación (1: nombre, 2: alias, 3: likes, 4: edad)
	 */
	public void ordenarPor(int tipo, int criterio) {
	    if (personas.isEmpty()) {
	        return;
	    }

	    ArrayList<Persona> copia = new ArrayList<>();
	    for (Persona p : personas) {
	        copia.add(p);
	    }

	    switch (tipo) {
	        case 1 -> ordenarQuickSortAscendente(copia, 0, copia.size() - 1, criterio);
	        case 2 -> ordenarQuickSortDescendente(copia, 0, copia.size() - 1, criterio);
	        case 3 -> ordenarInsercionAscendente(copia, criterio);
	        case 4 -> ordenarInsercionDescendente(copia, criterio);
	    }
	    
	    personas = copia;
	}

	/**
	 * Compara dos personas según el criterio especificado.
	 * 
	 * @param a La primera persona a comparar
	 * @param b La segunda persona a comparar
	 * @param criterio El criterio de comparación (1: nombre, 2: alias, 3: likes, 4: edad)
	 * @return Un valor negativo si a < b, cero si son iguales, positivo si a > b
	 */
	public int comparar(Persona a, Persona b, int criterio) {
	    if (criterio == 1)
	        return a.getNombre().compareToIgnoreCase(b.getNombre());
	    if (criterio == 2)
	        return a.getAlias().compareToIgnoreCase(b.getAlias());
	    if (criterio == 3)
	        return Integer.compare(a.getLikesRecibidos(), b.getLikesRecibidos());
	    if (criterio == 4)
	        return Integer.compare(a.getEdad(), b.getEdad());
	    return 0;
	}

	/**
	 * Ordena una lista de personas en orden ascendente usando el algoritmo QuickSort.
	 * 
	 * @param lista La lista de personas a ordenar
	 * @param izquierda El índice inicial del rango a ordenar
	 * @param derecha El índice final del rango a ordenar
	 * @param criterio El criterio de comparación
	 */
	public void ordenarQuickSortAscendente(ArrayList<Persona> lista, int izquierda, int derecha, int criterio) {
	    if (izquierda >= derecha) {
	        return;
	    }
	    
	    int i = izquierda;
	    int j = derecha;
	    Persona pivote = lista.get((izquierda + derecha) / 2);

	    while (i <= j) {
	        while (comparar(lista.get(i), pivote, criterio) < 0) {
	            i++;
	        }
	        while (comparar(lista.get(j), pivote, criterio) > 0) {
	            j--;
	        }
	        if (i <= j) {
	            Persona temp = lista.get(i);
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
	 * Ordena una lista de personas en orden descendente usando el algoritmo QuickSort.
	 * 
	 * @param lista La lista de personas a ordenar
	 * @param izquierda El índice inicial del rango a ordenar
	 * @param derecha El índice final del rango a ordenar
	 * @param criterio El criterio de comparación
	 */
	public void ordenarQuickSortDescendente(ArrayList<Persona> lista, int izquierda, int derecha, int criterio) {
	    if (izquierda >= derecha) {
	        return;
	    }
	    
	    int i = izquierda;
	    int j = derecha;
	    Persona pivote = lista.get((izquierda + derecha) / 2);

	    while (i <= j) {
	        while (comparar(lista.get(i), pivote, criterio) > 0) {
	            i++;
	        }
	        while (comparar(lista.get(j), pivote, criterio) < 0) {
	            j--;
	        }
	        if (i <= j) {
	            Persona temp = lista.get(i);
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
	 * Ordena una lista de personas en orden ascendente usando el algoritmo de inserción.
	 * 
	 * @param lista La lista de personas a ordenar
	 * @param criterio El criterio de comparación
	 */
	public void ordenarInsercionAscendente(ArrayList<Persona> lista, int criterio) {
	    for (int i = 1; i < lista.size(); i++) {
	        Persona actual = lista.get(i);
	        int pos = i - 1;
	        while (pos >= 0 && comparar(lista.get(pos), actual, criterio) > 0) {
	            lista.set(pos + 1, lista.get(pos));
	            pos--;
	        }
	        lista.set(pos + 1, actual);
	    }
	}

	/**
	 * Ordena una lista de personas en orden descendente usando el algoritmo de inserción.
	 * 
	 * @param lista La lista de personas a ordenar
	 * @param criterio El criterio de comparación
	 */
	public void ordenarInsercionDescendente(ArrayList<Persona> lista, int criterio) {
	    for (int i = 1; i < lista.size(); i++) {
	        Persona actual = lista.get(i);
	        int pos = i - 1;
	        while (pos >= 0 && comparar(lista.get(pos), actual, criterio) < 0) {
	            lista.set(pos + 1, lista.get(pos));
	            pos--;
	        }
	        lista.set(pos + 1, actual);
	    }
	}

	/**
	 * Obtiene el DAO de hombres.
	 * 
	 * @return El DAO de hombres
	 */
	public HombreDAO getHombreDAO() {
		return hombreDAO;
	}

	/**
	 * Establece el DAO de hombres.
	 * 
	 * @param hombreDAO El DAO de hombres a establecer
	 */
	public void setHombreDAO(HombreDAO hombreDAO) {
		this.hombreDAO = hombreDAO;
	}

	/**
	 * Obtiene el DAO de mujeres.
	 * 
	 * @return El DAO de mujeres
	 */
	public MujerDAO getMujerDAO() {
		return mujerDAO;
	}

	/**
	 * Establece el DAO de mujeres.
	 * 
	 * @param mujerDAO El DAO de mujeres a establecer
	 */
	public void setMujerDAO(MujerDAO mujerDAO) {
		this.mujerDAO = mujerDAO;
	}

	/**
	 * Obtiene la lista de todas las personas.
	 * 
	 * @return La lista de personas
	 */
	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	/**
	 * Establece la lista de todas las personas.
	 * 
	 * @param personas La lista de personas a establecer
	 */
	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
}