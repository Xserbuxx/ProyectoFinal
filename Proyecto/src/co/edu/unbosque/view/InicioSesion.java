package co.edu.unbosque.view;

import java.awt.BorderLayout;
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

	private JTextField campoUsuario;
	private JTextField campoContrasena;

	private JButton botonConfirmar;
	private JButton botonRegistrarse;

	public InicioSesion() {


		this.setLayout(null);
		this.setBackground(new Color(59, 59, 59));

		
		JPanel derecha = new JPanel();
		derecha.setBounds(640, 0, 640, 720);
		derecha.setBackground(new Color(30, 31, 34));
		derecha.setLayout(null); 

		
		ImageIcon iconoOriginal = new ImageIcon("Resources/imagenDerecha.png");
		Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(640, 720, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

		JLabel imagenLabel = new JLabel(iconoEscalado);
		imagenLabel.setBounds(0, 0, 640, 720);
		derecha.add(imagenLabel);
		
		JPanel panelUsuario = new JPanel(new BorderLayout());
		panelUsuario.setBounds(120, 250, 400, 50);
		panelUsuario.setBackground(Color.WHITE);
		panelUsuario.setBorder(null);

		
		JLabel iconUsuario = new JLabel();
		ImageIcon imgUsuario = new ImageIcon("Resources/iconUsu.png");
		Image imgU = imgUsuario.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconUsuario.setIcon(new ImageIcon(imgU));
		iconUsuario.setHorizontalAlignment(SwingConstants.CENTER);

		panelUsuario.add(iconUsuario, BorderLayout.WEST);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Sans", Font.PLAIN, 20));
		campoUsuario.setBorder(null);

		panelUsuario.add(campoUsuario, BorderLayout.CENTER);

		this.add(panelUsuario);

		
		JPanel panelContrasena = new JPanel(new BorderLayout());
		panelContrasena.setBounds(120, 370, 400, 50);
		panelContrasena.setBackground(Color.WHITE);
		panelContrasena.setBorder(null);

		JLabel iconContrasena = new JLabel();
		ImageIcon imgContrasena = new ImageIcon("Resources/iconLock.png");
		Image imgC = imgContrasena.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconContrasena.setIcon(new ImageIcon(imgC));
		iconContrasena.setHorizontalAlignment(SwingConstants.CENTER);

	
		panelContrasena.add(iconContrasena, BorderLayout.WEST);

		campoContrasena = new JPasswordField();
		campoContrasena.setFont(new Font("Sans", Font.PLAIN, 20));
		campoContrasena.setBorder(null);

		panelContrasena.add(campoContrasena, BorderLayout.CENTER);

		this.add(panelContrasena);

		Color colorTinder = new Color(255, 51, 102);
		botonConfirmar = new JButton();
		botonConfirmar.setBounds(150, 500, 330, 50);
		botonConfirmar.setFont(new Font("Sans", Font.BOLD, 25));
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

		this.add(campoUsuario);
		this.add(campoContrasena);
		this.add(botonConfirmar);
		this.add(botonRegistrarse);
		this.add(derecha);
	}

	public void mostrarTextos(String labelIniciarSesion, String labelUsuario, String labelContrasena,
			String labelBotonConfirmar, String labelBotonRegistrarse, String labelSinCuenta) {
		crearLabel(labelIniciarSesion, new Color(255, 255, 255, 200), 120, 100, 400, 50, 40);
		crearLabel(labelUsuario, new Color(255, 255, 255, 200), 120, 200, 400, 50, 30);
		crearLabel(labelContrasena, new Color(255, 255, 255, 200), 120, 320, 400, 50, 30);
		crearLabel(labelSinCuenta, new Color(255, 255, 255, 200), 150, 550, 200, 30, 14);

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
	
}
