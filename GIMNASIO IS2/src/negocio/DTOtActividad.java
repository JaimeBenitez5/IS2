package negocio;

import java.sql.Date;

public class DTOtActividad {
	String _tipoActividad;
	Date _fecha;
	int _idSala;
	String _dniEmpleado;
	int _idCatalogo;

	public DTOtActividad(final String tipoActividad, final int idSala , final Date fecha, final String dniEmpleado, final int idCatalogo) {
		_tipoActividad = tipoActividad;
		_dniEmpleado = dniEmpleado;
		_idSala = idSala;
		_fecha = fecha;
		_idCatalogo = idCatalogo;
	}
	
	public DTOtActividad(final String tipoActividad, final int idSala, final Date fecha, final String dniEmpleado) {
		_tipoActividad = tipoActividad;
		_idSala = idSala;
		_fecha = fecha;
		_idCatalogo = 0;
		_dniEmpleado = dniEmpleado;
	}
	
	public DTOtActividad(final String tipoActividad , final int idSala ,final Date fecha) {
		_tipoActividad = tipoActividad;
		_idSala = idSala;
		_fecha = fecha;
		_idCatalogo = 0;
	}
	
	public int getIdSala() {
		return _idSala;
	}
	
	public String getTipoActividad() {
		return _tipoActividad;
	}
	
	public String getDniEmpleado() {
		return _dniEmpleado;
	}
	
	public Date getFecha() {
		return _fecha;
	}
	
	public int getIdCatalogo() {
		return _idCatalogo;
	}
	
	public void setIdSala(final int idSala) {
		_idSala = idSala;
	}
	
	public void setTipoActividad(final String tipoActividad) {
		_tipoActividad = tipoActividad;
	}

	public void setDniEmpleado(final String dniEmpleado) {
		_dniEmpleado = dniEmpleado;
	}
	
	public void setFecha(final Date fecha) {
		_fecha = fecha;
	}
	
	public void setIdCatalogo(final int idCatalogo) {
		_idCatalogo = idCatalogo;
	}
	
	public String toString() {
        return  _tipoActividad + " " + _idSala + " " + _dniEmpleado + " " + _fecha;
    }
}
