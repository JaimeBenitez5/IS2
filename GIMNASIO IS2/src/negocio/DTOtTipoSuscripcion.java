package negocio;

public class DTOtTipoSuscripcion {
	private int _idTipoSuscripcion;
	private String _nombreSus;
	private int _duracion;
	private double _precio;
	
	public DTOtTipoSuscripcion(int ts){
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
