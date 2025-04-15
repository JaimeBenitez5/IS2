package negocio;

import java.util.List;
import integracion.DAOClientes;
import integracion.DAOClientesImp;

public class SAClienteImp implements SACliente {
	
	private static DAOClientes clientesDao = null;
	
	//USADO PATRON SINGLETON
	public static DAOClientes getDAOClientes(){
		if(clientesDao == null) clientesDao = new DAOClientesImp();
		return clientesDao;
	}
	
	public int altaCliente(final tCliente cliente) {
		return getDAOClientes().altaCliente(cliente); 
	}

	public tCliente leerCliente(final int id) {
		return getDAOClientes().leerCliente(id);
	}

	public int actualizarCliente(final tCliente cliente) {
		return getDAOClientes().actualizarCliente(cliente);
	}

	public int borrarCliente(final int id) {
		return getDAOClientes().borrarCliente(id);
	}
	
	public List<tCliente> leerTodosClientes() {
		return getDAOClientes().leerTodosClientes(); 
	}

}