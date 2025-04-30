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

	public int altaCliente(final DTOtCliente cliente) {
		DTOtCliente c = leerCliente(cliente.getDni());
		int exito = 0;
		if(c == null) exito = getDAOClientes().altaCliente(cliente); 
		else if (!c.getActivo()) {
			cliente.setActivo(true);
			exito = getDAOClientes().actualizarCliente(cliente);
		}
		return exito;
	}

	public DTOtCliente leerCliente(final String dni) {
		return getDAOClientes().leerCliente(dni);
	}
	
	public int actualizarCliente(final DTOtCliente cliente) {
		return getDAOClientes().actualizarCliente(cliente);
	}

	public int borrarCliente(final String dni) {
		DTOtCliente c = leerCliente(dni);
		int exito = 0;
		if(c != null && c.getActivo()) exito = getDAOClientes().borrarCliente(dni);
		return exito;
	}

	public List<DTOtCliente> leerTodosClientes() {
		return getDAOClientes().leerTodosClientes(); 
	}
}