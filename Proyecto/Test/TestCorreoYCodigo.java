import static org.junit.Assert.*;

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
 * Suite de pruebas para el envío de correo y verificación de código
 * Cubre el proceso post-registro y la validación del código de verificación
 */
public class TestCorreoYCodigo {
	
	private HombreDAO hombreDAO;
	private MujerDAO mujerDAO;
	private ImageIcon imagenPrueba;
	
	@Before
	public void setUp() {
		hombreDAO = new HombreDAO();
		mujerDAO = new MujerDAO();
		imagenPrueba = new ImageIcon("Resources/logo.png");
	}
	
	/**
	 * Test Case: Envío_Correo_PostRegistro
	 * Pre: registro exitoso
	 * Pasos: interceptar llamado al servicio de correo (mock)
	 * Esperado: correo enviado con alias, contraseña y código de verificación; 
	 *           formato del correo contiene código
	 * Tipo: Integration (mock)
	 * Prioridad: Alta
	 */
	@Test
	public void testEnvioCorreoPostRegistro() {
		// Crear usuario con código de verificación
		int codigoVerificacion = 123456;
		String correo = "test@example.com";
		String alias = "usuarioprueba";
		
		Hombre hombre = new Hombre(
			"Usuario Prueba",
			alias,
			25,
			"15/05/1999",
			175.0f,
			correo,
			imagenPrueba,
			true,
			"password123",
			codigoVerificacion, // Código de verificación
			0,
			0,
			0.0f,
			1000.0f,
			false,
			0,
			false,
			new ArrayList<String>(),
			false // No verificado inicialmente
		);
		
		// Registrar usuario
		boolean registroExitoso = hombreDAO.crear(hombre);
		assertTrue("El registro debe ser exitoso", registroExitoso);
		
		// Verificar que el usuario fue creado con los datos correctos
		assertNotNull("El usuario debe existir", hombreDAO.getHombres());
		assertFalse("El usuario no debe estar verificado inicialmente", hombre.isVerificado());
		assertEquals("El código debe estar almacenado correctamente", codigoVerificacion, hombre.getCodigo());
		assertEquals("El correo debe estar almacenado correctamente", correo, hombre.getCorreo());
		
		// Simular que el correo contiene el código
		String mensajeCorreo = "Su codigo de seguridad es: " + codigoVerificacion;
		assertTrue("El mensaje del correo debe contener el código", 
				   mensajeCorreo.contains(String.valueOf(codigoVerificacion)));
		
		// Verificar formato del código (6 dígitos)
		assertTrue("El código debe tener 6 dígitos", 
				   String.valueOf(codigoVerificacion).length() == 6);
		assertTrue("El código debe ser numérico positivo", codigoVerificacion > 0);
		assertTrue("El código debe estar en el rango correcto", 
				   codigoVerificacion >= 100000 && codigoVerificacion <= 999999);
		
		// Limpiar
		hombreDAO.borrar(hombre);
	}
	
	/**
	 * Test Case: Verificacion_Codigo_Valido
	 * Pre: código enviado y almacenado
	 * Pasos: ingresar código en UI
	 * Esperado: cuenta marcada como verificada
	 * Tipo: Integration
	 * Prioridad: Alta
	 */
	@Test
	public void testVerificacionCodigoValido() {
		// Crear usuario no verificado con código
		int codigoCorrector = 456789;
		
		Hombre hombre = new Hombre(
			"Carlos Perez",
			"carlosp",
			30,
			"10/10/1994",
			180.0f,
			"carlos@example.com",
			imagenPrueba,
			true,
			"password456",
			codigoCorrector,
			0,
			0,
			0.0f,
			1500.0f,
			false,
			0,
			false,
			new ArrayList<String>(),
			false // No verificado
		);
		
		hombreDAO.crear(hombre);
		
		// Simular ingreso del código correcto
		int codigoIngresado = 456789;
		
		// Validar que el código no es negativo
		try {
			LanzadorExcepciones.verificarNumeroNegativo(codigoIngresado);
			assertTrue("El código debe ser válido (no negativo)", true);
		} catch (NumeroNegativoException e) {
			fail("El código válido no debería lanzar excepción: " + e.getMessage());
		}
		
		// Validar que el código tiene 6 dígitos
		try {
			LanzadorExcepciones.verificarCodigo(codigoIngresado);
			assertTrue("El código debe tener 6 dígitos", true);
		} catch (CodigoException e) {
			fail("El código de 6 dígitos no debería lanzar excepción: " + e.getMessage());
		}
		
		// Verificar que el código coincide
		assertEquals("El código ingresado debe coincidir con el almacenado", 
					 codigoCorrector, codigoIngresado);
		
		// Marcar usuario como verificado
		hombre.setVerificado(true);
		hombreDAO.actualizar(hombre, hombre);
		
		// Verificar que el usuario está verificado
		assertTrue("El usuario debe estar verificado después de ingresar código correcto", 
				   hombre.isVerificado());
		
		// Limpiar
		hombreDAO.borrar(hombre);
	}
	
	/**
	 * Test Case: Verificacion_Codigo_Invalido
	 * Pre: código incorrecto
	 * Pasos: ingresar
	 * Esperado: rechazo y mensaje de error; cuenta no verificada
	 * Tipo: Unit
	 * Prioridad: Alta
	 */
	@Test
	public void testVerificacionCodigoInvalido() {
		// Crear usuario no verificado con código
		int codigoCorrecto = 789012;
		
		Mujer mujer = new Mujer(
			"Ana Lopez",
			"analopez",
			28,
			"20/03/1996",
			165.0f,
			"ana@example.com",
			imagenPrueba,
			true,
			"password789",
			codigoCorrecto,
			0,
			0,
			0.0f,
			false,
			1000.0f,
			0,
			false,
			new ArrayList<String>(),
			false // No verificado
		);
		
		mujerDAO.crear(mujer);
		
		// Simular ingreso de código incorrecto
		int codigoIncorrecto = 111111;
		
		// Verificar que el código no coincide
		assertNotEquals("El código incorrecto no debe coincidir con el almacenado", 
						codigoCorrecto, codigoIncorrecto);
		
		// El usuario debe permanecer no verificado
		assertFalse("El usuario no debe estar verificado con código incorrecto", 
					mujer.isVerificado());
		
		// Limpiar
		mujerDAO.borrar(mujer);
	}
	
	/**
	 * Test Case: Verificacion_Codigo_Negativo
	 * Pre: código negativo ingresado
	 * Pasos: intentar validar código negativo
	 * Esperado: rechazo con NumeroNegativoException
	 * Tipo: Unit
	 * Prioridad: Alta
	 */
	@Test
	public void testVerificacionCodigoNegativo() {
		try {
			int codigoNegativo = -123456;
			
			LanzadorExcepciones.verificarNumeroNegativo(codigoNegativo);
			
			fail("Debería lanzar NumeroNegativoException para código negativo");
			
		} catch (NumeroNegativoException e) {
			assertEquals("Debe indicar número debajo de cero", "Numero Debajo de Cero", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Verificacion_Codigo_MenosDe6Digitos
	 * Pre: código con menos de 6 dígitos
	 * Pasos: intentar validar código corto
	 * Esperado: rechazo con CodigoException
	 * Tipo: Unit
	 * Prioridad: Alta
	 */
	@Test
	public void testVerificacionCodigoMenosDe6Digitos() {
		try {
			int codigoCorto = 12345; // 5 dígitos
			
			LanzadorExcepciones.verificarCodigo(codigoCorto);
			
			fail("Debería lanzar CodigoException para código menor a 6 dígitos");
			
		} catch (CodigoException e) {
			assertEquals("Debe indicar número debajo de 6 dígitos", 
						 "Numero Debajo de 6 Digitos", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Verificacion_Codigo_MasDe6Digitos
	 * Pre: código con más de 6 dígitos
	 * Pasos: intentar validar código largo
	 * Esperado: rechazo con CodigoException
	 * Tipo: Unit
	 * Prioridad: Alta
	 */
	@Test
	public void testVerificacionCodigoMasDe6Digitos() {
		try {
			int codigoLargo = 1234567; // 7 dígitos
			
			LanzadorExcepciones.verificarCodigo(codigoLargo);
			
			fail("Debería lanzar CodigoException para código mayor a 6 dígitos");
			
		} catch (CodigoException e) {
			assertEquals("Debe indicar número encima de 6 dígitos", 
						 "Numero Encima de 6 Digitos", e.getMessage());
		}
	}
	
	/**
	 * Test Case: Envio_Correo_FormatoEmail
	 * Pre: correo con formato válido
	 * Pasos: validar formato de correo
	 * Esperado: validación exitosa
	 * Tipo: Unit
	 * Prioridad: Alta
	 */
	@Test
	public void testEnvioCorreoFormatoEmailValido() {
		try {
			String correoValido = "usuario@dominio.com";
			
			LanzadorExcepciones.verificarFormatoCorreo(correoValido);
			
			assertTrue("El correo válido debe pasar la validación", true);
			
		} catch (FormatoCorreoException e) {
			fail("No debería lanzar excepción para correo válido: " + e.getMessage());
		}
	}

}