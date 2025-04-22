package integracion;

import java.util.List;
import negocio.DTOtCliente;

public interface DAOClientes {
	
    int altaCliente(DTOtCliente cliente);

    DTOtCliente leerCliente(final String dni);

    int actualizarCliente(final DTOtCliente cliente);

    int borrarCliente(final String dni);

    List<DTOtCliente> leerTodosClientes();
    
}