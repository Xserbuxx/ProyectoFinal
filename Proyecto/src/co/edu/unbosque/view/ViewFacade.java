package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ViewFacade {
	
	private VentanaPrincipal ventanaPrincipal;
	private JPanel paneles;
	private CardLayout cl;
	
	private Idioma idm;
	
	public ViewFacade() {
		ventanaPrincipal = new VentanaPrincipal();
		cl = new CardLayout();
		paneles = new JPanel();
		
		paneles.setLayout(cl);
		
		idm = new Idioma();
		
		paneles.add(idm, "idioma");
		
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
	
}
