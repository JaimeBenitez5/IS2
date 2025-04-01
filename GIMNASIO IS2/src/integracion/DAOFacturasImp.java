package integracion;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import negocio.tFactura;

@objid ("5bf9ce28-9968-425b-9e68-f9008cfcecef")
public class DAOFacturasImp implements DAOFacturas {
    @objid ("76d2af0f-0cd9-4909-b199-1ce0dd1a53ad")
    public int createFactura(tFactura Factura) {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("9228d05e-bdc0-4445-9e05-09c4eef8fdc0")
    public tFactura readFactura() {
        // TODO Auto-generated return
        return null;
    }

    @objid ("dd2c0401-255e-46e3-b092-c65e45cab942")
    public int updateFactura(final tFactura factura) {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("ef1ea21a-dc61-4632-91b5-14ec0ba99b7d")
    public int deleteFactura(final String idFactura) {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("06420f7a-19a3-4d7d-b32f-b769cf72e7a6")
    public List<tFactura> readAllFacturas() {
        // TODO Auto-generated return
        return null;
    }

}
