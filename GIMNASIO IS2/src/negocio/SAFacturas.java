package negocio;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e3acffd2-7e12-4da1-94ca-5b94b2292967")
public interface SAFacturas {
    @objid ("82ac9e40-b335-44b3-bbaf-94025a6bd111")
    int altaFactura(final tFacturas factura);

    @objid ("c7de9db4-7d51-4531-8cff-cba48e90294c")
    tFacturas leerFactura();

    @objid ("f4b329dc-8b1a-41e8-a88e-0dc660930a09")
    int actualizarFactura(final tFacturas factura);

    @objid ("d0729746-4006-4206-8682-bb571ef437a7")
    int borrarFactura(final String id);

    @objid ("0d7ada41-39d9-42fe-a667-10099c7e4bc4")
    List<tFacturas> leerTodasFacturas();

}
