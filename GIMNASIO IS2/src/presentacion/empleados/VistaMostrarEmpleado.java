package presentacion.empleados;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.DTOtEmpleado;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaMostrarEmpleado {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Mostrar Empleado");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelMostrarEmpleados = new JPanel();
		panelMostrarEmpleados.setLayout(new BoxLayout(panelMostrarEmpleados, BoxLayout.Y_AXIS));
		panelMostrarEmpleados.setBackground(new Color(17, 47, 69));
		panelMostrarEmpleados.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelMostrarEmpleados, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Mostrar Empleado");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelMostrarEmpleados.add(titulo);
		panelMostrarEmpleados.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(1, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel dni = new JLabel("DNI:");
		dni.setForeground(Color.WHITE);
		panelCampos.add(dni);
		JTextField dniEmpTF = new JTextField(30);
		panelCampos.add(dniEmpTF);

		panelMostrarEmpleados.add(panelCampos);
		panelMostrarEmpleados.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton mostrar = UIElementFactory.crearBoton("Mostrar",  new Color(67, 75, 172));
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(mostrar);
		botones.add(botonMainMenu);

		panelMostrarEmpleados.add(botones);
		menuPrincipal.setVisible(true);


		mostrar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String dniEmpleado = dniEmpTF.getText();
				Controlador.accion(Evento.MOSTRAR_EMPLEADO, dniEmpleado);
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
	
	public static void actualizar(int evento, DTOtEmpleado empleado) {
		if (evento == Evento.RES_MOSTRAR_EMPLEADO_OK) {
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 200));
			String dni = empleado.getDni();
			String nombre = empleado.getNombre();
			JOptionPane.showMessageDialog(null, "ID: " + dni + " Nombre: " + nombre);
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_MOSTRAR_EMPLEADO_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar el empleado");
		}
	}
}
