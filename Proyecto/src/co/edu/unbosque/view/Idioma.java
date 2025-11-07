package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Idioma extends JPanel {

	private JComboBox<String> comboBox;
    private JButton confirmar;
    private JPanel panelEncabezado;
    private JLabel imagenLogo;
    private JLabel textoEncabezado;
    private JPanel panelContenido; 

    public Idioma() {
        this.setLayout(null);
        this.setBounds(0, 0, 1280, 720);

        panelEncabezado = new JPanel();
        panelEncabezado.setLayout(null);
        panelEncabezado.setBounds(0, 0, 1280, 200);

    
        ImageIcon headerIcon = new ImageIcon("Resources/fondoEncabezado.png");
        Image headerImg = headerIcon.getImage().getScaledInstance(1280, 200, Image.SCALE_SMOOTH);
        JLabel headerBg = new JLabel(new ImageIcon(headerImg));
        headerBg.setLayout(null);
        headerBg.setBounds(0, 0, 1280, 200);
      

        imagenLogo = new JLabel(new ImageIcon("Resources/logo.png"));
        imagenLogo.setBounds(0, 5, 250, 80);
        headerBg.add(imagenLogo);

        textoEncabezado = new JLabel("Experimenta el amor con una persona especial");
        textoEncabezado.setFont(new Font("Sans Serif", Font.BOLD, 28));
        textoEncabezado.setForeground(Color.BLACK);
        textoEncabezado.setBounds(370, 100, 800, 40);
        headerBg.add(textoEncabezado);

        panelEncabezado.add(headerBg);
        this.add(panelEncabezado);

        panelContenido = new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setBounds(0, 200, 1280, 520);

        ImageIcon contenidoIcon = new ImageIcon("Resources/fondoContenido.png"); // tu imagen
        Image contenidoImg = contenidoIcon.getImage().getScaledInstance(1280, 520, Image.SCALE_SMOOTH);
        JLabel contenidoBg = new JLabel(new ImageIcon(contenidoImg));
        contenidoBg.setLayout(null);
        contenidoBg.setBounds(0, 0, 1280, 520);
        panelContenido.add(contenidoBg);
        this.add(panelContenido);
        
        JLabel selecIdioma = new JLabel("Seleccione el idioma");
        selecIdioma.setBounds(500, 40, 400, 50);
        selecIdioma.setFont(new Font("Arial", Font.BOLD, 26));
        selecIdioma.setForeground(Color.BLACK);
        contenidoBg.add(selecIdioma);
        
        

        String[] idiomas = { "Español","English", "Português", "Русский", "中文", "עברית" };
        comboBox = new JComboBox<>(idiomas);
        comboBox.setBounds(450, 120, 400, 50);
        comboBox.setFont(new Font("Sans", Font.PLAIN, 20));
        contenidoBg.add(comboBox);

        Color colorTinder = new Color(255, 51, 102); 

        confirmar = new JButton("Confirmar");
        confirmar.setBounds(500, 200, 300, 50);
        confirmar.setFont(new Font("Arial", Font.BOLD, 22));
        confirmar.setBackground(colorTinder); 
        confirmar.setForeground(Color.WHITE);
        confirmar.setFocusPainted(false);
        contenidoBg.add(confirmar);

      
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
       
	}

	public JButton getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(JButton confirmar) {
		this.confirmar = confirmar;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

}
