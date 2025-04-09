package negocio;

public class tSala {
    private int _id;
    private int _aforo;
    public tSala(final int id, final int aforo) {
    	_id = id;
    	_aforo = aforo;
    }
    
    public tSala( final int aforo) {
    	_id = 0;
    	_aforo = aforo;
    }
    
    public int getId() {
    	return _id;
    }

    public int getAforo() {
        return _aforo;
    }

    public void setId(final int id) {
    	_id = id;
    }

    public void setAforo(final int aforo) {
    	_aforo = aforo;
    }

    public String toString() {
        return _id + " " + _aforo;
    }

}
