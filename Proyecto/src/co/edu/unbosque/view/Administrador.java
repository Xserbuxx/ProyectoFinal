package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Administrador extends JPanel {

	private JScrollPane scrollPanel;
	private JPanel panelUsuarios;

	public Administrador() {
		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));

		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(new Color(36, 41, 46));
		panelUsuarios.setLayout(new GridLayout(0, 1, 10, 10));

		scrollPanel = new JScrollPane(panelUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 60, 1260, 640);
		scrollPanel.setBackground(new Color(36, 41, 46));

		this.add(scrollPanel);
	}

	public void agregarUsuario(String alias, ImageIcon imagen, int edad, float estatura, ActionListener listener) {
		panelUsuarios.add(new PanelUsuarioAdmin(alias, imagen, edad, estatura, listener));
	}

	public void agregarUsuario(String alias, ImageIcon imagen, int edad, float estatura, ActionListener listener,
			String ingresoProm) {
		panelUsuarios.add(new PanelUsuarioAdmin(alias, imagen, edad, estatura, listener, ingresoProm));
	}

	public void limpiarUsuarios() {
		panelUsuarios.removeAll();
		panelUsuarios.revalidate();
		panelUsuarios.repaint();
	}

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
	}

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
	}

	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}

	public void setScrollPanel(JScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}

	public JPanel getPanelUsuarios() {
		return panelUsuarios;
	}

	public void setPanelUsuarios(JPanel panelUsuarios) {
		this.panelUsuarios = panelUsuarios;
	}

}
