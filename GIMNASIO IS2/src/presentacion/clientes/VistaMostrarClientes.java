package presentacion.clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;

import negocio.tCliente;
import presentacion.ButtonFactory;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.TablaClientes;
import presentacion.VistaMenuPrincipal;

public class VistaMostrarClientes {
	private static JFrame GUI = null;
	public VistaMostrarClientes() {
		
	}
	public static void open(Frame parent) {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}
	
	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Alta Cliente");
		menuPrincipal.setSize(1920, 1080);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelAltaCliente = new JPanel();
		panelAltaCliente.setLayout(new BoxLayout(panelAltaCliente, BoxLayout.Y_AXIS));
		panelAltaCliente.setBackground(new Color(17, 47, 69));
		panelAltaCliente.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); // Márgenes exteriores

		menuPrincipal.add(panelAltaCliente, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Añadir Cliente");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAltaCliente.add(titulo);
		panelAltaCliente.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(3, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel dni = new JLabel("DNI:");
		dni.setForeground(Color.WHITE);
		panelCampos.add(dni);
		JTextField dniTF = new JTextField(30);
		panelCampos.add(dniTF);

		JLabel nombre = new JLabel("Nombre:");
		nombre.setForeground(Color.WHITE);
		panelCampos.add(nombre);
		JTextField nombreTF = new JTextField(30);
		panelCampos.add(nombreTF);

		JLabel dir = new JLabel("Dirección:");
		dir.setForeground(Color.WHITE);
		panelCampos.add(dir);
		JTextField dirTF = new JTextField(30);
		panelCampos.add(dirTF);

		panelAltaCliente.add(panelCampos);
		panelAltaCliente.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = ButtonFactory.crearBotonConIcono("icons/back.png");
		JButton save = ButtonFactory.crearBotonConIcono("icons/save.png");
		JButton botonMainMenu = ButtonFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(save);
		botones.add(botonMainMenu);

		panelAltaCliente.add(botones);
		menuPrincipal.setVisible(true);

		save.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						String dni = dniTF.getText();
						String nombre = nombreTF.getText();
						String dir = dirTF.getText();
						if (dni.isEmpty() || nombre.isEmpty() || dir.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
						}
						tCliente c = new tCliente(dni, nombre, dir);
						Controlador.accion(Evento.ALTA_CLIENTE, c);
					}
				}
				);

		back.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
			}
		});

		botonMainMenu.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				VistaMenuPrincipal vmp = new VistaMenuPrincipal();
			}
		});

		menuPrincipal.setResizable(false);
		menuPrincipal.pack();

		return menuPrincipal;
	}
	
	public static void actualizar(int evento, List<tCliente> datos) {
		if (evento == Evento.RES_MOSTRAR_CLIENTES_OK) {

			JFrame menuPrincipal = new JFrame();
			menuPrincipal.setTitle("Menú CRUD Cliente");
			menuPrincipal.setSize(1280, 720);
			menuPrincipal.setLocationRelativeTo(null);
			menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Panel principal con margen
			JPanel panel = new JPanel(new GridLayout(3, 2, 20, 20)); // Espaciado entre celdas
			panel.setBackground(new Color(88, 161, 164));
			panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); // Márgenes exteriores

			// Botones
			JButton botonAlta = ButtonFactory.crearBoton("Alta Cliente",new Color(88, 161, 164));
			JButton botonReadAll = ButtonFactory.crearBoton("Mostrar Clientes",new Color(88, 161, 164));
			JButton botonRead = ButtonFactory.crearBoton("Mostrar Cliente",new Color(88, 161, 164));
			JButton botonUnroll = ButtonFactory.crearBoton("Dar de Baja Cliente",new Color(88, 161, 164));
			JButton botonModClient = ButtonFactory.crearBoton("Modificar Cliente",new Color(88, 161, 164));
			// Botón de regreso al menú principal con icono
			JButton botonMainMenu = new JButton(new ImageIcon("icons/main_menu.png"));
			botonMainMenu.setBorderPainted(false);
			botonMainMenu.setContentAreaFilled(false);
			botonMainMenu.setActionCommand("Ir a Menú Principal");

			// Agregar elementos al panel
			panel.add(botonAlta);
			panel.add(botonReadAll);
			panel.add(botonRead);
			panel.add(botonUnroll);
			panel.add(botonModClient);

			// Agregar el panel y el botón del menú principal
			menuPrincipal.add(panel, BorderLayout.CENTER);
			menuPrincipal.add(botonMainMenu, BorderLayout.SOUTH);
			menuPrincipal.setVisible(true);
			
			
			
			
			JFrame frame = new JFrame();
			JPanel mainPanel = new JPanel(new BorderLayout());
			frame.setContentPane(mainPanel);
			
			TablaClientes tc = new TablaClientes();
			tc.mostrarClientes(datos);
			
			JPanel clientesView = createViewPanel(new JTable(tc), "Clientes");
			clientesView.setPreferredSize(new Dimension(500, 200));
			
			mainPanel.add(clientesView);
			
		} else if (evento == Evento.RES_MOSTRAR_CLIENTES_KO)
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar ningun cliente");
	} 

	private static JPanel createViewPanel(JComponent c, String title) {
		JPanel p = new JPanel( new BorderLayout() );
		p.add(new JScrollPane(c));
		return p;
	}
}
