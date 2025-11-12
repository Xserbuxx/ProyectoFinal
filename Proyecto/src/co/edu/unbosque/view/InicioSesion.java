package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InicioSesion extends JPanel {
	private Font campoFuente = new Font("Segoe UI", Font.PLAIN, 30);
	private JTextField campoUsuario;
	private JTextField campoContrasena;

	private JButton botonConfirmar;
	private JButton botonRegistrarse;
	
	private JButton cambiarModo;

	public InicioSesion() {

		this.setLayout(null);
		this.setBackground(new Color(59, 59, 59));

		JPanel derecha = new JPanel();
		derecha.setBounds(640, 0, 640, 720);
		derecha.setBackground(new Color(30, 31, 34));
		derecha.setLayout(null);

		ImageIcon iconoOriginal = new ImageIcon("Resources/imagenDerecha.jpg");
		Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(640, 720, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

		JLabel imagenLabel = new JLabel(iconoEscalado);
		imagenLabel.setBounds(0, 0, 640, 720);
		derecha.add(imagenLabel);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(120, 250, 400, 50);
		campoUsuario.setFont(campoFuente);
		campoUsuario.setBorder(null);
		campoUsuario.setBackground(Color.WHITE);
		this.add(campoUsuario);

		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(120, 370, 400, 50);
		campoContrasena.setFont(campoFuente);
		campoContrasena.setBorder(null);
		campoContrasena.setBackground(Color.WHITE);
		this.add(campoContrasena);

		Color colorTinder = new Color(255, 51, 102);
		botonConfirmar = new JButton();
		botonConfirmar.setBounds(150, 500, 330, 50);
		botonConfirmar.setFont(campoFuente);
		botonConfirmar.setBackground(colorTinder);
		botonConfirmar.setForeground(Color.white);
		botonConfirmar.setFocusable(false);
		botonConfirmar.setFocusPainted(false);
		botonConfirmar.setBorderPainted(false);

		botonRegistrarse = new JButton();
		botonRegistrarse.setBounds(135, 580, 200, 14);
		botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 14));
		botonRegistrarse.setForeground(new Color(255, 51, 102));
		botonRegistrarse.setHorizontalAlignment(SwingConstants.LEFT);
		botonRegistrarse.setContentAreaFilled(false);
		botonRegistrarse.setBorderPainted(false);
		botonRegistrarse.setFocusPainted(false);
		
		cambiarModo = new JButton();
		cambiarModo.setBounds(1000, 10, 200, 50);
		cambiarModo.setBackground(colorTinder);
		cambiarModo.setBorderPainted(false);
		cambiarModo.setFocusPainted(false);
		cambiarModo.setFocusable(false);
		
		this.add(cambiarModo);
		this.add(derecha);
		this.add(campoUsuario);
		this.add(campoContrasena);
		this.add(botonConfirmar);
		this.add(botonRegistrarse);

	}
	
	public void cambiarModo() {
		if (this.getBackground().equals(new Color(59, 59, 59))) {
			this.setBackground(Color.white);
			for (int i = 0; i < this.getComponentCount(); i++) {
				if (this.getComponent(i) instanceof JLabel) {
					((JLabel) this.getComponent(i)).setForeground(Color.black);
				}
				if (this.getComponent(i) instanceof JTextField) {
					this.getComponent(i).setBackground(new Color(59, 59, 59));
					this.getComponent(i).setForeground(Color.white);
				}
			}
		} else {
			this.setBackground(new Color(59, 59, 59));
			for (int i = 0; i < this.getComponentCount(); i++) {
				if (this.getComponent(i) instanceof JLabel) {
					((JLabel) this.getComponent(i)).setForeground(Color.white);
				}
				if (this.getComponent(i) instanceof JTextField) {
					this.getComponent(i).setBackground(Color.white);
					this.getComponent(i).setForeground(Color.black);
				}
			}
		}
	}

	public void mostrarTextos(String labelIniciarSesion, String labelUsuario, String labelContrasena,
			String labelBotonConfirmar, String labelBotonRegistrarse, String labelSinCuenta, String labelCambiarModo) {

		crearLabel(labelIniciarSesion, new Color(255, 255, 255, 200), 120, 100, 400, 50, 40);

		JLabel iconUsuario = new JLabel();
		ImageIcon imgUsuario = new ImageIcon("Resources/iconoUsu.png");
		Image imgU = imgUsuario.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		iconUsuario.setIcon(new ImageIcon(imgU));
		iconUsuario.setBounds(120, 213, 30, 30);
		this.add(iconUsuario);
		crearLabel(labelUsuario, new Color(255, 255, 255, 200), 160, 200, 400, 50, 30);

		JLabel iconContrasena = new JLabel();
		ImageIcon imgContrasena = new ImageIcon("Resources/iconoSegu.png");
		Image imgC = imgContrasena.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		iconContrasena.setIcon(new ImageIcon(imgC));
		iconContrasena.setBounds(120, 328, 30, 30);
		this.add(iconContrasena);

		crearLabel(labelContrasena, new Color(255, 255, 255, 200), 160, 320, 400, 50, 30);

		crearLabel(labelSinCuenta, new Color(255, 255, 255, 200), 150, 550, 200, 30, 14);
		
		cambiarModo.setText(labelCambiarModo);
		
		botonConfirmar.setText(labelBotonConfirmar);
		botonRegistrarse.setText(labelBotonRegistrarse);
	}

	public void crearLabel(String texto, Color colorFondo, int x, int y, int ancho, int alto, int tamanoLetra) {
		JLabel label = new JLabel(texto);
		label.setForeground(colorFondo);
		label.setBounds(x, y, ancho, alto);
		label.setFont(new Font("Sans", Font.BOLD, tamanoLetra));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	public void limpiarCampos() {
		campoUsuario.setText("");
		campoContrasena.setText("");
	}

	public JTextField getCampoUsuario() {
		return campoUsuario;
	}

	public void setCampoUsuario(JTextField campoUsuario) {
		this.campoUsuario = campoUsuario;
	}

	public JTextField getCampoContrasena() {
		return campoContrasena;
	}

	public void setCampoContrasena(JTextField campoContrasena) {
		this.campoContrasena = campoContrasena;
	}

	public JButton getBotonConfirmar() {
		return botonConfirmar;
	}

	public void setBotonConfirmar(JButton botonConfirmar) {
		this.botonConfirmar = botonConfirmar;
	}

	public JButton getBotonRegistrarse() {
		return botonRegistrarse;
	}

	public void setBotonRegistrarse(JButton botonRegistrarse) {
		this.botonRegistrarse = botonRegistrarse;
	}

	public JButton getCambiarModo() {
		return cambiarModo;
	}

	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

}
