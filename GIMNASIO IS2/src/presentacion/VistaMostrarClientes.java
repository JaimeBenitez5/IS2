package presentacion;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VistaMostrarClientes {
	public VistaMostrarClientes() {
		
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
		VistaCliente vc = new VistaCliente();
	} 
}
