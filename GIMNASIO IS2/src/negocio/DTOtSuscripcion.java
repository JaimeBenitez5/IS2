package negocio;

public abstract class DTOtSuscripcion {
	protected int _idSuscripcion;
	protected int _tipoSus;
	protected String _nombre;
	protected int _duracion;
	protected double _precio;
	
	public int getIdSuscripcion() {
		return _idSuscripcion;
	}
	
	public int getTipoSus() {
		return _tipoSus;
	}
	
	public String getNombre() {
		return _nombre;
	}
	
	public int getDuracion() {
		return _duracion;
	}
	
	public double getPrecio() {
		return _precio;
	}
	
	public void setIdSuscripcion(final int idSuscripcion) {
		_idSuscripcion = idSuscripcion;
	}
	
	public void setTipoSus(final int tipoSus) {
		_tipoSus = tipoSus;
	}
	
	public void setNombre(final String nombre) {
		_nombre = nombre;
	}
	
	public void setDuracion(final int duracion) {
		_duracion = duracion;
	}
	
	public void setPrecio(final double precio) {
		_precio = precio;
	}
}