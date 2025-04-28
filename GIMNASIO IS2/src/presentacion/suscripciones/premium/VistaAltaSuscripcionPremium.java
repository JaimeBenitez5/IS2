package presentacion.suscripciones.premium;

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

import negocio.DTOtPremium;
import negocio.DTOtSuscripcion;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaAltaSuscripcionPremium {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Alta Suscripcion Premium");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelAltaSuscripcion = new JPanel();
		panelAltaSuscripcion.setLayout(new BoxLayout(panelAltaSuscripcion, BoxLayout.Y_AXIS));
		panelAltaSuscripcion.setBackground(new Color(17, 47, 69));
		panelAltaSuscripcion.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelAltaSuscripcion, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Añadir Suscripcion Premium");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAltaSuscripcion.add(titulo);
		panelAltaSuscripcion.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(3, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		
		JLabel nommbre = new JLabel("Nombre:");
		nommbre.setForeground(Color.WHITE);
		panelCampos.add(nommbre);
		JTextField nombreTF = new JTextField(30);
		panelCampos.add(nombreTF);
		
		JLabel idCat = new JLabel("ID de catalogo:");
		idCat.setForeground(Color.WHITE);
		panelCampos.add(idCat);
		JTextField idCatTF = new JTextField(30);
		panelCampos.add(idCatTF);
		
		JLabel dniEmp = new JLabel("DNI de Empleado Nutricionista:");
		dniEmp.setForeground(Color.WHITE);
		panelCampos.add(dniEmp);
		JTextField dniEmpTF = new JTextField(300);
		panelCampos.add(dniEmpTF);
		
		panelAltaSuscripcion.add(panelCampos);
		panelAltaSuscripcion.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton save = UIElementFactory.crearBotonConIcono("icons/save.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(save);
		botones.add(botonMainMenu);

		panelAltaSuscripcion.add(botones);
		menuPrincipal.setVisible(true);

		save.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String nombre = nombreTF.getText();
				int idCatalogo = Integer.parseInt(idCatTF.getText());
				String dniEmp = dniEmpTF.getText();
				if (dniEmpTF.getText() == "" || idCatTF.getText() == "" ) {
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					idCatTF.setText("");

					DTOtSuscripcion sus = new DTOtPremium(nombre, idCatalogo, dniEmp);
					Controlador.accion(Evento.ALTA_SUSCRIPCION_PREMIUM, sus);
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
		if (evento == Evento.RES_ALTA_SUSCRIPCION_PREMIUM_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "La suscripcion se ha insertado correctamente con ID: " + datos.toString());
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_ALTA_SUSCRIPCION_PREMIUM_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar la suscripcion con ID: " + datos.toString());
		}
	}
}
