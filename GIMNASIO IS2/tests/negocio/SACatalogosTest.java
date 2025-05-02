package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SACatalogosTest {
	
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
		catalogos = new SACatalogosImp();
		SAActividades = new SAActividadesImp();
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
		
		idSala1 = salas.altaSala(new DTOtSala(15,emp1));
		idSala2 = salas.altaSala(new DTOtSala(10,emp2));
		
		ArrayList<DTOtActividad> actividades = new ArrayList();
		actividades.add(new DTOtActividad("Yoga",idSala1,d1,"99999999X"));
		actividades.add(new DTOtActividad("Pilates",idSala2,d1,"88888888K"));
		actividades.add(new DTOtActividad("Crossfit",idSala1,d2,"99999999X"));
		
		for(DTOtActividad a : actividades) SAActividades.altaActividad(a);
		
		idCatalogo1 = catalogos.altaCatalogo(new DTOtCatalogo(3));
		catalogos.altaCatalogo(new DTOtCatalogo(idCatalogo1,actividades,3));
		
		assertEquals(idCatalogo1 + " 3 Yoga " + idSala1 + " 99999999X " + d1.toString() + 
				" Pilates " + idSala2 + " 88888888K " + d1.toString() + 
				" Crossfit " + idSala1 + " 99999999X " + d1.toString(),catalogos.leerCatalogo(idCatalogo1).toString());
		
		actividades.remove(2);
		
		catalogos.actualizarCatalogo(new DTOtCatalogo(idCatalogo1,actividades,3));
		
		assertEquals(idCatalogo1 + " 3 Yoga " + idSala1 + " 99999999X " + d1.toString() + 
				" Crossfit " + idSala1 + " 99999999X " + d1.toString(), catalogos.leerCatalogo(idCatalogo1).toString());
		
		catalogos.borrarCatalogo(idCatalogo1);
		
		idCatalogo1 = catalogos.altaCatalogo(new DTOtCatalogo(7));
		catalogos.altaCatalogo(new DTOtCatalogo(idCatalogo1,actividades,7));
		idCatalogo2 = catalogos.altaCatalogo(new DTOtCatalogo(5));
		catalogos.altaCatalogo(new DTOtCatalogo(idCatalogo2,actividades,5));
		
		List<DTOtCatalogo> list = catalogos.leerTodosCatalogos();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtCatalogo e : list) {
			if (e.toString().equals(idCatalogo1 + " 7 Yoga " + idSala1 + " 99999999X " + d1.toString() + 
					" Crossfit " + idSala1 + " 99999999X " +d1.toString())) a = true;
			else if(e.toString().equals(idCatalogo2 + " 5 Yoga " + idSala1 + " 99999999X " + d1.toString() + 
					" Crossfit " + idSala1 + " 99999999X " +d1.toString())) b = true;
		}
		
		assertTrue(a);
		assertTrue(b);
		
	}

}
