package presentacion.catalogos;

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

import negocio.DTOtCatalogo;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaMostrarCatalogos {
	private static JFrame GUI = null;
	private static JPanel panelMostrarCatalogos;

	public static void open() {  
		if (GUI == null) initGUI();
		Controlador.accion(Evento.MOSTRAR_CATALOGOS, null);
		GUI.setVisible(true);
	}

	private static void initGUI() {
		GUI = new JFrame("Menú Mostrar Catalogos");
		GUI.setSize(854, 480);
		GUI.setLocationRelativeTo(null);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(new BorderLayout());
		GUI.getContentPane().setBackground(new Color(17, 47, 69));

		panelMostrarCatalogos = new JPanel(new BorderLayout());
		panelMostrarCatalogos.setBackground(new Color(17, 47, 69));
		GUI.add(panelMostrarCatalogos, BorderLayout.CENTER);

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

	public static void actualizar(int evento, List<DTOtCatalogo> datos) {
		if (evento == Evento.RES_MOSTRAR_CATALOGOS_OK) {
			panelMostrarCatalogos.removeAll();
			String[] columnNames = {"ID", "Numero de actividades", "Actividades"};
			String[][] data = new String[datos.size()][3];

			for (int i = 0; i < datos.size(); i++) {
				DTOtCatalogo catalogo = datos.get(i);
				data[i][0] = String.valueOf(catalogo.getId());
				data[i][1] = String.valueOf(catalogo.getNumActividades());
				data[i][2] = String.valueOf(catalogo.getActividades());
			}

			JTable tablaCatalogos = new JTable(data, columnNames);
			tablaCatalogos.setAutoCreateRowSorter(true);
			JScrollPane scrollPane = new JScrollPane(tablaCatalogos);
			tablaCatalogos.setBackground(new Color(17, 47, 69));
			tablaCatalogos.setForeground(Color.WHITE);
			tablaCatalogos.setOpaque(false);
			tablaCatalogos.setShowGrid(false);
			scrollPane.setForeground(new Color(17, 47, 69));
			scrollPane.setOpaque(false);
			scrollPane.getViewport().setOpaque(false);
			panelMostrarCatalogos.add(scrollPane, BorderLayout.CENTER);
			panelMostrarCatalogos.revalidate();
			panelMostrarCatalogos.repaint();
		}
		else if (evento == Evento.RES_MOSTRAR_CATALOGOS_KO) {
			panelMostrarCatalogos.removeAll();
			if (datos == null || datos.isEmpty()) {
				JLabel mensaje = new JLabel("No hay catalogos disponibles.", SwingConstants.CENTER);
				mensaje.setForeground(Color.WHITE);
				panelMostrarCatalogos.add(mensaje, BorderLayout.CENTER);
			} 
		}
	}
}
