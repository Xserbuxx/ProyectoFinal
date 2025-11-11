package co.edu.unbosque.model.persistence;

/**
 * Interfaz genérica DAO (Data Access Object) que define las operaciones CRUD básicas.
 * Proporciona métodos para crear, leer, actualizar y eliminar datos, así como manejo de archivos serializados.
 * 
 * @param <D> Tipo de dato DTO (Data Transfer Object)
 * @param <E> Tipo de entidad
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public interface DAO <D,E>{
	
	/**
	 * Crea un nuevo registro en el sistema.
	 * 
	 * @param nuevoDato El dato a crear
	 * @return true si se creó exitosamente, false en caso contrario
	 */
	public boolean crear(D nuevoDato);
	
	/**
	 * Elimina un registro del sistema.
	 * 
	 * @param datoAEliminar El dato a eliminar
	 * @return true si se eliminó exitosamente, false en caso contrario
	 */
	public boolean borrar(D datoAEliminar);
	
	/**
	 * Actualiza un registro existente con nuevos datos.
	 * 
	 * @param datoAnterior El dato actual a actualizar
	 * @param nuevoDato Los nuevos datos
	 * @return true si se actualizó exitosamente, false en caso contrario
	 */
	public boolean actualizar(D datoAnterior, D nuevoDato);
	
	/**
	 * Busca y retorna un dato específico.
	 * 
	 * @param datoAEncontrar El dato a buscar
	 * @return El dato encontrado, o null si no existe
	 */
	public E encontrar(E datoAEncontrar);
	
	/**
	 * Retorna una representación en texto de todos los datos.
	 * 
	 * @return Una cadena con todos los datos
	 */
	public String mostrar();
	
	/**
	 * Carga los datos desde un archivo serializado.
	 */
	public void cargarArchivoSerializado();
	
	/**
	 * Escribe los datos actuales en un archivo serializado.
	 */
	public void escribirArchivoSerializado();
	
}