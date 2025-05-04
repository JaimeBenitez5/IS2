package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


class SAClientesTest {

	@Test
	void testClientes() {
		SAClientes clientes = new SAClientesImp();
		if(clientes.leerCliente("11111111A") == null) {
			assertEquals(1, clientes.altaCliente(new DTOtCliente("11111111A", "Agapito", "Casa de Agapito", true)));
		}
		else clientes.altaCliente(new DTOtCliente("11111111A", "Agapito", "Casa de Agapito", true));
		
		if (clientes.leerCliente("22222222B") == null) {
			assertEquals(1, clientes.altaCliente(new DTOtCliente("22222222B", "Josefa", "Casa de Josefa", true)));
		}
		else clientes.altaCliente(new DTOtCliente("22222222B", "Josefa", "Casa de Josefa", true));
		
		assertEquals(1,clientes.borrarCliente("11111111A"));
		assertEquals(0,clientes.borrarCliente("11111111A"));
		DTOtCliente test = clientes.leerCliente("11111111A");
		assertNull(clientes.leerCliente("88888888K"));
		assertEquals(test.getActivo(), false);
		clientes.actualizarCliente(new DTOtCliente("22222222B", "Carlitos", "Casa de Carlitos", false));
		assertEquals("22222222B Carlitos Casa de Carlitos false", clientes.leerCliente("22222222B").toString());
		clientes.altaCliente(new DTOtCliente("11111111A", "Agapito", "Casa de Agapito", true));
		assertEquals(0, clientes.altaCliente(new DTOtCliente("11111111A", "Agapito", "Casa de Agapito", true)));
		
		List<DTOtCliente> list = clientes.leerTodosClientes();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtCliente e : list) {
			if (e.toString().equals("11111111A Agapito Casa de Agapito true")) a = true;
			else if(e.toString().equals("22222222B Carlitos Casa de Carlitos false")) b = true;
		}
		
		assertTrue(a);
		assertTrue(b);
		
	}
}