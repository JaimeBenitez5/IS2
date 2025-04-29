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
import java.util.ArrayList;

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

import negocio.DTOtActividad;
import negocio.DTOtCatalogo;
import presentacion.Controlador;
import presentacion.Evento;
import presentacion.UIElementFactory;

public class VistaModificarCatalogo {
	private static JFrame GUI = null;

	public static void open() {
		if(GUI == null) GUI = initGUI();
		GUI.setVisible(true);
	}

	private static JFrame initGUI() {
		JFrame menuPrincipal = new JFrame("Menú Modificar Catalogo");
		menuPrincipal.setSize(854, 480);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new BorderLayout());
		menuPrincipal.getContentPane().setBackground(new Color(17, 47, 69));

		JPanel panelModificarCatalogo = new JPanel();
		panelModificarCatalogo.setLayout(new BoxLayout(panelModificarCatalogo, BoxLayout.Y_AXIS));
		panelModificarCatalogo.setBackground(new Color(17, 47, 69));
		panelModificarCatalogo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		menuPrincipal.add(panelModificarCatalogo, BorderLayout.CENTER);

		JLabel titulo = new JLabel("Modificar Catalogo");
		titulo.setForeground(Color.WHITE);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelModificarCatalogo.add(titulo);
		
		JPanel panelCampos = new JPanel(new GridLayout(2, 2, 20, 20));
		panelCampos.setBackground(new Color(17, 47, 69));
		
		JLabel idCat = new JLabel("ID de Catalogo:");
		idCat.setForeground(Color.WHITE);
		panelCampos.add(idCat);
		JTextField idCatTF = new JTextField(30);
		panelCampos.add(idCatTF);
		
		JLabel numero = new JLabel("Número de actividades:");
		numero.setForeground(Color.WHITE);
		panelCampos.add(numero);
		JTextField numeroTF = new JTextField(30);
		panelCampos.add(numeroTF);

		JButton numAct = UIElementFactory.crearBoton("Confirmar numero",  new Color(67, 75, 172));
		numAct.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelCampos.add(numAct);
		
		panelModificarCatalogo.add(panelCampos);
		
		JPanel actividadesPanel = new JPanel();
		actividadesPanel.setLayout(new BoxLayout(actividadesPanel, BoxLayout.Y_AXIS));
		actividadesPanel.setBackground(new Color(17, 47, 69));

		JScrollPane scrollActividades = new JScrollPane(actividadesPanel);
		scrollActividades.setPreferredSize(new Dimension(600, 500));
		scrollActividades.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollActividades.setBorder(BorderFactory.createTitledBorder("Actividades"));

		scrollActividades.getViewport().setBackground(new Color(17, 47, 69));
		panelModificarCatalogo.add(Box.createRigidArea(new Dimension(0, 20)));
		panelModificarCatalogo.add(numAct);
		panelModificarCatalogo.add(Box.createRigidArea(new Dimension(0, 20)));
		panelModificarCatalogo.add(scrollActividades);


		JPanel botones = new JPanel(new GridLayout(1, 5, 20, 0));
		botones.setBackground(new Color(17, 47, 69));

		JButton back = UIElementFactory.crearBotonConIcono("icons/back.png");
		JButton save = UIElementFactory.crearBotonConIcono("icons/save.png");
		JButton botonMainMenu = UIElementFactory.crearBotonConIcono("icons/main_menu.png");

		botones.add(back);
		botones.add(save);
		botones.add(botonMainMenu);

		panelModificarCatalogo.add(botones);
		menuPrincipal.setVisible(true);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idCat = Integer.parseInt(idCatTF.getText());
				String numAct = numeroTF.getText();
				if (numAct.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Introduce el número de actividades", "Error", JOptionPane.ERROR_MESSAGE);
				}
				int cantidad = Integer.parseInt(numAct);
				ArrayList<DTOtActividad> actividades = new ArrayList<DTOtActividad>();
				DTOtCatalogo catalogo = new DTOtCatalogo(idCat, cantidad);
				for (Component comp : actividadesPanel.getComponents()) {
					if (comp instanceof JPanel actividadPanel) {
						Component[] fields = actividadPanel.getComponents();
						String tipo = ((JTextField) fields[1]).getText();
						java.util.Date Date = (java.util.Date) ((JFormattedTextField) fields[3]).getValue();
						java.sql.Date sqlDate = new java.sql.Date(Date.getTime());
						int idSala = Integer.parseInt(((JTextField) fields[5]).getText());
						DTOtActividad act = new DTOtActividad(tipo, idSala, sqlDate);
						actividades.add(act);
					}
				}
				catalogo.setActividades(actividades);
				Controlador.accion(Evento.MODIFICAR_CATALOGO, catalogo);
			}
		});
		
		numAct.addActionListener(new ActionListener() {
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
					actividadesPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
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
		if (evento == Evento.RES_MODIFICAR_CATALOGO_OK) {
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			JOptionPane.showMessageDialog(null, "El catalogo se ha modificado correctamente");
			GUI.setVisible(false);
		} else if (evento == Evento.RES_MODIFICAR_CATALOGO_KO)
			JOptionPane.showMessageDialog(null, "No se ha podido modificar el catalogo");
	}
}
