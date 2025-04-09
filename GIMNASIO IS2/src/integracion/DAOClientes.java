package integracion;

import java.util.List;
import negocio.tCliente;

public interface DAOClientes {
	
    int createCliente(tCliente cliente);

    tCliente readCliente(final int id);

    int updateCliente(final tCliente cliente);

    int deleteCliente(final int id);

    List<tCliente> readAllClientes();
}

