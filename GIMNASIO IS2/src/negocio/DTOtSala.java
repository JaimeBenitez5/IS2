package negocio;

public class DTOtSala {
    private int _id;
    private int _aforo;
    private String[] _dniEmpleados;
    
    public DTOtSala(final int id, final int aforo, final String[] dniEmpleados) {
    	_id = id;
    	_aforo = aforo;
    	_dniEmpleados = dniEmpleados;
    }
    
    public DTOtSala(final int aforo, final String[] dniEmpleados) {
    	_id = 0;
    	_aforo = aforo;
    	_dniEmpleados = dniEmpleados;
    }
    
    public int getId() {
    	return _id;
    }

    public int getAforo() {
        return _aforo;
    }
    
    public String[] getDniEmpleados() {
    	return _dniEmpleados;
    }
    
    public String getDniEmpleado() {
    	return _dniEmpleados[0];
    }
    
    public void setId(final int id) {
    	_id = id;
    }

    public void setAforo(final int aforo) {
    	_aforo = aforo;
    }
    
    public void setDniEmpleados(final String[] dniEmpleados) {
    	_dniEmpleados = dniEmpleados;
    }
    
    public String toString() {
        return _id + " " + _aforo;
    }
}
