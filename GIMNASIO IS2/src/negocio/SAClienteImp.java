package negocio;

import java.util.List;
import integracion.DAOCliente;
import integracion.DAOClienteImp;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d2157bb0-ce0e-463c-a53f-5149b3c80275")
public class SAClienteImp implements SACliente {
    @objid ("ce4675dc-94ff-48e6-8c95-167d69434968")
    public int altaCliente(final DTOtCliente cliente) {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("aa2c3fc3-0c75-4838-98c9-2291294245e5")
    public DTOtCliente leerCliente() {
        // TODO Auto-generated return
        return null;
    }

    @objid ("8b08be3c-aaa6-4869-83d5-46e266a9b1a8")
    public int actualizarCliente(final DTOtCliente cliente) {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("ba15c147-35ff-47e1-9f3a-45991d5bf7d7")
    public int borrarCliente(final String dni) {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("71ced6f7-0fb3-4f29-a8d3-7a425d2444ed")
    public List<DTOtCliente> leerTodosClientes() {
    	DAOCliente clienteDao = new DAOClienteImp();
    	return clienteDao.readAllClientes(); 
    }

}
