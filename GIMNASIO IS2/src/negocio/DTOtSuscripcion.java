package negocio;

public class DTOtSuscripcion {
	private int _idSuscripcion;
	private DTOtTipoSuscripcion _tipoSuscripcion;
	
	public DTOtSuscripcion(final int id, final String nombre) {
		_idSuscripcion = id;
    	_nombre = nombre;
    }
    
    public DTOtSuscripcion(final DTOtTipoSuscripcion tipo, final String nombre) {
    	_idSuscripcion = 0;
    	_nombre = nombre;
    	_tipoSuscripcion = tipo;
    }
    
    public int getId() {
    	return _idSuscripcion;
    }

    public DTOtTipoSuscripcion getTipo() {
        return _tipo;
    }

    public String getNombre() {
        return _nombre;
    }
    
    public void setId(final int id) {
    	_idSuscripcion = id;
    }

    public String toString() {
        return _idSuscripcion + " " + _tipo + " "+ _nombre;
    }
}
