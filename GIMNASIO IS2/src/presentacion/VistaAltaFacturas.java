package presentacion;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import negocio.tFacturas;

@objid ("34f5ccb5-78ff-41ba-ab2d-5e29d41b81b5")
public class VistaAltaFacturas {
    @objid ("c700f41b-3c33-44ea-a15f-806c7542c396")
    private int _importe;

    @objid ("7e12b001-637d-428a-ad62-c3b178847fbd")
    private String _fecha;

    @objid ("9fc4df95-e9bb-469c-9e9c-1aab093b3a29")
    public tFacturas tFactura;

    @objid ("580387d6-5e41-406e-8a7a-2de798de52c3")
    public VistaAltaFacturas(final String fecha, final String Importe) {
    }

}
