package negocio;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a0558afe-02f6-43b3-9589-5d76b1c59eaa")
public class SAFacturaImp implements SAFactura {
    @objid ("8a537c2a-74b9-4326-ac0b-70ca35691a24")
    public int altaFactura(final tFactura factura) {
        return 0;
    }

    @objid ("80c2a22a-1355-41cf-9922-cdcae0b512a1")
    public tFactura leerFactura() {
        return null;
    }

    @objid ("3f7a883c-8c6b-4e10-8b6d-5c1db772d2ea")
    public int actualizarFactura(final tFactura factura) {
        return 0;
    }

    @objid ("318ce551-bef0-4261-b1e5-a874461b0756")
    public int borrarFactura(final String id) {
        return 0;
    }

    @objid ("3400b85b-d6e9-4ef5-a22a-acd0ce734746")
    public List<tFactura> leerTodasFacturas() {
        return null;
    }

}
