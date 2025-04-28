package negocio;

import java.util.ArrayList;

public class DTOtCatalogo {
	private int _id;
	private int _numActividades;
    private ArrayList<DTOtActividad> _actividades;
    
    public DTOtCatalogo(final int id, final ArrayList<DTOtActividad> actividades,final int numActividades) {
    	_id = id;
    	_actividades = actividades;
    	_numActividades = numActividades;
    }
    
    public DTOtCatalogo(final int id, final int numActividades) {
    	_id = id;
    	_actividades = new ArrayList<DTOtActividad>();
    	_numActividades = numActividades;
    }
    
    public DTOtCatalogo(final int numActividades) {
    	_id = 0;
    	_actividades = new ArrayList<DTOtActividad>();
    	_numActividades = numActividades;
    }
    
    public int getId() {
    	return _id;
    }

    public int getNumActividades() {
        return _numActividades;
    }
    
    public ArrayList<DTOtActividad> getActividades(){
		return _actividades;
    }
    
    public void setId(final int id) {
    	_id = id;
    }

    public void setNumActividades(final int numActividades) {
    	_numActividades = numActividades;
    }

    public void setActividades(ArrayList<DTOtActividad> actividades) {
    	_actividades = actividades;
    }
    
    public String toString() {
        return _id + " " + _numActividades + _actividades.toString();
    }
}
