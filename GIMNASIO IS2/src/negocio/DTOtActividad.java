package negocio;

import java.sql.Date;

public class DTOtActividad {
	String _tipoActividad;
	Date _fecha;
	int _idSala;
	String _dniEmpleado;
	int _idCatalogo;

	public DTOtActividad(final String tipoActividad, final String dniEmpleado, final int idSala , final Date fecha, final int idCatalogo) {
		_tipoActividad = tipoActividad;
		_dniEmpleado = dniEmpleado;
		_idSala = idSala;
		_fecha = fecha;
		_idCatalogo = idCatalogo;
	}
	
	public DTOtActividad(final String tipoActividad , final int idSala ,final Date fecha, final int idCatalogo) {
		_tipoActividad = tipoActividad;
		_idSala = idSala;
		_fecha = fecha;
		_idCatalogo = idCatalogo;
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

	public void setIdSala(int idSala) {
		_idSala = idSala;
	}
	
	public void setTipoActividad(String tipoActividad) {
		_tipoActividad = tipoActividad;
	}

	public void setDniEmpleado(String dniEmpleado) {
		_dniEmpleado = dniEmpleado;
	}
	
	public void setFecha(Date fecha) {
		_fecha = fecha;
	}
	
	public String toString() {
        return  _tipoActividad + " " + _idSala + " " + _dniEmpleado + " " + _fecha;
    }
}
