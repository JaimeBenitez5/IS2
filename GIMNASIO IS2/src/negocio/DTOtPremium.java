package negocio;

public class DTOtPremium extends DTOtSuscripcion{
	private int _idCatalogo;	
	private String _dniEmpleado;
	
	public DTOtPremium(final int idCatalogo, final String dniEmpleado) {
		_idSuscripcion = 2;
		_nombre = "PREMIUM";
		_duracion = 90;
		_idCatalogo = idCatalogo;
		_dniEmpleado = dniEmpleado;
	}

	public int get_idCatalogo() {
		return _idCatalogo;
	}

	public void set_idCatalogo(int _idCatalogo) {
		this._idCatalogo = _idCatalogo;
	}

	public String get_dniEmpleado() {
		return _dniEmpleado;
	}

	public void set_dniEmpleado(String _dniEmpleado) {
		this._dniEmpleado = _dniEmpleado;
	}
}
