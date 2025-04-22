package presentacion.actividades;

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

import negocio.tActividad;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaMostrarActividades {
	private static JFrame GUI = null;
	private static JPanel panelMostrarActividades;

	public static void open() {  
		if (GUI == null) initGUI();
		Controlador.accion(Evento.MOSTRAR_ACTIVIDADES, null);
		GUI.setVisible(true);
	}

	private static void initGUI() {
		GUI = new JFrame("Menú Mostrar Actividades");
		GUI.setSize(854, 480);
		GUI.setLocationRelativeTo(null);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(new BorderLayout());
		GUI.getContentPane().setBackground(new Color(17, 47, 69));

		panelMostrarActividades = new JPanel(new BorderLayout());
		panelMostrarActividades.setBackground(new Color(17, 47, 69));
		GUI.add(panelMostrarActividades, BorderLayout.CENTER);

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

	public static void actualizar(int evento, List<tActividad> res) {
		if (evento == Evento.RES_MOSTRAR_ACTIVIDADES_OK) {
			panelMostrarActividades.removeAll();
			String[] columnNames = {"Tipo de actividad", "ID de Sala" , "Fecha", "ID de Empleado"};
			String[][] data = new String[res.size()][4];

			for (int i = 0; i < res.size(); i++) {
				tActividad a = res.get(i);
				java.sql.Date sqlDate = a.getFecha();
				java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
				
				data[i][0] = a.getTipoActividad();
				data[i][1] = String.valueOf(a.getIdSala());
				data[i][2] = String.valueOf(utilDate);
				data[i][3] = String.valueOf(a.getIdEmpleado());
			}

			JTable tablaActividades = new JTable(data, columnNames);
			JScrollPane scrollPane = new JScrollPane(tablaActividades);
			tablaActividades.setBackground(new Color(17, 47, 69));
			tablaActividades.setForeground(Color.WHITE);
			tablaActividades.setOpaque(false);
			tablaActividades.setShowGrid(false);
			scrollPane.setForeground(new Color(17, 47, 69));
			scrollPane.setOpaque(false);
			scrollPane.getViewport().setOpaque(false);
			panelMostrarActividades.add(scrollPane, BorderLayout.CENTER);
			panelMostrarActividades.revalidate();
			panelMostrarActividades.repaint();
		}
		else if (evento == Evento.RES_MOSTRAR_ACTIVIDADES_KO) {
			panelMostrarActividades.removeAll();
			if (res == null || res.isEmpty()) {
				JLabel mensaje = new JLabel("No hay actividades disponibles.", SwingConstants.CENTER);
				mensaje.setForeground(Color.WHITE);
				panelMostrarActividades.add(mensaje, BorderLayout.CENTER);
			} 
		}
	}
}
