package mainLauncher;

import presentacion.Controlador;
import presentacion.Evento;


public class Main {
	public static void main ( String[] args ) {
		Controlador.accion(Evento.VISTA_MENU_PRINCIPAL, null);
	}
}