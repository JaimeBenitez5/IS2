package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
public class VistaModificarCliente {

	@objid ("3175bc60-dc4e-4d25-8fbe-2b50c79d9d60")
	public VistaModificarCliente() {
		JFrame menuPrincipal = new JFrame("Menú Modificar Cliente");
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

		JLabel titulo = new JLabel("Modificar Cliente");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAltaCliente.add(titulo);
		panelAltaCliente.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(4, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		

		JLabel id = new JLabel("ID:");
		id.setForeground(Color.WHITE);
		panelCampos.add(id);
		JTextField idTF = new JTextField(30);
		panelCampos.add(idTF);

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

		JButton back = crearBotonConIcono("icons/back.png");
		JButton discard = crearBoton("Descartar");
		JButton save = crearBoton("Guardar");
		JButton botonMainMenu = crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(discard);
		botones.add(Box.createRigidArea(new Dimension(40, 20)));
		botones.add(save);
		botones.add(botonMainMenu);

		panelAltaCliente.add(botones);
		menuPrincipal.setVisible(true);


		discard.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
					}
				}
				);

		save.addActionListener(
				new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						int id = Integer.parseInt(idTF.getText());
						String dni = dniTF.getText();
						String nombre = nombreTF.getText();
						String dir = dirTF.getText();
						if (dni.isEmpty() || nombre.isEmpty() || dir.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
						}
						tCliente c = new tCliente(id,dni, nombre, dir);
						Controlador.accion(Evento.MODIFICAR_CLIENTE, c);
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


	private static JButton crearBoton(String texto) {
		JButton boton = new JButton(texto);
		boton.setForeground(Color.WHITE);
		boton.setBackground(new Color(67, 75, 172));
		return boton;
	}

	private static JButton crearBotonConIcono(String ruta) {
		JButton boton = new JButton(new ImageIcon(ruta));
		boton.setBorderPainted(false);
		boton.setContentAreaFilled(false);
		return boton;
	}

	public static void actualizar(int evento, Object datos) {
		if (evento == Evento.RES_MODIFICAR_CLIENTE_OK) {
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "El cliente se ha modificado correctamente");
		} else if (evento == Evento.RES_MODIFICAR_CLIENTE_KO)
			JOptionPane.showMessageDialog(null, "No se ha podido modificar el cliente");
	}


}
