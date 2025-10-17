package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InicioSesion extends JPanel {

	private JTextField campoUsuario;
	private JTextField campoContrasena;

	private JButton botonConfirmar;
	private JButton botonRegistrarse;

	public InicioSesion() {

		this.setLayout(null);
		this.setBackground(new Color(36, 41, 46));

		JPanel derecha = new JPanel();

		derecha.setBounds(640, 0, 640, 720);
		derecha.setBackground(new Color(30, 31, 34));

		campoUsuario = new JTextField();
		campoUsuario.setBounds(120, 250, 400, 50);
		campoUsuario.setFont(new Font("Sans", Font.PLAIN, 20));

		campoContrasena = new JTextField();
		campoContrasena.setBounds(120, 370, 400, 50);
		campoContrasena.setFont(new Font("Sans", Font.PLAIN, 20));

		botonConfirmar = new JButton();
		botonConfirmar.setBounds(150, 500, 330, 50);
		botonConfirmar.setFont(new Font("Sans", Font.BOLD, 25));
		botonConfirmar.setBackground(new Color(3, 102, 214));
		botonConfirmar.setForeground(Color.white);
		botonConfirmar.setFocusable(false);
		botonConfirmar.setFocusPainted(false);
		botonConfirmar.setBorderPainted(false);

		botonRegistrarse = new JButton();
		botonRegistrarse.setBounds(135, 580, 200, 14);
		botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 14));
		botonRegistrarse.setForeground(new Color(0, 102, 204));
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

}
