package negocio;

public class DTOtEmpleado {
	private String _dni;
	private String _nombre;
    private DTOtRol _rolEmpleado;
    
    public DTOtEmpleado(final String dni, final String nombre, final DTOtRol rol) {
    	_dni = dni;
    	_nombre = nombre;
    	_rolEmpleado = rol;
    }
    
    public String getDni() {
        return _dni;
    }

    public String getNombre() {
        return _nombre;
    }
    
    public DTOtRol getRolEmpleado() {
        return _rolEmpleado;
    }
    
    public void setDni(final String dni) {
    	_dni = dni;
    }

    public void setNombre(final String nombre) {
    	_nombre = nombre;
    }
    
    public void setRolEmpleado(final DTOtRol rolEmpleado) {
        _rolEmpleado = rolEmpleado;
    }
    
    
    public String toString() {
        return  _dni + " " + _nombre + _rolEmpleado.toString();
    }
}
