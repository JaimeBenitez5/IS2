package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SAEmpleadosTest {

	@Test
	void test() {
		SAEmpleados empleados = new SAEmpleadosImp();
		
		empleados.borrarEmpleado("11111111A");
		empleados.borrarEmpleado("22222222B");
		empleados.borrarEmpleado("33333333C");
		empleados.borrarEmpleado("44444444D");
		
		empleados.altaEmpleado(new DTOtEmpleado("11111111A", "Agapito", new DTOtRol("Mantenimiento")));
		empleados.altaEmpleado(new DTOtEmpleado("22222222B", "Manuel", new DTOtRol("Recepcion")));
		empleados.altaEmpleado(new DTOtEmpleado("33333333C", "Josefa", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("44444444D", "Anastasia", new DTOtRol("Nutricionista")));
		
		assertEquals("11111111A Agapito 1 Mantenimiento 2400.0", empleados.leerEmpleado("11111111A").toString());
		assertEquals("22222222B Manuel 4 Recepcion 1500.0", empleados.leerEmpleado("22222222B").toString());
		assertEquals("33333333C Josefa 2 Monitor 2100.0", empleados.leerEmpleado("33333333C").toString());
		assertEquals("44444444D Anastasia 3 Nutricionista 1300.0", empleados.leerEmpleado("44444444D").toString());
		
		empleados.actualizarEmpleado(new DTOtEmpleado("11111111A", "Arturo",new DTOtRol("Mantenimiento")));
		assertEquals("11111111A Arturo 1 Mantenimiento 2400.0", empleados.leerEmpleado("11111111A").toString());
		
		empleados.borrarEmpleado("33333333C");
		empleados.borrarEmpleado("44444444D");
		
		List<DTOtEmpleado> list = empleados.leerTodosEmpleados();
		//METER UN RECORRIDO QUE HAGA QUE LOS BUSQUE EN LA LISTA, ASI SI HAY MAS AÑADIDOS NO PETA
		
		assertEquals("11111111A Arturo 1 Mantenimiento 2400.0",list.get(0).toString());
		assertEquals("22222222B Manuel 4 Recepcion 1500.0",list.get(1).toString());
		
	}

}
