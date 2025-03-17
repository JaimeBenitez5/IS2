package presentacion;
import negocio.SAClienteImp;

import java.util.Collection;
import java.util.List;

import negocio.DTOtCliente;
import negocio.SACliente;
import negocio.tCliente;

public class Controlador{
	public static void accion(int evento) {
		switch (evento) {
		// CLIENTE
		case Evento.ALTA_CLIENTE: { // 1 = ALTA_CLIENTES
			//TBD (To Be Developed)
			break;
		}
		case Evento.MOSTRAR_CLIENTES: { // 2 = MOSTRAR_CLIENTES
			SACliente SACliente = new SAClienteImp();
			List<DTOtCliente>res = SACliente.leerTodosClientes();
			if (!res.isEmpty())
				VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_OK, res);
			else
				VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_KO, null);
			break;
		}
		case Evento.BUSCAR_CLIENTE: { // 3 = BUSCAR_CLIENTE
			//TBD
			break;
		}
		case Evento.ELIMINAR_CLIENTE: { //4 = ELIMINAR_CLIENTE
			//TBD
			break;
		}
		case Evento.MODIFICAR_CLIENTE: { // 5 = MODIFICAR_CLIENTE
			//TBD
			break;
		}
		}
	}
}