package negocio;

import java.util.List;

public interface SACliente {
	
    int altaCliente(final tCliente cliente);

    tCliente leerCliente(final int id);

    int actualizarCliente(final tCliente cliente);

    int borrarCliente(final int id);

    List<tCliente> leerTodosClientes();

}
