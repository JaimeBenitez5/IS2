package presentacion;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonFactory {

	public static JButton crearBoton(String texto, Color color) {
		JButton boton = new JButton(texto);
		boton.setForeground(Color.WHITE);
		boton.setBackground(color);
		return boton;
	}

	public static JButton crearBotonConIcono(String ruta) {
		JButton boton = new JButton(new ImageIcon(ruta));
		boton.setBorderPainted(false);
		boton.setContentAreaFilled(false);
		return boton;
	}
}
