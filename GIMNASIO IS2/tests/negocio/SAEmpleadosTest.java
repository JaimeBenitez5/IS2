package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SAEmpleadosTest {
	
	static SAEmpleados empleados;
	
	@BeforeAll
	static void init() {
		empleados = new SAEmpleadosImp();
		empleados.borrarEmpleado("11111111A");
		empleados.borrarEmpleado("22222222B");
		empleados.borrarEmpleado("33333333C");
		empleados.borrarEmpleado("44444444D");
	}
	
	@AfterAll
	static void limpia() {
		empleados.borrarEmpleado("11111111A");
		empleados.borrarEmpleado("22222222B");
		empleados.borrarEmpleado("33333333C");
		empleados.borrarEmpleado("44444444D");
	}

	@Test
	void test() {
		
		assertEquals(1,empleados.altaEmpleado(new DTOtEmpleado("11111111A", "Agapito", new DTOtRol("Mantenimiento"))));
		assertEquals(1,empleados.altaEmpleado(new DTOtEmpleado("22222222B", "Manuel", new DTOtRol("Recepcion"))));
		assertEquals(1,empleados.altaEmpleado(new DTOtEmpleado("33333333C", "Josefa", new DTOtRol("Monitor"))));
		assertEquals(1,empleados.altaEmpleado(new DTOtEmpleado("44444444D", "Anastasia", new DTOtRol("Nutricionista"))));
		
		assertEquals(0,empleados.altaEmpleado(new DTOtEmpleado("11111111A", "Agapito", new DTOtRol("Mantenimiento"))));
		
		assertEquals("11111111A Agapito 1 Mantenimiento 2400.0", empleados.leerEmpleado("11111111A").toString());
		assertEquals("22222222B Manuel 4 Recepcion 1500.0", empleados.leerEmpleado("22222222B").toString());
		assertEquals("33333333C Josefa 2 Monitor 2100.0", empleados.leerEmpleado("33333333C").toString());
		assertEquals("44444444D Anastasia 3 Nutricionista 1300.0", empleados.leerEmpleado("44444444D").toString());
		
		assertEquals(1,empleados.actualizarEmpleado(new DTOtEmpleado("11111111A", "Arturo",new DTOtRol("Mantenimiento"))));
		assertEquals(0,empleados.actualizarEmpleado(new DTOtEmpleado("13264839A", "JoseManuel",new DTOtRol("Mantenimiento"))));
		assertEquals("11111111A Arturo 1 Mantenimiento 2400.0", empleados.leerEmpleado("11111111A").toString());
		
		assertEquals(1,empleados.borrarEmpleado("33333333C"));
		assertEquals(0,empleados.borrarEmpleado("33333333C"));
		assertNull(empleados.leerEmpleado("33333333C"));
		assertEquals(1,empleados.borrarEmpleado("44444444D"));
		assertNull(empleados.leerEmpleado("44444444D"));
		
		List<DTOtEmpleado> list = empleados.leerTodosEmpleados();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtEmpleado e : list) {
			if (e.toString().equals("11111111A Arturo 1 Mantenimiento 2400.0")) a = true;
			else if(e.toString().equals("22222222B Manuel 4 Recepcion 1500.0")) b = true;
		}
		
		assertTrue(a);
		assertTrue(b);
	}

}
