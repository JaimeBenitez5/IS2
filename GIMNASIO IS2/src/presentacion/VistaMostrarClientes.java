package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JFrame;

import negocio.tCliente;

public class VistaMostrarClientes {
	public VistaMostrarClientes() {
		
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
			JButton botonAlta = crearBoton("Alta Cliente");
			JButton botonReadAll = crearBoton("Mostrar Clientes");
			JButton botonRead = crearBoton("Mostrar Cliente");
			JButton botonUnroll = crearBoton("Dar de Baja Cliente");
			JButton botonModClient = crearBoton("Modificar Cliente");
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
