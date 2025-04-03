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
		SACliente SACliente = new SAClienteImp();
		switch(evento) {

		case Evento.VISTA_MENU_PRINCIPAL:{
			VistaMenuPrincipal.open();
			break;
		}
		//CLIENTES
		// vistas
		case Evento.VISTA_CLIENTE:{ 
			VistaCliente.open();
			break;
		}
		case Evento.VISTA_ALTA_CLIENTE:{	
			VistaAltaCliente.open();
			break;
		}
		case Evento.VISTA_ELIMINAR_CLIENTE:{
			VistaBajaCliente.open();
			break;
		}
		case Evento.VISTA_MOSTRAR_CLIENTES:{
			VistaMostrarClientes.open();
			break;
		}
		case Evento.VISTA_MOSTRAR_CLIENTE:{
			VistaMostrarCliente.open();
			break;
		}
		case Evento.VISTA_MODIFICAR_CLIENTE:{
			VistaModificarCliente.open();
			break;
		}
		//CLIENTES
		// negocio
		case Evento.ALTA_CLIENTE:{
			int id = SACliente.altaCliente((tCliente) datos);
			((tCliente) datos).setId(id);
			if(id != 0) VistaAltaCliente.actualizar(Evento.RES_ALTA_CLIENTE_OK, id);
			else VistaAltaCliente.actualizar(Evento.RES_ALTA_CLIENTE_KO, id);
			break;
		}
		case Evento.MOSTRAR_CLIENTES:{
			List<tCliente> res = SACliente.leerTodosClientes();
			if (!res.isEmpty()) {
				VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_OK, res);
			} else {
				VistaCliente.actualizar(Evento.RES_MOSTRAR_CLIENTES_KO, null);
			}
			break;
		}
		case Evento.BUSCAR_CLIENTE:{
			// Lógica para la búsqueda de cliente (aún no implementada)
			break;
		}
		case Evento.ELIMINAR_CLIENTE:{
			int exito = SACliente.borrarCliente((int) datos);
			if (exito == 1) {
				VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_OK, (int) datos);
			} else {
				VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_KO, null);
			}
			break;
		}
		case Evento.MODIFICAR_CLIENTE:{
			int exitoModificar = SACliente.actualizarCliente((tCliente) datos);
			if (exitoModificar == 1) {
				VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_OK, null);
			} else {
				VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_KO, null);
			}
			break;
		}
		// FACTURAS
		// vistas
		}
	}
}