package negocio;

public class DTOtEmpleado {
	private String _dni;
	private String _nombre;
    
    public DTOtEmpleado(final String dni, final String nombre) {
    	_dni = dni;
    	_nombre = nombre;
    }
    
    public String getDni() {
        return _dni;
    }

    public String getNombre() {
        return _nombre;
    }
    
    public void setDni(final String dni) {
    	_dni = dni;
    }

    public void setNombre(final String nombre) {
    	_nombre = nombre;
    }
    
    public String toString() {
        return  _dni + " " + _nombre;
    }
}
