package Util;

/**
 * Clase que proporciona métodos estáticos para realizar cálculos estadísticos
 * sobre un conjunto de datos numéricos. Incluye funcionalidades para calcular
 * media, mediana, moda, varianza, desviación estándar, mínimo, máximo y rango.
 * 
 * @author Sergio Enrique Caballero Neira
 * @version 1.0
 */
public class CalculadoraEstadisticas {

	/**
	 * Calcula la media aritmética (promedio) de un conjunto de datos.
	 * 
	 * @param datos Array de números decimales para los que se calculará la media
	 * @return La media aritmética de los datos. Retorna 0 si el array es nulo o vacío
	 */
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

	/**
	 * Calcula la mediana de un conjunto de datos. La mediana es el valor central
	 * cuando los datos están ordenados. Si hay un número par de elementos, retorna
	 * el promedio de los dos valores centrales.
	 * 
	 * @param datos Array de números decimales para calcular la mediana
	 * @return La mediana de los datos. Retorna 0 si el array es nulo o vacío
	 */
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

	/**
	 * Calcula la moda de un conjunto de datos. La moda es el valor que más se
	 * repite en el conjunto. Si hay múltiples modas (multimodal), retorna todas.
	 * 
	 * @param datos Array de números decimales para calcular la moda
	 * @return Array con las modas encontradas. Retorna un array con 0 si el
	 *         conjunto es nulo, vacío o si no hay repeticiones
	 */
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

	/**
	 * Calcula la varianza de un conjunto de datos. La varianza mide la dispersión
	 * o variabilidad de los datos respecto a la media.
	 * 
	 * @param datos Array de números decimales para calcular la varianza
	 * @return La varianza de los datos. Retorna 0 si el array es nulo o vacío
	 */
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

	/**
	 * Calcula la desviación estándar (desviación típica) de un conjunto de datos.
	 * Es la raíz cuadrada de la varianza e indica qué tan dispersos están los
	 * datos respecto a la media.
	 * 
	 * @param datos Array de números decimales para calcular la desviación
	 * @return La desviación estándar de los datos
	 */
	public static double calcularDesviacion(double[] datos) {
		double varianza = calcularVarianza(datos);
		return Math.sqrt(varianza);
	}

	/**
	 * Encuentra el valor mínimo en un conjunto de datos.
	 * 
	 * @param datos Array de números decimales del cual extraer el mínimo
	 * @return El valor mínimo del conjunto. Retorna 0 si el array es nulo o vacío
	 */
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

	/**
	 * Encuentra el valor máximo en un conjunto de datos.
	 * 
	 * @param datos Array de números decimales del cual extraer el máximo
	 * @return El valor máximo del conjunto. Retorna 0 si el array es nulo o vacío
	 */
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

	/**
	 * Calcula el rango de un conjunto de datos. El rango es la diferencia entre
	 * el valor máximo y el valor mínimo.
	 * 
	 * @param datos Array de números decimales para calcular el rango
	 * @return La diferencia entre el máximo y el mínimo del conjunto
	 */
	public static double calcularRango(double[] datos) {
		return calcularMaximo(datos) - calcularMinimo(datos);
	}

	/**
	 * Ordena un array de números en orden ascendente utilizando el algoritmo de
	 * inserción. Este método es privado y se utiliza internamente para calcular
	 * la mediana.
	 * 
	 * @param datos Array de números decimales a ordenar
	 * @return Un nuevo array con los datos ordenados en forma ascendente.
	 *         Retorna el array original si es nulo o vacío
	 */
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

	/**
	 * Cuenta las ocurrencias de un valor específico en un array de datos.
	 * Este método es privado y se utiliza internamente para calcular la moda.
	 * 
	 * @param datos Array de números decimales en el cual contar las ocurrencias
	 * @param valor El valor a contar en el array
	 * @return La cantidad de veces que aparece el valor en el array.
	 *         Retorna 0 si el array es nulo o vacío
	 */
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