package presentacion.suscripciones.basica;

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

import negocio.DTOtBasica;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaMostrarSuscripcionBasica {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Mostrar Suscripcion Basicas");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelBajaCliente = new JPanel();
		panelBajaCliente.setLayout(new BoxLayout(panelBajaCliente, BoxLayout.Y_AXIS));
		panelBajaCliente.setBackground(new Color(17, 47, 69));
		panelBajaCliente.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelBajaCliente, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Mostrar Suscripcion");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelBajaCliente.add(titulo);
		panelBajaCliente.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(1, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel id = new JLabel("ID:");
		id.setForeground(Color.WHITE);
		panelCampos.add(id);
		JTextField idTF = new JTextField(30);
		panelCampos.add(idTF);

		panelBajaCliente.add(panelCampos);
		panelBajaCliente.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton mostrar = UIElementFactory.crearBoton("Mostrar",  new Color(67, 75, 172));
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(mostrar);
		botones.add(botonMainMenu);

		panelBajaCliente.add(botones);
		menuPrincipal.setVisible(true);


		mostrar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String id = idTF.getText();
				idTF.setText("");
				Controlador.accion(Evento.MOSTRAR_SUSCRIPCIONES_BASICAS, id);
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
	
	public static void actualizar(int evento, DTOtBasica suscripcion) {
		if (evento == Evento.RES_MOSTRAR_SUSCRIPCION_BASICA_OK) {
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );

			String idSus = String.valueOf(suscripcion.getIdSuscripcion());
			String nombre = String.valueOf(suscripcion.getNombre());
			String duracion = String.valueOf(suscripcion.getDuracion());
			String tipoAct = String.valueOf(suscripcion.getTipoActividad());
			java.sql.Date sqlDate = suscripcion.getFecha();
			java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String fechaFormateada = sdf.format(utilDate);
			String idSala = String.valueOf(suscripcion.getIdSala());
			
			JOptionPane.showMessageDialog(null, "ID de Suscripcion: " + idSus + " Nombre: " + nombre +" Duracion: " + duracion + " Tipo de Actividad: " + tipoAct + " Fecha" + fechaFormateada + " ID de Sala: " + idSala);
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_MOSTRAR_SUSCRIPCION_BASICA_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar la suscripcion");
		}
	}
}
