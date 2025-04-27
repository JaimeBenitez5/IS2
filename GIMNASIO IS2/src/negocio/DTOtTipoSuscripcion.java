package negocio;

public class DTOtTipoSuscripcion {
	
	private TipoSuscripcion _idTipoSuscripcion;
	private final int _duracion;
	private final double _precio;
	
	public DTOtTipoSuscripcion(TipoSuscripcion ts){
		_idTipoSuscripcion=ts;
		switch (ts) {
		case BASICA:
			_duracion=30;
			_precio=19.9;
			break;
		default:
			_duracion=60;
			_precio=29.9;
			break;
		}
	}
	
	public int getDuracion() {
		return _duracion;	
	
	}
	
	public double getPrecio() {
		return _precio;	
	}
}
