package integracion;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import negocio.DTOtCliente;

@objid ("5db6cbcc-d2d1-43b5-97ab-d524a2cfb365")
public class DAOClienteImp implements DAOCliente {
    @objid ("d33cffc0-4796-4963-86bf-890bea10be49")
    public int createCliente(DTOtCliente cliente) {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("069139f7-3a72-4d97-b631-fc04b812eeca")
    public DTOtCliente readCliente() {
        // TODO Auto-generated return
        return null;
    }

    @objid ("720d1674-b5db-4c58-b692-9948ff65f58d")
    public int updateCliente(final DTOtCliente cliente) {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("10927b9e-db74-426b-8da0-8b4adf615314")
    public int deleteCliente(final String dni) {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("b2c3cc0f-18df-4728-9309-703997655f53")
    public List<DTOtCliente> readAllClientes() {
        
        return null;
    }

}
