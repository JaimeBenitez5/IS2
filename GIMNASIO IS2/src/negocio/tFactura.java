package negocio;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("403c9150-7be7-4ab1-9b69-06f7b6ed98c9")
public class tFactura {
    @objid ("480816c9-c698-44b2-b47d-1236f893e802")
    private int _id;

    @objid ("139c7700-be44-4f59-b332-6a3b048681f1")
    private String _fecha;

    @objid ("56c94a93-e571-4ae3-82ad-858dc04a4e73")
    private double _importeTotal;

    @objid ("9ee00610-835f-4659-bce2-eaef8f928bde")
    public tFactura(final int id, final String fecha, final double importeTotal) {
        _id = id;
        _fecha = fecha;
        _importeTotal = importeTotal;
    }

    @objid ("8d858711-5eb4-441a-8b1c-fa7dd885f52e")
    public int getId() {
        return _id;
    }

    @objid ("818d2fac-98d6-434d-9e2c-6c3113de9fa4")
    public String getFecha() {
        return _fecha;
    }

    @objid ("94c06b8c-48d3-4ebd-a092-cb952d469e7c")
    public double getImporte() {
        return _importeTotal;
    }

    @objid ("4e7997c5-bb15-4aa1-8186-0df5c899b5e0")
    public void setId(final int id) {
    	_id = id;
    }

    @objid ("702fc6f7-7c14-4070-a6e7-0f66c4bbd1c0")
    public void setFecha(final String fecha) {
    	_fecha = fecha;
    }

    @objid ("bf0f2f16-9810-46a9-aa0e-60382800504a")
    public void setImporte(final int importe) {
    	_importeTotal = importe;
    }

    @objid ("fd3e13f7-a42e-40c0-95e4-4563f324eafe")
    public String toString() {
        return _id + " " + _fecha + " " + _importeTotal;
    }

}
