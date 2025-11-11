package Util;


public class CalculadoraEstadisticas {

	public static double calcularMedia(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}
		double suma = 0;
		for (double dato : datos) {
			suma += dato;
		}
		return suma / datos.length;
	}

	public static double calcularMediana(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}

		double[] datosOrdenados = ordenarInsercionAscendente(datos);
		int n = datosOrdenados.length;

		if (n % 2 != 0) {
			return datosOrdenados[n / 2];
		} else {
			int medio1 = n / 2 - 1;
			int medio2 = n / 2;
			return (datosOrdenados[medio1] + datosOrdenados[medio2]) / 2.0;
		}
	}

	public static double[] calcularModa(double[] datos) {
		if (datos == null || datos.length == 0) {
			return new double[] { 0 };
		}

		double[] valoresUnicos = new double[datos.length];
		int cantidadUnicos = 0;

		for (int i = 0; i < datos.length; i++) {
			boolean encontrado = false;

			for (int j = 0; j < cantidadUnicos; j++) {
				if (valoresUnicos[j] == datos[i]) {
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				valoresUnicos[cantidadUnicos] = datos[i];
				cantidadUnicos++;
			}
		}

		int[] frecuencias = new int[cantidadUnicos];
		for (int i = 0; i < cantidadUnicos; i++) {
			frecuencias[i] = contarOcurrencias(datos, valoresUnicos[i]);
		}

		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		if (maxFrecuencia == 1) {
			return new double[] { 0 };
		}

		int cantidadModas = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				cantidadModas++;
			}
		}

		double[] modas = new double[cantidadModas];
		int indiceModas = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				modas[indiceModas] = valoresUnicos[i];
				indiceModas++;
			}
		}

		return modas;
	}

	public static double calcularVarianza(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}

		double media = calcularMedia(datos);
		double sumaDiferenciasCuadrado = 0;

		for (double dato : datos) {
			double diferencia = dato - media;
			double diferenciaAlCuadrado = diferencia * diferencia;
			sumaDiferenciasCuadrado += diferenciaAlCuadrado;
		}

		return sumaDiferenciasCuadrado / datos.length;
	}

	public static double calcularDesviacion(double[] datos) {
		double varianza = calcularVarianza(datos);
		return Math.sqrt(varianza);
	}

	public static double calcularMinimo(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}
		double minimo = datos[0];
		for (double dato : datos) {
			if (dato < minimo) {
				minimo = dato;
			}
		}
		return minimo;
	}

	public static double calcularMaximo(double[] datos) {
		if (datos == null || datos.length == 0) {
			return 0;
		}
		double maximo = datos[0];
		for (double dato : datos) {
			if (dato > maximo) {
				maximo = dato;
			}
		}
		return maximo;
	}

	public static double calcularRango(double[] datos) {
		return calcularMaximo(datos) - calcularMinimo(datos);
	}

	private static double[] ordenarInsercionAscendente(double[] datos) {
		if (datos == null || datos.length == 0) {
			return datos;
		}

		double[] datosOrdenados = new double[datos.length];
		for (int i = 0; i < datos.length; i++) {
			datosOrdenados[i] = datos[i];
		}

		for (int i = 1; i < datosOrdenados.length; i++) {
			double actual = datosOrdenados[i];
			int pos = i - 1;

			while (pos >= 0 && datosOrdenados[pos] > actual) {
				datosOrdenados[pos + 1] = datosOrdenados[pos];
				pos--;
			}

			datosOrdenados[pos + 1] = actual;
		}

		return datosOrdenados;
	}

	private static int contarOcurrencias(double[] datos, double valor) {
		if (datos == null || datos.length == 0) {
			return 0;
		}

		int contador = 0;
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] == valor) {
				contador++;
			}
		}

		return contador;
	}
}
