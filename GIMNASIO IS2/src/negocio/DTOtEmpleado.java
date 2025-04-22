package negocio;

public class DTOtEmpleado {
	private int _id;
	private String _dni;
	private String _nombre;
	private double _sueldo;
	private int _rol;
    
    public DTOtEmpleado(final int id, final String dni, final String nombre, final double sueldo, final int rol) {
    	_id = id;
    	_dni = dni;
    	_nombre = nombre;
    	_sueldo = sueldo;
    	_rol = rol;
    }
    
    public DTOtEmpleado(final String dni, final String nombre, final double sueldo, final int rol) {
    	_id = 0;
    	_dni = dni;
    	_nombre = nombre;
    	_sueldo = sueldo;
    	_rol = rol;
    }

    public int getId() {
        return _id;
    }

    public String getDni() {
        return _dni;
    }

    public String getNombre() {
        return _nombre;
    }
    
    public double getSueldo() {
    	return _sueldo;
    }
    
    public int getRol() {
    	return _rol;
    }
    
    public void setId(final int id) {
    	_id = id;
    }

    public void setDni(final String dni) {
    	_dni = dni;
    }

    public void setNombre(final String nombre) {
    	_nombre = nombre;
    }
    
    public void setSueldo(final double sueldo) {
    	_sueldo = sueldo;
    }
    
    public void setRol(final int rol) {
    	_rol = rol;
    }
    
    public String toString() {
        return _id + " " + _dni+ " " + _nombre + " " + _sueldo + " " + _rol;
    }
}
