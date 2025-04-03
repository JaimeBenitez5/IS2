package presentacion.clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JFrame;

import negocio.tCliente;
import presentacion.ButtonFactory;
import presentacion.Controlador;
import presentacion.Evento;

public class VistaMostrarClientes {
	private static JFrame GUI = null;
	private static JPanel panelMostrarClientes;

	public static void open() {  
		if (GUI == null) initGUI();
		GUI.setVisible(true);
		Controlador.accion(Evento.MOSTRAR_CLIENTES, null);
	}

	private static void initGUI() {
		GUI = new JFrame("Menú Mostrar Clientes");
		GUI.setSize(854, 480);
		GUI.setLocationRelativeTo(null);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(new BorderLayout());
		GUI.getContentPane().setBackground(new Color(17, 47, 69));

		// Panel principal donde se mostrarán los clientes
		panelMostrarClientes = new JPanel(new BorderLayout());
		panelMostrarClientes.setBackground(new Color(17, 47, 69));

		// Agregamos un mensaje inicial mientras cargan los datos
		JLabel mensajeInicial = new JLabel("Cargando clientes...", SwingConstants.CENTER);
		mensajeInicial.setForeground(Color.WHITE);
		panelMostrarClientes.add(mensajeInicial, BorderLayout.CENTER);

		GUI.add(panelMostrarClientes, BorderLayout.CENTER);

		// Botones de navegación
		JPanel botones = new JPanel(new FlowLayout());
		botones.setBackground(new Color(17, 47, 69));
		
		JButton back = ButtonFactory.crearBotonConIcono("icons/back.png");
		JButton botonMainMenu = ButtonFactory.crearBotonConIcono("icons/main_menu.png");


		botones.add(back);
		botones.add(botonMainMenu);
		GUI.add(botones, BorderLayout.SOUTH);

		// Acciones de los botones
		back.addActionListener(e -> GUI.setVisible(false));

		botonMainMenu.addActionListener(e -> {
			GUI.setVisible(false);
			Controlador.accion(Evento.VISTA_MENU_PRINCIPAL, null);
		});

		GUI.setVisible(true);
	}
	
	public static void actualizar(int evento, List<tCliente> datos) {
		if (evento == Evento.RES_MOSTRAR_CLIENTES_OK) {
	        // Limpiar el panel antes de actualizarlo
	        panelMostrarClientes.removeAll();

	        if (datos == null || datos.isEmpty()) {
	            JLabel mensaje = new JLabel("No hay clientes disponibles.", SwingConstants.CENTER);
	            mensaje.setForeground(Color.WHITE);
	            panelMostrarClientes.add(mensaje, BorderLayout.CENTER);
	        } else {
	            String[] columnNames = {"ID", "Nombre"};
	            String[][] data = new String[datos.size()][2];

	            for (int i = 0; i < datos.size(); i++) {
	                tCliente cliente = datos.get(i);
	                data[i][0] = String.valueOf(cliente.getId());
	                data[i][1] = cliente.getNombre();
	            }

	            JTable tablaClientes = new JTable(data, columnNames);
	            JScrollPane scrollPane = new JScrollPane(tablaClientes);
	            panelMostrarClientes.add(scrollPane, BorderLayout.CENTER);
	        }
	        // Refrescar la GUI
	        panelMostrarClientes.revalidate();
	        panelMostrarClientes.repaint();
	    }
	}
}
