package presentacion.suscripciones.basica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaSuscripcionesBasica {
private static JFrame GUI = null;
	
	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}
	
	private static JFrame initGUI(){
		JFrame menuPrincipal = new JFrame();
		menuPrincipal.setTitle("Menú CRUD Suscripciones");
		menuPrincipal.setSize(1280, 720);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridLayout(3, 2, 20, 20));
		panel.setBackground(new Color(88, 161, 164));
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		Color colorBotones = new Color(48, 86, 119);
		JButton botonAlta = UIElementFactory.crearBoton("Añadir Suscripción", colorBotones);
		JButton botonReadAll = UIElementFactory.crearBoton("Mostrar Suscripciones", colorBotones);
		JButton botonRead = UIElementFactory.crearBoton("Mostrar Suscripción", colorBotones);
		JButton botonUnroll = UIElementFactory.crearBoton("Eliminar Suscripción", colorBotones);
		JButton botonModClient = UIElementFactory.crearBoton("Modificar Suscripción", colorBotones);
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		panel.add(botonAlta);
		panel.add(botonReadAll);
		panel.add(botonRead);
		panel.add(botonUnroll);
		panel.add(botonModClient);

		menuPrincipal.add(panel, BorderLayout.CENTER);
		menuPrincipal.add(botonMainMenu, BorderLayout.SOUTH);
		menuPrincipal.setVisible(true);
		
		botonAlta.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_ANADIR_SUSCRIPCION_BASICA);
			}
		});

		botonReadAll.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_MOSTRAR_SUSCRIPCIONES_BASICA);
			}
		});

		botonRead.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_MOSTRAR_SUSCRIPCION_BASICA);
			}
		});

		botonUnroll.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_ELIMINAR_SUSCRIPCION_BASICA);
			}
		});

		botonModClient.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_MODIFICAR_SUSCRIPCION_BASICA);
			}
		});

		botonMainMenu.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_MENU_PRINCIPAL);
			}
		});
		
		return menuPrincipal;
	}
}
