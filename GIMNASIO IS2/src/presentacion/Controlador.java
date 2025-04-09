package presentacion;

import java.util.List;

import presentacion.actividades.*;
import presentacion.catalogos.VistaAnadirCatalogo;
import presentacion.catalogos.VistaCatalogos;
import presentacion.catalogos.VistaEliminarCatalogo;
import presentacion.catalogos.VistaModificarCatalogo;
import presentacion.catalogos.VistaMostrarCatalogo;
import presentacion.catalogos.VistaMostrarCatalogos;
import presentacion.clientes.*;
import presentacion.empleados.VistaAnadirEmpleado;
import presentacion.empleados.VistaEliminarEmpleado;
import presentacion.empleados.VistaEmpleados;
import presentacion.empleados.VistaModificarEmpleado;
import presentacion.empleados.VistaMostrarEmpleado;
import presentacion.empleados.VistaMostrarEmpleados;
import presentacion.salas.*;
import negocio.*;

public class Controlador{

	public static void accion(int evento, Object datos) { 
		SACliente SACliente = new SAClienteImp();
		SASalas SASalas = new SASalasImp();
		SAActividades SAActividades = new SAActividadesImp();
		SACatalogos SACatalogos = new SACatalogosImp();
		SAEmpleados SAEmpleados = new SAEmpleadosImp();
		//usar patron creacional para crear los sa
		switch(evento) {
		//CLIENTES
		case Evento.ALTA_CLIENTE:{
			int id = SACliente.altaCliente((tCliente) datos);
			((tCliente) datos).setId(id);
			if(id != 0) VistaAltaCliente.actualizar(Evento.RES_ALTA_CLIENTE_OK, id);
			else VistaAltaCliente.actualizar(Evento.RES_ALTA_CLIENTE_KO, id);
			break;
		}
		case Evento.MOSTRAR_CLIENTES:{
			List<tCliente> res = SACliente.leerTodosClientes();
			if (!res.isEmpty()) VistaMostrarClientes.actualizar(Evento.RES_MOSTRAR_CLIENTES_OK, res);
			else VistaMostrarClientes.actualizar(Evento.RES_MOSTRAR_CLIENTES_KO, null);
			break;
		}
		case Evento.MOSTRAR_CLIENTE:{
			tCliente cliente = SACliente.leerCliente((int)datos);
			VistaMostrarCliente.actualizar(Evento.RES_MOSTRAR_CLIENTE_OK, cliente);

		}
		case Evento.ELIMINAR_CLIENTE:{
			int exito = SACliente.borrarCliente((int) datos);
			if (exito == 1) VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_OK, (int) datos);
			else VistaBajaCliente.actualizar(Evento.RES_ELIMINAR_CLIENTE_KO, null);

			break;
		}
		case Evento.MODIFICAR_CLIENTE:{
			int exitoModificar = SACliente.actualizarCliente((tCliente) datos);
			if (exitoModificar == 1) VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_OK, null);
			else VistaModificarCliente.actualizar(Evento.RES_MODIFICAR_CLIENTE_KO, null);
			break;
		}
		//SALAS
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
			if (!res.isEmpty()) VistaMostrarSalas.actualizar(Evento.RES_MOSTRAR_SALAS_OK, res);
			else VistaMostrarSalas.actualizar(Evento.RES_MOSTRAR_SALAS_KO, null);
			break;
		}
		case Evento.ELIMINAR_SALA:{
			int exito = SASalas.borrarSala((int) datos);
			if (exito == 1) VistaEliminarSala.actualizar(Evento.RES_ELIMINAR_SALA_OK, (int) datos);
			else VistaEliminarSala.actualizar(Evento.RES_ELIMINAR_SALA_KO, null);
			break;
		}
		case Evento.MODIFICAR_SALA:{
			int exitoModificar = SASalas.actualizarSala((tSala) datos);
			if (exitoModificar == 1) VistaModificarSala.actualizar(Evento.RES_MODIFICAR_SALA_OK, null);
			else VistaModificarSala.actualizar(Evento.RES_MODIFICAR_SALA_KO, null);
			break;
		}
		//ACTIVIDADES
		case Evento.ALTA_ACTIVIDAD:{
			int id = SASalas.altaSala((tSala) datos);
			((tSala) datos).setId(id);
			if(id != 0) VistaAnadirSala.actualizar(Evento.RES_ALTA_SALA_OK, id);
			else VistaAnadirSala.actualizar(Evento.RES_ALTA_SALA_KO, id);
			break;
		}
		case Evento.MOSTRAR_ACTIVIDAD:{
			tSala s = SASalas.leerSala((int) datos);
			VistaMostrarSala.actualizar(Evento.RES_MOSTRAR_SALA_OK, s);
			break;
		}
		case Evento.MOSTRAR_ACTIVIDADES:{
			List<tSala> res = SASalas.leerTodasSalas();
			if (!res.isEmpty()) VistaMostrarSalas.actualizar(Evento.RES_MOSTRAR_SALAS_OK, res);
			else VistaMostrarSalas.actualizar(Evento.RES_MOSTRAR_SALAS_KO, null);
			break;
		}
		case Evento.ELIMINAR_ACTIVIDAD:{
			int exito = SASalas.borrarSala((int) datos);
			if (exito == 1) VistaEliminarSala.actualizar(Evento.RES_ELIMINAR_SALA_OK, (int) datos);
			else VistaEliminarSala.actualizar(Evento.RES_ELIMINAR_SALA_KO, null);
			break;
		}
		case Evento.MODIFICAR_ACTIVIDAD:{
			int exitoModificar = SASalas.actualizarSala((tSala) datos);
			if (exitoModificar == 1) VistaModificarSala.actualizar(Evento.RES_MODIFICAR_SALA_OK, null);
			else VistaModificarSala.actualizar(Evento.RES_MODIFICAR_SALA_KO, null);
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
		case Evento.VISTA_CLIENTES:{ 
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
		//VISTAS ACTIVIDADES
		case Evento.VISTA_ACTIVIDADES:{ 
			VistaActividad.open();
			break;
		}
		case Evento.VISTA_ANADIR_ACTIVIDAD:{ 
			VistaAnadirActvidad.open();
			break;
		}
		case Evento.VISTA_ELIMINAR_ACTIVIDAD:{ 
			VistaEliminarActividad.open();
			break;
		}
		case Evento.VISTA_MOSTRAR_ACTIVIDADES:{ 
			VistaMostrarActividades.open();
			break;
		}
		case Evento.VISTA_MOSTRAR_ACTIVIDAD:{ 
			VistaMostrarActividad.open();
			break;
		}
		case Evento.VISTA_MODIFICAR_ACTIVIDAD:{ 
			VistaModificarActividad.open();
			break;
		}
		// VISTAS CATÁLOGOS
		case Evento.VISTA_CATALOGOS: {
			VistaCatalogos.open();
			break;
		}
		case Evento.VISTA_ANADIR_CATALOGO: {
			VistaAnadirCatalogo.open();
			break;
		}
		case Evento.VISTA_ELIMINAR_CATALOGO: {
			VistaEliminarCatalogo.open();
			break;
		}
		case Evento.VISTA_MOSTRAR_CATALOGOS: {
			VistaMostrarCatalogos.open();
			break;
		}
		case Evento.VISTA_MOSTRAR_CATALOGO: {
			VistaMostrarCatalogo.open();
			break;
		}
		case Evento.VISTA_MODIFICAR_CATALOGO: {
			VistaModificarCatalogo.open();
			break;
		}
		// VISTAS EMPLEADOS
		case Evento.VISTA_EMPLEADOS: {
			VistaEmpleados.open();
			break;
		}
		case Evento.VISTA_ANADIR_EMPLEADO: {
			VistaAnadirEmpleado.open();
			break;
		}
		case Evento.VISTA_ELIMINAR_EMPLEADO: {
			VistaEliminarEmpleado.open();
			break;
		}
		case Evento.VISTA_MOSTRAR_EMPLEADOS: {
			VistaMostrarEmpleados.open();
			break;
		}
		case Evento.VISTA_MOSTRAR_EMPLEADO: {
			VistaMostrarEmpleado.open();
			break;
		}
		case Evento.VISTA_MODIFICAR_EMPLEADO: {
			VistaModificarEmpleado.open();
			break;
		}
		}
	}
}