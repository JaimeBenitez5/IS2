package presentacion.compras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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

import negocio.DTOtCompra;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaMostrarCompra {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Mostrar Compra");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelMostrarCompra = new JPanel();
		panelMostrarCompra.setLayout(new BoxLayout(panelMostrarCompra, BoxLayout.Y_AXIS));
		panelMostrarCompra.setBackground(new Color(17, 47, 69));
		panelMostrarCompra.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelMostrarCompra, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Mostrar Compra");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelMostrarCompra.add(titulo);
		panelMostrarCompra.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(1, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel id = new JLabel("ID:");
		id.setForeground(Color.WHITE);
		panelCampos.add(id);
		JTextField idTF = new JTextField(30);
		panelCampos.add(idTF);

		panelMostrarCompra.add(panelCampos);
		panelMostrarCompra.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton mostrar = UIElementFactory.crearBoton("Mostrar",  new Color(67, 75, 172));
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(mostrar);
		botones.add(botonMainMenu);

		panelMostrarCompra.add(botones);
		menuPrincipal.setVisible(true);


		mostrar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				int id = Integer.parseInt(idTF.getText());
				idTF.setText("");
				Controlador.accion(Evento.MOSTRAR_COMPRA, id);
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
	
	public static void actualizar(int evento, DTOtCompra c) {
		if (evento == Evento.RES_MOSTRAR_COMPRA_OK) {
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			java.sql.Date sqlDate = c.getFecha();
			java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String fecha = sdf.format(utilDate);
			
			String id = String.valueOf(c.getId());
			String idSus = String.valueOf(c.getSuscripcion());
			String dniCli = c.getDniCliente();
			String metPago = c.getMetodoPago();
			String idFac= String.valueOf(c.getIdFactura());
			String dniEmp = c.getDniEmpleado();
			JOptionPane.showMessageDialog(null, "ID de Compra: " + id + " ID de Suscripcion: " + idSus +
					" DNI de Cliente: " + dniCli + " Fecha: " + fecha +  " Metodo de Pago: " + metPago +
					" ID de Factura: " + idFac + " DNI de Empleado: " + dniEmp);
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_MOSTRAR_COMPRA_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar la compra");
		}
	}
}
