package negocio;

import java.util.List;
import integracion.DAOClientes;
import integracion.DAOClientesImp;

public class SAClientesImp implements SAClientes {

	private static DAOClientes clientesDao = null;

	//USADO PATRON SINGLETON
	public static DAOClientes getDAOClientes(){
		if(clientesDao == null) clientesDao = new DAOClientesImp();
		return clientesDao;
	}

	public int altaCliente(final tCliente cliente) {
		tCliente c = leerCliente(cliente.getId());
		int exito = 0;
		if(c == null) exito = getDAOClientes().altaCliente(cliente); 
		else if (!c.getActivo()) {
			cliente.setActivo(true);
			exito = getDAOClientes().actualizarCliente(cliente);;
		}
		return exito;
	}

	public tCliente leerCliente(final int id) {
		return getDAOClientes().leerCliente(id);
	}
	
	public int actualizarCliente(final tCliente cliente) {
		return getDAOClientes().actualizarCliente(cliente);
	}

	public int borrarCliente(final int id) {
		tCliente c = leerCliente(id);
		int exito = 0;
		if(c != null && c.getActivo()) exito = getDAOClientes().borrarCliente(id);
		return exito;
	}

	public List<tCliente> leerTodosClientes() {
		return getDAOClientes().leerTodosClientes(); 
	}
}