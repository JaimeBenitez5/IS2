package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VistaMenuPrincipal {
	public VistaMenuPrincipal() {

		JFrame menuPrincipal = new JFrame();
		menuPrincipal.setTitle("Menu Principal");
		menuPrincipal.setBounds(100, 100, 450, 300);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new FlowLayout());
		menuPrincipal.getContentPane().setBackground(new Color(88, 161, 164));

		JButton botonCliente = new JButton();
		botonCliente.setText("Clientes");
		botonCliente.setBounds(153, 180, 132, 32);
		botonCliente.setForeground(Color.WHITE);
		botonCliente.setBackground(new Color(48, 86, 119));
		menuPrincipal.getContentPane().add(botonCliente);

		JButton botonFacturas = new JButton();
		botonFacturas.setText("Facturas");
		botonFacturas.setForeground(Color.WHITE);
		botonFacturas.setBackground(new Color(48, 86, 119));
		botonFacturas.setBounds(253, 380, 132, 32);

		menuPrincipal.getContentPane().add(botonFacturas);

		JButton botonEmpleados = new JButton();
		botonEmpleados.setText("Empleados");
		botonEmpleados.setBounds(053, 480, 132, 32);
		botonEmpleados.setForeground(Color.WHITE);
		botonEmpleados.setBackground(new Color(48, 86, 119));
		menuPrincipal.getContentPane().add(botonEmpleados);

		JButton botonSalas = new JButton();
		botonSalas.setText("Salas");
		botonSalas.setBounds(053, 480, 132, 32);
		botonSalas.setForeground(Color.WHITE);
		botonSalas.setBackground(new Color(48, 86, 119));
		menuPrincipal.getContentPane().add(botonSalas);

		ImageIcon logo = new ImageIcon("icons/logo.png");
		JLabel logoL = new JLabel(logo);

		menuPrincipal.getContentPane().add(logoL);
		menuPrincipal.setVisible (true);

		// Listener's
		botonCliente.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
						VistaCliente vc = new VistaCliente();
					}
				}
				);


		botonFacturas.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
						VistaFacturas vf = new VistaFacturas();
					}
				}
				);

		botonEmpleados.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
						VistaEmpleados ve = new VistaEmpleados();
					}
				}
				);

		botonSalas.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
						VistaSalas vs = new VistaSalas();
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
