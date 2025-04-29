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

import presentacion.Comprobaciones;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaBajaCliente {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Baja Cliente");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelBajaCliente = new JPanel();
		panelBajaCliente.setLayout(new BoxLayout(panelBajaCliente, BoxLayout.Y_AXIS));
		panelBajaCliente.setBackground(new Color(17, 47, 69));
		panelBajaCliente.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelBajaCliente, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Dar de baja Cliente");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelBajaCliente.add(titulo);
		panelBajaCliente.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(1, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel dni = new JLabel("DNI:");
		dni.setForeground(Color.WHITE);
		panelCampos.add(dni);
		JTextField dniTF = new JTextField(30);
		panelCampos.add(dniTF);

		panelBajaCliente.add(panelCampos);
		panelBajaCliente.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton delete = UIElementFactory.crearBoton("Dar de baja",  new Color(67, 75, 172));
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(delete);
		botones.add(botonMainMenu);

		panelBajaCliente.add(botones);
		menuPrincipal.setVisible(true);


		delete.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String dni = dniTF.getText().trim();
				if (!Comprobaciones.esDNIValido(dni)) {
					JOptionPane.showMessageDialog(null, "DNI no valido. Debe tener 8 numeros y una letra al final", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					dniTF.setText("");
					Controlador.accion(Evento.ELIMINAR_CLIENTE, dni);
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
		if (evento == Evento.RES_ELIMINAR_CLIENTE_OK) {
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "El cliente se ha eliminado correctamente");
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_ELIMINAR_CLIENTE_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido eliminar el cliente");
		}
	}
}
