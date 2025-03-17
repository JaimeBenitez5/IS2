package integracion;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import negocio.tFacturas;

@objid ("983a064f-d8eb-42b7-9b44-6a368f94d5b6")
public interface DAOFacturas {
    @objid ("2985688f-5c8b-4982-8414-34d32a9c9a4a")
    int createFactura(tFacturas Factura);

    @objid ("13674d5b-fafe-4506-96cc-61a453976789")
    tFacturas readFactura();

    @objid ("22adb0f8-47f8-4256-8a12-128ce03252e7")
    int updateFactura(final tFacturas factura);

    @objid ("af66c645-aaa5-44d3-b0ef-1b27ab1a9f40")
    int deleteFactura(final String idFactura);

    @objid ("1a8186bb-25c9-4222-b105-ae504f80d068")
    List<tFacturas> readAllFacturas();

}
