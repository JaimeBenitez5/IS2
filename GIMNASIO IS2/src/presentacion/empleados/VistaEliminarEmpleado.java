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

import presentacion.Comprobaciones;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaEliminarEmpleado {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Baja Empleado");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelBajaEmpleado = new JPanel();
		panelBajaEmpleado.setLayout(new BoxLayout(panelBajaEmpleado, BoxLayout.Y_AXIS));
		panelBajaEmpleado.setBackground(new Color(17, 47, 69));
		panelBajaEmpleado.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelBajaEmpleado, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Dar de baja Empleado");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelBajaEmpleado.add(titulo);
		panelBajaEmpleado.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(1, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel dni = new JLabel("DNI:");
		dni.setForeground(Color.WHITE);
		panelCampos.add(dni);
		JTextField dniTF = new JTextField(30);
		panelCampos.add(dniTF);

		panelBajaEmpleado.add(panelCampos);
		panelBajaEmpleado.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton delete = UIElementFactory.crearBoton("Dar de baja",  new Color(67, 75, 172));
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(delete);
		botones.add(botonMainMenu);

		panelBajaEmpleado.add(botones);
		menuPrincipal.setVisible(true);


		delete.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				int n = JOptionPane.showOptionDialog(menuPrincipal, "🚨 Advertencia, si el empleado a borrar esta asociado a una sala, actividad, suscripcion premium o compra, esta tambien se eliminara. Estas seguro? 🚨", "Advertencia",
						JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);

				if (n == 0) {
					String dniEmp = dniTF.getText().trim();
					if (!Comprobaciones.esDNIValido(dniEmp)) {
						JOptionPane.showMessageDialog(null, "DNI no valido. Debe tener 8 numeros y una letra al final", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else Controlador.accion(Evento.ELIMINAR_EMPLEADO, dniEmp);
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
		if (evento == Evento.RES_ELIMINAR_EMPLEADO_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 200));
			JOptionPane.showMessageDialog(null, "El empleado se ha eliminado correctamente");
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_ELIMINAR_EMPLEADO_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido eliminar el empleado");
		}
	}
}
