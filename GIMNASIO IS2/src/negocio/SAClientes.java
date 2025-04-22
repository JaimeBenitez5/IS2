package negocio;

import java.util.List;

public interface SAClientes {
	
    int altaCliente(final DTOtCliente cliente);

    DTOtCliente leerCliente(final String dni);

    int actualizarCliente(final DTOtCliente cliente);

    int borrarCliente(final String dni);

    List<DTOtCliente> leerTodosClientes();

}
