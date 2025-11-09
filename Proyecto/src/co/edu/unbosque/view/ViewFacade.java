package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ViewFacade {
	
	private VentanaPrincipal ventanaPrincipal;
	private JPanel paneles;
	private CardLayout cl;
	
	private Idioma idm;
	private InicioSesion is;
	private Registro reg;
	private VerificarCodigo vc;
	private SeleccionGustos sg;
	private Aplicacion app;
	private Perfil per;
	private Administrador admin;
	private InfoUsuario infoUsuario;
	private ConfirmarBaja confirmarBaja;
	
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
	
	public void mostrarPanel(String panel) {
		cl.show(paneles, panel);
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public Idioma getIdm() {
		return idm;
	}

	public void setIdm(Idioma idm) {
		this.idm = idm;
	}

	public JPanel getPaneles() {
		return paneles;
	}

	public void setPaneles(JPanel paneles) {
		this.paneles = paneles;
	}

	public CardLayout getCl() {
		return cl;
	}

	public void setCl(CardLayout cl) {
		this.cl = cl;
	}

	public InicioSesion getIs() {
		return is;
	}

	public void setIs(InicioSesion is) {
		this.is = is;
	}

	public Registro getReg() {
		return reg;
	}

	public void setReg(Registro reg) {
		this.reg = reg;
	}

	public VerificarCodigo getVc() {
		return vc;
	}

	public void setVc(VerificarCodigo vc) {
		this.vc = vc;
	}

	public SeleccionGustos getSg() {
		return sg;
	}

	public void setSg(SeleccionGustos sg) {
		this.sg = sg;
	}

	public Aplicacion getApp() {
		return app;
	}

	public void setApp(Aplicacion app) {
		this.app = app;
	}

	public Perfil getPer() {
		return per;
	}

	public void setPer(Perfil per) {
		this.per = per;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public InfoUsuario getInfoUsuario() {
		return infoUsuario;
	}

	public void setInfoUsuario(InfoUsuario infoUsuario) {
		this.infoUsuario = infoUsuario;
	}

	public ConfirmarBaja getConfirmarBaja() {
		return confirmarBaja;
	}

	public void setConfirmarBaja(ConfirmarBaja confirmarBaja) {
		this.confirmarBaja = confirmarBaja;
	}	
	
}
