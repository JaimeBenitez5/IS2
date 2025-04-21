package negocio;

import java.sql.Date;

public class tActividad {
	String _tipoActividad;
	Date _fecha;
	int _idSala;
	int _idEmpleado;

	public tActividad(final String tipoActividad, final int idEmpleado,  final int idSala ,final Date fecha) {
		_tipoActividad = tipoActividad;
		_idEmpleado = idEmpleado;
		_idSala = idSala;
		_fecha = fecha;
	}
	
	public tActividad(final String tipoActividad , final int idSala ,final Date fecha) {
		_tipoActividad = tipoActividad;
		_idSala = idSala;
		_fecha = fecha;
	}

	public int getIdSala() {
		return _idSala;
	}
	
	public String getTipoActividad() {
		return _tipoActividad;
	}
	
	public int getIdEmpleado() {
		return _idEmpleado;
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

	public void setIdEmpleado(int idEmpleado) {
		_idEmpleado = idEmpleado;
	}
	
	public void setFecha(Date fecha) {
		_fecha = fecha;
	}
	
	public String toString() {
        return  _tipoActividad + " " + _idSala + " " + _idEmpleado + " " + _fecha;
    }
}
