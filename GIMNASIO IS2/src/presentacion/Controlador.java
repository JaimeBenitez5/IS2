package presentacion;
import negocio.SAClienteImp;

import java.util.Collection;
import java.util.List;

import negocio.tCliente;
import negocio.SACliente;
import negocio.tCliente;

public class Controlador{
	public static void accion(int evento) {
		switch (evento) {
		// CLIENTE
		case Evento.ALTA_CLIENTE: { // 1 = ALTA_CLIENTES
			VistaAltaCliente vac = new VistaAltaCliente();
			break;
		}
		case Evento.MOSTRAR_CLIENTES: { // 2 = MOSTRAR_CLIENTES
			VistaMostrarClientes vmcs = new VistaMostrarClientes();
			SACliente SACliente = new SAClienteImp();
			List<tCliente>res = SACliente.leerTodosClientes();
			VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_OK, res);
			//if (!res.isEmpty()) VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_OK, res);
			//else VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_KO, null);
			break;
		}
		case Evento.BUSCAR_CLIENTE: { // 3 = BUSCAR_CLIENTE
			//TBD
			break;
		}
		case Evento.ELIMINAR_CLIENTE: { //4 = ELIMINAR_CLIENTE
			VistaBajaCliente vbc = new VistaBajaCliente();
			break;
		}
		case Evento.MODIFICAR_CLIENTE: { // 5 = MODIFICAR_CLIENTE
			//TBD
			break;
		}
		}
	}
}