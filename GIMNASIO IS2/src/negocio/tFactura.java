package negocio;

public class tFactura {
    private int _id;
    private String _fecha;
    private double _importeTotal;

    public tFactura(final int id, final String fecha, final double importeTotal) {
        _id = id;
        _fecha = fecha;
        _importeTotal = importeTotal;
    }

    public int getId() {
        return _id;
    }

    public String getFecha() {
        return _fecha;
    }

    public double getImporte() {
        return _importeTotal;
    }

    public void setId(final int id) {
    	_id = id;
    }

    public void setFecha(final String fecha) {
    	_fecha = fecha;
    }

    public void setImporte(final int importe) {
    	_importeTotal = importe;
    }

    public String toString() {
        return _id + " " + _fecha + " " + _importeTotal;
    }
}
