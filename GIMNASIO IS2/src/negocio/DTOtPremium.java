package negocio;

public class DTOtPremium extends DTOtSuscripcion{
	private int _idCatalogo;	
	private String _dniEmpleado;
	
	public DTOtPremium(final String nombre, final int idCatalogo, final String dniEmpleado) {
		_idSuscripcion = 0;
		_tipoSus = 2;
		_duracion = 90;
		_nombre = nombre;
		_idCatalogo = idCatalogo;
		_dniEmpleado = dniEmpleado;
	}

	public int getIdCatalogo() {
		return _idCatalogo;
	}

	public String getDniEmpleado() {
		return _dniEmpleado;
	}
	
	public void setIdCatalogo(final int idCatalogo) {
		_idCatalogo = idCatalogo;
	}
	
	public void setDniEmpleado(String dniEmpleado) {
		_dniEmpleado = dniEmpleado;
	}
}
