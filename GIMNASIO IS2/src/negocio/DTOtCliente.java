package negocio;

public class DTOtCliente {
    private String _dni;
    private String _nombre;
    private boolean _activo;    
    private String _dir;

    public DTOtCliente(final String dni, final String nombre, final String dir, final boolean activo) {
    	_dni = dni;
    	_nombre = nombre;
    	_activo = activo;
    	_dir = dir;
    }
    
    public String getDni() {
        return _dni;
    }

    public String getNombre() {
        return _nombre;
    }
    
    public String getDir() {
        return _dir;
    }
    
    public boolean getActivo() {
        return _activo;
    }

    public void setDni(final String dni) {
    	_dni = dni;
    }

    public void setNombre(final String nombre) {
    	_nombre = nombre;
    }

    public void setActivo(final boolean activo) {
    	_activo = activo;
    }

    public String toString() {
        return _dni + " " + _nombre + " " + _dir + " " + _activo;
    }
}
