package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SASalasTest {

	@Test
	void test() {
		SASalasImp salas = new SASalasImp(); 
		assertEquals(1,salas.altaSala(new DTOtSala(33,null)));
		assertEquals(2,salas.altaSala(new DTOtSala(15,null)));
		
		String[] empleados = {"11111111A", "22222222B"};
		
		salas.altaSala(new DTOtSala(10,empleados));
		
		assertEquals("3 10 Empleados: 11111111A 22222222B ", salas.leerSala(3).toString());
		
		salas.actualizarSala(new DTOtSala(3,5,empleados));
		
		assertEquals("3 5 Empleados: 11111111A 22222222B ",salas.leerSala(3).toString());
		
		String[] emplea2 = {"22222222B", "33333333C"};
		
		SASalasImp.getDAOSalas().actualizarMantenedor(new DTOtSala(3, 5, emplea2));
		
		assertEquals("3 5 Empleados: 22222222B 33333333C ",salas.leerSala(3).toString()); 
		
		salas.borrarSala(1);
		
		List<DTOtSala> list = salas.leerTodasSalas();
		
		assertEquals("2 15 Empleados: ", list.get(0).toString());
		assertEquals("3 5 Empleados: 22222222B 33333333C ", list.get(1).toString());
	
	}

}
