package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VistaFacturas {
	public VistaFacturas() {
		// ------------------------------------
		// Diseño de la vista
		JFrame menuPrincipal = new JFrame();
		menuPrincipal.setTitle("Menu CRUDs Facturas");
		menuPrincipal.setBounds(100, 100, 450, 300);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new FlowLayout());
		menuPrincipal.getContentPane().setBackground(new Color(88, 161, 164));


		JButton botonAlta = new JButton();
		botonAlta.setText("Crear Factura");
		botonAlta.setBounds(153, 180, 132, 32);
		menuPrincipal.getContentPane().add(botonAlta);

		JButton botonReadAll = new JButton();
		botonReadAll.setText("Mostrar facturas");
		botonReadAll.setBounds(253, 380, 132, 32);
		menuPrincipal.getContentPane().add(botonReadAll);

		JButton botonRead = new JButton();
		botonRead.setText("Mostrar factura");
		botonRead.setBounds(053, 480, 132, 32);
		menuPrincipal.getContentPane().add(botonRead);

		JButton botonListByClient = new JButton();
		botonListByClient.setText("Listar facturas por cliente");
		botonListByClient.setBounds(053, 480, 132, 32);
		menuPrincipal.getContentPane().add(botonListByClient);


		JButton botonMainMenu =  new JButton(new ImageIcon("icons/main_menu.png"));
		botonMainMenu.setActionCommand("Ir a menu principal");
		botonMainMenu.setBorderPainted(false);
		botonMainMenu.setContentAreaFilled(false);
		menuPrincipal.getContentPane().add(botonMainMenu);


		menuPrincipal.setVisible (true);
		// ------------------------------------
		// Listener's
		botonAlta.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
						VistaAltaCliente vac = new VistaAltaCliente();
						Controlador.accion(Evento.ALTA_CLIENTE);
					}
				}
				);


		botonReadAll.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						Controlador.accion(Evento.MOSTRAR_CLIENTES);
					}
				}
				);

		botonListByClient.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
						VistaBajaCliente vbc = new VistaBajaCliente();
						Controlador.accion(Evento.ELIMINAR_CLIENTE);
					}
				}
				);


		botonMainMenu.addActionListener( 
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
						VistaMenuPrincipal vmp = new VistaMenuPrincipal();
					}
				}
				);
	}

	public static void actualizar(int evento, Object datos) {
		if (evento == Evento.RES_MOSTRAR_CLIENTES_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, scrollPane, "CLIENTES", JOptionPane.DEFAULT_OPTION);
		} else if (evento == Evento.RES_MOSTRAR_CLIENTES_KO)
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar ningun cliente");
	} 
}
