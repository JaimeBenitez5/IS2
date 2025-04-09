package negocio;

import java.util.List;
import integracion.DAOClientes;
import integracion.DAOClientesImp;

public class SAClienteImp implements SACliente {
	
	private static DAOClientes clienteDao = new DAOClientesImp();//usar singleton

	public int altaCliente(final tCliente cliente) {
		return clienteDao.altaCliente(cliente); 
	}

	public tCliente leerCliente(final int id) {
		return clienteDao.leerCliente(id);
	}

	public int actualizarCliente(final tCliente cliente) {
		return clienteDao.actualizarCliente(cliente);
	}

	public int borrarCliente(final int id) {
		return clienteDao.borrarCliente(id);
	}
	
	public List<tCliente> leerTodosClientes() {
		return clienteDao.leerTodosClientes(); 
	}

}
