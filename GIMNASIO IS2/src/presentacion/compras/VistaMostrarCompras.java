package presentacion.compras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import negocio.DTOtCompra;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaMostrarCompras {

	private static JFrame GUI = null;
	private static JPanel panelMostrarFacturas;

	public static void open() {  
		if (GUI == null) initGUI();
		Controlador.accion(Evento.MOSTRAR_COMPRAS, null);
		GUI.setVisible(true);
	}

	private static void initGUI() {
		GUI = new JFrame("Menú Mostrar Compras");
		GUI.setSize(854, 480);
		GUI.setLocationRelativeTo(null);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(new BorderLayout());
		GUI.getContentPane().setBackground(new Color(17, 47, 69));

		panelMostrarFacturas = new JPanel(new BorderLayout());
		panelMostrarFacturas.setBackground(new Color(17, 47, 69));
		GUI.add(panelMostrarFacturas, BorderLayout.CENTER);

		JPanel botones = new JPanel(new FlowLayout());
		botones.setBackground(new Color(17, 47, 69));
		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");


		botones.add(back);
		botones.add(botonMainMenu);
		GUI.add(botones, BorderLayout.SOUTH);

		back.addActionListener(new ActionListener () {
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

	public static void actualizar(int evento, List<DTOtCompra> res) {
		if (evento == Evento.RES_MOSTRAR_COMPRAS_OK) {
			panelMostrarFacturas.removeAll();
			String[] columnNames = {"ID de Compra", "ID de Suscripcion", "DNI de Cliente", "Fecha", "Metodo de Pago", "ID de Factura", "DNI de Empleado" };
			String[][] data = new String[res.size()][7];

			for (int i = 0; i < res.size(); i++) {
				DTOtCompra c = res.get(i);
				java.sql.Date sqlDate = c.getFecha();
				java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String fechaFormateada = sdf.format(utilDate);
				
				data[i][0] = String.valueOf(c.getId());
				data[i][1] = String.valueOf(c.getSuscripcion());
				data[i][2] = c.getDniCliente();
				data[i][3] = fechaFormateada;
				data[i][4] = c.getMetodoPago();
				data[i][5] = String.valueOf(c.getIdFactura());
				data[i][6] = c.getDniEmpleado();
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
			panelMostrarFacturas.add(scrollPane, BorderLayout.CENTER);
			panelMostrarFacturas.revalidate();
			panelMostrarFacturas.repaint();
		}
		else if (evento == Evento.RES_MOSTRAR_COMPRAS_KO) {
			panelMostrarFacturas.removeAll();
			if (res == null || res.isEmpty()) {
				JLabel mensaje = new JLabel("No hay compras disponibles.", SwingConstants.CENTER);
				mensaje.setForeground(Color.WHITE);
				panelMostrarFacturas.add(mensaje, BorderLayout.CENTER);
			} 
		}
	}

}
