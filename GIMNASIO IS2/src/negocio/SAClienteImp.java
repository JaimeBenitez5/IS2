package negocio;

import java.util.List;
import integracion.DAOClientes;
import integracion.DAOClientesImp;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d2157bb0-ce0e-463c-a53f-5149b3c80275")
public class SAClienteImp implements SACliente {
	//SEGURAMENTE NO SE CREA UN DAO CADA VEZ PERO DE MOMENTO LO DEJAMOS
	
	// Orquesta la lógica de negocio
	// Valida datos antes de interactuar con la base de datos
	// Llama a los DAOs para acceder a la base de datos
	// Facilita la escalabilidad y mantenimiento
	
	private static DAOClientes clienteDao = new DAOClientesImp();

	@objid ("ce4675dc-94ff-48e6-8c95-167d69434968")
	public int altaCliente(final tCliente cliente) {
		return clienteDao.createCliente(cliente); 
	}

	@objid ("aa2c3fc3-0c75-4838-98c9-2291294245e5")
	public tCliente leerCliente(final int id) {
		return clienteDao.readCliente(id);
	}

	@objid ("8b08be3c-aaa6-4869-83d5-46e266a9b1a8")
	public int actualizarCliente(final tCliente cliente) {
		return clienteDao.updateCliente(cliente);
	}

	@objid ("ba15c147-35ff-47e1-9f3a-45991d5bf7d7")
	public int borrarCliente(final int id) {
		return clienteDao.deleteCliente(id);
	}

	@objid ("71ced6f7-0fb3-4f29-a8d3-7a425d2444ed")
	public List<tCliente> leerTodosClientes() {
		return clienteDao.readAllClientes(); 
	}

}
