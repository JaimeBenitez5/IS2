package presentacion.clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JFrame;

import negocio.tCliente;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaMostrarClientes {
	private static JFrame GUI = null;
	private static JPanel panelMostrarClientes;

	public static void open() {  
		if (GUI == null) initGUI();
		Controlador.accion(Evento.MOSTRAR_CLIENTES, null);
		GUI.setVisible(true);
	}

	private static void initGUI() {
		GUI = new JFrame("Menú Mostrar Clientes");
		GUI.setSize(854, 480);
		GUI.setLocationRelativeTo(null);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(new BorderLayout());
		GUI.getContentPane().setBackground(new Color(17, 47, 69));

		panelMostrarClientes = new JPanel(new BorderLayout());
		panelMostrarClientes.setBackground(new Color(17, 47, 69));
		GUI.add(panelMostrarClientes, BorderLayout.CENTER);

		JPanel botones = new JPanel(new FlowLayout());
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");


		botones.add(back);
		botones.add(botonMainMenu);
		GUI.add(botones, BorderLayout.SOUTH);

		back.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				GUI.setVisible (false);
			}
		});


		botonMainMenu.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				GUI.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_MENU_PRINCIPAL);
			}
		});
		GUI.setVisible(true);
	}

	public static void actualizar(int evento, List<tCliente> datos) {
		if (evento == Evento.RES_MOSTRAR_CLIENTES_OK) {
			panelMostrarClientes.removeAll();
			String[] columnNames = {"ID", "Nombre", "Direccion", "Activo"};
			String[][] data = new String[datos.size()][4];

			for (int i = 0; i < datos.size(); i++) {
				tCliente cliente = datos.get(i);
				data[i][0] = String.valueOf(cliente.getId());
				data[i][1] = cliente.getNombre();
				data[i][2] = cliente.getDir();
				data[i][3] = cliente.getActivo() + "";
			}

			JTable tablaClientes = new JTable(data, columnNames);
			JScrollPane scrollPane = new JScrollPane(tablaClientes);
			tablaClientes.setBackground(new Color(17, 47, 69));
			tablaClientes.setForeground(Color.WHITE);
			tablaClientes.setOpaque(false);
			tablaClientes.setShowGrid(false);
			scrollPane.setForeground(new Color(17, 47, 69));
			scrollPane.setOpaque(false);
			scrollPane.getViewport().setOpaque(false);
			panelMostrarClientes.add(scrollPane, BorderLayout.CENTER);

			panelMostrarClientes.revalidate();
			panelMostrarClientes.repaint();
		}
		else if (evento == Evento.RES_MOSTRAR_CLIENTES_KO) {
			panelMostrarClientes.removeAll();
			if (datos == null || datos.isEmpty()) {
				JLabel mensaje = new JLabel("No hay clientes disponibles.", SwingConstants.CENTER);
				mensaje.setForeground(Color.WHITE);
				panelMostrarClientes.add(mensaje, BorderLayout.CENTER);
			} 
		}
	}
}
