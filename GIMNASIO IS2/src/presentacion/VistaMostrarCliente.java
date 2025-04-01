package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import configFiles.BDConexion;

public class VistaMostrarCliente {
	public VistaMostrarCliente() {
		// ------------------------------------
		// Diseño de la vista
		JFrame menuPrincipal = new JFrame();
		menuPrincipal.setTitle("Menu Alta Cliente");
		menuPrincipal.setBounds(100, 100, 450, 300);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new FlowLayout());
		menuPrincipal.getContentPane().setBackground(new Color(88, 161, 164));

		JLabel titulo = new JLabel("Añadir cliente");
		menuPrincipal.add(titulo);

		JLabel dniL = new JLabel("DNI:");
		dniL.setAlignmentX(0);
		menuPrincipal.add(dniL);

		JTextField dniTF= new JTextField(30);
		menuPrincipal.add(dniTF);

		JLabel nombreL = new JLabel("Nombre:");
		menuPrincipal.add(nombreL);

		JTextField nombreTF= new JTextField(30);
		menuPrincipal.add(nombreTF);

		JLabel dirL = new JLabel("Dirección:");
		menuPrincipal.add(dirL);

		JTextField dirTF= new JTextField(30);
		menuPrincipal.add(dirTF);

		JButton back =  new JButton(new ImageIcon("icons/back.png"));
		back.setActionCommand("back");
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		menuPrincipal.getContentPane().add(back);

		JButton discard = new JButton();
		discard.setText("Descartar");
		discard.setBounds(153, 180, 132, 32);
		discard.setForeground(Color.WHITE);
		discard.setBackground(new Color(48, 86, 119));
		menuPrincipal.getContentPane().add(discard);

		JButton save = new JButton();
		save.setText("Guardar");
		save.setBounds(253, 380, 132, 32);
		save.setForeground(Color.WHITE);
		save.setBackground(new Color(48, 86, 119));
		menuPrincipal.getContentPane().add(save);

		JButton botonMainMenu =  new JButton(new ImageIcon("icons/main_menu.png"));
		botonMainMenu.setActionCommand("Ir a menu principal");
		botonMainMenu.setBorderPainted(false);
		botonMainMenu.setContentAreaFilled(false);
		menuPrincipal.getContentPane().add(botonMainMenu);

		menuPrincipal.setVisible (true);
		// Listener's
		discard.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						// TBD (To Be Developed)
					}
				}
				);

		save.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						Controlador.accion(Evento.MOSTRAR_CLIENTES, null);
					}
				}
				);

		back.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				VistaCliente vc = new VistaCliente();
			}
		}
				);

		botonMainMenu.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				VistaMenuPrincipal vmp = new VistaMenuPrincipal();
			}
		}
				);
	}

	public static void actualizar(int evento, Object datos) {
		JTextArea textArea = new JTextArea(datos.toString());
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "CLIENTES", JOptionPane.DEFAULT_OPTION);
		JOptionPane.showMessageDialog(null, "No se ha podido encontrar ningun cliente");
	} 
}
