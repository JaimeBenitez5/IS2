package presentacion.clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentacion.ButtonFactory;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.VistaMenuPrincipal;

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
		JButton botonAlta = ButtonFactory.crearBoton("Añadir Cliente", colorBotones);
		JButton botonReadAll = ButtonFactory.crearBoton("Mostrar Clientes", colorBotones);
		JButton botonRead = ButtonFactory.crearBoton("Mostrar Cliente", colorBotones);
		JButton botonUnroll = ButtonFactory.crearBoton("Dar de Baja Cliente", colorBotones);
		JButton botonModClient = ButtonFactory.crearBoton("Modificar Cliente", colorBotones);
		JButton botonMainMenu = ButtonFactory.crearBotonConIcono("icons/main_menu.png");

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
			Controlador.accion(Evento.VISTA_ALTA_CLIENTE, null);
		});

		botonReadAll.addActionListener(e -> {
			Controlador.accion(Evento.VISTA_MOSTRAR_CLIENTES, null);
		});
		
		botonRead.addActionListener(e -> {
			Controlador.accion(Evento.VISTA_MOSTRAR_CLIENTE, null);
		});
		
		botonUnroll.addActionListener(e -> {
			Controlador.accion(Evento.VISTA_ELIMINAR_CLIENTE, null);
		});

		botonModClient.addActionListener(e -> {
			Controlador.accion(Evento.VISTA_MODIFICAR_CLIENTE, null);
		});
		
		botonMainMenu.addActionListener(e -> {
			menuPrincipal.setVisible(false);
			Controlador.accion(Evento.VISTA_MENU_PRINCIPAL, null);
		});
		
		return menuPrincipal;
	}
	
	private static JButton crearBoton(String texto) {
		JButton boton = new JButton(texto);
		boton.setForeground(Color.WHITE);
		boton.setBackground(new Color(48, 86, 119));
		return boton;
	}

	public static void actualizar(int evento, Object datos) {
		
	} 
	
}