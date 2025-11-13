package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Panel de administración del sistema.
 * Permite visualizar, ordenar, filtrar usuarios y generar reportes en PDF.
 * Incluye funcionalidades de búsqueda, ranking y gestión de usuarios.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class Administrador extends JPanel {

	/** Panel de desplazamiento para la lista de usuarios */
	private JScrollPane scrollPanel;
	
	/** Panel contenedor de los paneles de usuario */
	private JPanel panelUsuarios;
	
	/** Botón para ejecutar el ordenamiento */
	private JButton botonOrdenar;
	
	/** Radio button para ordenamiento ascendente */
	private JRadioButton botonAscendente;
	
	/** Radio button para ordenamiento descendente */
	private JRadioButton botonDescendente;
	
	/** Radio button para ordenar por edad */
	private JRadioButton botonPorEdad;
	
	/** Radio button para ordenar por nombre */
	private JRadioButton botonNombre;
	
	/** Radio button para ordenar por alias */
	private JRadioButton botonAlias;
	
	/** Radio button para ordenar por likes */
	private JRadioButton botonLikes;
	
	/** Grupo de botones para tipo de ordenamiento */
	private ButtonGroup grupoOrdenamientos;
	
	/** Grupo de botones para criterio de ordenamiento */
	private ButtonGroup grupoCriterios;

	/** Radio button para top de likes */
	private JRadioButton botonTopLikes;
	
	/** Radio button para top de ingresos */
	private JRadioButton botonTopIngresos;
	
	/** Grupo de botones para tipo de ranking */
	private ButtonGroup grupoTop;

	/** Botón para generar ranking top */
	private JButton botonTop;

	/** Botón para generar reporte PDF */
	private JButton botonPDF;
	
	/** Radio button para PDF de edades */
	private JRadioButton botonEdadPDF;
	
	/** Radio button para PDF de likes */
	private JRadioButton botonLikesPDF;
	
	/** Radio button para PDF de ingresos */
	private JRadioButton botonIngresosPDF;
	
	/** Radio button para PDF de estaturas */
	private JRadioButton botonEstaturaPDF;
	
	/** Grupo de botones para tipo de PDF */
	private ButtonGroup grupoPDF;
	
	/** Botón para cambiar entre modo claro y oscuro */
	private JButton cambiarModo;
	
	/** Botón para volver al menú anterior */
	private JButton botonVolver;
	
	/** Campo de texto para búsqueda */
	private JTextField txtBuscar;
	
	/** Botón para ejecutar la búsqueda */
	private JButton botonBuscar;

	/**
	 * Constructor que inicializa el panel de administración.
	 * Crea todos los componentes visuales y los organiza en el panel.
	 */
	public Administrador() {
		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));
		
		JPanel barraLateral = new JPanel();
		barraLateral.setLayout(null);
		barraLateral.setBackground(new Color(255, 51, 102));
		barraLateral.setBounds(0, 0, 350, 720);

		ImageIcon imgLogo = new ImageIcon("Resources/logo.png");
		JLabel logo = new JLabel(new ImageIcon(imgLogo.getImage().getScaledInstance(180, 60, Image.SCALE_SMOOTH)));
		logo.setBounds(60, 0, 180, 75);
		barraLateral.add(logo);
		
		ImageIcon imagenVolver = new ImageIcon("Resources/volver3.png");
		Image imagenRedimensionadaVolver = imagenVolver.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionada = new ImageIcon(imagenRedimensionadaVolver);

		botonVolver = new JButton(imagenRedimensionada);
		botonVolver.setBounds(10, 10, 50, 50);
		botonVolver.setBackground(new Color(255, 51, 102));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setFocusable(false);

		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(new Color(36, 41, 46));
		panelUsuarios.setLayout(new GridLayout(0, 1, 10, 10));

		scrollPanel = new JScrollPane(panelUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(350, 60, 900, 640);
		scrollPanel.setBackground(new Color(36, 41, 46));

		botonOrdenar = new JButton();
		botonOrdenar.setBounds(10, 100, 100, 30);
		CampoRedondeado.aplicarRedondeado(botonOrdenar, 25, new Color(74,144,226), Color.WHITE);

		botonAscendente = new JRadioButton();
		botonAscendente.setBounds(10, 200, 140, 30);
		botonAscendente.setBackground(new Color(255, 51, 102));

		botonDescendente = new JRadioButton();
		botonDescendente.setBounds(10, 250, 140, 30);
		botonDescendente.setBackground(new Color(255, 51, 102));

		grupoOrdenamientos = new ButtonGroup();
		grupoOrdenamientos.add(botonAscendente);
		grupoOrdenamientos.add(botonDescendente);

		botonPorEdad = new JRadioButton();
		botonPorEdad.setBounds(10, 350, 100, 30);
		botonPorEdad.setBackground(new Color(255, 51, 102));

		botonNombre = new JRadioButton();
		botonNombre.setBounds(10, 400, 100, 30);
		botonNombre.setBackground(new Color(255, 51, 102));

		botonAlias = new JRadioButton();
		botonAlias.setBounds(10, 450, 100, 30);
		botonAlias.setBackground(new Color(255, 51, 102));

		botonLikes = new JRadioButton();
		botonLikes.setBounds(10, 500, 100, 30);
		botonLikes.setBackground(new Color(255, 51, 102));

		grupoCriterios = new ButtonGroup();
		grupoCriterios.add(botonPorEdad);
		grupoCriterios.add(botonNombre);
		grupoCriterios.add(botonAlias);
		grupoCriterios.add(botonLikes);

		botonTopLikes = new JRadioButton();
		botonTopLikes.setBounds(150, 200, 200, 30);
		botonTopLikes.setBackground(new Color(255, 51, 102));

		botonTopIngresos = new JRadioButton();
		botonTopIngresos.setBounds(150, 250, 120, 30);
		botonTopIngresos.setBackground(new Color(255, 51, 102));

		grupoTop = new ButtonGroup();
		grupoTop.add(botonTopLikes);
		grupoTop.add(botonTopIngresos);

		botonTop = new JButton();
		botonTop.setBounds(150, 100, 200, 30);
		CampoRedondeado.aplicarRedondeado(botonTop, 25, new Color(74,144,226), Color.WHITE);

		botonPDF = new JButton();
		botonPDF.setBounds(150, 350, 150, 30);
		CampoRedondeado.aplicarRedondeado(botonPDF, 25, new Color(74,144,226), Color.WHITE);

		botonEdadPDF = new JRadioButton();
		botonEdadPDF.setBounds(150, 400, 100, 30);
		botonEdadPDF.setBackground(new Color(255, 51, 102));

		botonLikesPDF = new JRadioButton();
		botonLikesPDF.setBounds(150, 450, 200, 30);
		botonLikesPDF.setBackground(new Color(255, 51, 102));

		botonIngresosPDF = new JRadioButton();
		botonIngresosPDF.setBounds(150, 500, 100, 30);
		botonIngresosPDF.setBackground(new Color(255, 51, 102));

		botonEstaturaPDF = new JRadioButton();
		botonEstaturaPDF.setBounds(150, 550, 100, 30);
		botonEstaturaPDF.setBackground(new Color(255, 51, 102));

		grupoPDF = new ButtonGroup();
		grupoPDF.add(botonEdadPDF);
		grupoPDF.add(botonLikesPDF);
		grupoPDF.add(botonIngresosPDF);
		grupoPDF.add(botonEstaturaPDF);
		
		cambiarModo = new JButton();
		cambiarModo.setBounds(1060, 15, 180, 40);
		CampoRedondeado.aplicarRedondeado(cambiarModo, 25, new Color(255, 51, 102), Color.WHITE);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(400, 15, 400, 40);
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(820, 15, 100, 40);
		CampoRedondeado.aplicarRedondeado(botonBuscar, 25, new Color(74,144,226), Color.WHITE);
		
		this.add(txtBuscar);
		this.add(botonBuscar);
		this.add(botonVolver);
		this.add(cambiarModo);
		this.add(botonEdadPDF);
		this.add(botonLikesPDF);
		this.add(botonIngresosPDF);
		this.add(botonEstaturaPDF);
		this.add(botonPDF);
		this.add(botonOrdenar);
		this.add(botonAscendente);
		this.add(botonDescendente);
		this.add(botonPorEdad);
		this.add(botonNombre);
		this.add(botonAlias);
		this.add(botonLikes);
		this.add(botonTopLikes);
		this.add(botonTopIngresos);
		this.add(scrollPanel);
		this.add(botonTop);
		this.add(barraLateral);
	}

	/**
	 * Muestra los textos traducidos en todos los componentes según el idioma seleccionado.
	 * 
	 * @param labelBotonOrdenar Texto del botón ordenar
	 * @param labelBotonAscendente Texto del botón ascendente
	 * @param labelBotonDescendente Texto del botón descendente
	 * @param labelBotonPorEdad Texto del botón por edad
	 * @param labelBotonNombre Texto del botón nombre
	 * @param labelBotonAlias Texto del botón alias
	 * @param labelBotonLikes Texto del botón likes
	 * @param labelBotonTopLikes Texto del botón top likes
	 * @param labelBotonTopIngresos Texto del botón top ingresos
	 * @param labelBotonTop Texto del botón top
	 * @param labelOrdenarPor Texto de la etiqueta "Ordenar por"
	 * @param labelCriterio Texto de la etiqueta "Criterio"
	 * @param labelTop Texto de la etiqueta "Top"
	 * @param labelPDF Texto del botón PDF
	 * @param labelBotonEdadPDF Texto del botón edad PDF
	 * @param labelBotonLikesPDF Texto del botón likes PDF
	 * @param labelBotonIngresosPDF Texto del botón ingresos PDF
	 * @param labelBotonEstaturaPDF Texto del botón estatura PDF
	 * @param labelCambiarModo Texto del botón cambiar modo
	 * @param labelBotonBuscar Texto del botón buscar
	 */
	public void mostrarTextos(String labelBotonOrdenar, String labelBotonAscendente, String labelBotonDescendente,
			String labelBotonPorEdad, String labelBotonNombre, String labelBotonAlias, String labelBotonLikes,
			String labelBotonTopLikes, String labelBotonTopIngresos, String labelBotonTop, String labelOrdenarPor,
			String labelCriterio, String labelTop, String labelPDF, String labelBotonEdadPDF, String labelBotonLikesPDF,
			String labelBotonIngresosPDF, String labelBotonEstaturaPDF, String labelCambiarModo, String labelBotonBuscar) {
		botonOrdenar.setText(labelBotonOrdenar);
		botonTop.setText(labelBotonTop);
		botonAscendente.setText(labelBotonAscendente);
		botonDescendente.setText(labelBotonDescendente);
		botonPorEdad.setText(labelBotonPorEdad);
		botonNombre.setText(labelBotonNombre);
		botonAlias.setText(labelBotonAlias);
		botonLikes.setText(labelBotonLikes);
		botonTopLikes.setText(labelBotonTopLikes);
		botonTopIngresos.setText(labelBotonTopIngresos);
		botonPDF.setText(labelPDF);
		crearLabel(labelOrdenarPor, Color.WHITE, 10, 150, 300, 30, 24);
		crearLabel(labelCriterio, Color.WHITE, 10, 300, 300, 30, 24);
		crearLabel(labelTop, Color.WHITE, 150, 150, 300, 30, 24);
		botonEdadPDF.setText(labelBotonEdadPDF);
		botonLikesPDF.setText(labelBotonLikesPDF);
		botonIngresosPDF.setText(labelBotonIngresosPDF);
		botonEstaturaPDF.setText(labelBotonEstaturaPDF);
		cambiarModo.setText(labelCambiarModo);
		botonBuscar.setText(labelBotonBuscar);
	}
	
	/**
	 * Cambia el modo visual del panel entre claro y oscuro.
	 * Alterna los colores de fondo y texto de todos los componentes.
	 */
	public void cambiarModo() {
		Color fondo;
		Color texto;
		Color fondoI;
		Color textoI;
		if (this.getBackground().equals(Color.WHITE)) {
			fondo = new Color(36, 41, 46);
			fondoI = Color.WHITE;
			texto = Color.WHITE;
			textoI = Color.BLACK;
		} else {
			fondo = Color.WHITE;
			fondoI = new Color(36, 41, 46);
			texto = Color.BLACK;
			textoI = Color.WHITE;
		}
		this.setBackground(fondo);
		panelUsuarios.setBackground(fondo);
		for (int i = 0; i < panelUsuarios.getComponentCount(); i++) {
			Component comp = panelUsuarios.getComponent(i);
			if (comp instanceof PanelUsuarioAdmin) {
				((PanelUsuarioAdmin) comp).cambiarModo(fondo, texto);
			}
		}
		txtBuscar.setBackground(fondoI);
		txtBuscar.setForeground(textoI);
		this.revalidate();
		this.repaint();
	}

	/**
	 * Crea y agrega una etiqueta de texto al panel con el estilo especificado.
	 * 
	 * @param texto El texto a mostrar
	 * @param colorFondo El color del texto
	 * @param x Posición X
	 * @param y Posición Y
	 * @param ancho Ancho de la etiqueta
	 * @param alto Alto de la etiqueta
	 * @param tamanoLetra Tamaño de la fuente
	 */
	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	/**
	 * Agrega un panel de usuario mujer a la lista.
	 * 
	 * @param alias El alias del usuario
	 * @param imagen La imagen de perfil
	 * @param edad La edad del usuario
	 * @param estatura La estatura del usuario
	 * @param listener Listener para los botones de acción
	 */
	public void agregarUsuario(String alias, ImageIcon imagen, String edad, String estatura, ActionListener listener) {
		panelUsuarios.add(new PanelUsuarioAdmin(alias, imagen, edad, estatura, listener));
	}

	/**
	 * Agrega un panel de usuario hombre a la lista.
	 * 
	 * @param alias El alias del usuario
	 * @param imagen La imagen de perfil
	 * @param edad La edad del usuario
	 * @param estatura La estatura del usuario
	 * @param listener Listener para los botones de acción
	 * @param ingresoProm El ingreso promedio del usuario
	 */
	public void agregarUsuario(String alias, ImageIcon imagen, String edad, String estatura, ActionListener listener,
			String ingresoProm) {
		panelUsuarios.add(new PanelUsuarioAdmin(alias, imagen, edad, estatura, listener, ingresoProm));
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
	 * Deshabilita todos los componentes del panel.
	 */
	public void setOff() {
		scrollPanel.setEnabled(false);
		panelUsuarios.setEnabled(false);
		for (Component comp : panelUsuarios.getComponents()) {
			for (Component com : ((JPanel) comp).getComponents()) {
				if (com instanceof JButton) {
					com.setEnabled(false);
				}
			}
		}
		scrollPanel.revalidate();
		scrollPanel.repaint();
		botonOrdenar.setEnabled(false);
		botonAscendente.setEnabled(false);
		botonDescendente.setEnabled(false);
		botonPorEdad.setEnabled(false);
		botonNombre.setEnabled(false);
		botonAlias.setEnabled(false);
		botonLikes.setEnabled(false);
		botonTopLikes.setEnabled(false);
		botonTopIngresos.setEnabled(false);
		botonTop.setEnabled(false);
		botonPDF.setEnabled(false);
		botonEdadPDF.setEnabled(false);
		botonLikesPDF.setEnabled(false);
		botonIngresosPDF.setEnabled(false);
		botonEstaturaPDF.setEnabled(false);
		cambiarModo.setEnabled(false);
		txtBuscar.setEnabled(false);
		botonBuscar.setEnabled(false);
	}

	/**
	 * Habilita todos los componentes del panel.
	 */
	public void setOn() {
		scrollPanel.setEnabled(true);
		panelUsuarios.setEnabled(true);
		scrollPanel.setEnabled(false);
		panelUsuarios.setEnabled(false);
		for (Component comp : panelUsuarios.getComponents()) {
			for (Component com : ((JPanel) comp).getComponents()) {
				if (com instanceof JButton) {
					com.setEnabled(true);
				}
			}
		}
		scrollPanel.revalidate();
		scrollPanel.repaint();
		botonOrdenar.setEnabled(true);
		botonAscendente.setEnabled(true);
		botonDescendente.setEnabled(true);
		botonPorEdad.setEnabled(true);
		botonNombre.setEnabled(true);
		botonAlias.setEnabled(true);
		botonLikes.setEnabled(true);
		botonTopLikes.setEnabled(true);
		botonTopIngresos.setEnabled(true);
		botonTop.setEnabled(true);
		botonPDF.setEnabled(true);
		botonEdadPDF.setEnabled(true);
		botonLikesPDF.setEnabled(true);
		botonIngresosPDF.setEnabled(true);
		botonEstaturaPDF.setEnabled(true);
		cambiarModo.setEnabled(true);
		txtBuscar.setEnabled(true);
		botonBuscar.setEnabled(true);
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
	 * Obtiene el botón de ordenar.
	 * 
	 * @return El botón ordenar
	 */
	public JButton getBotonOrdenar() {
		return botonOrdenar;
	}

	/**
	 * Establece el botón de ordenar.
	 * 
	 * @param botonOrdenar El nuevo botón ordenar
	 */
	public void setBotonOrdenar(JButton botonOrdenar) {
		this.botonOrdenar = botonOrdenar;
	}

	/**
	 * Obtiene el radio button ascendente.
	 * 
	 * @return El botón ascendente
	 */
	public JRadioButton getBotonAscendente() {
		return botonAscendente;
	}

	/**
	 * Establece el radio button ascendente.
	 * 
	 * @param botonAscendente El nuevo botón ascendente
	 */
	public void setBotonAscendente(JRadioButton botonAscendente) {
		this.botonAscendente = botonAscendente;
	}

	/**
	 * Obtiene el radio button descendente.
	 * 
	 * @return El botón descendente
	 */
	public JRadioButton getBotonDescendente() {
		return botonDescendente;
	}

	/**
	 * Establece el radio button descendente.
	 * 
	 * @param botonDescendente El nuevo botón descendente
	 */
	public void setBotonDescendente(JRadioButton botonDescendente) {
		this.botonDescendente = botonDescendente;
	}

	/**
	 * Obtiene el radio button por edad.
	 * 
	 * @return El botón por edad
	 */
	public JRadioButton getBotonPorEdad() {
		return botonPorEdad;
	}

	/**
	 * Establece el radio button por edad.
	 * 
	 * @param botonPorEdad El nuevo botón por edad
	 */
	public void setBotonPorEdad(JRadioButton botonPorEdad) {
		this.botonPorEdad = botonPorEdad;
	}

	/**
	 * Obtiene el radio button nombre.
	 * 
	 * @return El botón nombre
	 */
	public JRadioButton getBotonNombre() {
		return botonNombre;
	}

	/**
	 * Establece el radio button nombre.
	 * 
	 * @param botonNombre El nuevo botón nombre
	 */
	public void setBotonNombre(JRadioButton botonNombre) {
		this.botonNombre = botonNombre;
	}

	/**
	 * Obtiene el radio button alias.
	 * 
	 * @return El botón alias
	 */
	public JRadioButton getBotonAlias() {
		return botonAlias;
	}

	/**
	 * Establece el radio button alias.
	 * 
	 * @param botonAlias El nuevo botón alias
	 */
	public void setBotonAlias(JRadioButton botonAlias) {
		this.botonAlias = botonAlias;
	}

	/**
	 * Obtiene el radio button likes.
	 * 
	 * @return El botón likes
	 */
	public JRadioButton getBotonLikes() {
		return botonLikes;
	}

	/**
	 * Establece el radio button likes.
	 * 
	 * @param botonLikes El nuevo botón likes
	 */
	public void setBotonLikes(JRadioButton botonLikes) {
		this.botonLikes = botonLikes;
	}

	/**
	 * Obtiene el grupo de ordenamientos.
	 * 
	 * @return El grupo ordenamientos
	 */
	public ButtonGroup getGrupoOrdenamientos() {
		return grupoOrdenamientos;
	}

	/**
	 * Establece el grupo de ordenamientos.
	 * 
	 * @param grupoOrdenamientos El nuevo grupo ordenamientos
	 */
	public void setGrupoOrdenamientos(ButtonGroup grupoOrdenamientos) {
		this.grupoOrdenamientos = grupoOrdenamientos;
	}

	/**
	 * Obtiene el grupo de criterios.
	 * 
	 * @return El grupo criterios
	 */
	public ButtonGroup getGrupoCriterios() {
		return grupoCriterios;
	}

	/**
	 * Establece el grupo de criterios.
	 * 
	 * @param grupoCriterios El nuevo grupo criterios
	 */
	public void setGrupoCriterios(ButtonGroup grupoCriterios) {
		this.grupoCriterios = grupoCriterios;
	}

	/**
	 * Obtiene el radio button top likes.
	 * 
	 * @return El botón top likes
	 */
	public JRadioButton getBotonTopLikes() {
		return botonTopLikes;
	}

	/**
	 * Establece el radio button top likes.
	 * 
	 * @param botonTopLikes El nuevo botón top likes
	 */
	public void setBotonTopLikes(JRadioButton botonTopLikes) {
		this.botonTopLikes = botonTopLikes;
	}

	/**
	 * Obtiene el radio button top ingresos.
	 * 
	 * @return El botón top ingresos
	 */
	public JRadioButton getBotonTopIngresos() {
		return botonTopIngresos;
	}

	/**
	 * Establece el radio button top ingresos.
	 * 
	 * @param botonTopIngresos El nuevo botón top ingresos
	 */
	public void setBotonTopIngresos(JRadioButton botonTopIngresos) {
		this.botonTopIngresos = botonTopIngresos;
	}

	/**
	 * Obtiene el grupo top.
	 * 
	 * @return El grupo top
	 */
	public ButtonGroup getGrupoTop() {
		return grupoTop;
	}

	/**
	 * Establece el grupo top.
	 * 
	 * @param grupoTop El nuevo grupo top
	 */
	public void setGrupoTop(ButtonGroup grupoTop) {
		this.grupoTop = grupoTop;
	}

	/**
	 * Obtiene el botón top.
	 * 
	 * @return El botón top
	 */
	public JButton getBotonTop() {
		return botonTop;
	}

	/**
	 * Establece el botón top.
	 * 
	 * @param botonTop El nuevo botón top
	 */
	public void setBotonTop(JButton botonTop) {
		this.botonTop = botonTop;
	}

	/**
	 * Obtiene el botón PDF.
	 * 
	 * @return El botón PDF
	 */
	public JButton getBotonPDF() {
		return botonPDF;
	}

	/**
	 * Establece el botón PDF.
	 * 
	 * @param botonPDF El nuevo botón PDF
	 */
	public void setBotonPDF(JButton botonPDF) {
		this.botonPDF = botonPDF;
	}
	
	/**
	 * Obtiene el radio button edad PDF.
	 * 
	 * @return El botón edad PDF
	 */
	public JRadioButton getBotonEdadPDF() {
		return botonEdadPDF;
	}

	/**
	 * Obtiene el radio button likes PDF.
	 * 
	 * @return El botón likes PDF
	 */
	public JRadioButton getBotonLikesPDF() {
		return botonLikesPDF;
	}

	/**
	 * Establece el radio button likes PDF.
	 * 
	 * @param botonLikesPDF El nuevo botón likes PDF
	 */
	public void setBotonLikesPDF(JRadioButton botonLikesPDF) {
		this.botonLikesPDF = botonLikesPDF;
	}

	/**
	 * Obtiene el radio button ingresos PDF.
	 * 
	 * @return El botón ingresos PDF
	 */
	public JRadioButton getBotonIngresosPDF() {
		return botonIngresosPDF;
	}

	/**
	 * Establece el radio button ingresos PDF.
	 * 
	 * @param botonIngresosPDF El nuevo botón ingresos PDF
	 */
	public void setBotonIngresosPDF(JRadioButton botonIngresosPDF) {
		this.botonIngresosPDF = botonIngresosPDF;
	}

	/**
	 * Obtiene el radio button estatura PDF.
	 * 
	 * @return El botón estatura PDF
	 */
	public JRadioButton getBotonEstaturaPDF() {
		return botonEstaturaPDF;
	}

	/**
	 * Establece el radio button estatura PDF.
	 * 
	 * @param botonEstaturaPDF El nuevo botón estatura PDF
	 */
	public void setBotonEstaturaPDF(JRadioButton botonEstaturaPDF) {
		this.botonEstaturaPDF = botonEstaturaPDF;
	}

	/**
	 * Obtiene el grupo PDF.
	 * 
	 * @return El grupo PDF
	 */
	public ButtonGroup getGrupoPDF() {
		return grupoPDF;
	}

	/**
	 * Establece el grupo PDF.
	 * 
	 * @param grupoPDF El nuevo grupo PDF
	 */
	public void setGrupoPDF(ButtonGroup grupoPDF) {
		this.grupoPDF = grupoPDF;
	}

	/**
	 * Establece el radio button edad PDF.
	 * 
	 * @param botonEdadPDF El nuevo botón edad PDF
	 */
	public void setBotonEdadPDF(JRadioButton botonEdadPDF) {
		this.botonEdadPDF = botonEdadPDF;
	}

	/**
	 * Obtiene el botón cambiar modo.
	 * 
	 * @return El botón cambiar modo
	 */
	public JButton getCambiarModo() {
		return cambiarModo;
	}

	/**
	 * Establece el botón cambiar modo.
	 * 
	 * @param cambiarModo El nuevo botón cambiar modo
	 */
	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
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

	/**
	 * Obtiene el campo de texto buscar.
	 * 
	 * @return El campo texto buscar
	 */
	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	/**
	 * Establece el campo de texto buscar.
	 * 
	 * @param txtBuscar El nuevo campo texto buscar
	 */
	public void setTxtBuscar(JTextField txtBuscar) {
		this.txtBuscar = txtBuscar;
	}

	/**
	 * Obtiene el botón buscar.
	 * 
	 * @return El botón buscar
	 */
	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	/**
	 * Establece el botón buscar.
	 * 
	 * @param botonBuscar El nuevo botón buscar
	 */
	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}
	
}