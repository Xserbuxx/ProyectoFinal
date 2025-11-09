package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.Persona;

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

	// QUICKSORT ASCENDENTE - CORREGIDO (ahora es recursivo)
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

	// QUICKSORT DESCENDENTE - CORREGIDO (ahora es recursivo)
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

	// INSERCIÓN ASCENDENTE - Está correcta
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

	// INSERCIÓN DESCENDENTE - Está correcta
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

	public ArrayList<Hombre> getHombres() {
		return hombres;
	}

	public void setHombres(ArrayList<Hombre> hombres) {
		this.hombres = hombres;
	}
}
