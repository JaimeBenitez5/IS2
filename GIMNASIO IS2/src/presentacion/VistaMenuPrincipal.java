package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaMenuPrincipal {
	private static JFrame GUI = null;
	
	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}
	
	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame();
		menuPrincipal.setTitle("Menú Principal");
		menuPrincipal.setSize(1280, 720);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel principal con margen
		JPanel mainPanel = new JPanel(new GridLayout(3, 3, 25, 25));
		mainPanel.setPreferredSize(new Dimension(400, 400));
		mainPanel.setBackground(new Color(88, 161, 164));
		mainPanel.setMinimumSize(new Dimension(400, 400));
		mainPanel.setPreferredSize(new Dimension(400, 400));
		mainPanel.setMaximumSize(new Dimension(400, 400));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		// Botones
		Color colorBotones = new Color(48, 86, 119);
		JButton botonCliente = ButtonFactory.crearBoton("Clientes", colorBotones);
		JButton botonFacturas = ButtonFactory.crearBoton("Facturas",colorBotones);
		JButton botonSalas = ButtonFactory.crearBoton("Salas", colorBotones);
		JButton botonEmpleados = ButtonFactory.crearBoton("Empleados",colorBotones);

		// Logo
		ImageIcon logo = new ImageIcon("icons/logo.png");
		JLabel logoL = new JLabel(logo, JLabel.CENTER);

		// Agregar elementos en orden al grid
		mainPanel.add(botonCliente);
		mainPanel.add(Box.createRigidArea(new Dimension(1, 1)));
		mainPanel.add(botonFacturas);
		mainPanel.add(Box.createRigidArea(new Dimension(1, 1)));
		mainPanel.add(logoL);
		mainPanel.add(Box.createRigidArea(new Dimension(1, 1)));
		mainPanel.add(botonSalas);
		mainPanel.add(Box.createRigidArea(new Dimension(1, 1)));
		mainPanel.add(botonEmpleados);

		menuPrincipal.add(mainPanel);
		menuPrincipal.setVisible(true);
		
		// Listener's
		botonCliente.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
						Controlador.mostrarVista(Evento.VISTA_CLIENTE);
					}
				}
				);

		botonFacturas.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
						Controlador.mostrarVista(Evento.VISTA_FACTURAS);
					}
				}
				);

		botonEmpleados.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
					}
				}
				);

		botonSalas.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						menuPrincipal.setVisible (false);
					}
				}
				);
		return menuPrincipal;
	}
	
}
