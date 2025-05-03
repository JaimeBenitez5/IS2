package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SAActividadesTest {
	
	static SAActividades actividades;
	static SASalas salas;
	static SAEmpleados empleados;
	static SACatalogos catalogos;
	static Date d1;
	static Date d2;
	static int idSala1;
	static int idSala2;
	static int idCatalogo;
	String[] emp1 = {"77777777V"};
	String[] emp2 = {"66666666Z"};
	
	@BeforeAll
	static void init() {
		actividades = new SAActividadesImp();
		salas = new SASalasImp();
		empleados = new SAEmpleadosImp();
		catalogos = new SACatalogosImp();
		
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
		catalogos.borrarCatalogo(idCatalogo);
	}

	@Test
	void test() {
		empleados.altaEmpleado(new DTOtEmpleado("99999999X", "Test1", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("88888888K", "Test2", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("77777777V", "Test3", new DTOtRol("Mantenimiento")));
		empleados.altaEmpleado(new DTOtEmpleado("66666666Z", "Test4", new DTOtRol("Mantenimiento")));
		
		idSala1 = salas.altaSala(new DTOtSala(15,emp1));
		idSala2 = salas.altaSala(new DTOtSala(10,emp2));
		
		actividades.altaActividad(new DTOtActividad("Yoga", idSala1, d1,"99999999X"));
		actividades.altaActividad(new DTOtActividad("Pilates", idSala2, d1,"88888888K"));
		actividades.altaActividad(new DTOtActividad("Crossfit", idSala1, d2,"99999999X"));
		
		ArrayList<DTOtActividad> act = new ArrayList<DTOtActividad>();
		act.add(new DTOtActividad("Yoga", idSala1, d1, "99999999X"));
		act.add(new DTOtActividad("Pilates", idSala2, d1, "88888888K"));
		act.add(new DTOtActividad("Crossfit", idSala1, d2, "99999999X"));
		
		idCatalogo = catalogos.altaCatalogo(new DTOtCatalogo(0, act, 3));
		
		
		assertEquals(actividades.leerActividad("Yoga", d1, idSala1).toString(), "Yoga " + idSala1 + " 99999999X 2025-01-01");
		
		actividades.actualizarActividad(new DTOtActividad("Yoga",idSala1, d1,"88888888K",1));
		
		assertEquals(actividades.leerActividad("Yoga", d1, idSala1).toString(),"Yoga " + idSala1 + " 88888888K 2025-01-01");
		
		actividades.borrarActividad("Crossfit", d2, idSala1);
		
		List<DTOtActividad> list = actividades.leerTodasActividades();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtActividad e : list) {
			if (e.toString().equals("Yoga " + idSala1 + " 88888888K " + d1.toString())) a = true;
			else if(e.toString().equals("Pilates " + idSala2 + " 88888888K " + d1.toString())) b = true;
		}
		
		assertTrue(a);
		assertTrue(b);
		
	}

}
