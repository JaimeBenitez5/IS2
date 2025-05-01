package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import negocio.DTOtCliente;
import negocio.SAClientes;
import negocio.SAClientesImp;

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
		
		clientes.borrarCliente("11111111A");
		DTOtCliente test = clientes.leerCliente("11111111A");
		assertEquals(test.getActivo(), false);
		clientes.actualizarCliente(new DTOtCliente("22222222B", "Carlitos", "Casa de Carlitos", false));
		assertEquals("22222222B Carlitos Casa de Carlitos false", clientes.leerCliente("22222222B").toString());
		clientes.actualizarCliente(new DTOtCliente("11111111A", "Agapito", "Casa de Agapito", true));
		
		List<DTOtCliente> list = clientes.leerTodosClientes();
		
		assertEquals("11111111A Agapito Casa de Agapito true", list.get(0).toString());
		assertEquals("22222222B Carlitos Casa de Carlitos false", list.get(1).toString());
		
	}
}