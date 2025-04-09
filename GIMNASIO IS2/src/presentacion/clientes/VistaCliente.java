package presentacion.clientes;

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

public class VistaCliente {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI(){
		JFrame menuPrincipal = new JFrame();
		menuPrincipal.setTitle("Menú CRUD Cliente");
		menuPrincipal.setSize(1280, 720);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel principal con margen
		JPanel panel = new JPanel(new GridLayout(3, 2, 20, 20)); // Espaciado entre celdas
		panel.setBackground(new Color(88, 161, 164));
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); // Márgenes exteriores

		// Botones
		Color colorBotones = new Color(48, 86, 119);
		JButton botonAlta = UIElementFactory.crearBoton("Añadir Cliente", colorBotones);
		JButton botonReadAll = UIElementFactory.crearBoton("Mostrar Clientes", colorBotones);
		JButton botonRead = UIElementFactory.crearBoton("Mostrar Cliente", colorBotones);
		JButton botonUnroll = UIElementFactory.crearBoton("Dar de Baja Cliente", colorBotones);
		JButton botonModClient = UIElementFactory.crearBoton("Modificar Cliente", colorBotones);
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		// Agregar elementos al panel
		panel.add(botonAlta);
		panel.add(botonReadAll);
		panel.add(botonRead);
		panel.add(botonUnroll);
		panel.add(botonModClient);

		// Agregar el panel y el botón del menú principal
		menuPrincipal.add(panel, BorderLayout.CENTER);
		menuPrincipal.add(botonMainMenu, BorderLayout.SOUTH);
		menuPrincipal.setVisible(true);

		botonAlta.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_ALTA_CLIENTE);
			}
		});

		botonReadAll.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_MOSTRAR_CLIENTES);
			}
		});

		botonRead.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_MOSTRAR_CLIENTE);
			}
		});

		botonUnroll.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_ELIMINAR_CLIENTE);
			}
		});

		botonModClient.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Controlador.mostrarVista(Evento.VISTA_MODIFICAR_CLIENTE);
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