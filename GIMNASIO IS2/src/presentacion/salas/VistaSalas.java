package presentacion.salas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaSalas {
	private static JFrame GUI = null;
	
	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}
	
	private static JFrame initGUI(){
		JFrame menuPrincipal = new JFrame();
		menuPrincipal.setTitle("Menú CRUD Salas");
		menuPrincipal.setSize(1280, 720);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel principal con margen
		JPanel panel = new JPanel(new GridLayout(3, 2, 20, 20)); // Espaciado entre celdas
		panel.setBackground(new Color(88, 161, 164));
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); // Márgenes exteriores

		// Botones
		Color colorBotones = new Color(48, 86, 119);
		JButton botonAlta = UIElementFactory.crearBoton("Añadir Sala", colorBotones);
		JButton botonReadAll = UIElementFactory.crearBoton("Mostrar Salas", colorBotones);
		JButton botonRead = UIElementFactory.crearBoton("Mostrar Sala", colorBotones);
		JButton botonUnroll = UIElementFactory.crearBoton("Eliminar Sala", colorBotones);
		JButton botonModClient = UIElementFactory.crearBoton("Modificar Sala", colorBotones);
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

		// Listeners
		botonAlta.addActionListener(e -> {
			Controlador.mostrarVista(Evento.VISTA_ANADIR_SALAS);
		});

		botonReadAll.addActionListener(e -> {
			Controlador.mostrarVista(Evento.VISTA_MOSTRAR_SALAS);
		});
		
		botonRead.addActionListener(e -> {
			Controlador.mostrarVista(Evento.VISTA_MOSTRAR_SALA);
		});
		
		botonUnroll.addActionListener(e -> {
			Controlador.mostrarVista(Evento.VISTA_ELIMINAR_SALA);
		});

		botonModClient.addActionListener(e -> {
			Controlador.mostrarVista(Evento.VISTA_MODIFICAR_SALA);
		});
		
		botonMainMenu.addActionListener(e -> {
			menuPrincipal.setVisible(false);
			Controlador.mostrarVista(Evento.VISTA_MENU_PRINCIPAL);
		});
		
		return menuPrincipal;
	}
	
	public static void actualizar(int evento, Object datos) {
		
	} 
	
}