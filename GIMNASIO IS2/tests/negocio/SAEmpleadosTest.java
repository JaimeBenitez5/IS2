package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SAEmpleadosTest {

	@Test
	void test() {
		SAEmpleadosImp empleados = new SAEmpleadosImp();
		DTOtEmpleado A = new DTOtEmpleado("11111111A", "Agapito", new DTOtRol("MANTENIMIENTO"));
		DTOtEmpleado B = new DTOtEmpleado("22222222B", "Manuel", new DTOtRol("RECEPCION")); 
		DTOtEmpleado C = new DTOtEmpleado("33333333C", "Josefa", new DTOtRol("MONITOR"));
		DTOtEmpleado D = new DTOtEmpleado("44444444D", "Anastasia", new DTOtRol("NUTRICIONISTA"));
		
		empleados.altaEmpleado(A);
		empleados.altaEmpleado(B);
		empleados.altaEmpleado(C);
		empleados.altaEmpleado(D);
		
		assertEquals(A.toString(),empleados.leerEmpleado("11111111A").toString());
		assertEquals(B.toString(),empleados.leerEmpleado("22222222B").toString());
		assertEquals(C.toString(),empleados.leerEmpleado("33333333C").toString());
		assertEquals(D.toString(),empleados.leerEmpleado("44444444D").toString());
		
		empleados.actualizarEmpleado(new DTOtEmpleado("11111111A", "Arturo",new DTOtRol("MANTENIMIENTO")));
		assertEquals("11111111A Arturo 1 MANTENIMIENTO 0.0",empleados.leerEmpleado("11111111A").toString());
		
		empleados.borrarEmpleado("33333333C");
		empleados.borrarEmpleado("44444444D");
		
		empleados.actualizarEmpleado(new DTOtEmpleado("22222222B", "Joaquin", new DTOtRol("MONITOR")));
		
		List<DTOtEmpleado> list = empleados.leerTodosEmpleados();
		
		assertEquals("11111111A Arturo 1 MANTENIMIENTO 0.0",list.get(0).toString());
		assertEquals("22222222B Joaquin 2 MONITOR 0.0",list.get(1).toString());
		
	}

}
