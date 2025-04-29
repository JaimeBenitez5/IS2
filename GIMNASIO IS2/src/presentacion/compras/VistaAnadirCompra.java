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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.DTOtCompra;
import presentacion.Comprobaciones;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;


public class VistaAnadirCompra {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Alta Compra");
		menuPrincipal.setSize(854, 500);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelAnadirCompra = new JPanel();
		panelAnadirCompra.setLayout(new BoxLayout(panelAnadirCompra, BoxLayout.Y_AXIS));
		panelAnadirCompra.setBackground(new Color(17, 47, 69));
		panelAnadirCompra.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

		menuPrincipal.add(panelAnadirCompra, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Añadir Compra");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAnadirCompra.add(titulo);
		panelAnadirCompra.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(6, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));

		JLabel dniEmpleado = new JLabel("DNI de Empleado:");
		dniEmpleado.setForeground(Color.WHITE);
		panelCampos.add(dniEmpleado);
		JTextField dniETF = new JTextField(30);
		panelCampos.add(dniETF);

		JLabel suscripcion = new JLabel("ID de Suscripcion:");
		suscripcion.setForeground(Color.WHITE);
		panelCampos.add(suscripcion);
		JTextField suscripcionTF = new JTextField(30);
		panelCampos.add(suscripcionTF);
		
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
		
		JLabel metodoPago = new JLabel("Metodo de Pago:");
		metodoPago.setForeground(Color.WHITE);
		panelCampos.add(metodoPago);
		JComboBox<String> comboMetodo = new JComboBox<>(new String[] { "Sin Asignar", "Efectivo", "Tarjeta", "Transferencia Bancaria", "Bizum"});
		panelCampos.add(comboMetodo);
		
		panelAnadirCompra.add(panelCampos);

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton save = UIElementFactory.crearBotonConIcono("icons/save.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(save);
		botones.add(botonMainMenu);

		panelAnadirCompra.add(botones);
		menuPrincipal.setVisible(true);

		save.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				int idSus = 0;
				String dniE = dniETF.getText();
				String dniC = dniClienteTF.getText();
				java.util.Date Date = (java.util.Date) fechaTF.getValue();
				java.sql.Date sqlDate = new java.sql.Date(Date.getTime());
				String mPago = comboMetodo.getSelectedItem().toString();
				boolean idsCorrectos = true;
				try {
					idSus = Integer.parseInt(suscripcionTF.getText());
				}catch( NumberFormatException nfe){
					idsCorrectos = false;
					JOptionPane.showMessageDialog(null, "Los IDs solo pueden contener numeros", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (!Comprobaciones.esDNIValido(dniE) || !Comprobaciones.esDNIValido(dniC) ) {
				    JOptionPane.showMessageDialog(null, "DNI no valido. Debe tener 8 numeros y una letra al final", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (dniE.isEmpty() || dniC.isEmpty() || fecha == null) {
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(idsCorrectos){
					dniETF.setText("");
					dniClienteTF.setText("");
					suscripcionTF.setText("");
					dniClienteTF.setText("");
					comboMetodo.setSelectedItem("Sin Asignar");
					DTOtCompra c = new DTOtCompra(idSus, dniC, sqlDate, mPago, dniE);
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
