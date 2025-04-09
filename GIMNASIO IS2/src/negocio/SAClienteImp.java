package negocio;

import java.util.List;
import integracion.DAOClientes;
import integracion.DAOClientesImp;

public class SAClienteImp implements SACliente {
	//SEGURAMENTE NO SE CREA UN DAO CADA VEZ PERO DE MOMENTO LO DEJAMOS
	
	// Orquesta la lógica de negocio
	// Valida datos antes de interactuar con la base de datos
	// Llama a los DAOs para acceder a la base de datos
	// Facilita la escalabilidad y mantenimiento
	
	private static DAOClientes clienteDao = new DAOClientesImp();//usar singleton

	public int altaCliente(final tCliente cliente) {
		return clienteDao.createCliente(cliente); 
	}

	public tCliente leerCliente(final int id) {
		return clienteDao.readCliente(id);
	}

	public int actualizarCliente(final tCliente cliente) {
		return clienteDao.updateCliente(cliente);
	}

	public int borrarCliente(final int id) {
		return clienteDao.deleteCliente(id);
	}
	
	public List<tCliente> leerTodosClientes() {
		return clienteDao.readAllClientes(); 
	}

}
