package negocio;

public class DTOtSala {
    private int _id;
    private int _aforo;
    private String _dniEmpleado;
    
    public DTOtSala(final int id, final int aforo, final String dniEmpleado) {
    	_id = id;
    	_aforo = aforo;
    	_dniEmpleado = dniEmpleado;
    }
    
    public DTOtSala(final int aforo, final String dniEmpleado) {
    	_id = 0;
    	_aforo = aforo;
    	_dniEmpleado = dniEmpleado;
    }
    
    public int getId() {
    	return _id;
    }

    public int getAforo() {
        return _aforo;
    }
    
    public String getDniEmpleado() {
    	return _dniEmpleado;
    }
    
    public void setId(final int id) {
    	_id = id;
    }

    public void setAforo(final int aforo) {
    	_aforo = aforo;
    }
    
    public void setDniEmpleado(final String dniEmpleado) {
    	_dniEmpleado = dniEmpleado;
    }

    public String toString() {
        return _id + " " + _aforo;
    }
}
