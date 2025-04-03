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
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.ButtonFactory;
import presentacion.Controlador;
import presentacion.Evento;

public class VistaMostrarCliente {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Mostrar Cliente");
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

		JLabel titulo = new JLabel("Mostrar Cliente");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelBajaCliente.add(titulo);
		panelBajaCliente.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(1, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel id = new JLabel("ID:");
		id.setForeground(Color.WHITE);
		panelCampos.add(id);
		JTextField idTF = new JTextField(30);
		panelCampos.add(idTF);

		panelBajaCliente.add(panelCampos);
		panelBajaCliente.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = ButtonFactory.crearBotonConIcono("icons/back.png");
		JButton delete = ButtonFactory.crearBoton("Mostrar",  new Color(67, 75, 172));
		JButton botonMainMenu = ButtonFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(delete);
		botones.add(botonMainMenu);

		panelBajaCliente.add(botones);
		menuPrincipal.setVisible(true);


		delete.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				int id = Integer.parseInt(idTF.getText());
				Controlador.accion(Evento.ELIMINAR_CLIENTE, id);
			}
		});

		back.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.accion(Evento.VISTA_CLIENTE, null);
			}
		});

		botonMainMenu.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.accion(Evento.VISTA_MENU_PRINCIPAL, null);
			}
		});
		
		return menuPrincipal;
	}

}
