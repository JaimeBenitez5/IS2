package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import negocio.SACliente;
import negocio.SAClienteImp;
import negocio.tCliente;


@objid ("69cff9f9-fddd-46c9-b01f-2aa13f2b2c28")
public class VistaAltaCliente {

	@objid ("3175bc60-dc4e-4d25-8fbe-2b50c79d9d60")
	public VistaAltaCliente() {
		JFrame menuPrincipal = new JFrame();
		menuPrincipal.setTitle("Menu Alta Cliente");
		menuPrincipal.setBounds(0, 0, 1080, 1920);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new FlowLayout());
		menuPrincipal.getContentPane().setBackground(new Color(88, 161, 164));

		JPanel panelAltaCliente = new JPanel();
		menuPrincipal.add(panelAltaCliente);
		menuPrincipal.setBackground(new Color(88, 161, 164));
		panelAltaCliente.setLayout(new BoxLayout(panelAltaCliente,BoxLayout.Y_AXIS));

		JLabel titulo = new JLabel("Añadir cliente");
		JPanel t= new JPanel();
		t.setBackground(new Color(88, 161, 164));
		t.setForeground(new Color(88,161,164));
		titulo.setBackground(new Color(88, 161, 164));


		t.add(titulo);
		
		panelAltaCliente.add(t);
		
		
		JPanel panelDNI = new JPanel(new GridLayout(1, 2));
		panelDNI.setBackground(new Color(88, 161, 164));
		panelDNI.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		panelAltaCliente.add(panelDNI);
		JPanel empty= new JPanel();
		empty.setSize(0, 10);;
		empty.setBackground(new Color(88, 161, 164));
		panelAltaCliente.add(empty);


		JLabel dni = new JLabel("DNI:");
		panelDNI.add(dni);

		JTextField dniTF= new JTextField(30);
		panelDNI.add(dniTF);

		JPanel panelNombre = new JPanel(new GridLayout(1, 2));
		panelNombre.setBackground(new Color(88, 161, 164));
		panelNombre.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		panelAltaCliente.add(panelNombre);
		JPanel empty1= new JPanel();
		empty1.setSize(0, 10);;
		empty1.setBackground(new Color(88, 161, 164));
		panelAltaCliente.add(empty1);

		JLabel nombreL = new JLabel("Nombre:");
		panelNombre.add(nombreL);

		JTextField nombreTF= new JTextField(30);
		panelNombre.add(nombreTF);

		JPanel panelDireccion = new JPanel(new GridLayout(1, 2));
		panelDireccion.setBackground(new Color(88, 161, 164));
		panelDireccion.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		panelAltaCliente.add(panelDireccion);

		JLabel dirL = new JLabel("Dirección:");
		panelDireccion.add(dirL);

		JTextField dirTF= new JTextField(30);
		panelDireccion.add(dirTF);


		JPanel botones= new JPanel();
		botones.setBackground(new Color(88, 161, 164));
		panelAltaCliente.add(botones);
		botones.setLayout(new GridLayout(1,5));

		JButton back =  new JButton(new ImageIcon("icons/back.png"));
		back.setActionCommand("back");
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		botones.add(back);

		JButton discard = new JButton();
		discard.setText("Descartar");
		discard.setBounds(153, 180, 132, 32);
		discard.setForeground(Color.WHITE);
		discard.setBackground(new Color(48, 86, 119));
		botones.add(discard);

		JPanel espacio = new JPanel();
		espacio.setPreferredSize(new Dimension(20, 0));
		espacio.setMaximumSize(new Dimension(20, 0));
		espacio.setBackground(new Color(88, 161, 164));
		espacio.setOpaque(true);
		botones.add(espacio);

		JButton save = new JButton();
		save.setText("Guardar");
		save.setBounds(253, 380, 132, 32);
		save.setForeground(Color.WHITE);
		save.setBackground(new Color(48, 86, 119));
		botones.add(save);

		JButton botonMainMenu =  new JButton(new ImageIcon("icons/main_menu.png"));
		botonMainMenu.setActionCommand("Ir a menu principal");
		botonMainMenu.setBorderPainted(false);
		botonMainMenu.setContentAreaFilled(false);
		botones.add(botonMainMenu);

		menuPrincipal.setVisible (true);

		discard.addActionListener(
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
				}
			}
		);

		save.addActionListener(
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					String dni = dniTF.getText();
					String nombre = nombreTF.getText();
					String dir = dirTF.getText();
					tCliente c = new tCliente(0, dni, nombre, dir, true);
					SACliente SACliente = new SAClienteImp();
					int id = SACliente.altaCliente(c);
					c.setId(id);
				}
			}
		);

		back.addActionListener( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				menuPrincipal.setVisible (false);
				VistaCliente vc = new VistaCliente();
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
