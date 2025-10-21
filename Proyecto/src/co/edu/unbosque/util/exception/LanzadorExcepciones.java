package co.edu.unbosque.util.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LanzadorExcepciones {

	public static void verificarNumeroNegativo(int numero) throws NumeroNegativoException {
		if (numero < 0) {
			throw new NumeroNegativoException("Numero Debajo de Cero");
		}
		if (numero == 0) {
			throw new NumeroNegativoException("Numero Igual a Cero");
		}
	}

	public static void verificarCodigo(int codigo) throws CodigoException {
		if (codigo < 100000) {
			throw new CodigoException("Numero Debajo de 6 Digitos");
		}
		if (codigo > 999999) {
			throw new CodigoException("Numero Encima de 6 Digitos");
		}
	}

	public static void verificarCampoVacio(String texto, String nombre) throws CampoVacioException {
		if (texto == null || texto.trim().isEmpty()) {
			throw new CampoVacioException(nombre);
		}
	}

	public static void verificarRangoNumero(int numero, int min, int max) throws RangoNumeroException {
		if (numero < min) {
			throw new RangoNumeroException("min");
		}
		if (numero > max) {
			throw new RangoNumeroException("max");
		}
	}

	public static void verificarRangoNumero(float numero, float min, float max) throws RangoNumeroException {
		if (numero < min) {
			throw new RangoNumeroException("min");
		}
		if (numero > max) {
			throw new RangoNumeroException("max");
		}
	}

	public static void verificarCaracterEspecial(String texto, String nombre) throws CaracteresEspecialesException {
		if (!texto.matches("^[a-zA-Z0-9\s]+$")) {
			throw new CaracteresEspecialesException(nombre);
		}
	}

	public static void verificarFormatoCorreo(String correo) throws FormatoCorreoException {
		String patronCorreo = "^[A-Za-z0-9._-]+@+[A-Za-z0-9._-]+$";

		if (!correo.matches(patronCorreo)) {
			throw new FormatoCorreoException("Formato Incorrecto de Correo");
		}
	}

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

	public static void verificarEspaciosExcesivos(String campo, String nombreCampo) throws EspaciosExcesivosException {
		if (campo.startsWith(" ") || campo.endsWith(" ")) {
			throw new EspaciosExcesivosException(nombreCampo + "_Inicio-Fin");
		}

		if (campo.contains("  ")) {
			throw new EspaciosExcesivosException(nombreCampo + "_Exceso");
		}
	}

	public static void verificarEspacios(String campo, String nombreCampo) throws ContieneEspaciosException {
		if (campo.contains(" ")) {
			throw new ContieneEspaciosException(nombreCampo);
		}
	}

	public static void verificarCampoMuyCorto(String campo, String nombreCampo)
			throws CampoCortoException {
		if (campo.length() < 8) {
			throw new CampoCortoException(nombreCampo);
		}
	}

	public static void verificarCampoMuyLargo(String campo, String nombreCampo)
			throws CampoLargoException {
		if (campo.length() > 50) {
			throw new CampoLargoException(nombreCampo);
		}
	}
	
	public static void verificarImagen(String ruta) throws ImagenException {
		if (!ruta.endsWith(".jpg")) {
			throw new ImagenException("");
		}
	}
}
