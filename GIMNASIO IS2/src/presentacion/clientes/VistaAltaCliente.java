package presentacion.clientes;

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

import negocio.tCliente;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaAltaCliente {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Alta Cliente");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelAltaCliente = new JPanel();
		panelAltaCliente.setLayout(new BoxLayout(panelAltaCliente, BoxLayout.Y_AXIS));
		panelAltaCliente.setBackground(new Color(17, 47, 69));
		panelAltaCliente.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelAltaCliente, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Añadir Cliente");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAltaCliente.add(titulo);
		panelAltaCliente.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(3, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel dni = new JLabel("DNI:");
		dni.setForeground(Color.WHITE);
		panelCampos.add(dni);
		JTextField dniTF = new JTextField(30);
		panelCampos.add(dniTF);

		JLabel nombre = new JLabel("Nombre:");
		nombre.setForeground(Color.WHITE);
		panelCampos.add(nombre);
		JTextField nombreTF = new JTextField(30);
		panelCampos.add(nombreTF);

		JLabel dir = new JLabel("Dirección:");
		dir.setForeground(Color.WHITE);
		panelCampos.add(dir);
		JTextField dirTF = new JTextField(30);
		panelCampos.add(dirTF);

		panelAltaCliente.add(panelCampos);
		panelAltaCliente.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton save = UIElementFactory.crearBotonConIcono("icons/save.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(save);
		botones.add(botonMainMenu);

		panelAltaCliente.add(botones);
		menuPrincipal.setVisible(true);

		save.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String dni = dniTF.getText();
				String nombre = nombreTF.getText();
				String dir = dirTF.getText();
				if (dni.isEmpty() || nombre.isEmpty() || dir.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					dniTF.setText("");
					nombreTF.setText("");
					dirTF.setText("");
					tCliente c = new tCliente(dni, nombre, dir);
					Controlador.accion(Evento.ALTA_CLIENTE, c);
				}
			}
		});

		back.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
			}
		});

		botonMainMenu.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_MENU_PRINCIPAL);
			}
		});

		return menuPrincipal;
	}

	public static void actualizar(int evento, Object datos) {
		if (evento == Evento.RES_ALTA_CLIENTE_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "El cliente se ha insertado correctamente con ID: " + datos.toString());
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_ALTA_CLIENTE_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar el cliente");
		}
	}
}
