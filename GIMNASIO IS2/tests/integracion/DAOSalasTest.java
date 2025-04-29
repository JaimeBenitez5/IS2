package integracion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import negocio.DTOtSala;

class DAOSalasTest {

	@Test
	void testSalas() {
		DAOSalas dao = new DAOSalasImp();
		assertEquals(1,dao.altaSala(new DTOtSala(33,null)));
		assertEquals(2,dao.altaSala(new DTOtSala(15,null)));
		
		String[] empleados = {"11111111A", "22222222B"};
		
		dao.altaSala(new DTOtSala(10,empleados));
		
		assertEquals("3 10 Empleados: 11111111A 22222222B ", dao.leerSala(3).toString());
		
		dao.actualizarSala(new DTOtSala(3,5,empleados));
		
		assertEquals("3 5 Empleados: 11111111A 22222222B ",dao.leerSala(3).toString());
		
		String[] emplea2 = {"22222222B", "33333333C"};
		
		dao.actualizarMantenedor(new DTOtSala(3, 5, emplea2));
		
		assertEquals("3 5 Empleados: 22222222B 33333333C ",dao.leerSala(3).toString()); 
		
		dao.borrarSala(1);
		
		List<DTOtSala> list = dao.leerTodasSalas();
		
		assertEquals("2 15 Empleados: ", list.get(0).toString());
		assertEquals("3 5 Empleados: 22222222B 33333333C ", list.get(1).toString());
	}

}
