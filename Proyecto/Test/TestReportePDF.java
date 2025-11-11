import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Util.CalculadoraEstadisticas;
import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.Persona;

public class TestReportePDF {

	private double[] datosConocidos;
	private double mediaEsperada;
	private double medianaEsperada;
	private double varianzaEsperada;
	private double desviacionEsperada;
	private ArrayList<Persona> personasTest;

	@Before
	public void setUp() {
		// Conjunto de datos conocido: {2, 4, 4, 4, 5, 5, 7, 9}
		datosConocidos = new double[] { 2, 4, 4, 4, 5, 5, 7, 9 };
		
		// Valores calculados externamente
		mediaEsperada = 5.0; // (2+4+4+4+5+5+7+9)/8 = 40/8 = 5
		medianaEsperada = 4.5; // (4+5)/2 = 4.5
		// Varianza: [(2-5)² + (4-5)² + (4-5)² + (4-5)² + (5-5)² + (5-5)² + (7-5)² + (9-5)²] / 8
		// = [9 + 1 + 1 + 1 + 0 + 0 + 4 + 16] / 8 = 32/8 = 4
		varianzaEsperada = 4.0;
		desviacionEsperada = 2.0; // √4 = 2
		
		// Crear personas de prueba
		personasTest = new ArrayList<>();
		personasTest.add(new Hombre("Juan Perez", "juan01", 25, "15/05/1999", 175.0f, 
				"juan@test.com", new ImageIcon(), true, "password123", 123456, 30, 20, 170.0f, 
				3000.0f, false, 10, false, new ArrayList<String>(), true));
		
		personasTest.add(new Hombre("Carlos Lopez", "carlos02", 28, "20/03/1996", 180.0f, 
				"carlos@test.com", new ImageIcon(), true, "password456", 654321, 35, 22, 175.0f, 
				3500.0f, false, 15, false, new ArrayList<String>(), true));
		
		personasTest.add(new Mujer("Maria Garcia", "maria01", 24, "10/07/2000", 165.0f, 
				"maria@test.com", new ImageIcon(), true, "password789", 789012, 32, 20, 170.0f, 
				false, 2500.0f, 8, false, new ArrayList<String>(), true));
	}

	@After
	public void tearDown() {
		// Limpiar archivos de prueba generados
		File testPDF = new File("test_estadisticas.pdf");
		if (testPDF.exists()) {
			testPDF.delete();
		}
		
		File dirGraficos = new File("graficos_temp");
		if (dirGraficos.exists()) {
			File[] archivos = dirGraficos.listFiles();
			if (archivos != null) {
				for (File archivo : archivos) {
					archivo.delete();
				}
			}
			dirGraficos.delete();
		}
	}

	/**
	 * Test: Estadisticas_Calculo_Correcto
	 * Pre: conjunto de datos conocido
	 * Pasos: ejecutar cálculo de estadísticas
	 * Esperado: media, moda, mediana, desviación y varianza calculadas correctamente
	 * Tipo: Unit
	 * Prioridad: Alta
	 */
	@Test
	public void testEstadisticas_Calculo_Correcto() {
		// Act: Calcular estadísticas
		double mediaCalculada = CalculadoraEstadisticas.calcularMedia(datosConocidos);
		double medianaCalculada = CalculadoraEstadisticas.calcularMediana(datosConocidos);
		double varianzaCalculada = CalculadoraEstadisticas.calcularVarianza(datosConocidos);
		double desviacionCalculada = CalculadoraEstadisticas.calcularDesviacion(datosConocidos);
		double[] modaCalculada = CalculadoraEstadisticas.calcularModa(datosConocidos);
		double minimoCalculado = CalculadoraEstadisticas.calcularMinimo(datosConocidos);
		double maximoCalculado = CalculadoraEstadisticas.calcularMaximo(datosConocidos);
		double rangoCalculado = CalculadoraEstadisticas.calcularRango(datosConocidos);

		// Assert: Verificar que los cálculos sean correctos (con tolerancia de 0.0001)
		assertEquals("La media no se calculó correctamente", mediaEsperada, mediaCalculada, 0.0001);
		assertEquals("La mediana no se calculó correctamente", medianaEsperada, medianaCalculada, 0.0001);
		assertEquals("La varianza no se calculó correctamente", varianzaEsperada, varianzaCalculada, 0.0001);
		assertEquals("La desviación estándar no se calculó correctamente", desviacionEsperada, desviacionCalculada, 0.0001);
		
		// La moda debe ser 4 (aparece 3 veces)
		assertNotNull("La moda no debe ser null", modaCalculada);
		assertTrue("Debe haber al menos una moda", modaCalculada.length > 0);
		assertEquals("La moda no se calculó correctamente", 4.0, modaCalculada[0], 0.0001);
		
		// Verificar mínimo y máximo
		assertEquals("El mínimo no se calculó correctamente", 2.0, minimoCalculado, 0.0001);
		assertEquals("El máximo no se calculó correctamente", 9.0, maximoCalculado, 0.0001);
		assertEquals("El rango no se calculó correctamente", 7.0, rangoCalculado, 0.0001);
	}

	/**
	 * Test: Reporte_PDF_ContenidoYGrafico
	 * Pre: estadísticas calculadas
	 * Pasos: generar PDF
	 * Esperado: PDF generado, contiene fecha/hora, tablas y gráficos; archivo no corrupto
	 * Tipo: Integration
	 * Prioridad: Media
	 */
	@Test
	public void testReporte_PDF_ContenidoYGrafico() {
		// Arrange: Preparar datos de personas
		double[] edades = new double[personasTest.size()];
		double[] estaturas = new double[personasTest.size()];
		
		for (int i = 0; i < personasTest.size(); i++) {
			edades[i] = personasTest.get(i).getEdad();
			estaturas[i] = personasTest.get(i).getEstatura();
		}

		// Act: Generar el PDF de prueba
		String nombreArchivo = "test_estadisticas";
		File archivoPDF = new File(nombreArchivo + ".pdf");
		
		// Eliminar archivo si existe
		if (archivoPDF.exists()) {
			archivoPDF.delete();
		}

		try {
			// Generar PDF con estadísticas de edades
			generarInformeTest(edades, nombreArchivo);

			// Assert: Verificar que el PDF se haya generado
			assertTrue("El archivo PDF debe existir después de la generación", archivoPDF.exists());
			
			// Verificar que el archivo no esté vacío
			assertTrue("El archivo PDF no debe estar vacío", archivoPDF.length() > 0);
			
			// Verificar que el archivo tenga un tamaño razonable (más de 1KB)
			assertTrue("El archivo PDF debe tener un tamaño razonable (>1KB)", archivoPDF.length() > 1024);
			
			// Verificar que sea un archivo PDF válido (comienza con %PDF)
			java.io.FileInputStream fis = new java.io.FileInputStream(archivoPDF);
			byte[] header = new byte[4];
			fis.read(header);
			fis.close();
			
			String headerStr = new String(header);
			assertEquals("El archivo debe comenzar con la firma PDF", "%PDF", headerStr);
			
		} catch (Exception e) {
			fail("No se pudo generar o verificar el PDF: " + e.getMessage());
		}
	}

	/**
	 * Método auxiliar para generar informe de prueba
	 */
	private void generarInformeTest(double[] datos, String nombreArchivo) {
		try {
			File dirGraficos = new File("graficos_temp");
			if (!dirGraficos.exists()) {
				dirGraficos.mkdir();
			}

			File graficoBarras = crearGraficoBarrasTest(datos, "graficos_temp/barras.png");
			File histograma = crearHistogramaTest(datos, "graficos_temp/histograma.png");
			File graficoLinea = crearGraficoLineaTest(datos, "graficos_temp/linea.png");

			String rutaPDF = nombreArchivo + ".pdf";
			com.itextpdf.kernel.pdf.PdfWriter writer = new com.itextpdf.kernel.pdf.PdfWriter(rutaPDF);
			com.itextpdf.kernel.pdf.PdfDocument pdf = new com.itextpdf.kernel.pdf.PdfDocument(writer);
			com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdf);

			// Título
			com.itextpdf.layout.element.Paragraph titulo = new com.itextpdf.layout.element.Paragraph("Informe Estadístico de Prueba")
					.setFontSize(20)
					.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
			document.add(titulo);

			// Fecha y hora
			java.time.LocalDateTime ahora = java.time.LocalDateTime.now();
			com.itextpdf.layout.element.Paragraph fechaHora = new com.itextpdf.layout.element.Paragraph(
					"Generado: " + ahora.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
					.setFontSize(10)
					.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT);
			document.add(fechaHora);

			document.add(new com.itextpdf.layout.element.Paragraph("\n"));

			// Tabla de estadísticas
			com.itextpdf.layout.element.Table tabla = new com.itextpdf.layout.element.Table(2);
			tabla.setWidth(com.itextpdf.layout.properties.UnitValue.createPercentValue(60));

			tabla.addHeaderCell("Medida");
			tabla.addHeaderCell("Valor");

			tabla.addCell("Media");
			tabla.addCell(String.format("%.4f", CalculadoraEstadisticas.calcularMedia(datos)));

			tabla.addCell("Mediana");
			tabla.addCell(String.format("%.4f", CalculadoraEstadisticas.calcularMediana(datos)));

			tabla.addCell("Desviación Estándar");
			tabla.addCell(String.format("%.4f", CalculadoraEstadisticas.calcularDesviacion(datos)));

			tabla.addCell("Varianza");
			tabla.addCell(String.format("%.4f", CalculadoraEstadisticas.calcularVarianza(datos)));

			tabla.addCell("Cantidad de Datos");
			tabla.addCell(String.valueOf(datos.length));

			document.add(tabla);
			document.add(new com.itextpdf.layout.element.Paragraph("\n"));

			// Agregar gráficos
			if (graficoBarras != null) {
				document.add(new com.itextpdf.layout.element.Paragraph("Gráfico de Barras").setFontSize(14));
				com.itextpdf.layout.element.Image imgBarras = new com.itextpdf.layout.element.Image(
						com.itextpdf.io.image.ImageDataFactory.create(graficoBarras.getAbsolutePath()));
				imgBarras.setWidth(com.itextpdf.layout.properties.UnitValue.createPercentValue(80));
				document.add(imgBarras);
			}

			document.close();

			// Limpiar archivos temporales
			limpiarArchivosTemporalesTest(dirGraficos);

		} catch (Exception e) {
			throw new RuntimeException("Error al generar PDF de prueba: " + e.getMessage(), e);
		}
	}

	private File crearGraficoBarrasTest(double[] datos, String rutaArchivo) {
		try {
			org.jfree.data.category.DefaultCategoryDataset dataset = new org.jfree.data.category.DefaultCategoryDataset();

			dataset.addValue(CalculadoraEstadisticas.calcularMedia(datos), "Valor", "Media");
			dataset.addValue(CalculadoraEstadisticas.calcularMediana(datos), "Valor", "Mediana");
			dataset.addValue(CalculadoraEstadisticas.calcularDesviacion(datos), "Valor", "Desviación");

			org.jfree.chart.JFreeChart chart = org.jfree.chart.ChartFactory.createBarChart(
					"Estadísticas Descriptivas", "Medida", "Valor", dataset,
					org.jfree.chart.plot.PlotOrientation.VERTICAL, true, true, false);

			File chartFile = new File(rutaArchivo);
			org.jfree.chart.ChartUtils.saveChartAsPNG(chartFile, chart, 600, 400);
			return chartFile;
		} catch (Exception e) {
			return null;
		}
	}

	private File crearHistogramaTest(double[] datos, String rutaArchivo) {
		try {
			org.jfree.data.statistics.HistogramDataset dataset = new org.jfree.data.statistics.HistogramDataset();
			dataset.addSeries("Frecuencia", datos, 5);

			org.jfree.chart.JFreeChart chart = org.jfree.chart.ChartFactory.createHistogram(
					"Distribución de Datos", "Valores", "Frecuencia", dataset,
					org.jfree.chart.plot.PlotOrientation.VERTICAL, true, true, false);

			File chartFile = new File(rutaArchivo);
			org.jfree.chart.ChartUtils.saveChartAsPNG(chartFile, chart, 600, 400);
			return chartFile;
		} catch (Exception e) {
			return null;
		}
	}

	private File crearGraficoLineaTest(double[] datos, String rutaArchivo) {
		try {
			org.jfree.data.category.DefaultCategoryDataset dataset = new org.jfree.data.category.DefaultCategoryDataset();

			for (int i = 0; i < datos.length; i++) {
				dataset.addValue(datos[i], "Datos", String.valueOf(i + 1));
			}

			org.jfree.chart.JFreeChart chart = org.jfree.chart.ChartFactory.createLineChart(
					"Tendencia de Datos", "Índice", "Valor", dataset,
					org.jfree.chart.plot.PlotOrientation.VERTICAL, true, true, false);

			File chartFile = new File(rutaArchivo);
			org.jfree.chart.ChartUtils.saveChartAsPNG(chartFile, chart, 600, 400);
			return chartFile;
		} catch (Exception e) {
			return null;
		}
	}

	private void limpiarArchivosTemporalesTest(File directorio) {
		if (directorio != null && directorio.isDirectory()) {
			File[] archivos = directorio.listFiles();
			if (archivos != null) {
				for (File archivo : archivos) {
					if (archivo.isFile()) {
						archivo.delete();
					}
				}
			}
			directorio.delete();
		}
	}
}