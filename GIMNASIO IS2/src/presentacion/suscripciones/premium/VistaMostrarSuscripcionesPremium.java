package presentacion.suscripciones.premium;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import negocio.DTOtCliente;
import negocio.DTOtPremium;
import negocio.DTOtSuscripcion;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaMostrarSuscripcionesPremium {
	private static JFrame GUI = null;
	private static JPanel panelMostrarSuscripciones;

	public static void open() {  
		if (GUI == null) initGUI();
		Controlador.accion(Evento.MOSTRAR_SUSCRIPCIONES_PREMIUM, null);
		GUI.setVisible(true);
	}

	private static void initGUI() {
		GUI = new JFrame("Menú Mostrar Suscripciones");
		GUI.setSize(854, 480);
		GUI.setLocationRelativeTo(null);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(new BorderLayout());
		GUI.getContentPane().setBackground(new Color(17, 47, 69));

		panelMostrarSuscripciones = new JPanel(new BorderLayout());
		panelMostrarSuscripciones.setBackground(new Color(17, 47, 69));
		GUI.add(panelMostrarSuscripciones, BorderLayout.CENTER);

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

	public static void actualizar(int evento, List<DTOtSuscripcion> datos) {
		if (evento == Evento.RES_MOSTRAR_SUSCRIPCIONES_PREMIUM_OK) {
			panelMostrarSuscripciones.removeAll();
			String[] columnNames = {"ID de Suscripcion", "Nombre", "Duracion", "DNI de Empleado", "ID de Catalogo"};
			String[][] data = new String[datos.size()][5];

			for (int i = 0; i < datos.size(); i++) {
				DTOtPremium suscripcion = (DTOtPremium) datos.get(i);
				data[i][0] = String.valueOf(suscripcion.getIdSuscripcion());
				data[i][1] = String.valueOf(suscripcion.getNombre());
				data[i][2] = String.valueOf(suscripcion.getDuracion());
				data[i][3] = String.valueOf(suscripcion.getDniEmpleado());
				data[i][4] = String.valueOf(suscripcion.getIdCatalogo());
			}

			JTable tablaSuscripciones = new JTable(data, columnNames);
			JScrollPane scrollPane = new JScrollPane(tablaSuscripciones);
			tablaSuscripciones.setBackground(new Color(17, 47, 69));
			tablaSuscripciones.setForeground(Color.WHITE);
			tablaSuscripciones.setOpaque(false);
			tablaSuscripciones.setShowGrid(false);
			scrollPane.setForeground(new Color(17, 47, 69));
			scrollPane.setOpaque(false);
			scrollPane.getViewport().setOpaque(false);
			panelMostrarSuscripciones.add(scrollPane, BorderLayout.CENTER);

			panelMostrarSuscripciones.revalidate();
			panelMostrarSuscripciones.repaint();
		}
		else if (evento == Evento.RES_MOSTRAR_SUSCRIPCIONES_PREMIUM_KO) {
			panelMostrarSuscripciones.removeAll();
			if (datos == null || datos.isEmpty()) {
				JLabel mensaje = new JLabel("No hay suscripciones disponibles.", SwingConstants.CENTER);
				mensaje.setForeground(Color.WHITE);
				panelMostrarSuscripciones.add(mensaje, BorderLayout.CENTER);
			} 
		}
	}
}
