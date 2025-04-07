package negocio;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d7421738-99f0-4e3f-9a1e-85219bef586b")
public class tSala {
    @objid ("aa00d3af-7fd4-476c-9c88-dd9622d403fd")
    private int _id;

    @objid ("f2b8e125-7c01-43f7-9580-3cb5c97f9135")
    private int _aforo;

    @objid ("74c41cfe-20c9-4d8e-8f75-ec3f656b36a7")
    public tSala(final int id, final int aforo) {
    	_id = id;
    	_aforo = aforo;
    }
    
    public tSala( final int aforo) {
    	_id = 0;
    	_aforo = aforo;
    }
    
    @objid ("7978c70e-d8be-43b0-8ddb-478aea7528d5")
    public int getId() {
    	return _id;
    }

    @objid ("002160f9-8aa6-48c9-9065-40fba5788379")
    public int getAforo() {
        return _aforo;
    }

    @objid ("83fb29c9-383a-4cf1-8673-56485039a1ce")
    public void setId(final int id) {
    	_id = id;
    }

    @objid ("b675af17-8097-45d9-b886-40aca684f378")
    public void setAforo(final int aforo) {
    	_aforo = aforo;
    }

    @objid ("59aadfe3-e054-4b90-90d5-1dcd4a89bdb4")
    public String toString() {
        return _id + " " + _aforo;
    }

}
