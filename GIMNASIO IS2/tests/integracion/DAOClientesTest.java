package integracion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import negocio.DTOtCliente;

class DAOClientesTest {

	@Test
	void testClientes() {
		DAOClientes dao = new DAOClientesImp();
		assertEquals(1,dao.altaCliente(new DTOtCliente("11111111A", "Agapito", "Casa de Agapito", true)));
		assertEquals(2,dao.altaCliente(new DTOtCliente("22222222B", "Josefa", "Casa de Josefa", true)));
		dao.borrarCliente("11111111A");
		DTOtCliente test = dao.leerCliente("11111111A");
		assertEquals(test.getActivo(), false);
		dao.actualizarCliente(new DTOtCliente("22222222B", "Carlitos", "Casa de Carlitos", false));
		assertEquals("22222222B Carlitos Casa de Carlitos false", dao.leerCliente("22222222B").toString());
		dao.actualizarCliente(new DTOtCliente("11111111A", "Agapito", "Casa de Agapito", true));
		
		List<DTOtCliente> list = dao.leerTodosClientes();
		
		assertEquals("11111111A Agapito Casa de Agapito true", list.get(0).toString());
		assertEquals("22222222B Carlitos Casa de Carlitos false", list.get(1).toString());
	}

}
