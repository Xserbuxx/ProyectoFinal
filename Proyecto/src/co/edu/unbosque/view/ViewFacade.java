package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * Clase fachada que gestiona todas las vistas de la aplicación.
 * Implementa el patrón de diseño Facade para simplificar el acceso
 * y la gestión de los diferentes paneles de la interfaz gráfica.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class ViewFacade {
	
	/** Ventana principal de la aplicación */
	private VentanaPrincipal ventanaPrincipal;
	
	/** Panel contenedor que utiliza CardLayout para cambiar entre vistas */
	private JPanel paneles;
	
	/** Gestor de diseño CardLayout para intercambiar paneles */
	private CardLayout cl;
	
	/** Panel de selección de idioma */
	private Idioma idm;
	
	/** Panel de inicio de sesión */
	private InicioSesion is;
	
	/** Panel de registro de usuario */
	private Registro reg;
	
	/** Panel de verificación de código */
	private VerificarCodigo vc;
	
	/** Panel de selección de gustos del usuario */
	private SeleccionGustos sg;
	
	/** Panel principal de la aplicación */
	private Aplicacion app;
	
	/** Panel de perfil de usuario */
	private Perfil per;
	
	/** Panel de administración */
	private Administrador admin;
	
	/** Panel de información de usuario */
	private InfoUsuario infoUsuario;
	
	/** Panel de confirmación de baja de cuenta */
	private ConfirmarBaja confirmarBaja;
	
	/**
	 * Constructor que inicializa la fachada de vistas.
	 * Crea e inicializa todos los paneles de la aplicación y los
	 * agrega al CardLayout con sus respectivos identificadores.
	 */
	public ViewFacade() {
		ventanaPrincipal = new VentanaPrincipal();
		cl = new CardLayout();
		paneles = new JPanel();
		
		paneles.setLayout(cl);
		
		idm = new Idioma();
		is = new InicioSesion();
		reg = new Registro();
		vc = new VerificarCodigo();
		sg = new SeleccionGustos();
		app = new Aplicacion();
		per = new Perfil();
		admin = new Administrador();
		infoUsuario = new InfoUsuario();
		confirmarBaja = new ConfirmarBaja();
		
		paneles.add(idm, "idioma");
		paneles.add(is, "inicioSesion");
		paneles.add(reg, "registro");
		paneles.add(vc, "verificarCodigo");
		paneles.add(sg, "seleccionGustos");
		paneles.add(app, "aplicacion");
		paneles.add(per, "perfil");
		paneles.add(admin, "administrador");
		paneles.add(infoUsuario, "infoUsuario");
		
		ventanaPrincipal.add(paneles);
	}
	
	/**
	 * Cambia el modo visual (claro/oscuro) de todos los paneles que
	 * soportan esta funcionalidad.
	 */
	public void cambiarModo() {
		app.cambiarModo();
		per.cambiarModo();
		admin.cambiarModo();
		confirmarBaja.cambiarModo();
		infoUsuario.cambiarModo();
		is.cambiarModo();
		reg.cambiarModo();
		vc.cambiarModo();
		sg.cambiarModo();
	}
	
	/**
	 * Muestra el panel especificado utilizando CardLayout.
	 * 
	 * @param panel Identificador del panel a mostrar
	 */
	public void mostrarPanel(String panel) {
		cl.show(paneles, panel);
	}

	/**
	 * Obtiene la ventana principal de la aplicación.
	 * 
	 * @return VentanaPrincipal instancia de la ventana principal
	 */
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	/**
	 * Establece la ventana principal de la aplicación.
	 * 
	 * @param ventanaPrincipal Nueva instancia de VentanaPrincipal
	 */
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	/**
	 * Obtiene el panel de selección de idioma.
	 * 
	 * @return Idioma instancia del panel de idioma
	 */
	public Idioma getIdm() {
		return idm;
	}

	/**
	 * Establece el panel de selección de idioma.
	 * 
	 * @param idm Nueva instancia de Idioma
	 */
	public void setIdm(Idioma idm) {
		this.idm = idm;
	}

	/**
	 * Obtiene el panel contenedor principal.
	 * 
	 * @return JPanel contenedor de todos los paneles
	 */
	public JPanel getPaneles() {
		return paneles;
	}

	/**
	 * Establece el panel contenedor principal.
	 * 
	 * @param paneles Nuevo JPanel contenedor
	 */
	public void setPaneles(JPanel paneles) {
		this.paneles = paneles;
	}

	/**
	 * Obtiene el gestor CardLayout.
	 * 
	 * @return CardLayout gestor de diseño
	 */
	public CardLayout getCl() {
		return cl;
	}

	/**
	 * Establece el gestor CardLayout.
	 * 
	 * @param cl Nuevo CardLayout
	 */
	public void setCl(CardLayout cl) {
		this.cl = cl;
	}

	/**
	 * Obtiene el panel de inicio de sesión.
	 * 
	 * @return InicioSesion instancia del panel de inicio de sesión
	 */
	public InicioSesion getIs() {
		return is;
	}

	/**
	 * Establece el panel de inicio de sesión.
	 * 
	 * @param is Nueva instancia de InicioSesion
	 */
	public void setIs(InicioSesion is) {
		this.is = is;
	}

	/**
	 * Obtiene el panel de registro.
	 * 
	 * @return Registro instancia del panel de registro
	 */
	public Registro getReg() {
		return reg;
	}

	/**
	 * Establece el panel de registro.
	 * 
	 * @param reg Nueva instancia de Registro
	 */
	public void setReg(Registro reg) {
		this.reg = reg;
	}

	/**
	 * Obtiene el panel de verificación de código.
	 * 
	 * @return VerificarCodigo instancia del panel de verificación
	 */
	public VerificarCodigo getVc() {
		return vc;
	}

	/**
	 * Establece el panel de verificación de código.
	 * 
	 * @param vc Nueva instancia de VerificarCodigo
	 */
	public void setVc(VerificarCodigo vc) {
		this.vc = vc;
	}

	/**
	 * Obtiene el panel de selección de gustos.
	 * 
	 * @return SeleccionGustos instancia del panel de selección de gustos
	 */
	public SeleccionGustos getSg() {
		return sg;
	}

	/**
	 * Establece el panel de selección de gustos.
	 * 
	 * @param sg Nueva instancia de SeleccionGustos
	 */
	public void setSg(SeleccionGustos sg) {
		this.sg = sg;
	}

	/**
	 * Obtiene el panel principal de la aplicación.
	 * 
	 * @return Aplicacion instancia del panel principal
	 */
	public Aplicacion getApp() {
		return app;
	}

	/**
	 * Establece el panel principal de la aplicación.
	 * 
	 * @param app Nueva instancia de Aplicacion
	 */
	public void setApp(Aplicacion app) {
		this.app = app;
	}

	/**
	 * Obtiene el panel de perfil de usuario.
	 * 
	 * @return Perfil instancia del panel de perfil
	 */
	public Perfil getPer() {
		return per;
	}

	/**
	 * Establece el panel de perfil de usuario.
	 * 
	 * @param per Nueva instancia de Perfil
	 */
	public void setPer(Perfil per) {
		this.per = per;
	}

	/**
	 * Obtiene el panel de administración.
	 * 
	 * @return Administrador instancia del panel de administración
	 */
	public Administrador getAdmin() {
		return admin;
	}

	/**
	 * Establece el panel de administración.
	 * 
	 * @param admin Nueva instancia de Administrador
	 */
	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	/**
	 * Obtiene el panel de información de usuario.
	 * 
	 * @return InfoUsuario instancia del panel de información
	 */
	public InfoUsuario getInfoUsuario() {
		return infoUsuario;
	}

	/**
	 * Establece el panel de información de usuario.
	 * 
	 * @param infoUsuario Nueva instancia de InfoUsuario
	 */
	public void setInfoUsuario(InfoUsuario infoUsuario) {
		this.infoUsuario = infoUsuario;
	}

	/**
	 * Obtiene el panel de confirmación de baja.
	 * 
	 * @return ConfirmarBaja instancia del panel de confirmación
	 */
	public ConfirmarBaja getConfirmarBaja() {
		return confirmarBaja;
	}

	/**
	 * Establece el panel de confirmación de baja.
	 * 
	 * @param confirmarBaja Nueva instancia de ConfirmarBaja
	 */
	public void setConfirmarBaja(ConfirmarBaja confirmarBaja) {
		this.confirmarBaja = confirmarBaja;
	}	
	
}