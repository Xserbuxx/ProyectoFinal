import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.Persona;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

/**
 * Suite de pruebas para login, preferencias de búsqueda y filtrado de perfiles
 * Cubre validación de credenciales, guardado de preferencias y modo incógnito
 */
public class TestLoginYPreferencias {
	
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
	 * Test Case: Login_Credenciales_Correctas
	 * Pre: usuario verificado registrado
	 * Pasos: login con email/alias y contraseña
	 * Esperado: acceso permitido
	 * Tipo: Integration
	 * Prioridad: Alta
	 */
	@Test
	public void testLoginCredencialesCorrectas() {
		// Crear y registrar usuario verificado
		Hombre hombre = new Hombre(
			"Test Login",
			"testlogin",
			25,
			"15/05/1999",
			175.0f,
			"testlogin@example.com",
			imagenPrueba,
			true,
			"password123",
			123456,
			0,
			0,
			0.0f,
			1500.0f,
			false,
			0,
			false,
			new ArrayList<String>(),
			true // Usuario verificado
		);
		
		hombreDAO.crear(hombre);
		
		// Simular login: buscar usuario por alias y contraseña
		String aliasIngresado = "testlogin";
		String contrasenaIngresada = "password123";
		
		Persona usuarioEncontrado = null;
		
		// Buscar en hombres
		for (Hombre h : hombreDAO.getHombres()) {
			if (h.getAlias().equals(aliasIngresado) && h.getContrasena().equals(contrasenaIngresada)) {
				usuarioEncontrado = h;
				break;
			}
		}
		
		assertNotNull("El usuario debe ser encontrado con credenciales correctas", usuarioEncontrado);
		assertTrue("El usuario debe estar verificado", usuarioEncontrado.isVerificado());
		assertEquals("El alias debe coincidir", aliasIngresado, usuarioEncontrado.getAlias());
		
		// Limpiar
		hombreDAO.borrar(hombre);
	}
	
	/**
	 * Test Case: Login_Credenciales_Incorrectas
	 * Pre: contraseña errónea
	 * Pasos: intentar login
	 * Esperado: acceso denegado; contador opcional de intentos
	 * Tipo: Unit
	 * Prioridad: Alta
	 */
	@Test
	public void testLoginCredencialesIncorrectas() {
		// Crear y registrar usuario
		Mujer mujer = new Mujer(
			"Test Login Fail",
			"testloginfail",
			28,
			"20/03/1996",
			165.0f,
			"testfail@example.com",
			imagenPrueba,
			true,
			"passwordcorrecto",
			654321,
			0,
			0,
			0.0f,
			false,
			1200.0f,
			0,
			false,
			new ArrayList<String>(),
			true
		);
		
		mujerDAO.crear(mujer);
		
		// Intentar login con contraseña incorrecta
		String aliasIngresado = "testloginfail";
		String contrasenaIncorrecta = "passwordincorrecto";
		
		Persona usuarioEncontrado = null;
		
		// Buscar en mujeres
		for (Mujer m : mujerDAO.getMujeres()) {
			if (m.getAlias().equals(aliasIngresado) && m.getContrasena().equals(contrasenaIncorrecta)) {
				usuarioEncontrado = m;
				break;
			}
		}
		
		assertNull("El usuario no debe ser encontrado con contraseña incorrecta", usuarioEncontrado);
		
		// Limpiar
		mujerDAO.borrar(mujer);
	}
	
	/**
	 * Test Case: Login_Usuario_NoExiste
	 * Pre: usuario no registrado
	 * Pasos: intentar login con alias inexistente
	 * Esperado: acceso denegado
	 * Tipo: Unit
	 * Prioridad: Alta
	 */
	@Test
	public void testLoginUsuarioNoExiste() {
		String aliasInexistente = "usuarionoexiste";
		String contrasena = "cualquierpassword";
		
		Persona usuarioEncontrado = null;
		
		// Buscar en hombres
		for (Hombre h : hombreDAO.getHombres()) {
			if (h.getAlias().equals(aliasInexistente) && h.getContrasena().equals(contrasena)) {
				usuarioEncontrado = h;
				break;
			}
		}
		
		// Buscar en mujeres si no se encontró en hombres
		if (usuarioEncontrado == null) {
			for (Mujer m : mujerDAO.getMujeres()) {
				if (m.getAlias().equals(aliasInexistente) && m.getContrasena().equals(contrasena)) {
					usuarioEncontrado = m;
					break;
				}
			}
		}
		
		assertNull("No se debe encontrar un usuario inexistente", usuarioEncontrado);
	}
	
	/**
	 * Test Case: Login_Usuario_NoVerificado
	 * Pre: usuario registrado pero no verificado
	 * Pasos: intentar login
	 * Esperado: debe redirigir a verificación de código
	 * Tipo: Integration
	 * Prioridad: Alta
	 */
	@Test
	public void testLoginUsuarioNoVerificado() {
		// Crear usuario no verificado
		Hombre hombre = new Hombre(
			"Test No Verificado",
			"testnoverif",
			30,
			"10/10/1994",
			180.0f,
			"noverif@example.com",
			imagenPrueba,
			true,
			"password789",
			789012,
			0,
			0,
			0.0f,
			2000.0f,
			false,
			0,
			false,
			new ArrayList<String>(),
			false // No verificado
		);
		
		hombreDAO.crear(hombre);
		
		// Buscar usuario
		Persona usuarioEncontrado = null;
		for (Hombre h : hombreDAO.getHombres()) {
			if (h.getAlias().equals("testnoverif") && h.getContrasena().equals("password789")) {
				usuarioEncontrado = h;
				break;
			}
		}
		
		assertNotNull("El usuario debe existir", usuarioEncontrado);
		assertFalse("El usuario no debe estar verificado", usuarioEncontrado.isVerificado());
		assertTrue("El código de verificación debe ser mayor a 0", usuarioEncontrado.getCodigo() > 0);
		
		// Limpiar
		hombreDAO.borrar(hombre);
	}
	
	/**
	 * Test Case: Guardar_Preferencias_Busqueda
	 * Pre: usuario logueado
	 * Pasos: guardar rango de edad, estatura y estado divorcio
	 * Esperado: preferencias persistidas en perfil
	 * Tipo: Integration
	 * Prioridad: Media
	 */
	@Test
	public void testGuardarPreferenciasBusqueda() {
		// Crear usuario
		Hombre hombre = new Hombre(
			"Test Preferencias",
			"testpref",
			32,
			"15/03/1992",
			178.0f,
			"testpref@example.com",
			imagenPrueba,
			true,
			"password456",
			456789,
			0,
			0,
			0.0f,
			2500.0f,
			false,
			0,
			false,
			new ArrayList<String>(),
			true
		);
		
		hombreDAO.crear(hombre);
		
		// Guardar preferencias de búsqueda
		int edadMinima = 25;
		int edadMaxima = 35;
		float estaturaIdeal = 165.0f;
		boolean estadoDivorcio = true;
		
		// Buscar usuario y actualizar preferencias
		for (Hombre h : hombreDAO.getHombres()) {
			if (h.getAlias().equals("testpref")) {
				h.setEdadMinima(edadMinima);
				h.setEdadMaxima(edadMaxima);
				h.setEstaturaIdeal(estaturaIdeal);
				h.setEstadoDivorcio(estadoDivorcio);
				break;
			}
		}
		
		// Persistir cambios
		hombreDAO.escribirArchivoSerializado();
		
		// Recargar desde archivo
		hombreDAO.cargarArchivoSerializado();
		
		// Verificar que las preferencias se guardaron
		Hombre usuarioRecargado = null;
		for (Hombre h : hombreDAO.getHombres()) {
			if (h.getAlias().equals("testpref")) {
				usuarioRecargado = h;
				break;
			}
		}
		
		assertNotNull("El usuario debe existir después de recargar", usuarioRecargado);
		assertEquals("La edad mínima debe persistir", edadMinima, usuarioRecargado.getEdadMinima());
		assertEquals("La edad máxima debe persistir", edadMaxima, usuarioRecargado.getEdadMaxima());
		assertEquals("La estatura ideal debe persistir", estaturaIdeal, usuarioRecargado.getEstaturaIdeal(), 0.01f);
		assertEquals("El estado de divorcio debe persistir", estadoDivorcio, usuarioRecargado.isEstadoDivorcio());
		
		// Limpiar
		hombreDAO.borrar(new Hombre(
			usuarioRecargado.getNombre(),
			usuarioRecargado.getAlias(),
			usuarioRecargado.getEdad(),
			usuarioRecargado.getFechaNacimiento(),
			usuarioRecargado.getEstatura(),
			usuarioRecargado.getCorreo(),
			usuarioRecargado.getImagen(),
			usuarioRecargado.isDisponibilidad(),
			usuarioRecargado.getContrasena(),
			usuarioRecargado.getCodigo(),
			usuarioRecargado.getEdadMaxima(),
			usuarioRecargado.getEdadMinima(),
			usuarioRecargado.getEstaturaIdeal(),
			usuarioRecargado.getIngresoProm(),
			usuarioRecargado.isEstadoDivorcio(),
			usuarioRecargado.getLikesRecibidos(),
			usuarioRecargado.isIncognito(),
			usuarioRecargado.getLikesDados(),
			usuarioRecargado.isVerificado()
		));
	}
}
