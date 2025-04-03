package presentacion.suscripciones;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import negocio.tFactura;

@objid ("e975df99-37a1-4afb-8d29-b09262385f75")
public class VistaAltaSuscripcion {
    @objid ("9e811310-cf3f-421a-b966-7e36625b72b0")
    private int _importe;

    @objid ("64e196b7-f74f-4313-ac7a-33dd812ef1e7")
    private String _fecha;

    @objid ("56f50867-e55d-4996-879d-cf03b3cba963")
    public tFactura tFactura;

    @objid ("4c2b3fe1-fba6-40c7-9a2d-11bee9628a51")
    public VistaAltaSuscripcion(final String fecha, final String Importe) {
 
    }

}
