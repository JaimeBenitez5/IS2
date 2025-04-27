package negocio;

public class DTOtSuscripcion {
	private int _id;
	private DTOtTipoSuscripcion _tipo;
	private String _nombre;
	
	
	public DTOtSuscripcion(final int id,final String nombre) {
    	_id = id;
    	_nombre = nombre;
    }
    
    public DTOtSuscripcion(final DTOtTipoSuscripcion tipo, final String nombre) {
    	_id = 0;
    	_nombre= nombre;
    	_tipo=tipo;
    }
    
    public int getId() {
    	return _id;
    }

    public DTOtTipoSuscripcion getTipo() {
        return _tipo;
    }

    public String getNombre() {
        return _nombre;
    }
    
    public void setId(final int id) {
    	_id = id;
    }

    public String toString() {
        return _id + " " + _tipo + " "+ _nombre;
    }
}
