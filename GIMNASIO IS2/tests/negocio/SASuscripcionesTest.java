package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class SASuscripcionesTest {
	
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
	
	int idCatalogo1;
	int idCatalogo2;
	
	static Date d1;
	static Date d2;
	
	@BeforeAll
	static void init() {
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
		salas.borrarSala(idSala1);
		salas.borrarSala(idSala2);
	}

	@Test
	void test() {
		
		empleados.altaEmpleado(new DTOtEmpleado("99999999X", "Test1", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("88888888K", "Test2", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("77777777V", "Test3", new DTOtRol("Mantenimiento")));
		empleados.altaEmpleado(new DTOtEmpleado("66666666Z", "Test4", new DTOtRol("Mantenimiento")));
		empleados.altaEmpleado(new DTOtEmpleado("22222222B", "Test5", new DTOtRol("Nutricionista")));
		empleados.altaEmpleado(new DTOtEmpleado("11111111A", "Test6", new DTOtRol("Nutricionista")));
		
		idSala1 = salas.altaSala(new DTOtSala(15, emp1));
		idSala2 = salas.altaSala(new DTOtSala(10, emp2));
		
		ArrayList<DTOtActividad> act = new ArrayList<DTOtActividad>();
		act.add(new DTOtActividad("Yoga", idSala1, d1, "99999999X"));
		act.add(new DTOtActividad("Pilates", idSala2, d1, "88888888K"));
		act.add(new DTOtActividad("Crossfit", idSala1, d2, "99999999X"));
		
		for(DTOtActividad a : act) actividades.altaActividad(a);
		
		idCatalogo1 = catalogos.altaCatalogo(new DTOtCatalogo(0, act, 7));
		
		int numBas = basicas.altaSuscripcion(new DTOtBasica("Agapito", "Yoga", d1, idSala1));
		int numPrem = premium.altaSuscripcion(new DTOtPremium("Anacleto", idCatalogo1, "11111111A"));
		
		
		assertEquals("1 1 30 30.0 Agapito Yoga " + d1.toString() + " " + idSala1, basicas.leerSuscripcion(numBas).toString());
		assertEquals("2 2 90 120.0 Anacleto " + idCatalogo1 + " 11111111A", premium.leerSuscripcion(numPrem).toString());
		
		basicas.actualizarSuscripcion(new DTOtBasica(numBas, "Josefa", "Crossfit", d2, idSala1));
		
		assertEquals("1 1 30 30.0 Josefa Crossfit " + d2.toString() + " " + idSala1, basicas.leerSuscripcion(numBas).toString());
		basicas.borrarSuscripcion(numBas);
		
		premium.actualizarSuscripcion(new DTOtPremium(numPrem, "Manuel", idCatalogo1, "22222222B"));
		
		List<DTOtSuscripcion> list = premium.leerTodasSuscripciones();
		
		boolean a = false;
		
		for(DTOtSuscripcion e : list) {
			if (e.toString().equals("2 2 90 120.0 Manuel 1 22222222B")) a = true;
		}
		
		assertTrue(a);
		
		assertEquals("2 2 90 120.0 Manuel 1 22222222B", list.get(0).toString());
	}

}
