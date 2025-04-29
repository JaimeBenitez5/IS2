package presentacion.catalogos;

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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.DTOtCatalogo;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaAnadirCatalogo {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Añadir Catalogo");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelAnadirCatalogo = new JPanel();
		panelAnadirCatalogo.setLayout(new BoxLayout(panelAnadirCatalogo, BoxLayout.Y_AXIS));
		panelAnadirCatalogo.setBackground(new Color(17, 47, 69));
		panelAnadirCatalogo.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		menuPrincipal.add(panelAnadirCatalogo, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Añadir Catalogo");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAnadirCatalogo.add(titulo);
		panelAnadirCatalogo.add(Box.createRigidArea(new Dimension(0, 30)));

		JPanel panelCampos = new JPanel(new GridLayout(4, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel numero = new JLabel("Número de actividades:");
		numero.setForeground(Color.WHITE);
		panelCampos.add(numero);
		JTextField numeroTF = new JTextField(30);
		panelCampos.add(numeroTF);

		JButton generarActividades = new JButton("Confirmar número");
		generarActividades.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelCampos.add(generarActividades);

		panelAnadirCatalogo.add(panelCampos);
		
		JPanel actividadesPanel = new JPanel();
		actividadesPanel.setLayout(new BoxLayout(actividadesPanel, BoxLayout.Y_AXIS));
		actividadesPanel.setBackground(new Color(17, 47, 69));

		JScrollPane scrollActividades = new JScrollPane(actividadesPanel);
		scrollActividades.setPreferredSize(new Dimension(600, 200));
		scrollActividades.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollActividades.setBorder(BorderFactory.createTitledBorder("Actividades"));

		scrollActividades.getViewport().setBackground(new Color(17, 47, 69));
		panelAnadirCatalogo.add(generarActividades);
		panelAnadirCatalogo.add(Box.createRigidArea(new Dimension(0, 20)));
		panelAnadirCatalogo.add(scrollActividades);


		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton save = UIElementFactory.crearBotonConIcono("icons/save.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(save);
		botones.add(botonMainMenu);

		panelAnadirCatalogo.add(botones);
		menuPrincipal.setVisible(true);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = numeroTF.getText();
				if (n.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Introduce el número de actividades", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int cantidad = Integer.parseInt(n);
				DTOtCatalogo catalogo = new DTOtCatalogo(cantidad);
				for (Component comp : actividadesPanel.getComponents()) {
					if (comp instanceof JPanel actividadPanel) {
						Component[] fields = actividadPanel.getComponents();
						String tipo = ((JTextField) fields[1]).getText();
						String fecha = ((JFormattedTextField) fields[3]).getText();
						String sala = ((JTextField) fields[5]).getText();
						// Puedes almacenar esta información como lista de objetos o DTOs, según tu modelo
						System.out.println("Actividad -> Tipo: " + tipo + ", Fecha: " + fecha + ", Sala: " + sala);
					}
				}
				Controlador.accion(Evento.ALTA_CATALOGO, catalogo);
			}
		});
		
		generarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actividadesPanel.removeAll();
				String n = numeroTF.getText();
				int cantidad = 0;
				try {
					cantidad = Integer.parseInt(n);
					if (cantidad <= 0) throw new NumberFormatException();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Introduce un número válido mayor que 0");
					return;
				}
				for (int i = 0; i < cantidad; i++) {
					JPanel actividad = new JPanel(new GridLayout(1, 6, 10, 10));
					actividad.setBackground(new Color(17, 47, 69));
					JLabel tipoLabel = new JLabel("Tipo:");
					tipoLabel.setForeground(Color.WHITE);
					JTextField tipoTF = new JTextField();
					JLabel fechaLabel = new JLabel("Fecha:");
					fechaLabel.setForeground(Color.WHITE);
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					JFormattedTextField fechaTF = new JFormattedTextField(format);
					fechaTF.setValue(new java.util.Date());
					JLabel salaLabel = new JLabel("Sala:");
					salaLabel.setForeground(Color.WHITE);
					JTextField salaTF = new JTextField();

					actividad.add(tipoLabel);
					actividad.add(tipoTF);
					actividad.add(fechaLabel);
					actividad.add(fechaTF);
					actividad.add(salaLabel);
					actividad.add(salaTF);
					actividadesPanel.add(actividad);
				}
				actividadesPanel.revalidate();
				actividadesPanel.repaint();
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
		if (evento == Evento.RES_ALTA_CATALOGO_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "El catalogo se ha insertado correctamente con ID: " + datos.toString());
			GUI.setVisible(false);
		} 
		else if (evento == Evento.RES_ALTA_CATALOGO_KO) {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar el catalogo");
		}
	}
}
