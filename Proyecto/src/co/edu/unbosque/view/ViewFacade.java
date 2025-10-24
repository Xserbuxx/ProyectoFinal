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
		
		paneles.add(idm, "idioma");
		paneles.add(is, "inicioSesion");
		paneles.add(reg, "registro");
		paneles.add(vc, "verificarCodigo");
		paneles.add(sg, "seleccionGustos");
		
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
}
