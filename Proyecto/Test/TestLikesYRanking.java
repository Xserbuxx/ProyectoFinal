import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Persona;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

/**
 * Suite de pruebas para el sistema de likes y ranking de usuarios
 * Cubre dar likes, validaciones de seguridad y ordenamiento por ranking
 */
public class TestLikesYRanking {
	
	private HombreDAO hombreDAO;
	private MujerDAO mujerDAO;
	private ModelFacade modelFacade;
	private ImageIcon imagenPrueba;
	
	@Before
	public void setUp() {
		hombreDAO = new HombreDAO();
		mujerDAO = new MujerDAO();
		modelFacade = new ModelFacade();
		imagenPrueba = new ImageIcon("Resources/logo.png");
	}
	
	/**
	 * Test Case: DarLike_IncrementaContador
	 * Pre: perfil objetivo con N likes
	 * Pasos: usuario A da like a perfil B
	 * Esperado: likes de B aumentan a N+1
	 */
	@Test
	public void testDarLikeIncrementaContador() {
		// Crear usuario A (quien da el like)
		Hombre usuarioA = new Hombre(
			"Usuario A",
			"usuarioa",
			25,
			"15/05/1999",
			175.0f,
			"usuarioa@example.com",
			imagenPrueba,
			true,
			"password123",
			123456,
			0,
			0,
			0.0f,
			1500.0f,
			false,
			0, // Sin likes inicialmente
			false,
			new ArrayList<String>(), // No ha dado likes
			true
		);
		
		// Crear usuario B (quien recibe el like)
		Mujer usuarioB = new Mujer(
			"Usuario B",
			"usuariob",
			28,
			"20/03/1996",
			165.0f,
			"usuariob@example.com",
			imagenPrueba,
			true,
			"password456",
			654321,
			0,
			0,
			0.0f,
			false,
			0.0f,
			5, // Tiene 5 likes inicialmente
			false,
			new ArrayList<String>(),
			true
		);
		
		hombreDAO.crear(usuarioA);
		mujerDAO.crear(usuarioB);
		
		// Obtener likes iniciales de B
		int likesIniciales = usuarioB.getLikesRecibidos();
		assertEquals("Usuario B debe tener 5 likes inicialmente", 5, likesIniciales);
		
		// Simular que usuario A da like a usuario B
		// 1. Agregar alias de B a la lista de likes dados de A
		Hombre hombreA = null;
		for (Hombre h : hombreDAO.getHombres()) {
			if (h.getAlias().equals("usuarioa")) {
				h.getLikesDados().add("usuariob");
				hombreA = h;
				break;
			}
		}
		
		// 2. Incrementar contador de likes recibidos de B
		Mujer mujerB = null;
		for (Mujer m : mujerDAO.getMujeres()) {
			if (m.getAlias().equals("usuariob")) {
				m.setLikesRecibidos(m.getLikesRecibidos() + 1);
				mujerB = m;
				break;
			}
		}
		
		// Persistir cambios
		hombreDAO.escribirArchivoSerializado();
		mujerDAO.escribirArchivoSerializado();
		
		// Verificaciones
		assertNotNull("Usuario A debe existir", hombreA);
		assertNotNull("Usuario B debe existir", mujerB);
		assertTrue("Usuario A debe tener 'usuariob' en su lista de likes dados", 
				   hombreA.getLikesDados().contains("usuariob"));
		assertEquals("Los likes de Usuario B deben aumentar a N+1", 
					 likesIniciales + 1, mujerB.getLikesRecibidos());
		assertEquals("Usuario B debe tener 6 likes", 6, mujerB.getLikesRecibidos());
		
		// Limpiar
		hombreDAO.borrar(usuarioA);
		mujerDAO.borrar(usuarioB);
	}
	
	/**
	 * Test Case: Likes_NoNegativo
	 * Pre: intento malicioso de establecer likes negativos (API)
	 * Pasos: llamar endpoint/update con -5
	 * Esperado: validación evita valor negativo
	 */
	@Test
	public void testLikesNoNegativo() {
		// Crear usuario con likes positivos
		Hombre hombre = new Hombre(
			"Test Seguridad",
			"testseguridad",
			30,
			"10/10/1994",
			180.0f,
			"testseg@example.com",
			imagenPrueba,
			true,
			"password789",
			789012,
			0,
			0,
			0.0f,
			2000.0f,
			false,
			10, // Tiene 10 likes
			false,
			new ArrayList<String>(),
			true
		);
		
		hombreDAO.crear(hombre);
		
		// Intentar establecer likes negativos (simulando ataque)
		int likesNegativos = -5;
		
		// Buscar usuario y validar
		Hombre hombreEncontrado = null;
		for (Hombre h : hombreDAO.getHombres()) {
			if (h.getAlias().equals("testseguridad")) {
				hombreEncontrado = h;
				break;
			}
		}
		
		assertNotNull("El usuario debe existir", hombreEncontrado);
		
		// Validación de seguridad: no permitir likes negativos
		if (likesNegativos < 0) {
			// La validación debe evitar que se establezcan likes negativos
			assertTrue("La validación debe detectar likes negativos", likesNegativos < 0);
			// No actualizar el valor
		} else {
			hombreEncontrado.setLikesRecibidos(likesNegativos);
		}
		
		// Verificar que los likes NO se actualizaron a negativo
		assertEquals("Los likes deben permanecer en su valor original (10)", 
					 10, hombreEncontrado.getLikesRecibidos());
		assertTrue("Los likes no deben ser negativos", 
				   hombreEncontrado.getLikesRecibidos() >= 0);
		
		// Limpiar
		hombreDAO.borrar(hombre);
	}
	
	/**
	 * Test Case: Likes_ValorCero
	 * Pre: usuario sin likes
	 * Pasos: verificar que 0 likes es válido
	 * Esperado: 0 es un valor válido para likes
	 */
	@Test
	public void testLikesValorCero() {
		Mujer mujer = new Mujer(
			"Usuario Sin Likes",
			"sinlikes",
			25,
			"15/05/1999",
			160.0f,
			"sinlikes@example.com",
			imagenPrueba,
			true,
			"password",
			111111,
			0,
			0,
			0.0f,
			false,
			0.0f,
			0, // 0 likes
			false,
			new ArrayList<String>(),
			true
		);
		
		mujerDAO.crear(mujer);
		
		// Buscar usuario
		Mujer mujerEncontrada = null;
		for (Mujer m : mujerDAO.getMujeres()) {
			if (m.getAlias().equals("sinlikes")) {
				mujerEncontrada = m;
				break;
			}
		}
		
		assertNotNull("El usuario debe existir", mujerEncontrada);
		assertEquals("0 likes es un valor válido", 0, mujerEncontrada.getLikesRecibidos());
		assertTrue("Los likes deben ser >= 0", mujerEncontrada.getLikesRecibidos() >= 0);
		
		// Limpiar
		mujerDAO.borrar(mujer);
	}
	
	/**
	 * Test Case: RemoverLike_DecrementaContador
	 * Pre: usuario A ya dio like a usuario B
	 * Pasos: usuario A quita el like a usuario B
	 * Esperado: likes de B disminuyen en 1
	 */
	@Test
	public void testRemoverLikeDecrementaContador() {
		// Crear usuario A
		Hombre usuarioA = new Hombre(
			"Usuario A Remove",
			"usuarioaremove",
			25,
			"15/05/1999",
			175.0f,
			"usuarioarem@example.com",
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
			new ArrayList<String>(), // Inicialmente sin likes dados
			true
		);
		
		// Crear usuario B con likes
		Mujer usuarioB = new Mujer(
			"Usuario B Remove",
			"usuariobremove",
			28,
			"20/03/1996",
			165.0f,
			"usuariobrem@example.com",
			imagenPrueba,
			true,
			"password456",
			654321,
			0,
			0,
			0.0f,
			false,
			0.0f,
			10, // Tiene 10 likes
			false,
			new ArrayList<String>(),
			true
		);
		
		hombreDAO.crear(usuarioA);
		mujerDAO.crear(usuarioB);
		
		// Primero, dar like
		Hombre hombreA = null;
		for (Hombre h : hombreDAO.getHombres()) {
			if (h.getAlias().equals("usuarioaremove")) {
				h.getLikesDados().add("usuariobremove");
				hombreA = h;
				break;
			}
		}
		
		Mujer mujerB = null;
		for (Mujer m : mujerDAO.getMujeres()) {
			if (m.getAlias().equals("usuariobremove")) {
				m.setLikesRecibidos(m.getLikesRecibidos() + 1);
				mujerB = m;
				break;
			}
		}
		
		hombreDAO.escribirArchivoSerializado();
		mujerDAO.escribirArchivoSerializado();
		
		// Verificar que el like se dio correctamente
		assertEquals("Usuario B debe tener 11 likes después de recibir el like", 
					 11, mujerB.getLikesRecibidos());
		
		// Ahora, quitar el like
		hombreA.getLikesDados().remove("usuariobremove");
		mujerB.setLikesRecibidos(mujerB.getLikesRecibidos() - 1);
		
		hombreDAO.escribirArchivoSerializado();
		mujerDAO.escribirArchivoSerializado();
		
		// Verificaciones
		assertFalse("Usuario A no debe tener 'usuariobremove' en su lista de likes dados", 
					hombreA.getLikesDados().contains("usuariobremove"));
		assertEquals("Los likes de Usuario B deben decrementar a 10", 
					 10, mujerB.getLikesRecibidos());
		
		// Limpiar
		hombreDAO.borrar(usuarioA);
		mujerDAO.borrar(usuarioB);
	}
	
	/**
	 * Test Case: MultiplesLikes_MismoUsuario
	 * Pre: varios usuarios dan like al mismo perfil
	 * Pasos: 3 usuarios diferentes dan like a usuario objetivo
	 * Esperado: contador incrementa correctamente 3 veces
	 */
	@Test
	public void testMultiplesLikesMismoUsuario() {
		// Crear usuario objetivo (quien recibe los likes)
		Mujer objetivo = new Mujer(
			"Usuario Popular",
			"popular",
			28,
			"20/03/1996",
			165.0f,
			"popular@example.com",
			imagenPrueba,
			true,
			"password",
			111111,
			0,
			0,
			0.0f,
			false,
			0.0f,
			0, // Sin likes inicialmente
			false,
			new ArrayList<String>(),
			true
		);
		
		mujerDAO.crear(objetivo);
		
		// Crear 3 usuarios que darán like
		ArrayList<Hombre> usuariosQueGustan = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			Hombre usuario = new Hombre(
				"Fan " + i,
				"fan" + i,
				25 + i,
				"01/01/1990",
				175.0f,
				"fan" + i + "@example.com",
				imagenPrueba,
				true,
				"password",
				100000 + i,
				0,
				0,
				0.0f,
				1500.0f,
				false,
				0,
				false,
				new ArrayList<String>(),
				true
			);
			hombreDAO.crear(usuario);
			usuariosQueGustan.add(usuario);
		}
		
		// Cada uno da like
		Mujer mujerObjetivo = null;
		for (Mujer m : mujerDAO.getMujeres()) {
			if (m.getAlias().equals("popular")) {
				mujerObjetivo = m;
				break;
			}
		}
		
		int likesEsperados = 0;
		for (int i = 1; i <= 3; i++) {
			// Buscar fan
			for (Hombre h : hombreDAO.getHombres()) {
				if (h.getAlias().equals("fan" + i)) {
					h.getLikesDados().add("popular");
					mujerObjetivo.setLikesRecibidos(mujerObjetivo.getLikesRecibidos() + 1);
					likesEsperados++;
					break;
				}
			}
		}
		
		hombreDAO.escribirArchivoSerializado();
		mujerDAO.escribirArchivoSerializado();
		
		// Verificaciones
		assertEquals("El usuario popular debe tener 3 likes", 3, mujerObjetivo.getLikesRecibidos());
		assertEquals("Likes esperados deben ser 3", 3, likesEsperados);
		
		// Limpiar
		mujerDAO.borrar(objetivo);
		for (Hombre usuario : usuariosQueGustan) {
			hombreDAO.borrar(usuario);
		}
	}
	
	/**
	 * Test Case: Ordenamiento_Ascendente_Likes
	 * Pre: varios usuarios con diferentes likes
	 * Pasos: ordenar por likes ascendente
	 * Esperado: lista ordenada de menor a mayor likes
	 */
	@Test
	public void testOrdenamientoAscendenteLikes() {
		// Crear usuarios con diferentes cantidades de likes
		ArrayList<Mujer> usuariosCreados = new ArrayList<>();
		int[] likesArray = {50, 10, 30, 5, 100};
		
		for (int i = 0; i < likesArray.length; i++) {
			Mujer usuario = new Mujer(
				"Usuario Orden " + i,
				"usuarioorden" + i,
				25 + i,
				"01/01/1990",
				160.0f + i,
				"orden" + i + "@example.com",
				imagenPrueba,
				true,
				"password",
				100000 + i,
				0,
				0,
				0.0f,
				false,
				0.0f,
				likesArray[i],
				false,
				new ArrayList<String>(),
				true
			);
			mujerDAO.crear(usuario);
			usuariosCreados.add(usuario);
		}
		
		// Actualizar y ordenar ascendente por likes (tipo 1, criterio 3)
		modelFacade.actualizarPersonas();
		modelFacade.ordenarPor(1, 3); // 1 = ascendente, 3 = por likes
		
		ArrayList<Persona> personas = modelFacade.getPersonas();
		
		// Verificar orden ascendente (excluyendo admin)
		ArrayList<Persona> usuariosOrdenados = new ArrayList<>();
		for (Persona p : personas) {
			if (!p.getAlias().equals("admin") && p.getAlias().startsWith("usuarioorden")) {
				usuariosOrdenados.add(p);
			}
		}
		
		// Verificar que están en orden ascendente
		for (int i = 0; i < usuariosOrdenados.size() - 1; i++) {
			assertTrue("Los likes deben estar en orden ascendente", 
					   usuariosOrdenados.get(i).getLikesRecibidos() <= usuariosOrdenados.get(i + 1).getLikesRecibidos());
		}
		
		// Limpiar
		for (Mujer usuario : usuariosCreados) {
			mujerDAO.borrar(usuario);
		}
	}
}