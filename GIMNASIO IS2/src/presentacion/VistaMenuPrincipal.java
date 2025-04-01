package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
		menuPrincipal.setTitle("Menú Principal");
		menuPrincipal.setSize(1280, 720);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel principal con margen
		JPanel panel = new JPanel(new GridLayout(3, 3, 25, 25)); // Espaciado entre celdas
		panel.setBackground(new Color(88, 161, 164));
		panel.setMinimumSize(new Dimension(400, 400));
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); // Márgenes exteriores

		// Botones
		JButton botonCliente = crearBoton("Clientes");
		JButton botonFacturas = crearBoton("Facturas");
		JButton botonSalas = crearBoton("Salas");
		JButton botonEmpleados = crearBoton("Empleados");

		// Logo
		ImageIcon logo = new ImageIcon("icons/logo.png");
		JLabel logoL = new JLabel(logo, JLabel.CENTER);

		// Agregar elementos en orden al grid
		panel.add(botonCliente);
		panel.add(Box.createRigidArea(new Dimension(80, 1)));
		panel.add(botonFacturas);
		panel.add(Box.createRigidArea(new Dimension(80, 1)));
		panel.add(logoL);
		panel.add(Box.createRigidArea(new Dimension(80, 1)));
		panel.add(botonSalas);
		panel.add(Box.createRigidArea(new Dimension(80, 1)));
		panel.add(botonEmpleados);

		menuPrincipal.add(panel);
		menuPrincipal.setVisible(true);


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

	private static JButton crearBoton(String texto) {
		JButton boton = new JButton(texto);
		boton.setForeground(Color.WHITE);
		boton.setBackground(new Color(48, 86, 119));
		return boton;
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
