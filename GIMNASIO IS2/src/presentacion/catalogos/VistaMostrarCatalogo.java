package presentacion.catalogos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import negocio.DTOtCatalogo;
import negocio.DTOtCliente;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaMostrarCatalogo {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Mostrar Catalogo");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelMostrarCliente = new JPanel();
		panelMostrarCliente.setLayout(new BoxLayout(panelMostrarCliente, BoxLayout.Y_AXIS));
		panelMostrarCliente.setBackground(new Color(17, 47, 69));
		panelMostrarCliente.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelMostrarCliente, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Mostrar Catalogo");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelMostrarCliente.add(titulo);
		panelMostrarCliente.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(1, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel id = new JLabel("ID:");
		id.setForeground(Color.WHITE);
		panelCampos.add(id);
		JTextField idTF = new JTextField(30);
		panelCampos.add(idTF);

		panelMostrarCliente.add(panelCampos);
		panelMostrarCliente.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton delete = UIElementFactory.crearBoton("Mostrar",  new Color(67, 75, 172));
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(delete);
		botones.add(botonMainMenu);

		panelMostrarCliente.add(botones);
		menuPrincipal.setVisible(true);


		delete.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String id = idTF.getText();
				idTF.setText("");
				Controlador.accion(Evento.MOSTRAR_CATALOGO, id);
			}
		});

		back.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
			}
		});

		botonMainMenu.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				Controlador.mostrarVista(Evento.VISTA_MENU_PRINCIPAL);
			}
		});
		
		return menuPrincipal;
	}
	
	public static void actualizar(int evento, DTOtCatalogo catalogo) {
		if (evento == Evento.RES_MOSTRAR_CATALOGO_OK) {
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			int n = catalogo.getNumActividades();
			JOptionPane.showMessageDialog(null,"Numero de actividades: "+n);
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_MOSTRAR_CATALOGO_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar el catalogo");
		}
	}
}
