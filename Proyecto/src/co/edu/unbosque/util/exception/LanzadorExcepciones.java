package co.edu.unbosque.util.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase utilitaria que contiene métodos estáticos para validar datos y lanzar excepciones personalizadas.
 * Centraliza toda la lógica de validación de entrada de datos del sistema.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class LanzadorExcepciones {

	/**
	 * Verifica que un número no sea negativo ni cero.
	 * 
	 * @param numero El número a verificar
	 * @throws NumeroNegativoException Si el número es negativo o igual a cero
	 */
	public static void verificarNumeroNegativo(int numero) throws NumeroNegativoException {
		if (numero < 0) {
			throw new NumeroNegativoException("Numero Debajo de Cero");
		}
		if (numero == 0) {
			throw new NumeroNegativoException("Numero Igual a Cero");
		}
	}

	/**
	 * Verifica que un código de verificación tenga exactamente 6 dígitos.
	 * 
	 * @param codigo El código a verificar
	 * @throws CodigoException Si el código tiene menos de 6 o más de 6 dígitos
	 */
	public static void verificarCodigo(int codigo) throws CodigoException {
		if (codigo < 100000) {
			throw new CodigoException("Numero Debajo de 6 Digitos");
		}
		if (codigo > 999999) {
			throw new CodigoException("Numero Encima de 6 Digitos");
		}
	}

	/**
	 * Verifica que un campo de texto no esté vacío.
	 * 
	 * @param texto El texto a verificar
	 * @param nombre El nombre del campo para el mensaje de error
	 * @throws CampoVacioException Si el texto está vacío o es null
	 */
	public static void verificarCampoVacio(String texto, String nombre) throws CampoVacioException {
		if (texto == null || texto.trim().isEmpty()) {
			throw new CampoVacioException(nombre);
		}
	}

	/**
	 * Verifica que un número entero esté dentro de un rango específico.
	 * 
	 * @param numero El número a verificar
	 * @param min El valor mínimo permitido
	 * @param max El valor máximo permitido
	 * @throws RangoNumeroException Si el número está fuera del rango
	 */
	public static void verificarRangoNumero(int numero, int min, int max) throws RangoNumeroException {
		if (numero < min) {
			throw new RangoNumeroException("min");
		}
		if (numero > max) {
			throw new RangoNumeroException("max");
		}
	}

	/**
	 * Verifica que un número decimal esté dentro de un rango específico.
	 * 
	 * @param numero El número a verificar
	 * @param min El valor mínimo permitido
	 * @param max El valor máximo permitido
	 * @throws RangoNumeroException Si el número está fuera del rango
	 */
	public static void verificarRangoNumero(float numero, float min, float max) throws RangoNumeroException {
		if (numero < min) {
			throw new RangoNumeroException("min");
		}
		if (numero > max) {
			throw new RangoNumeroException("max");
		}
	}

	/**
	 * Verifica que un texto no contenga caracteres especiales.
	 * Solo se permiten letras, números y espacios.
	 * 
	 * @param texto El texto a verificar
	 * @param nombre El nombre del campo para el mensaje de error
	 * @throws CaracteresEspecialesException Si el texto contiene caracteres especiales
	 */
	public static void verificarCaracterEspecial(String texto, String nombre) throws CaracteresEspecialesException {
		if (!texto.matches("^[a-zA-Z0-9\s]+$")) {
			throw new CaracteresEspecialesException(nombre);
		}
	}

	/**
	 * Verifica que un correo electrónico tenga un formato válido.
	 * 
	 * @param correo El correo electrónico a verificar
	 * @throws FormatoCorreoException Si el formato del correo es inválido
	 */
	public static void verificarFormatoCorreo(String correo) throws FormatoCorreoException {
		String patronCorreo = "^[A-Za-z0-9._-]+@+[A-Za-z0-9._-]+$";

		if (!correo.matches(patronCorreo)) {
			throw new FormatoCorreoException("Formato Incorrecto de Correo");
		}
	}

	/**
	 * Verifica que una fecha tenga un formato válido y sea coherente con la edad ingresada.
	 * El formato esperado es dd/MM/yyyy.
	 * 
	 * @param fecha La fecha a verificar en formato dd/MM/yyyy
	 * @param edadIngresada La edad ingresada para verificar coherencia
	 * @throws FormatoFechaException Si el formato es inválido, la fecha es futura o no es coherente con la edad
	 */
	public static void verificarFormatoFecha(String fecha, int edadIngresada) throws FormatoFechaException {
		String patronFecha = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

		if (!fecha.matches(patronFecha)) {
			throw new FormatoFechaException("Formato Incorrecto");
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			Date fechaParsed = sdf.parse(fecha);
			Date hoy = new Date();
			Calendar calendarFecha = Calendar.getInstance();
			calendarFecha.setTime(fechaParsed);

			if (fechaParsed.after(hoy)) {
				throw new FormatoFechaException("Futuro");
			}

			Calendar calendarHoy = Calendar.getInstance();
			int edadCalculada = calendarHoy.get(Calendar.YEAR) - calendarFecha.get(Calendar.YEAR);

			if (edadCalculada != edadIngresada) {
				throw new FormatoFechaException("Incoherencia");
			}

		} catch (ParseException e) {
			throw new FormatoFechaException("Formato Incorrecto");
		}
	}

	/**
	 * Verifica que un campo no tenga espacios excesivos o mal ubicados.
	 * No debe tener espacios al inicio, al final, ni múltiples espacios consecutivos.
	 * 
	 * @param campo El texto a verificar
	 * @param nombreCampo El nombre del campo para el mensaje de error
	 * @throws EspaciosExcesivosException Si hay espacios excesivos o mal ubicados
	 */
	public static void verificarEspaciosExcesivos(String campo, String nombreCampo) throws EspaciosExcesivosException {
		if (campo.startsWith(" ") || campo.endsWith(" ")) {
			throw new EspaciosExcesivosException(nombreCampo + "_Inicio-Fin");
		}

		if (campo.contains("  ")) {
			throw new EspaciosExcesivosException(nombreCampo + "_Exceso");
		}
	}

	/**
	 * Verifica que un campo no contenga espacios.
	 * 
	 * @param campo El texto a verificar
	 * @param nombreCampo El nombre del campo para el mensaje de error
	 * @throws ContieneEspaciosException Si el campo contiene espacios
	 */
	public static void verificarEspacios(String campo, String nombreCampo) throws ContieneEspaciosException {
		if (campo.contains(" ")) {
			throw new ContieneEspaciosException(nombreCampo);
		}
	}

	/**
	 * Verifica que un campo tenga al menos 8 caracteres.
	 * 
	 * @param campo El texto a verificar
	 * @param nombreCampo El nombre del campo para el mensaje de error
	 * @throws CampoCortoException Si el campo tiene menos de 8 caracteres
	 */
	public static void verificarCampoMuyCorto(String campo, String nombreCampo)
			throws CampoCortoException {
		if (campo.length() < 8) {
			throw new CampoCortoException(nombreCampo);
		}
	}

	/**
	 * Verifica que un campo no tenga más de 50 caracteres.
	 * 
	 * @param campo El texto a verificar
	 * @param nombreCampo El nombre del campo para el mensaje de error
	 * @throws CampoLargoException Si el campo tiene más de 50 caracteres
	 */
	public static void verificarCampoMuyLargo(String campo, String nombreCampo)
			throws CampoLargoException {
		if (campo.length() > 50) {
			throw new CampoLargoException(nombreCampo);
		}
	}
	
	/**
	 * Verifica que la ruta de una imagen tenga la extensión .jpg.
	 * 
	 * @param ruta La ruta de la imagen a verificar
	 * @throws ImagenException Si la imagen no tiene extensión .jpg
	 */
	public static void verificarImagen(String ruta) throws ImagenException {
		if (!ruta.endsWith(".jpg")) {
			throw new ImagenException("");
		}
	}
}