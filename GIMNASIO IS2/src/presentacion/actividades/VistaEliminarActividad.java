package presentacion.actividades;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.DTOtActividad;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaEliminarActividad {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Eliminar Actividad");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelEliminarActividad = new JPanel();
		panelEliminarActividad.setLayout(new BoxLayout(panelEliminarActividad, BoxLayout.Y_AXIS));
		panelEliminarActividad.setBackground(new Color(17, 47, 69));
		panelEliminarActividad.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelEliminarActividad, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Eliminar Actividad");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelEliminarActividad.add(titulo);
		panelEliminarActividad.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(3, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel tipoAct = new JLabel("Tipo de actividad:");
		tipoAct.setForeground(Color.WHITE);
		panelCampos.add(tipoAct);
		JTextField tipoActTF = new JTextField(30);
		panelCampos.add(tipoActTF);

		JLabel fecha = new JLabel("Fecha:");
		fecha.setForeground(Color.WHITE);
		panelCampos.add(fecha);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField fechaTF = new JFormattedTextField(format);
		fechaTF.setColumns(10);
		fechaTF.setValue(new java.util.Date());
		panelCampos.add(fechaTF);

		JLabel idSala = new JLabel("ID Sala:");
		idSala.setForeground(Color.WHITE);
		panelCampos.add(idSala);
		JTextField idSalaTF = new JTextField(30);
		panelCampos.add(idSalaTF);

		panelEliminarActividad.add(panelCampos);
		panelEliminarActividad.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton delete = UIElementFactory.crearBoton("Dar de baja",  new Color(67, 75, 172));
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(delete);
		botones.add(botonMainMenu);

		panelEliminarActividad.add(botones);
		menuPrincipal.setVisible(true);

		delete.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String tipoAct = tipoActTF.getText();
				java.util.Date Date = (java.util.Date) fechaTF.getValue();
				java.sql.Date sqlDate = new java.sql.Date(Date.getTime());
				int idSala = 0;
				boolean idsCorrectos = true;
				try {
					idSala = Integer.parseInt(idSalaTF.getText());
				}catch( NumberFormatException nfe){
					idsCorrectos = false;
					JOptionPane.showMessageDialog(null, "Los IDs solo pueden contener numeros", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (idsCorrectos) {
					tipoActTF.setText("");
					fechaTF.setValue(new java.util.Date());
					idSalaTF.setText("");
					DTOtActividad a = new DTOtActividad(tipoAct, idSala, sqlDate);
					Controlador.accion(Evento.ELIMINAR_ACTIVIDAD, a);
				}
			}
		});

		back.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
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

	public static void actualizar(int evento, Object datos) {
		if (evento == Evento.RES_ELIMINAR_ACTIVIDAD_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "La actividad se ha eliminado correctamente");
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_ELIMINAR_ACTIVIDAD_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido eliminar la actividad");
		}
	}
}
