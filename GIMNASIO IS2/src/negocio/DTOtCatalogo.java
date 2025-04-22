package negocio;

public class DTOtCatalogo {
	private int _id;
	private int _numActividades;
    
    public DTOtCatalogo(final int id, final int numActividades) {
    	_id = id;
    	_numActividades = numActividades;
    }
    
    public DTOtCatalogo(final int numActividades) {
    	_id = 0;
    	_numActividades = numActividades;
    }
    
    public int getId() {
    	return _id;
    }

    public int getNumActividades() {
        return _numActividades;
    }

    public void setId(final int id) {
    	_id = id;
    }

    public void setNumActividades(final int numActividades) {
    	_numActividades = numActividades;
    }

    public String toString() {
        return _id + " " + _numActividades;
    }
}
