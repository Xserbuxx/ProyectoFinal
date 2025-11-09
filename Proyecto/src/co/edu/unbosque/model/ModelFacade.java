package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

public class ModelFacade {

	private HombreDAO hombreDAO;
	private MujerDAO mujerDAO;
	
	private ArrayList<Persona> personas;

	public ModelFacade() {
		hombreDAO = new HombreDAO();
		mujerDAO = new MujerDAO();
		personas = new ArrayList<>();
	}
	
	public void actualizarPersonas() {
		personas.clear();
		personas = new ArrayList<>();
		personas.addAll(hombreDAO.getHombres());
		personas.addAll(mujerDAO.getMujeres());
		hombreDAO.escribirArchivoSerializado();
		mujerDAO.escribirArchivoSerializado();
	}
	
	public void eliminarPersona(Persona p) {
		if (p instanceof Hombre) {
			hombreDAO.borrar((Hombre) p);
			personas.remove(p);
		} else if (p instanceof Mujer) {
			mujerDAO.borrar((Mujer) p);
			personas.remove(p);
		}
	}
	
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

	public int comparar(Persona a, Persona b, int criterio) {
	    if (criterio == 1)
	        return a.getNombre().compareToIgnoreCase(b.getNombre());
	    if (criterio == 2)
	        return a.getAlias().compareToIgnoreCase(b.getAlias());
	    if (criterio == 3)
	        return Integer.compare(a.getLikesRecibidos(), b.getLikesRecibidos()); // CORREGIDO
	    if (criterio == 4)
	        return Integer.compare(a.getEdad(), b.getEdad()); // CORREGIDO
	    return 0;
	}

	// QUICKSORT ASCENDENTE - CORREGIDO (ahora es recursivo)
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

	// QUICKSORT DESCENDENTE - CORREGIDO (ahora es recursivo)
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

	// INSERCIÓN ASCENDENTE - Está correcta
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

	// INSERCIÓN DESCENDENTE - Está correcta
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

	public HombreDAO getHombreDAO() {
		return hombreDAO;
	}

	public void setHombreDAO(HombreDAO hombreDAO) {
		this.hombreDAO = hombreDAO;
	}

	public MujerDAO getMujerDAO() {
		return mujerDAO;
	}

	public void setMujerDAO(MujerDAO mujerDAO) {
		this.mujerDAO = mujerDAO;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
}
