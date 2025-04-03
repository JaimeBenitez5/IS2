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
			if(datos != null) {
				SACliente SACliente = new SAClienteImp();
				int id = SACliente.altaCliente((tCliente) datos);
				((tCliente) datos).setId(id);
				VistaAltaCliente.actualizar(Evento.RES_ALTA_CLIENTE_OK, id);	
			}
			else {
				VistaAltaCliente vac = new VistaAltaCliente();
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
			if(datos != null) {
				SACliente SACliente = new SAClienteImp();
				int exito = SACliente.borrarCliente((int)datos);
				if (exito == 1) VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_OK, (int)datos);
				else VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_KO, (int)datos);
			}
			else {
				VistaBajaCliente vbc = new VistaBajaCliente();
			}
			break;
		}
		case Evento.MODIFICAR_CLIENTE: { // 5 = MODIFICAR_CLIENTE
			if(datos != null) {
				SACliente SACliente = new SAClienteImp();
				int exito = SACliente.actualizarCliente((tCliente) datos);
				if(exito == 1) VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_OK, null);
				else VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_KO, null);
			}
			else {
				VistaModificarCliente vmc = new VistaModificarCliente();
			}
			break;
		}
		}
	}
}