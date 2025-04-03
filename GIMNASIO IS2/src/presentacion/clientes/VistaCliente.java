package presentacion.clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentacion.Controlador;
import presentacion.Evento;
import presentacion.VistaMenuPrincipal;

public class VistaCliente {
	public VistaCliente() {
		// ------------------------------------
		// Diseño de la vista
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
		JButton botonAlta = crearBoton("Alta Cliente");
		JButton botonReadAll = crearBoton("Mostrar Clientes");
		JButton botonRead = crearBoton("Mostrar Cliente");
		JButton botonUnroll = crearBoton("Dar de Baja Cliente");
		JButton botonModClient = crearBoton("Modificar Cliente");
		// Botón de regreso al menú principal con icono
		JButton botonMainMenu = new JButton(new ImageIcon("icons/main_menu.png"));
		botonMainMenu.setBorderPainted(false);
		botonMainMenu.setContentAreaFilled(false);
		botonMainMenu.setActionCommand("Ir a Menú Principal");

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
			menuPrincipal.setVisible(false);
			Controlador.accion(Evento.ALTA_CLIENTE, null);
		});

		botonReadAll.addActionListener(e -> {
			menuPrincipal.setVisible(false);
			new VistaMostrarClientes();
			Controlador.accion(Evento.MOSTRAR_CLIENTES, null);
		});
		
		botonRead.addActionListener(e -> {
			menuPrincipal.setVisible(false);
			new VistaMostrarCliente();
			Controlador.accion(Evento.MOSTRAR_CLIENTE, null);
		});
		
		botonUnroll.addActionListener(e -> {
			menuPrincipal.setVisible(false);
			Controlador.accion(Evento.ELIMINAR_CLIENTE, null);
		});


		botonModClient.addActionListener(e -> {
			menuPrincipal.setVisible(false);
			Controlador.accion(Evento.MODIFICAR_CLIENTE, null);
		});
		
		botonMainMenu.addActionListener(e -> {
			menuPrincipal.setVisible(false);
			new VistaMenuPrincipal();
		});
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