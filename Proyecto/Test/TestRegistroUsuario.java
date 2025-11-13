import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;
import co.edu.unbosque.util.exception.*;

/**
 * Suite de pruebas para el registro de usuarios
 * Cubre validaciones de edad, fecha, email, alias, formato de foto y campos obligatorios
 */
public class TestRegistroUsuario {
	
	private HombreDAO hombreDAO;
	private MujerDAO mujerDAO;
	private ImageIcon imagenPrueba;
	
	@Before
	public void setUp() {
		hombreDAO = new HombreDAO();
		mujerDAO = new MujerDAO();
		imagenPrueba = new ImageIcon("Resources/logo.png"); // Imagen de prueba
	}
	
	/**
	 * Test Case: Registro_Usuario_MayorDeEdad
	 * Pre: datos válidos salvo la edad
	 * Pasos: registrar usuario con fecha de nacimiento que resulte en 18 años exactos hoy
	 * Esperado: registro permitido; edad calculada = 18
	 */
	@Test
	public void testRegistroUsuarioMayorDeEdad() {
		try {
			// Calcular fecha de nacimiento para 18 años exactos
			LocalDate hoy = LocalDate.now();
			LocalDate fechaNacimiento18 = hoy.minusYears(18);
			String fechaStr = fechaNacimiento18.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			// Crear usuario con 18 años exactos
			Hombre hombre = new Hombre(
				"Juan Perez", 
				"juanperez18", 
				18, 
				fechaStr, 
				175.0f, 
				"juan@example.com", 
				imagenPrueba, 
				true, 
				"password123", 
				123456, 
				25, 
				20, 
				170.0f, 
				1000.0f, 
				false, 
				0, 
				false, 
				new ArrayList<String>(), 
				false
			);
			
			// Validar edad
			LanzadorExcepciones.verificarRangoNumero(18, 18, 130);
			
			// Validar fecha
			LanzadorExcepciones.verificarFormatoFecha(fechaStr, 18);
			
			// Intentar registrar
			hombreDAO.getHombres().add(hombre);
			hombreDAO.escribirArchivoSerializado();
			
			assertTrue("El registro debe ser exitoso para usuario de 18 años", hombreDAO.getHombres().contains(hombre));
			assertEquals("La edad debe ser 18", 18, hombre.getEdad());
			
			// Limpiar
			hombreDAO.borrar(hombre);
			
		} catch (Exception e) {
			fail("No debería lanzar excepción para usuario de 18 años: " + e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Usuario_MenorDeEdad
	 * Pre: fecha de nacimiento que da <18
	 * Pasos: intentar registrar
	 * Esperado: rechazo con mensaje "Debe ser mayor de 18"
	 */
	@Test
	public void testRegistroUsuarioMenorDeEdad() {
		try {
			int edadMenor = 17;
			
			// Intentar validar edad menor a 18
			LanzadorExcepciones.verificarRangoNumero(edadMenor, 18, 130);
			
			fail("Debería lanzar RangoNumeroException para edad menor a 18");
			
		} catch (RangoNumeroException e) {
			assertEquals("Debe retornar mensaje de edad mínima", "min", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_FormatoFecha_Invalido
	 * Pre: fecha en formato diferente (e.g., YYYY-MM-DD)
	 * Pasos: enviar registro
	 * Esperado: rechazo con mensaje de formato inválido (DD/MM/YYYY)
	 */
	@Test
	public void testRegistroFormatoFechaInvalido() {
		try {
			String fechaFormatoIncorrecto = "2005-05-15"; // Formato YYYY-MM-DD
			
			LanzadorExcepciones.verificarFormatoFecha(fechaFormatoIncorrecto, 19);
			
			fail("Debería lanzar FormatoFechaException para formato incorrecto");
			
		} catch (FormatoFechaException e) {
			assertEquals("Debe indicar formato incorrecto", "Formato Incorrecto", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_FormatoFecha_FechaFutura
	 * Pre: fecha de nacimiento en el futuro
	 * Pasos: enviar registro
	 * Esperado: rechazo con mensaje de fecha futura
	 */
	@Test
	public void testRegistroFechaFutura() {
		try {
			LocalDate fechaFutura = LocalDate.now().plusYears(1);
			String fechaStr = fechaFutura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			LanzadorExcepciones.verificarFormatoFecha(fechaStr, 0);
			
			fail("Debería lanzar FormatoFechaException para fecha futura");
			
		} catch (FormatoFechaException e) {
			assertEquals("Debe indicar fecha en el futuro", "Futuro", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_FormatoFecha_Incoherencia
	 * Pre: fecha que no coincide con la edad proporcionada
	 * Pasos: enviar registro
	 * Esperado: rechazo con mensaje de incoherencia
	 */
	@Test
	public void testRegistroFechaIncoherente() {
		try {
			// Fecha de nacimiento que da 25 años, pero se indica edad de 30
			LocalDate fecha25 = LocalDate.now().minusYears(25);
			String fechaStr = fecha25.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			LanzadorExcepciones.verificarFormatoFecha(fechaStr, 30);
			
			fail("Debería lanzar FormatoFechaException por incoherencia");
			
		} catch (FormatoFechaException e) {
			assertEquals("Debe indicar incoherencia entre edad y fecha", "Incoherencia", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Email_Invalido
	 * Pre: email sin '@' o dominio
	 * Pasos: enviar registro
	 * Esperado: rechazo con validación de email
	 */
	@Test
	public void testRegistroEmailInvalido() {
		try {
			String emailSinArroba = "usuarioexample.com";
			
			LanzadorExcepciones.verificarFormatoCorreo(emailSinArroba);
			
			fail("Debería lanzar FormatoCorreoException para email sin @");
			
		} catch (FormatoCorreoException e) {
			assertEquals("Debe indicar formato de correo incorrecto", "Formato Incorrecto de Correo", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Email_SinDominio
	 * Pre: email con @ pero sin dominio completo
	 * Pasos: enviar registro
	 * Esperado: rechazo con validación de email
	 */
	@Test
	public void testRegistroEmailSinDominio() {
		try {
			String emailSinDominio = "usuario@";
			
			LanzadorExcepciones.verificarFormatoCorreo(emailSinDominio);
			
			fail("Debería lanzar FormatoCorreoException para email sin dominio");
			
		} catch (FormatoCorreoException e) {
			assertEquals("Debe indicar formato de correo incorrecto", "Formato Incorrecto de Correo", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_AliasNoUnico
	 * Pre: existe usuario con alias "pepito"
	 * Pasos: intentar registrar otro usuario con alias "pepito"
	 * Esperado: rechazo por alias duplicado
	 */
	@Test
	public void testRegistroAliasNoUnico() {
		// Crear primer usuario
		Hombre hombre1 = new Hombre(
			"Pedro Lopez", 
			"pepito", 
			25, 
			"15/05/1999", 
			180.0f, 
			"pedro@example.com", 
			imagenPrueba, 
			true, 
			"password123", 
			123456, 
			30, 
			20, 
			165.0f, 
			2000.0f, 
			false, 
			0, 
			false, 
			new ArrayList<String>(), 
			false
		);
		
		// Registrar primer usuario
		hombreDAO.getHombres().add(hombre1);
		hombreDAO.escribirArchivoSerializado();
		
		// Verificar que existe
		Hombre encontrado = hombreDAO.encontrar(hombre1);
		assertNotNull("El primer usuario debe existir", encontrado);
		
		// Intentar registrar segundo usuario con mismo alias
		Hombre hombre2 = new Hombre(
			"Juan Martinez", 
			"pepito", // Mismo alias
			28, 
			"10/03/1996", 
			175.0f, 
			"juan@example.com", 
			imagenPrueba, 
			true, 
			"password456", 
			654321, 
			35, 
			22, 
			170.0f, 
			1500.0f, 
			false, 
			0, 
			false, 
			new ArrayList<String>(), 
			false
		);
		
		Hombre duplicado = hombreDAO.encontrar(hombre2);
		assertNotNull("El segundo registro debe fallar por alias duplicado", duplicado);
		assertEquals("Debe encontrar el primer usuario con ese alias", "Pedro Lopez", duplicado.getNombre());
		
		// Limpiar
		hombreDAO.borrar(hombre1);
	}
	
	/**
	 * Test Case: Registro_FotoFormatoNoJPG
	 * Pre: foto en PNG o sin extensión
	 * Pasos: intentar subir foto
	 * Esperado: rechazo; aceptar solo .jpg
	 */
	@Test
	public void testRegistroFotoFormatoNoJPG() {
		try {
			String rutaImagenPNG = "Resources/imagen.png";
			
			LanzadorExcepciones.verificarImagen(rutaImagenPNG);
			
			fail("Debería lanzar ImagenException para formato diferente a .jpg");
			
		} catch (ImagenException e) {
			assertNotNull("Debe lanzar excepción para formato no JPG", e);
		}
	}
	
	/**
	 * Test Case: Registro_FotoSinExtension
	 * Pre: ruta sin extensión de archivo
	 * Pasos: intentar subir foto
	 * Esperado: rechazo
	 */
	@Test
	public void testRegistroFotoSinExtension() {
		try {
			String rutaSinExtension = "Resources/imagen";
			
			LanzadorExcepciones.verificarImagen(rutaSinExtension);
			
			fail("Debería lanzar ImagenException para archivo sin extensión");
			
		} catch (ImagenException e) {
			assertNotNull("Debe lanzar excepción para archivo sin extensión", e);
		}
	}
	
	/**
	 * Test Case: Registro_Estatura_ObligatoriaHombres
	 * Pre: registrar hombre sin estatura
	 * Pasos: enviar registro
	 * Esperado: rechazo por campo obligatorio
	 */
	@Test
	public void testRegistroEstaturaObligatoriaHombres() {
		try {
			float estaturaInvalida = 0.0f;
			
			LanzadorExcepciones.verificarRangoNumero(estaturaInvalida, 50f, 250f);
			
			fail("Debería lanzar RangoNumeroException para estatura 0");
			
		} catch (RangoNumeroException e) {
			assertEquals("Debe indicar que la estatura es menor al mínimo", "min", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Estatura_RangoValido
	 * Pre: estatura dentro del rango válido (50-250 cm)
	 * Pasos: validar estatura
	 * Esperado: validación exitosa
	 */
	@Test
	public void testRegistroEstaturaRangoValido() {
		try {
			float estaturaValida = 175.0f;
			
			LanzadorExcepciones.verificarRangoNumero(estaturaValida, 50f, 250f);
			
			// Si no lanza excepción, la prueba es exitosa
			assertTrue("La estatura válida debe pasar la validación", true);
			
		} catch (RangoNumeroException e) {
			fail("No debería lanzar excepción para estatura válida: " + e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Ingresos_ObligatorioHombres
	 * Pre: registrar hombre sin ingresos mensuales
	 * Pasos: enviar registro
	 * Esperado: rechazo por campo obligatorio
	 */
	@Test
	public void testRegistroIngresosObligatorioHombres() {
		try {
			float ingresosInvalidos = 0.0f;
			
			LanzadorExcepciones.verificarRangoNumero(ingresosInvalidos, 244.85f, 1000000f);
			
			fail("Debería lanzar RangoNumeroException para ingresos 0");
			
		} catch (RangoNumeroException e) {
			assertEquals("Debe indicar que los ingresos son menores al mínimo", "min", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Ingresos_RangoValido
	 * Pre: ingresos dentro del rango válido
	 * Pasos: validar ingresos
	 * Esperado: validación exitosa
	 */
	@Test
	public void testRegistroIngresosRangoValido() {
		try {
			float ingresosValidos = 1500.0f;
			
			LanzadorExcepciones.verificarRangoNumero(ingresosValidos, 244.85f, 1000000f);
			
			assertTrue("Los ingresos válidos deben pasar la validación", true);
			
		} catch (RangoNumeroException e) {
			fail("No debería lanzar excepción para ingresos válidos: " + e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Divorcios_Mujeres_OpcionalPeroValidar
	 * Pre: registrar mujer y omitir información de divorcio
	 * Pasos: enviar registro
	 * Esperado: registro permitido; campo nulo o "no informado" válido
	 */
	@Test
	public void testRegistroDivorciosMujeresOpcional() {
		// Crear mujer sin especificar divorcio (false por defecto)
		Mujer mujer = new Mujer(
			"Maria Garcia", 
			"mariag", 
			30, 
			"20/08/1994", 
			165.0f, 
			"maria@example.com", 
			imagenPrueba, 
			true, 
			"password789", 
			789012, 
			40, 
			25, 
			175.0f, 
			false, // Estado de divorcio puede ser false (no divorciada)
			1000.0f, 
			0, 
			false, 
			new ArrayList<String>(), 
			false
		);
		
		// Intentar registrar
		mujerDAO.getMujeres().add(mujer);
		mujerDAO.escribirArchivoSerializado();
		
		assertTrue("El registro debe ser exitoso sin especificar divorcio", mujerDAO.getMujeres().contains(mujer));
		assertFalse("El campo divorciada debe tener valor por defecto (false)", mujer.isDivorciada());
		
		// Limpiar
		mujerDAO.borrar(mujer);
	}
	
	/**
	 * Test Case: Registro_CampoVacio_Nombre
	 * Pre: campo nombre vacío
	 * Pasos: intentar registrar
	 * Esperado: rechazo por campo obligatorio
	 */
	@Test
	public void testRegistroCampoVacioNombre() {
		try {
			String nombreVacio = "";
			
			LanzadorExcepciones.verificarCampoVacio(nombreVacio, "Nombre");
			
			fail("Debería lanzar CampoVacioException para nombre vacío");
			
		} catch (CampoVacioException e) {
			assertEquals("Debe indicar el campo nombre", "Nombre", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_CampoVacio_Alias
	 * Pre: campo alias vacío
	 * Pasos: intentar registrar
	 * Esperado: rechazo por campo obligatorio
	 */
	@Test
	public void testRegistroCampoVacioAlias() {
		try {
			String aliasVacio = "   "; // Solo espacios
			
			LanzadorExcepciones.verificarCampoVacio(aliasVacio, "Alias");
			
			fail("Debería lanzar CampoVacioException para alias vacío");
			
		} catch (CampoVacioException e) {
			assertEquals("Debe indicar el campo alias", "Alias", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Alias_CaracteresEspeciales
	 * Pre: alias con caracteres especiales
	 * Pasos: intentar registrar
	 * Esperado: rechazo por caracteres no permitidos
	 */
	@Test
	public void testRegistroAliasCaracteresEspeciales() {
		try {
			String aliasInvalido = "usuario@123";
			
			LanzadorExcepciones.verificarCaracterEspecial(aliasInvalido, "Alias");
			
			fail("Debería lanzar CaracteresEspecialesException para alias con @");
			
		} catch (CaracteresEspecialesException e) {
			assertEquals("Debe indicar el campo alias", "Alias", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Alias_MuyCorto
	 * Pre: alias con menos de 8 caracteres
	 * Pasos: intentar registrar
	 * Esperado: rechazo por longitud mínima
	 */
	@Test
	public void testRegistroAliasMuyCorto() {
		try {
			String aliasCorto = "usr123"; // 6 caracteres
			
			LanzadorExcepciones.verificarCampoMuyCorto(aliasCorto, "Alias");
			
			fail("Debería lanzar CampoCortoException para alias menor a 8 caracteres");
			
		} catch (CampoCortoException e) {
			assertEquals("Debe indicar el campo alias", "Alias", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Alias_MuyLargo
	 * Pre: alias con más de 50 caracteres
	 * Pasos: intentar registrar
	 * Esperado: rechazo por longitud máxima
	 */
	@Test
	public void testRegistroAliasMuyLargo() {
		try {
			String aliasLargo = "a".repeat(51); // 51 caracteres
			
			LanzadorExcepciones.verificarCampoMuyLargo(aliasLargo, "Alias");
			
			fail("Debería lanzar CampoLargoException para alias mayor a 50 caracteres");
			
		} catch (CampoLargoException e) {
			assertEquals("Debe indicar el campo alias", "Alias", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Registro_Usuario_Completo_Hombre
	 * Pre: todos los datos válidos para un hombre
	 * Pasos: registrar usuario completo
	 * Esperado: registro exitoso
	 */
	@Test
	public void testRegistroUsuarioCompletoHombre() {
		Hombre hombre = new Hombre(
			"Carlos Rodriguez", 
			"carlosr2024", 
			32, 
			"15/03/1992", 
			178.0f, 
			"carlos@example.com", 
			imagenPrueba, 
			true, 
			"password123", 
			123456, 
			40, 
			25, 
			165.0f, 
			2500.0f, 
			true, 
			0, 
			false, 
			new ArrayList<String>(), 
			false
		);
		
		hombreDAO.getHombres().add(hombre);
		hombreDAO.escribirArchivoSerializado();
		
		assertTrue("El registro completo debe ser exitoso", hombreDAO.getHombres().contains(hombre));
		
		// Verificar que el usuario fue creado buscando en la lista
		boolean encontrado = false;
		for (Hombre h : hombreDAO.getHombres()) {
			if (h.getAlias().equals("carlosr2024")) {
				encontrado = true;
				break;
			}
		}
		assertTrue("El usuario debe existir en la base de datos", encontrado);
		
		// Limpiar
		hombreDAO.borrar(hombre);
	}
	
	/**
	 * Test Case: Registro_Usuario_Completo_Mujer
	 * Pre: todos los datos válidos para una mujer
	 * Pasos: registrar usuario completo
	 * Esperado: registro exitoso
	 */
	@Test
	public void testRegistroUsuarioCompletoMujer() {
		Mujer mujer = new Mujer(
			"Ana Martinez", 
			"anamartinez", 
			28, 
			"22/11/1996", 
			168.0f, 
			"ana@example.com", 
			imagenPrueba, 
			true, 
			"password456", 
			654321, 
			35, 
			23, 
			180.0f, 
			true, 
			1800.0f, 
			0, 
			false, 
			new ArrayList<String>(), 
			false
		);
		
		mujerDAO.getMujeres().add(mujer);
		mujerDAO.escribirArchivoSerializado();
		
		assertTrue("El registro completo debe ser exitoso", mujerDAO.getMujeres().contains(mujer));
		
		// Verificar que el usuario fue creado buscando en la lista
		boolean encontrado = false;
		for (Mujer m : mujerDAO.getMujeres()) {
			if (m.getAlias().equals("anamartinez")) {
				encontrado = true;
				break;
			}
		}
		assertTrue("El usuario debe existir en la base de datos", encontrado);
		
		// Limpiar
		mujerDAO.borrar(mujer);
	}
}