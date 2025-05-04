package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SAComprasTest {
	
	static SAClientes clientes;
	static SASuscripciones basicas;
	static SASuscripciones premium;
	static SACatalogos catalogos;
	static SAActividades actividades;
	static SASalas salas;
	static SAEmpleados empleados;
	static int idSala1;
	static int idSala2;
	
	String[] emp1 = {"77777777V"};
	String[] emp2 = {"66666666Z"};
	
	static int idCatalogo1;
	
	static SACompras compras;
	static int idSuscripcion;
	static Date d1;
	static Date d2;
	
	@BeforeAll
	static void init() {
		compras = new SAComprasImp();
		clientes = new SAClientesImp();
		basicas = new SASuscripcionesBasicasImp();
		premium = new SASuscripcionesPremiumImp();
		catalogos = new SACatalogosImp();
		actividades = new SAActividadesImp();
		salas = new SASalasImp();
		empleados = new SAEmpleadosImp();
		d1 = Date.valueOf("2025-1-1");
		d2 = Date.valueOf("2025-1-2");
	}
	
	@AfterAll
	static void limpia() {
		empleados.borrarEmpleado("99999999X");
		empleados.borrarEmpleado("88888888K");
		empleados.borrarEmpleado("77777777V");
		empleados.borrarEmpleado("66666666Z");
		empleados.borrarEmpleado("44444444D");
		empleados.borrarEmpleado("33333333C");
		empleados.borrarEmpleado("22222222B");
		empleados.borrarEmpleado("11111111A");
		salas.borrarSala(idSala1);
		salas.borrarSala(idSala2);
		catalogos.borrarCatalogo(idCatalogo1);
	}

	@Test
	void test() {
		
		if(clientes.leerCliente("12345678A") == null)
			clientes.altaCliente(new DTOtCliente("12345678A", "TesTeo", "casa1", true));
		if(clientes.leerCliente("87654321B") == null)
			clientes.altaCliente(new DTOtCliente("87654321B", "TesTeo2", "casa2", true));
		
		empleados.altaEmpleado(new DTOtEmpleado("99999999X", "Test1", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("88888888K", "Test2", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("77777777V", "Test3", new DTOtRol("Mantenimiento")));
		empleados.altaEmpleado(new DTOtEmpleado("66666666Z", "Test4", new DTOtRol("Mantenimiento")));
		empleados.altaEmpleado(new DTOtEmpleado("44444444D", "Test5", new DTOtRol("Recepcion")));
		empleados.altaEmpleado(new DTOtEmpleado("33333333C", "Test6", new DTOtRol("Recepcion")));
		empleados.altaEmpleado(new DTOtEmpleado("22222222B", "Test7", new DTOtRol("Nutricionista")));
		empleados.altaEmpleado(new DTOtEmpleado("11111111A", "Test8", new DTOtRol("Nutricionista")));
		
		idSala1 = salas.altaSala(new DTOtSala(15, emp1));
		idSala2 = salas.altaSala(new DTOtSala(10, emp2));
		
		ArrayList<DTOtActividad> act = new ArrayList<DTOtActividad>();
		act.add(new DTOtActividad("Yoga", idSala1, d1, "99999999X"));
		act.add(new DTOtActividad("Pilates", idSala2, d1, "88888888K"));
		act.add(new DTOtActividad("Crossfit", idSala1, d2, "99999999X"));
		
		for(DTOtActividad a : act) actividades.altaActividad(a);
		
		idCatalogo1 = catalogos.altaCatalogo(new DTOtCatalogo(0, act, 7));
		
		int idBas = basicas.altaSuscripcion(new DTOtBasica("Agapito", "Yoga", d1, idSala1));
		int idPrem = premium.altaSuscripcion(new DTOtPremium("Anacleto", idCatalogo1, "11111111A"));
		
		int idCompra1 = compras.altaCompra(new DTOtCompra(0,idBas,"12345678A",d1,"Efectivo","33333333C"));
		int idCompra2 = compras.altaCompra(new DTOtCompra(0,idPrem,"87654321B",d2,"Tarjeta","44444444D"));
		
		DTOtCompra compra1 = compras.leerCompra(idCompra1);
		DTOtCompra compra2 = compras.leerCompra(idCompra2);
		
		
		int idFactura1 = compra1.getIdFactura();
		int idFactura2 = compra2.getIdFactura();
		
		double precio1 = basicas.leerSuscripcion(idBas).getPrecio();
		double precio2 = premium.leerSuscripcion(idPrem).getPrecio();
		
		assertEquals(idCompra1 + " " + idBas + " 12345678A " + d1.toString() + " Efectivo 33333333C " + idFactura1, compra1.toString());
		assertEquals(idCompra2 + " " + idPrem + " 87654321B " + d2.toString() + " Tarjeta 44444444D " + idFactura2, compra2.toString());
		
		assertEquals(idFactura1 + " " + d1.toString() + " " + precio1, compras.leerFactura(idFactura1).toString());
		assertEquals(idFactura2 + " " + d2.toString() + " " + precio2, compras.leerFactura(idFactura2).toString());
		
		compra1.setDniEmpleado("44444444D");
		compra1.setFecha(d2);
		compra1.setMetodoPago("Bizum");
		
		assertEquals(1, compras.actualizarCompra(compra1));
		
		assertEquals(idCompra1 + " " + idBas + " 12345678A " + d2.toString() + " Bizum 44444444D " + idFactura1, compras.leerCompra(idCompra1).toString());
		assertEquals(idFactura1 + " " + d2.toString() + " " + precio1, compras.leerFactura(idFactura1).toString());
		
		List<DTOtCompra> listCompras = compras.leerTodasCompras();
		List<DTOtFactura> listFacturas = compras.leerTodasFacturas();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtCompra c : listCompras) {
			if (c.toString().equals(idCompra1 + " " + idBas + " 12345678A " + d2.toString() + " Bizum 44444444D " + idFactura1)) a = true;
			else if (c.toString().equals(idCompra2 + " " + idPrem + " 87654321B " + d2.toString() + " Tarjeta 44444444D " + idFactura2)) b = true;
		}
		
		assertTrue(a); a = false;
		assertTrue(b); b = false;
		
		for(DTOtFactura f : listFacturas) {
			if(f.toString().equals(idFactura1 + " " + d2.toString() + " " + precio1)) a = true;
			else if (f.toString().equals(idFactura2 + " " + d2.toString() + " " + precio2)) b = true;
		}
		
		assertTrue(a);
		assertTrue(b);
		
		assertEquals(1,compras.borrarCompra(idCompra1));
		assertEquals(0,compras.borrarCompra(idCompra1));
		
		assertNull(compras.leerCompra(idCompra1));
		assertNull(compras.leerFactura(idFactura1));
	} 

}
