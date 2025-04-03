package presentacion;

import negocio.SAClienteImp;

import java.util.List;

import negocio.tCliente;
import presentacion.clientes.VistaAltaCliente;
import presentacion.clientes.VistaBajaCliente;
import presentacion.clientes.VistaCliente;
import presentacion.clientes.VistaModificarCliente;
import presentacion.clientes.VistaMostrarCliente;
import presentacion.clientes.VistaMostrarClientes;
import negocio.SACliente;

public class Controlador{
	public static void accion(int evento, Object datos) {
		// CLIENTE
		if(evento == Evento.VISTA_CLIENTE) {
			VistaCliente.open(null);
		}
		else if(evento == Evento.VISTA_ALTA_CLIENTE) {
			VistaAltaCliente.open(null);
		}
		else if(evento == Evento.VISTA_ELIMINAR_CLIENTE) {
			VistaBajaCliente.open(null);
		}
		else if(evento == Evento.VISTA_MOSTRAR_CLIENTES) {
			VistaMostrarClientes.open(null);
		}
		else if(evento == Evento.VISTA_MOSTRAR_CLIENTE) {
			VistaMostrarCliente.open(null);
		}
		else if(evento == Evento.VISTA_MODIFICAR_CLIENTE) {
			VistaModificarCliente.open(null);
		}


		else if(evento == Evento.ALTA_CLIENTE) {
			SACliente SACliente = new SAClienteImp();
			int id = SACliente.altaCliente((tCliente) datos);
			((tCliente) datos).setId(id);
			//controlar si se ha podido insertar o no
			VistaAltaCliente.actualizar(Evento.RES_ALTA_CLIENTE_OK, id);
		}
		else if( evento == Evento.MOSTRAR_CLIENTES) {
			SACliente SACliente = new SAClienteImp();
			List<tCliente>res = SACliente.leerTodosClientes();
			if (!res.isEmpty()) VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_OK, res);
			else VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_KO, null);
		}
		else if(evento == Evento.BUSCAR_CLIENTE) {

		}
		else if(evento == Evento.ELIMINAR_CLIENTE) {
			SACliente SACliente = new SAClienteImp();
			int exito = SACliente.borrarCliente((int)datos);
			if (exito == 1) VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_OK, (int)datos);
			else VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_KO, (int)datos);

		}
		else if(evento ==  Evento.MODIFICAR_CLIENTE) {
			SACliente SACliente = new SAClienteImp();
			int exito = SACliente.actualizarCliente((tCliente) datos);
			if(exito == 1) VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_OK, null);
			else VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_KO, null);

		}
	}
}