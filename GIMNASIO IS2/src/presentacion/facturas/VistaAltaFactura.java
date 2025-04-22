package presentacion.facturas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.DTOtFactura;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaAltaFactura {
	
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Alta Factura");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelAltaFactura = new JPanel();
		panelAltaFactura.setLayout(new BoxLayout(panelAltaFactura, BoxLayout.Y_AXIS));
		panelAltaFactura.setBackground(new Color(17, 47, 69));
		panelAltaFactura.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelAltaFactura, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Añadir Factura");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAltaFactura.add(titulo);
		panelAltaFactura.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(3, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel importe = new JLabel("Importe total:");
		importe.setForeground(Color.WHITE);
		panelCampos.add(importe);
		JTextField importeTF = new JTextField(30);
		panelCampos.add(importeTF);

		JLabel fecha = new JLabel("Fecha:");
		fecha.setForeground(Color.WHITE);
		panelCampos.add(fecha);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField fechaTF = new JFormattedTextField(format);
		fechaTF.setColumns(10);
		fechaTF.setValue(new java.util.Date());
		panelCampos.add(fechaTF);

		JLabel numFactura = new JLabel("Número de factura:");
		numFactura.setForeground(Color.WHITE);
		panelCampos.add(numFactura);
		JTextField numFactTF = new JTextField(30);
		panelCampos.add(numFactTF);

		panelAltaFactura.add(panelCampos);
		panelAltaFactura.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton save = UIElementFactory.crearBotonConIcono("icons/save.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(save);
		botones.add(botonMainMenu);

		panelAltaFactura.add(botones);
		menuPrincipal.setVisible(true);

		save.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				double importe = Double.parseDouble(importeTF.getText());
				java.util.Date Date = (java.util.Date) fechaTF.getValue();
				java.sql.Date sqlDate = new java.sql.Date(Date.getTime());
				int num = Integer.parseInt(numFactTF.getText());
				if (importe == 0) {
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					importeTF.setText("");
					fechaTF.setText("");
					numFactTF.setText("");
					DTOtFactura c = new DTOtFactura(num, sqlDate, importe);
					Controlador.accion(Evento.ALTA_FACTURA, c);
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
		if (evento == Evento.RES_ALTA_FACTURA_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "La factura se ha insertado correctamente con ID: " + datos.toString());
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_ALTA_FACTURA_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar la factura");
		}
	}
}
