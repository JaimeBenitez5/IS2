package negocio;

public abstract class DTOtSuscripcion {
	protected int _idSuscripcion;
	protected String _nombre;
	protected int _duracion;
	
	public int getIdSuscripcion() {
		return _idSuscripcion;
	}
	
	public String get_nombre() {
		return _nombre;
	}
	
	public int get_duracion() {
		return _duracion;
	}
	
	public void setIdSuscripcion(int idSuscripcion) {
		_idSuscripcion = idSuscripcion;
	}
	
	public void set_nombre(String nombre) {
		_nombre = nombre;
	}
	
	public void set_duracion(int duracion) {
		_duracion = duracion;
	}
}