package co.edu.unbosque.model.persistence;

public interface DAO <D,E>{
	
	public boolean crear(D nuevoDato);
	public boolean borrar(D datoAEliminar);
	public boolean actualizar(D datoAnterior, D nuevoDato);
	public E encontrar(E datoAEncontrar);
	public String mostrar();
	
	public void cargarArchivoSerializado();
	public void escribirArchivoSerializado();
	
}
