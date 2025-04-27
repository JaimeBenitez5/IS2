package presentacion;

import java.awt.Color;
import java.awt.Dimension;
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

public class VistaMenuPrincipal{
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Principal");
		menuPrincipal.setSize(1280, 720);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel(new GridLayout(3, 3, 25, 25));
		mainPanel.setPreferredSize(new Dimension(400, 400));
		mainPanel.setBackground(new Color(88, 161, 164));
		mainPanel.setMinimumSize(new Dimension(400, 400));
		mainPanel.setPreferredSize(new Dimension(400, 400));
		mainPanel.setMaximumSize(new Dimension(400, 400));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		Color colorBotones = new Color(48, 86, 119);
		JButton botonCliente = UIElementFactory.crearBoton("Clientes", colorBotones);
		JButton botonFacturas = UIElementFactory.crearBoton("Facturas",colorBotones);
		JButton botonSalas = UIElementFactory.crearBoton("Salas", colorBotones);
		JButton botonActividades = UIElementFactory.crearBoton("Actividades",colorBotones);
		JButton botonEmpleados = UIElementFactory.crearBoton("Empleados",colorBotones);
		JButton botonCatalogos = UIElementFactory.crearBoton("Catalogos",colorBotones);
		JButton botonSuscripciones = UIElementFactory.crearBoton("Suscripciones",colorBotones);
		ImageIcon logo = new ImageIcon("icons/logo.png");
		JLabel logoL = new JLabel(logo, JLabel.CENTER);

		mainPanel.add(botonCliente);
		mainPanel.add(Box.createRigidArea(new Dimension(1, 1)));
		mainPanel.add(botonFacturas);
		mainPanel.add(botonSalas);
		mainPanel.add(logoL);
		mainPanel.add(botonActividades);
		mainPanel.add(botonEmpleados);
		mainPanel.add(botonSuscripciones);
		mainPanel.add(botonCatalogos);

		menuPrincipal.add(mainPanel);
		menuPrincipal.setVisible(true);

		botonCliente.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_CLIENTES);
			}
		});

		botonFacturas.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_FACTURAS);
			}
		});

		botonSalas.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_SALAS);
			}
		});
		botonActividades.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_ACTIVIDADES);
			}
		});

		botonEmpleados.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_EMPLEADOS);
			}
		});

		botonCatalogos.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_CATALOGOS);
			}
		});

		botonSuscripciones.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_SUSCRIPCIONES);
			}
		});
		
		return menuPrincipal;
	}
}
