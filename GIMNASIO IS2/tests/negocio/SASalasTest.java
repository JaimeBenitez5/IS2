package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SASalasTest {
	
	static int idSala1;
	static int idSala2;
	static int idSala3;
	static SASalas salas;
	static SAEmpleados empleados;
	
	@BeforeAll
	static void inicia() {
		salas = new SASalasImp();
		empleados = new SAEmpleadosImp();
		empleados.altaEmpleado(new DTOtEmpleado("77777777V", "Test3", new DTOtRol("Mantenimiento")));
		empleados.altaEmpleado(new DTOtEmpleado("66666666Z", "Test4", new DTOtRol("Mantenimiento")));
	}
	
	@AfterAll
	static void limpia() {
		salas.borrarSala(idSala1);
		salas.borrarSala(idSala2);
		salas.borrarSala(idSala3);
		empleados.borrarEmpleado("77777777V");
		empleados.borrarEmpleado("66666666Z");
	}

	@Test
	void test() {		
		
		String[] emplea1 = {"66666666Z", "77777777V"};
		
		idSala1 = salas.altaSala(new DTOtSala(33, emplea1));
		idSala2 = salas.altaSala(new DTOtSala(15, emplea1));	
		idSala3 = salas.altaSala(new DTOtSala(10, emplea1));		
		
		assertEquals( idSala3 + " 10 Empleados: 66666666Z 77777777V ", salas.leerSala(idSala3).toString());
		
		salas.actualizarSala(new DTOtSala(idSala3,5,emplea1));
		
		assertEquals(idSala3 + " 5 Empleados: 66666666Z 77777777V ",salas.leerSala(idSala3).toString());
		
		String[] emplea2 = {"66666666Z"};
		
		SASalasImp.getDAOSalas().actualizarMantenedor(new DTOtSala(idSala3, 5, emplea2));
		
		assertEquals(idSala3 + " 5 Empleados: 66666666Z ",salas.leerSala(idSala3).toString()); 
		
		salas.borrarSala(idSala1);
		
		List<DTOtSala> list = salas.leerTodasSalas();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtSala e : list) {
			if (e.toString().equals(idSala2 + " 15 Empleados: 66666666Z 77777777V ")) a = true;
			else if(e.toString().equals(idSala3 + " 5 Empleados: 66666666Z ")) b = true;
		}
		
		assertEquals(a,true);
		assertEquals(b,true);
	
	}

}
