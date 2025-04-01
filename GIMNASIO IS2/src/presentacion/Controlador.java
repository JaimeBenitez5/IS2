package presentacion;
import negocio.SAClienteImp;

import java.util.List;

import negocio.tCliente;
import negocio.SACliente;

public class Controlador{
	public static void accion(int evento, Object datos) {
		switch (evento) {
		// CLIENTE
		case Evento.ALTA_CLIENTE: { // 1 = ALTA_CLIENTES
			VistaAltaCliente vac = new VistaAltaCliente();
			if(datos != null) {
				SACliente SACliente = new SAClienteImp();
				int id = SACliente.altaCliente((tCliente) datos);
				((tCliente) datos).setId(id);
				VistaAltaCliente.actualizar(Evento.RES_ALTA_CLIENTE_OK, id);	
			}
			break;
		}
		case Evento.MOSTRAR_CLIENTES: { // 2 = MOSTRAR_CLIENTES
			VistaMostrarClientes vmcs = new VistaMostrarClientes();
			SACliente SACliente = new SAClienteImp();
			List<tCliente>res = SACliente.leerTodosClientes();
			if (!res.isEmpty()) VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_OK, res);
			else VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_KO, null);
			break;
		}
		case Evento.BUSCAR_CLIENTE: { // 3 = BUSCAR_CLIENTE
			//TBD
			break;
		}
		case Evento.ELIMINAR_CLIENTE: { //4 = ELIMINAR_CLIENTE
			VistaBajaCliente vbc = new VistaBajaCliente();
			if(datos != null) {
				SACliente SACliente = new SAClienteImp();
				int exito = SACliente.borrarCliente((int)datos);
				if (exito == 1) VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_OK, 1);
				else VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_KO, 1);
			}
			break;
		}
		case Evento.MODIFICAR_CLIENTE: { // 5 = MODIFICAR_CLIENTE
			//TBD
			break;
		}
		}
	}
//	
//	public static void accion(int evento, tCliente cliente) {
//		if(evento == Evento.ALTA_CLIENTE) {
//			SACliente SACliente = new SAClienteImp();
//			int id = SACliente.altaCliente(cliente);
//			cliente.setId(id);
//			VistaAltaCliente.actualizar(Evento.RES_ALTA_CLIENTE_OK, id);
//		}
//	}
//
//	public static void accion(int evento, int id) {
//		if(evento == Evento.ELIMINAR_CLIENTE) {
//			SACliente SACliente = new SAClienteImp();
//			int exito = SACliente.borrarCliente(id);
//			if (exito == 1) VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_OK, 1);
//			else VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_KO, 1);
//		}
//	}


}