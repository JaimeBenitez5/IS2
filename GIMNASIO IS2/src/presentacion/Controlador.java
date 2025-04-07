	package presentacion;
	
	import java.util.List;
	
	import presentacion.clientes.*;
	import presentacion.salas.*;
	import negocio.*;
	
	public class Controlador{
	
		public static void accion(int evento, Object datos) { 
			SACliente SACliente = new SAClienteImp();
			SASalas SASalas = new SASalasImp();
			switch(evento) {
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
					VistaMostrarClientes.actualizar(Evento.RES_MOSTRAR_CLIENTES_OK, res);
				} 
				else {
					VistaMostrarClientes.actualizar(Evento.RES_MOSTRAR_CLIENTES_KO, null);
				}
				break;
			}
			case Evento.MOSTRAR_CLIENTE:{
				tCliente cliente = SACliente.leerCliente((int)datos);
				VistaMostrarCliente.actualizar(Evento.RES_MOSTRAR_CLIENTE_OK, cliente);
	
			}
			case Evento.BUSCAR_CLIENTE:{
				// Lógica para la búsqueda de cliente (aún no implementada)
				break;
			}
			case Evento.ELIMINAR_CLIENTE:{
				int exito = SACliente.borrarCliente((int) datos);
				if (exito == 1) {
					VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_OK, (int) datos);
				} 
				else {
					VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_KO, null);
				}
				break;
			}
			case Evento.MODIFICAR_CLIENTE:{
				int exitoModificar = SACliente.actualizarCliente((tCliente) datos);
				if (exitoModificar == 1) {
					VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_OK, null);
				}
				else {
					VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_KO, null);
				}
				break;
			}
			// SALAS
			case Evento.ALTA_SALA:{
				int id = SASalas.altaSala((tSala) datos);
				((tSala) datos).setId(id);
				if(id != 0) VistaAnadirSala.actualizar(Evento.RES_ALTA_SALA_OK, id);
				else VistaAnadirSala.actualizar(Evento.RES_ALTA_SALA_KO, id);
				break;
			}
			case Evento.MOSTRAR_SALA:{
				tSala s = SASalas.leerSala((int) datos);
				VistaMostrarSala.actualizar(Evento.RES_MOSTRAR_SALA_OK, s);
				break;
			}
			case Evento.MOSTRAR_SALAS:{
				List<tSala> res = SASalas.leerTodasSalas();
				if (!res.isEmpty()) {
					VistaMostrarSalas.actualizar(Evento.RES_MOSTRAR_SALAS_OK, res);
				} 
				else {
					VistaMostrarSalas.actualizar(Evento.RES_MOSTRAR_SALAS_KO, null);
				}
				break;
			}
			}
		}
	
		public static void mostrarVista(int evento) {
			switch(evento) {
			case Evento.VISTA_MENU_PRINCIPAL:{
				VistaMenuPrincipal.open();
				break;
			}
			//VISTAS CLIENTES
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
			//VISTAS SALAS
			case Evento.VISTA_SALAS:{ 
				VistaSalas.open();
				break;
			}
			case Evento.VISTA_ANADIR_SALAS:{ 
				VistaAnadirSala.open();
				break;
			}
			case Evento.VISTA_ELIMINAR_SALA:{ 
				VistaEliminarSala.open();
				break;
			}
			case Evento.VISTA_MOSTRAR_SALAS:{ 
				VistaMostrarSalas.open();
				break;
			}
			case Evento.VISTA_MOSTRAR_SALA:{ 
				VistaMostrarSala.open();
				break;
			}
			case Evento.VISTA_MODIFICAR_SALA:{ 
				VistaModificarSala.open();
				break;
			}
			}
		}
	}