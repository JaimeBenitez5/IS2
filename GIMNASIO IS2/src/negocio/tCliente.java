package negocio;

public class tCliente {
    private int _id;
    private String _dni;
    private String _nombre;
    private boolean _activo;    
    private String _dir;

    public tCliente(final int id, final String dni, final String nombre, final String dir, final boolean activo) {
    	_id = id;
    	_dni = dni;
    	_nombre = nombre;
    	_activo = activo;
    	_dir = dir;
    }
    
    public tCliente(final int id, final String dni, final String nombre, final String dir) {
    	_id = id;
    	_dni = dni;
    	_nombre = nombre;
    	_activo = true;
    	_dir = dir;
    }
    
    public tCliente(final String dni, final String nombre, final String dir) {
    	_id = 0;
    	_dni = dni;
    	_nombre = nombre;
    	_activo = true;
    	_dir = dir;
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
    
    public String getDir() {
        return _dir;
    }
    
    public boolean getActivo() {
        return _activo;
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

    public void setActivo(final boolean activo) {
    	_activo = activo;
    }

    public String toString() {
        return _id + " " + _dni+ " " + _nombre + " " + _dir + " " + _activo;
    }
}
