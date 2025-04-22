package presentacion.salas;

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

import negocio.DTOtSala;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaModificarSala {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Modificar Sala");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelModificarSala = new JPanel();
		panelModificarSala.setLayout(new BoxLayout(panelModificarSala, BoxLayout.Y_AXIS));
		panelModificarSala.setBackground(new Color(17, 47, 69));
		panelModificarSala.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelModificarSala, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Modificar Sala");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelModificarSala.add(titulo);
		panelModificarSala.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(4, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel id = new JLabel("ID:");
		id.setForeground(Color.WHITE);
		panelCampos.add(id);
		JTextField idTF = new JTextField(30);
		panelCampos.add(idTF);

		JLabel aforo = new JLabel("Aforo:");
		aforo.setForeground(Color.WHITE);
		panelCampos.add(aforo);
		JTextField aforoTF = new JTextField(30);
		panelCampos.add(aforoTF);

		panelModificarSala.add(panelCampos);
		panelModificarSala.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton save = UIElementFactory.crearBotonConIcono("icons/save.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(save);
		botones.add(botonMainMenu);

		panelModificarSala.add(botones);
		menuPrincipal.setVisible(true);

		save.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				int id = Integer.parseInt(idTF.getText());
				int aforo = Integer.parseInt(aforoTF.getText());
				DTOtSala s = new DTOtSala(id, aforo);
				Controlador.accion(Evento.MODIFICAR_SALA, s);
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
		
		menuPrincipal.setResizable(false);
		menuPrincipal.pack();
		return menuPrincipal;
	}


	public static void actualizar(int evento, Object datos) {
		if (evento == Evento.RES_MODIFICAR_SALA_OK) {
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "La sala se ha modificado correctamente");
			GUI.setVisible(false);
		} else if (evento == Evento.RES_MODIFICAR_SALA_KO)
			JOptionPane.showMessageDialog(null, "No se ha podido modificar la sala");
	}
}
