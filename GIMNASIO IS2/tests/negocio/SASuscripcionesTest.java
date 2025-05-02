package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import integracion.DAOSuscripciones;
import integracion.DAOSuscripcionesBasicasImp;

class SASuscripcionesTest {
	
	static SASuscripciones basicas;
	static SASuscripciones premium;
	static SACatalogos catalogos;
	static SAActividades SAActividades;
	static SASalas salas;
	static SAEmpleados empleados;
	static int idSala1;
	static int idSala2;
	
	String[] emp1 = {"77777777V"};
	String[] emp2 = {"66666666Z"};
	
	int idCatalogo1;
	int idCatalogo2;
	
	static Date d1;
	static Date d2;
	
	@BeforeAll
	static void init() {
		basicas = new SASuscripcionesBasicasImp();
		premium = new SASuscripcionesPremiumImp();
		catalogos = new SACatalogosImp();
		SAActividades = new SAActividadesImp();
		salas = new SASalasImp();
		empleados = new SAEmpleadosImp();
		
		d1 = Date.valueOf("2025-1-1");
	}
	
	@AfterAll
	static void limpia() {
		empleados.borrarEmpleado("99999999X");
		empleados.borrarEmpleado("88888888K");
		empleados.borrarEmpleado("77777777V");
		empleados.borrarEmpleado("66666666Z");
		salas.borrarSala(idSala1);
		salas.borrarSala(idSala2);
	}

	@Test
	void test() {
		
		empleados.altaEmpleado(new DTOtEmpleado("99999999X", "Test1", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("88888888K", "Test2", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("77777777V", "Test3", new DTOtRol("Mantenimiento")));
		empleados.altaEmpleado(new DTOtEmpleado("66666666Z", "Test4", new DTOtRol("Mantenimiento")));
		
		idSala1 = salas.altaSala(new DTOtSala(15,emp1));
		idSala2 = salas.altaSala(new DTOtSala(10,emp2));
		
		DAOSuscripciones daoBas = SASuscripcionesBasicasImp.getDAOSuscripciones();
		DAOSuscripciones daoPrem = SASuscripcionesPremiumImp.getDAOSuscripciones();
		
		int numBas = basicas.altaSuscripcion(new DTOtBasica("Agapito", "Yoga",d1, 1));
		int numPrem = premium.altaSuscripcion(new DTOtPremium("Anacleto",1,"11111111A"));
		
		daoBas.altaSuscripcionBasica(new DTOtBasica(numBas,"Agapito", "Yoga",d1, 1));
		daoPrem.altaSuscripcionPremium(new DTOtPremium(numPrem,"Anacleto",1,"11111111A"));
		
		Date d = d1;
		
		assertEquals("1 1 30 30 Agapito Yoga " + d.toString() + " 1", basicas.leerSuscripcion(1).toString());
		assertEquals("2 2 90 120 Anacleto 1 11111111A", premium.leerSuscripcion(2));
		
		basicas.actualizarSuscripcion(new DTOtBasica(numBas,"Josefa", "Crossfit", d1, 1));
		daoBas.actualizarSuscripcionBasica(new DTOtBasica(numBas,"Josefa", "Crossfit",d1, 1));
		
		assertEquals("1 1 30 30 Josefa Crossfit " + d.toString() + " 1", basicas.leerSuscripcion(1));
		basicas.borrarSuscripcion(1);
		
		premium.actualizarSuscripcion(new DTOtPremium(numPrem,"Manuel",2,"22222222B"));
		daoPrem.actualizarSuscripcionPremium(new DTOtPremium(numPrem,"Manuel",2,"22222222B"));
		
		List<DTOtSuscripcion> list = premium.leerTodasSuscripciones();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtSuscripcion e : list) {
			if (e.toString().equals("2 2 90 120 Manuel 2 22222222B")) a = true;
			else if(e.toString().equals("")) b = true;
		}
		
		assertTrue(a);
		assertTrue(b);
		
		assertEquals("2 2 90 120 Manuel 2 22222222B", list.get(0).toString());
	}

}
