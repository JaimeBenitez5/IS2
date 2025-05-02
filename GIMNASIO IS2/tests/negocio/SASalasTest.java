package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SASalasTest {

	@Test
	void test() {
		SASalasImp salas = new SASalasImp(); 
		
		String[] empleados = {"11111111A", "22222222B"};
		
		int idSala1 = salas.altaSala(new DTOtSala(33, empleados));
		int idSala2 = salas.altaSala(new DTOtSala(15, empleados));	
		int idSala3 = salas.altaSala(new DTOtSala(10, empleados));
		
		assertEquals( idSala3 + "10 Empleados: 11111111A 22222222B ", salas.leerSala(idSala3).toString());
		
		salas.actualizarSala(new DTOtSala(3,5,empleados));
		
		assertEquals(idSala3 + "5 Empleados: 11111111A 22222222B ",salas.leerSala(idSala3).toString());
		
		String[] emplea2 = {"22222222B", "33333333C"};
		
		SASalasImp.getDAOSalas().actualizarMantenedor(new DTOtSala(3, 5, emplea2));
		
		assertEquals(idSala3 + "5 Empleados: 22222222B 33333333C ",salas.leerSala(idSala3).toString()); 
		
		salas.borrarSala(idSala1);
		
		List<DTOtSala> list = salas.leerTodasSalas();
		
		assertEquals(idSala2 + "15 Empleados: ", list.get(0).toString());
		assertEquals(idSala3 + "5 Empleados: 22222222B 33333333C ", list.get(1).toString());
	
	}

}
