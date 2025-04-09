package integracion;

import java.util.List;
import negocio.tCliente;

public interface DAOClientes {
	
    int altaCliente(tCliente cliente);

    tCliente leerCliente(final int id);

    int actualizarCliente(final tCliente cliente);

    int borrarCliente(final int id);

    List<tCliente> leerTodosClientes();
    
}

