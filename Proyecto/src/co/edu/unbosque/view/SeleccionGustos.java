package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Clase que representa el panel de selección de gustos y preferencias en la aplicación.
 * Permite a los usuarios especificar sus preferencias sobre las características
 * de las personas que les interesan, como rango de edad, estatura ideal,
 * y preferencias específicas según el género.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class SeleccionGustos extends JPanel {

	/** Campo de texto para ingresar la edad mínima deseada */
	private JTextField campoEdadMinima;
	
	/** Campo de texto para ingresar la edad máxima deseada */
	private JTextField campoEdadMaxima;
	
	/** Campo de texto para ingresar la estatura ideal */
	private JTextField campoEstaturaIdeal;
	
	/** Campo de texto para ingresar el ingreso ideal (solo para mujeres) */
	private JTextField campoIngresoIdeal;

	/** Botón para confirmar la selección de gustos */
	private JButton botonConfirmar;

	/** Radio button para indicar preferencia por persona divorciada */
	private JRadioButton divorciada;
	
	/** Radio button para indicar preferencia por persona no divorciada */
	private JRadioButton noDivorciada;

	/** Grupo de botones para el estado de divorcio */
	private ButtonGroup estadoDivorcio;

	/** Panel que contiene el formulario de gustos */
	private JPanel panelFormulario;
	
	/** Botón para cambiar entre modo claro y oscuro */
	private JButton cambiarModo;

	/**
	 * Constructor de la clase SeleccionGustos.
	 * Inicializa todos los componentes gráficos del panel de selección de gustos,
	 * configura sus propiedades visuales y los agrega al panel.
	 * Incluye un panel decorativo con imagen de fondo.
	 */
	public SeleccionGustos() {

		this.setBackground(new Color(59, 59, 59));
		this.setLayout(null);

		JPanel panel = new JPanel(null);
		panel.setBounds(0, 0, 600, 800);
		panel.setBackground(new Color(30, 31, 34));

		ImageIcon originalIcon = new ImageIcon("Resources/fondo_panel.png");
		Image imagenEscalada = originalIcon.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

		JLabel imagenPanel = new JLabel(iconoEscalado);
		imagenPanel.setBounds(0, 0, 600, 800);

		panel.add(imagenPanel);
		panel.setComponentZOrder(imagenPanel, panel.getComponentCount() - 1);

		this.add(panel);

		Color colorTinder = new Color(255, 51, 102);

		panelFormulario = new JPanel(null);
		panelFormulario.setBounds(760, 100, 400, 500);
		panelFormulario.setBackground(new Color(59, 59, 59));
		panelFormulario.setBorder(BorderFactory.createLineBorder(colorTinder, 4, true)); // borde redondeado

		int baseX = 850;
		int baseY = 200;

		Font campoFuente = new Font("Segoe UI", Font.PLAIN, 14);

		campoEdadMinima = new CampoRedondeado(10, 30);
		campoEdadMinima.setBounds(baseX, baseY + 40, 90, 30);
		campoEdadMinima.setFont(campoFuente);

		campoEdadMaxima = new CampoRedondeado(10, 30);
		campoEdadMaxima.setBounds(baseX + 120, baseY + 40, 90, 30);
		campoEdadMaxima.setFont(campoFuente);

		campoEstaturaIdeal = new CampoRedondeado(10, 30);
		campoEstaturaIdeal.setBounds(baseX, baseY + 120, 210, 30);
		campoEstaturaIdeal.setFont(campoFuente);

		campoIngresoIdeal = new CampoRedondeado(10, 30);
		campoIngresoIdeal.setBounds(baseX, baseY + 220, 210, 30);
		campoIngresoIdeal.setFont(campoFuente);
		campoIngresoIdeal.setVisible(false);
		campoIngresoIdeal.setEnabled(false);

		botonConfirmar = new JButton();
		botonConfirmar.setBounds(baseX + 45, baseY + 320, 130, 35);
		CampoRedondeado.aplicarRedondeado(botonConfirmar, 20, colorTinder, Color.WHITE);

		divorciada = new JRadioButton();
		divorciada.setBounds(baseX, baseY + 230, 200, 20);
		divorciada.setBackground(new Color(59, 59, 59));
		divorciada.setForeground(Color.WHITE);
		divorciada.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		noDivorciada = new JRadioButton();
		noDivorciada.setBounds(baseX, baseY + 250, 200, 20);
		noDivorciada.setBackground(new Color(59, 59, 59));
		noDivorciada.setForeground(Color.WHITE);
		noDivorciada.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		noDivorciada.setVisible(false);

		estadoDivorcio = new ButtonGroup();
		estadoDivorcio.add(divorciada);
		estadoDivorcio.add(noDivorciada);
		
		cambiarModo = new JButton();
		cambiarModo.setBounds(1060, 15, 180, 40);
		CampoRedondeado.aplicarRedondeado(cambiarModo, 25, new Color(255, 51, 102), Color.WHITE);
		
		this.add(cambiarModo);
		this.add(divorciada);
		this.add(noDivorciada);
		this.add(campoEdadMinima);
		this.add(campoEdadMaxima);
		this.add(campoEstaturaIdeal);
		this.add(campoIngresoIdeal);
		this.add(botonConfirmar);
		this.add(panel);
		this.add(panelFormulario);
	}

	/**
	 * Muestra los campos específicos para usuarios mujeres.
	 * Permite ingresar el ingreso ideal y oculta las opciones de estado de divorcio.
	 * 
	 * @param labelIngresoIdeal Texto de la etiqueta de ingreso ideal
	 */
	public void mostrarCamposMujer(String labelIngresoIdeal) {
		campoIngresoIdeal.setVisible(true);
		campoIngresoIdeal.setEnabled(true);
		divorciada.setVisible(false);
		divorciada.setEnabled(false);
		noDivorciada.setVisible(false);
		noDivorciada.setEnabled(false);
		estadoDivorcio.clearSelection();

		crearLabel(labelIngresoIdeal, Color.WHITE, 850, 190 + 200, 200, 30, 16);
	}

	/**
	 * Muestra los campos específicos para usuarios hombres.
	 * Permite seleccionar preferencia sobre estado de divorcio y oculta el campo de ingreso.
	 * 
	 * @param labelDivorciada Texto de la etiqueta de estado divorciada
	 */
	public void mostrarCamposHombre(String labelDivorciada) {
		campoIngresoIdeal.setVisible(false);
		campoIngresoIdeal.setEnabled(false);
		divorciada.setVisible(true);
		divorciada.setEnabled(true);
		noDivorciada.setVisible(true);
		noDivorciada.setEnabled(true);
		campoIngresoIdeal.setText("");

		crearLabel(labelDivorciada, Color.WHITE, 850, 190 + 200, 200, 30, 16);
	}

	/**
	 * Muestra todos los textos de las etiquetas del formulario de gustos.
	 * Este método es utilizado para la internacionalización de la interfaz.
	 * 
	 * @param labelEdadMinima Texto de la etiqueta de edad mínima
	 * @param labelEdadMaxima Texto de la etiqueta de edad máxima
	 * @param labelEstaturaIdeal Texto de la etiqueta de estatura ideal
	 * @param labelDivorciada Texto para la opción divorciada
	 * @param labelNoDivorciada Texto para la opción no divorciada
	 * @param labelConfirmar Texto del botón confirmar
	 * @param labelEdad Texto de la etiqueta de edad
	 * @param labelPersonaIdeal Texto del título "persona ideal"
	 * @param labelCambiarModo Texto del botón cambiar modo
	 */
	public void mostrarTextos(String labelEdadMinima, String labelEdadMaxima, String labelEstaturaIdeal,
			String labelDivorciada, String labelNoDivorciada, String labelConfirmar, String labelEdad,
			String labelPersonaIdeal, String labelCambiarModo) {
		int baseX = 850;
		int baseY = 200;

		crearLabel(labelEdad, Color.WHITE, baseX, baseY - 30, 200, 30, 16);
		crearLabel(labelEdadMinima, Color.WHITE, baseX, baseY + 10, 200, 30, 16);
		crearLabel(labelEdadMaxima, Color.WHITE, baseX + 120, baseY + 10, 200, 30, 16);
		crearLabel(labelEstaturaIdeal, Color.WHITE, baseX, baseY + 90, 200, 30, 16);
		crearLabel(labelPersonaIdeal, Color.WHITE, baseX, baseY - 75, 200, 30, 16);

		divorciada.setText(labelDivorciada);
		noDivorciada.setText(labelNoDivorciada);
		botonConfirmar.setText(labelConfirmar);
		cambiarModo.setText(labelCambiarModo);
	}

	/**
	 * Elimina las etiquetas relacionadas con los campos específicos de género.
	 * 
	 * @param labelIngresoProm Texto de la etiqueta de ingreso promedio
	 * @param labelEstadoDivorcio Texto de la etiqueta de estado de divorcio
	 */
	public void eliminarLabelGustos(String labelIngresoProm, String labelEstadoDivorcio) {
		for (Component c : this.getComponents()) {
			if (!(c instanceof JLabel)) {
				continue;
			}
			if (((JLabel) c).getText().equals(labelIngresoProm) || ((JLabel) c).getText().equals(labelEstadoDivorcio)) {
				this.remove(c);
				this.revalidate();
				this.repaint();
			}
		}
	}

	/**
	 * Limpia todos los campos del formulario de gustos y restablece las selecciones.
	 */
	public void limpiarCampos() {
		campoEdadMinima.setText("");
		campoEdadMaxima.setText("");
		campoEstaturaIdeal.setText("");
		campoIngresoIdeal.setText("");
		estadoDivorcio.clearSelection();
	}
	
	/**
	 * Cambia entre el modo oscuro y modo claro de la interfaz.
	 * Alterna los colores de fondo y texto de todos los componentes del panel.
	 */
	public void cambiarModo() {
		if (this.getBackground().equals(new Color(59, 59, 59))) {
			this.setBackground(Color.WHITE);
			panelFormulario.setBackground(Color.WHITE);
			for (Component c : this.getComponents()) {
				if (c instanceof JLabel) {
					((JLabel) c).setForeground(Color.BLACK);
				} else if (c instanceof JRadioButton) {
					((JRadioButton) c).setBackground(Color.WHITE);
					((JRadioButton) c).setForeground(Color.BLACK);
				} else if (c instanceof JTextField) {
					((JTextField) c).setBackground(new Color(59, 59, 59));
					((JTextField) c).setForeground(Color.WHITE);
				}
			}
		} else {
			this.setBackground(new Color(59, 59, 59));
			panelFormulario.setBackground(new Color(59, 59, 59));
			for (Component c : this.getComponents()) {
				if (c instanceof JLabel) {
					((JLabel) c).setForeground(Color.WHITE);
				} else if (c instanceof JRadioButton) {
					((JRadioButton) c).setBackground(new Color(59, 59, 59));
					((JRadioButton) c).setForeground(Color.WHITE);
				} else if (c instanceof JTextField) {
					((JTextField) c).setBackground(Color.WHITE);
					((JTextField) c).setForeground(Color.BLACK);
				}
			}
		}
	}

	/**
	 * Crea y agrega una etiqueta al panel con las propiedades especificadas.
	 * La etiqueta se posiciona al frente de otros componentes.
	 * 
	 * @param texto Texto a mostrar en la etiqueta
	 * @param colorFondo Color del texto de la etiqueta
	 * @param x Posición X de la etiqueta
	 * @param y Posición Y de la etiqueta
	 * @param ancho Ancho de la etiqueta
	 * @param alto Alto de la etiqueta
	 * @param tamanoLetra Tamaño de la fuente
	 */
	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Segoe UI", Font.PLAIN, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	/**
	 * Obtiene el campo de texto de la edad mínima.
	 * 
	 * @return El campo edad mínima
	 */
	public JTextField getCampoEdadMinima() {
		return campoEdadMinima;
	}

	/**
	 * Establece el campo de texto de la edad mínima.
	 * 
	 * @param campoEdadMinima El campo a establecer
	 */
	public void setCampoEdadMinima(JTextField campoEdadMinima) {
		this.campoEdadMinima = campoEdadMinima;
	}

	/**
	 * Obtiene el campo de texto de la edad máxima.
	 * 
	 * @return El campo edad máxima
	 */
	public JTextField getCampoEdadMaxima() {
		return campoEdadMaxima;
	}

	/**
	 * Establece el campo de texto de la edad máxima.
	 * 
	 * @param campoEdadMaxima El campo a establecer
	 */
	public void setCampoEdadMaxima(JTextField campoEdadMaxima) {
		this.campoEdadMaxima = campoEdadMaxima;
	}

	/**
	 * Obtiene el campo de texto de la estatura ideal.
	 * 
	 * @return El campo estatura ideal
	 */
	public JTextField getCampoEstaturaIdeal() {
		return campoEstaturaIdeal;
	}

	/**
	 * Establece el campo de texto de la estatura ideal.
	 * 
	 * @param campoEstaturaIdeal El campo a establecer
	 */
	public void setCampoEstaturaIdeal(JTextField campoEstaturaIdeal) {
		this.campoEstaturaIdeal = campoEstaturaIdeal;
	}

	/**
	 * Obtiene el campo de texto del ingreso ideal.
	 * 
	 * @return El campo ingreso ideal
	 */
	public JTextField getCampoIngresoIdeal() {
		return campoIngresoIdeal;
	}

	/**
	 * Establece el campo de texto del ingreso ideal.
	 * 
	 * @param campoIngresoIdeal El campo a establecer
	 */
	public void setCampoIngresoIdeal(JTextField campoIngresoIdeal) {
		this.campoIngresoIdeal = campoIngresoIdeal;
	}

	/**
	 * Obtiene el botón de confirmar.
	 * 
	 * @return El botón confirmar
	 */
	public JButton getBotonConfirmar() {
		return botonConfirmar;
	}

	/**
	 * Establece el botón de confirmar.
	 * 
	 * @param botonConfirmar El botón a establecer
	 */
	public void setBotonConfirmar(JButton botonConfirmar) {
		this.botonConfirmar = botonConfirmar;
	}

	/**
	 * Obtiene el radio button de divorciada.
	 * 
	 * @return El radio button divorciada
	 */
	public JRadioButton getDivorciada() {
		return divorciada;
	}

	/**
	 * Establece el radio button de divorciada.
	 * 
	 * @param divorciada El radio button a establecer
	 */
	public void setDivorciada(JRadioButton divorciada) {
		this.divorciada = divorciada;
	}

	/**
	 * Obtiene el radio button de no divorciada.
	 * 
	 * @return El radio button no divorciada
	 */
	public JRadioButton getNoDivorciada() {
		return noDivorciada;
	}

	/**
	 * Establece el radio button de no divorciada.
	 * 
	 * @param noDivorciada El radio button a establecer
	 */
	public void setNoDivorciada(JRadioButton noDivorciada) {
		this.noDivorciada = noDivorciada;
	}

	/**
	 * Obtiene el grupo de botones de estado de divorcio.
	 * 
	 * @return El grupo de estado de divorcio
	 */
	public ButtonGroup getEstadoDivorcio() {
		return estadoDivorcio;
	}

	/**
	 * Establece el grupo de botones de estado de divorcio.
	 * 
	 * @param estadoDivorcio El grupo a establecer
	 */
	public void setEstadoDivorcio(ButtonGroup estadoDivorcio) {
		this.estadoDivorcio = estadoDivorcio;
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
	 * @param cambiarModo El botón a establecer
	 */
	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

}