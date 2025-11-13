package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Panel principal de la aplicación donde se muestran los usuarios disponibles.
 * Permite ver perfiles de otros usuarios y dar likes.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class Aplicacion extends JPanel {

	/** Panel de desplazamiento para la lista de usuarios */
	private JScrollPane scrollPanel;
	
	/** Panel contenedor de los paneles de usuario */
	private JPanel panelUsuarios;
	
	/** Botón para ir al perfil del usuario actual */
	private JButton botonPerfil;
	
	/** Botón para volver al menú anterior */
	private JButton botonVolver;

	/**
	 * Constructor que inicializa el panel de aplicación.
	 * Crea la interfaz con la lista de usuarios disponibles.
	 */
	public Aplicacion() {
		this.setLayout(null);
		this.setBackground(new Color(59, 59, 59));

		JPanel barraLateral = new JPanel();
		barraLateral.setLayout(null);
		barraLateral.setBackground(new Color(255, 51, 102));
		barraLateral.setBounds(0, 0, 350, 720);
		
		ImageIcon imgLogo = new ImageIcon("Resources/logo.png");
		JLabel logo = new JLabel(new ImageIcon(imgLogo.getImage().getScaledInstance(180, 60, Image.SCALE_SMOOTH)));
		logo.setBounds(60, 0, 180, 75);
		this.add(logo);
		
		ImageIcon imagenPerfil = new ImageIcon("Resources/perfil.png");
		Image imagenRedimensionadaPerfil = imagenPerfil.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionada = new ImageIcon(imagenRedimensionadaPerfil);

		botonPerfil = new JButton(imagenRedimensionada);
		botonPerfil.setBounds(1200, 5, 50, 50);
		botonPerfil.setBackground(new Color(0, 0, 0, 0));
		botonPerfil.setContentAreaFilled(false);
		botonPerfil.setBorderPainted(false);
		botonPerfil.setFocusPainted(false);
		botonPerfil.setFocusable(false);
		
		ImageIcon imagenVolver = new ImageIcon("Resources/volver3.png");
		Image imagenRedimensionadaVolver = imagenVolver.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionadaVolverv = new ImageIcon(imagenRedimensionadaVolver);

		botonVolver = new JButton(imagenRedimensionadaVolverv);
		botonVolver.setBounds(10, 10, 50, 50);
		botonVolver.setBackground(new Color(255, 51, 102));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setFocusable(false);

		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(Color.WHITE);
		panelUsuarios.setLayout(new GridLayout(0, 1, 1, 1));

		scrollPanel = new JScrollPane(panelUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(350, 60, 900, 640);
		scrollPanel.setBackground(new Color(36, 41, 46));
		
		this.add(botonVolver);
		this.add(botonPerfil);
		this.add(scrollPanel);
		this.add(barraLateral);
	}
	
	/**
	 * Cambia el modo visual del panel entre claro y oscuro.
	 * Alterna los colores de fondo y texto de todos los componentes.
	 */
	public void cambiarModo() {
		Color fondo;
		Color texto;
		if (this.getBackground().equals(Color.WHITE)) {
			fondo = new Color(36, 41, 46);
			texto = Color.WHITE;
		} else {
			fondo = Color.WHITE;
			texto = Color.BLACK;
		}
		this.setBackground(fondo);
		panelUsuarios.setBackground(fondo);
		for (int i = 0; i < panelUsuarios.getComponentCount(); i++) {
			Component comp = panelUsuarios.getComponent(i);
			if (comp instanceof PanelUsuario) {
				((PanelUsuario) comp).cambiarModo(fondo, texto);
			}
		}
	}

	/**
	 * Agrega un panel de usuario mujer a la lista.
	 * 
	 * @param alias El alias del usuario
	 * @param imagen La imagen de perfil
	 * @param edad La edad del usuario
	 * @param estatura La estatura del usuario
	 * @param likes Cantidad de likes recibidos
	 * @param like Si el usuario actual ya dio like
	 * @param listener Listener para el botón de like
	 */
	public void agregarUsuario(String alias, ImageIcon imagen, String edad, String estatura, int likes, boolean like,
			ActionListener listener) {
		panelUsuarios.add(new PanelUsuario(alias, imagen, edad, estatura, likes, like, listener));
	}
	
	/**
	 * Agrega un panel de usuario hombre a la lista.
	 * 
	 * @param alias El alias del usuario
	 * @param imagen La imagen de perfil
	 * @param edad La edad del usuario
	 * @param estatura La estatura del usuario
	 * @param likes Cantidad de likes recibidos
	 * @param like Si el usuario actual ya dio like
	 * @param listener Listener para el botón de like
	 * @param ingresoProm El ingreso promedio del usuario
	 */
	public void agregarUsuario(String alias, ImageIcon imagen, String edad, String estatura, int likes, boolean like,
			ActionListener listener, String ingresoProm) {
		panelUsuarios.add(new PanelUsuario(alias, imagen, edad, estatura, likes, like, listener, ingresoProm));
	}
	
	/**
	 * Elimina todos los paneles de usuario de la lista.
	 */
	public void limpiarUsuarios() {
		panelUsuarios.removeAll();
		panelUsuarios.revalidate();
		panelUsuarios.repaint();
	}

	/**
	 * Obtiene el panel de desplazamiento.
	 * 
	 * @return El scroll panel
	 */
	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}

	/**
	 * Establece el panel de desplazamiento.
	 * 
	 * @param scrollPanel El nuevo scroll panel
	 */
	public void setScrollPanel(JScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}

	/**
	 * Obtiene el panel de usuarios.
	 * 
	 * @return El panel usuarios
	 */
	public JPanel getPanelUsuarios() {
		return panelUsuarios;
	}

	/**
	 * Establece el panel de usuarios.
	 * 
	 * @param panelUsuarios El nuevo panel usuarios
	 */
	public void setPanelUsuarios(JPanel panelUsuarios) {
		this.panelUsuarios = panelUsuarios;
	}

	/**
	 * Obtiene el botón de perfil.
	 * 
	 * @return El botón perfil
	 */
	public JButton getBotonPerfil() {
		return botonPerfil;
	}

	/**
	 * Establece el botón de perfil.
	 * 
	 * @param botonPerfil El nuevo botón perfil
	 */
	public void setBotonPerfil(JButton botonPerfil) {
		this.botonPerfil = botonPerfil;
	}

	/**
	 * Obtiene el botón volver.
	 * 
	 * @return El botón volver
	 */
	public JButton getBotonVolver() {
		return botonVolver;
	}

	/**
	 * Establece el botón volver.
	 * 
	 * @param botonVolver El nuevo botón volver
	 */
	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}
	
}