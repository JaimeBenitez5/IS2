package presentacion.compras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

import negocio.DTOtCliente;
import negocio.DTOtCompra;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

import java.util.Date;

public class VistaAnadirCompra {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Alta Compras");
		menuPrincipal.setSize(854, 500);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelAñadirCompra = new JPanel();
		panelAñadirCompra.setLayout(new BoxLayout(panelAñadirCompra, BoxLayout.Y_AXIS));
		panelAñadirCompra.setBackground(new Color(17, 47, 69));
		panelAñadirCompra.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelAñadirCompra, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Añadir Compra");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAñadirCompra.add(titulo);
		panelAñadirCompra.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(5, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel dniEmpleado = new JLabel("DNI empleado:");
		dniEmpleado.setForeground(Color.WHITE);
		panelCampos.add(dniEmpleado);
		JTextField dniETF = new JTextField(30);
		panelCampos.add(dniETF);

//		JLabel idFactura = new JLabel("Id Factura:");
//		idFactura.setForeground(Color.WHITE);
//		panelCampos.add(idFactura);
//		JTextField nombreTF = new JTextField(30);
//		panelCampos.add(nombreTF);

		JLabel suscripciones = new JLabel("Suscripciones:");
		suscripciones.setForeground(Color.WHITE);
		panelCampos.add(suscripciones);
		JTextField suscripcionesTF = new JTextField(30);
		panelCampos.add(suscripcionesTF);
		
		JLabel dniCliente = new JLabel("DNI cliente:");
		dniCliente.setForeground(Color.WHITE);
		panelCampos.add(dniCliente);
		JTextField dniClienteTF = new JTextField(30);
		panelCampos.add(dniClienteTF);
	
		JLabel fecha = new JLabel("Fecha:");
		fecha.setForeground(Color.WHITE);
		panelCampos.add(fecha);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField fechaTF = new JFormattedTextField(format);
		fechaTF.setColumns(10);
		fechaTF.setValue(new java.util.Date());
		panelCampos.add(fechaTF);
		
		JLabel metodoPago = new JLabel("Metodo de pago:");
		metodoPago.setForeground(Color.WHITE);
		panelCampos.add(metodoPago);
		JTextField metodoPagoTF = new JTextField(30);
		panelCampos.add(metodoPagoTF);
		
		panelAñadirCompra.add(panelCampos);
		panelAñadirCompra.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton save = UIElementFactory.crearBotonConIcono("icons/save.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(save);
		botones.add(botonMainMenu);

		panelAñadirCompra.add(botones);
		menuPrincipal.setVisible(true);

		save.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String dniE = dniETF.getText();
				String[] suscripciones = suscripcionesTF.getText().split(" ");
				String dniC = dniClienteTF.getText();
				java.util.Date Date = (java.util.Date) fechaTF.getValue();
				java.sql.Date sqlDate = new java.sql.Date(Date.getTime());
				String mPago = metodoPago.getText();
				if (dniE.isEmpty() || suscripciones.length==0 || dniC.isEmpty() || fecha==null) {
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					dniETF.setText("");
					suscripcionesTF.setText("");
					dniClienteTF.setText("");
					fechaTF.setText("");
					metodoPago.setText("");
					List<Integer> sus= new ArrayList<>();
					for(String s: suscripciones) {
						sus.add(Integer.parseInt(s));
					}
					DTOtCompra c = new DTOtCompra(dniE, 0, sus, dniC,sqlDate,mPago);
					Controlador.accion(Evento.ALTA_COMPRA, c);
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
		if (evento == Evento.RES_ALTA_COMPRA_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "La compra se ha insertado correctamente con Id: " + datos.toString());
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_ALTA_COMPRA_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar la compra con Id: " + datos.toString());
		}
	}
}
