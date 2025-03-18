package presentacion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VistaBajaCliente {
	public VistaBajaCliente() {
	// ------------------------------------
	// Diseño de la vista
	JFrame menuPrincipal = new JFrame();
	menuPrincipal.setTitle("Menu Baja Cliente");
	menuPrincipal.setBounds(100, 100, 450, 300);
	menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	menuPrincipal.getContentPane().setLayout(new FlowLayout());
	// Menu con botones para acceder a la funcionalidad de la
	// entidad cliente. Solo se muestran los CRUDs Alta y mostrar.

	JLabel titulo = new JLabel("Dar de baja cliente");

	JButton unroll = new JButton();
	unroll.setText("Descartar");
	unroll.setBounds(153, 180, 132, 32);
	menuPrincipal.getContentPane().add(unroll);


	menuPrincipal.setVisible (true);
	// ------------------------------------
	// Listener's
	unroll.addActionListener(
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					// TBD (To Be Developed)
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
