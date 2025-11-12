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

public class SeleccionGustos extends JPanel {

	private JTextField campoEdadMinima;
	private JTextField campoEdadMaxima;
	private JTextField campoEstaturaIdeal;
	private JTextField campoIngresoIdeal;

	private JButton botonConfirmar;

	private JRadioButton divorciada;
	private JRadioButton noDivorciada;

	private ButtonGroup estadoDivorcio;

	private JPanel panelFormulario;
	
	private JButton cambiarModo;

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

	public void limpiarCampos() {
		campoEdadMinima.setText("");
		campoEdadMaxima.setText("");
		campoEstaturaIdeal.setText("");
		campoIngresoIdeal.setText("");
		estadoDivorcio.clearSelection();
	}
	
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

	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Segoe UI", Font.PLAIN, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	public JTextField getCampoEdadMinima() {
		return campoEdadMinima;
	}

	public void setCampoEdadMinima(JTextField campoEdadMinima) {
		this.campoEdadMinima = campoEdadMinima;
	}

	public JTextField getCampoEdadMaxima() {
		return campoEdadMaxima;
	}

	public void setCampoEdadMaxima(JTextField campoEdadMaxima) {
		this.campoEdadMaxima = campoEdadMaxima;
	}

	public JTextField getCampoEstaturaIdeal() {
		return campoEstaturaIdeal;
	}

	public void setCampoEstaturaIdeal(JTextField campoEstaturaIdeal) {
		this.campoEstaturaIdeal = campoEstaturaIdeal;
	}

	public JTextField getCampoIngresoIdeal() {
		return campoIngresoIdeal;
	}

	public void setCampoIngresoIdeal(JTextField campoIngresoIdeal) {
		this.campoIngresoIdeal = campoIngresoIdeal;
	}

	public JButton getBotonConfirmar() {
		return botonConfirmar;
	}

	public void setBotonConfirmar(JButton botonConfirmar) {
		this.botonConfirmar = botonConfirmar;
	}

	public JRadioButton getDivorciada() {
		return divorciada;
	}

	public void setDivorciada(JRadioButton divorciada) {
		this.divorciada = divorciada;
	}

	public JRadioButton getNoDivorciada() {
		return noDivorciada;
	}

	public void setNoDivorciada(JRadioButton noDivorciada) {
		this.noDivorciada = noDivorciada;
	}

	public ButtonGroup getEstadoDivorcio() {
		return estadoDivorcio;
	}

	public void setEstadoDivorcio(ButtonGroup estadoDivorcio) {
		this.estadoDivorcio = estadoDivorcio;
	}

	public JButton getCambiarModo() {
		return cambiarModo;
	}

	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

}
