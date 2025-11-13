package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel de selección de idioma de la aplicación.
 * Permite al usuario elegir entre diferentes idiomas disponibles.
 * 
 * @author Leidy Natalia Díaz Peña
 * @version 1.0
 */
public class Idioma extends JPanel {

	/** ComboBox para seleccionar el idioma */
	private JComboBox<String> comboBox;
	
	/** Botón para confirmar la selección */
	private JButton confirmar;
	
	/** Panel del encabezado superior */
	private JPanel panelEncabezado;
	
	/** Etiqueta con el logo de la aplicación */
	private JLabel imagenLogo;
	
	/** Etiqueta con el texto del encabezado */
	private JLabel textoEncabezado;
	
	/** Panel principal de contenido */
	private JPanel panelContenido;

	/** Color principal de la aplicación (rosa Tinder) */
	private Color colorTinder = new Color(255, 51, 102);
	
	/** Fuente principal para textos grandes */
	private Font campoFuente = new Font("Segoe UI", Font.PLAIN, 30);
	
	/** Fuente secundaria para textos medianos */
	private Font campoFuente2 = new Font("Segoe UI", Font.PLAIN, 20);
	
	/**
	 * Constructor que inicializa el panel de selección de idioma.
	 * Crea la interfaz con un combobox de idiomas decorado con banderas.
	 */
	public Idioma() {
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);

		panelEncabezado = new JPanel();
		panelEncabezado.setLayout(null);
		panelEncabezado.setBounds(0, 0, 1280, 100);

		panelEncabezado.setBackground(colorTinder); 

		imagenLogo = new JLabel(new ImageIcon("Resources/logo.png"));
		imagenLogo.setBounds(0, 5, 250, 80);
		panelEncabezado.add(imagenLogo);

		this.add(panelEncabezado);

		panelContenido = new JPanel();
		panelContenido.setLayout(null);
		panelContenido.setBounds(0, 100, 1280, 620);
		panelContenido.setBackground(new Color(59, 59, 59));
		this.add(panelContenido);

		textoEncabezado = new JLabel("¿Estás preparado para encontrar tu match perfecto?", JLabel.CENTER);
		textoEncabezado.setFont(campoFuente);
		textoEncabezado.setForeground(Color.WHITE);
		textoEncabezado.setBounds(100, 40, 1080, 50);
		panelContenido.add(textoEncabezado);

		JPanel panelRecuadro = new JPanel();

		panelRecuadro.setLayout(null);
		panelRecuadro.setBounds(400, 160, 480, 260);
		panelRecuadro.setBackground(new Color(255, 255, 255, 20));
		panelRecuadro.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
		panelContenido.add(panelRecuadro);

		JLabel selecIdioma = new JLabel("Seleccione  idioma", JLabel.CENTER);
		selecIdioma.setBounds(0, 10, 480, 40);
		selecIdioma.setFont(campoFuente);
		selecIdioma.setForeground(Color.WHITE);
		panelRecuadro.add(selecIdioma);

		JPanel panelComboDecorado = new JPanel();
		panelComboDecorado.setLayout(null);
		panelComboDecorado.setBounds(40, 70, 400, 50);
		panelComboDecorado.setBackground(new Color(59, 59, 59));
		panelComboDecorado.setBorder(javax.swing.BorderFactory.createLineBorder(colorTinder, 2, true));
		panelRecuadro.add(panelComboDecorado);

		JLabel iconoMundo = new JLabel("🌐");
		iconoMundo.setBounds(355, 5, 40, 40);
		iconoMundo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
		iconoMundo.setForeground(Color.WHITE);
		panelComboDecorado.add(iconoMundo);

		String[] idiomas = { "Español", "English", "Português", "Русский", "\u4e2d\u56fd\u4eba", "עברית" };
		String[] rutasBanderas = { "Resources/bandera_es.png", "Resources/bandera_usa.png", "Resources/bandera_pt.png",
				"Resources/bandera_rusia.png", "Resources/bandera_china.png", "Resources/bandera_israel.png" };

		comboBox = new JComboBox<>(idiomas);
		comboBox.setBounds(10, 5, 340, 40);
		comboBox.setFont(new Font("Sans", Font.PLAIN, 20));
		comboBox.setBackground(new Color(59, 59, 59));
		comboBox.setForeground(Color.WHITE);
		comboBox.setFocusable(false);
		comboBox.setBorder(null);

		comboBox.setRenderer(new javax.swing.ListCellRenderer<String>() {
			private JLabel label = new JLabel();

			@Override
			public java.awt.Component getListCellRendererComponent(javax.swing.JList<? extends String> list,
					String value, int index, boolean isSelected, boolean cellHasFocus) {

				int i = java.util.Arrays.asList(idiomas).indexOf(value);

				ImageIcon icon = new ImageIcon(rutasBanderas[i]);
				Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				label.setIcon(new ImageIcon(img));

				label.setText("  " + value);
				label.setFont(campoFuente2);
				label.setOpaque(true);
				label.setForeground(Color.WHITE);
				label.setBackground(isSelected ? new Color(255, 51, 102) : new Color(59, 59, 59));
				repaint();
				return label;
			}
		});
		panelComboDecorado.add(comboBox);

		confirmar = new JButton("Confirmar");
		confirmar.setBounds(90, 150, 300, 50);
		CampoRedondeado.aplicarRedondeado(confirmar, 30, colorTinder, Color.WHITE);
		panelRecuadro.add(confirmar);

	}

	/**
	 * Obtiene el combobox de selección de idiomas.
	 * 
	 * @return El combobox de idiomas
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	/**
	 * Establece el combobox de selección de idiomas.
	 * 
	 * @param comboBox El nuevo combobox
	 */
	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	/**
	 * Obtiene el botón de confirmación.
	 * 
	 * @return El botón confirmar
	 */
	public JButton getConfirmar() {
		return confirmar;
	}

	/**
	 * Establece el botón de confirmación.
	 * 
	 * @param confirmar El nuevo botón confirmar
	 */
	public void setConfirmar(JButton confirmar) {
		this.confirmar = confirmar;
	}

	/**
	 * Obtiene el panel del encabezado.
	 * 
	 * @return El panel encabezado
	 */
	public JPanel getPanelEncabezado() {
		return panelEncabezado;
	}

	/**
	 * Establece el panel del encabezado.
	 * 
	 * @param panelEncabezado El nuevo panel encabezado
	 */
	public void setPanelEncabezado(JPanel panelEncabezado) {
		this.panelEncabezado = panelEncabezado;
	}

	/**
	 * Obtiene la etiqueta del logo.
	 * 
	 * @return La etiqueta imagen logo
	 */
	public JLabel getImagenLogo() {
		return imagenLogo;
	}

	/**
	 * Establece la etiqueta del logo.
	 * 
	 * @param imagenLogo La nueva etiqueta logo
	 */
	public void setImagenLogo(JLabel imagenLogo) {
		this.imagenLogo = imagenLogo;
	}

	/**
	 * Obtiene la etiqueta del texto del encabezado.
	 * 
	 * @return La etiqueta texto encabezado
	 */
	public JLabel getTextoEncabezado() {
		return textoEncabezado;
	}

	/**
	 * Establece la etiqueta del texto del encabezado.
	 * 
	 * @param textoEncabezado La nueva etiqueta texto
	 */
	public void setTextoEncabezado(JLabel textoEncabezado) {
		this.textoEncabezado = textoEncabezado;
	}

	/**
	 * Obtiene el panel de contenido principal.
	 * 
	 * @return El panel contenido
	 */
	public JPanel getPanelContenido() {
		return panelContenido;
	}

	/**
	 * Establece el panel de contenido principal.
	 * 
	 * @param panelContenido El nuevo panel contenido
	 */
	public void setPanelContenido(JPanel panelContenido) {
		this.panelContenido = panelContenido;
	}
}