package negocio;

import java.sql.Date;

public class tActividad {
	int _id;
	String _tipoActividad;
	Date _fecha;
	int _idSala;
	String _dniEmpleado;

	public tActividad(final int id, final String tipoActividad, final String dniEmpleado,  final int idSala ,final Date fecha) {
		_id = id;
		_tipoActividad = tipoActividad;
		_dniEmpleado = dniEmpleado;
		_idSala = idSala;
		_fecha = fecha;
	}

	public tActividad( final String tipoActividad, final String dniEmpleado,  final Date fecha) {
		_id = 0;
		_tipoActividad = tipoActividad;
		_dniEmpleado = dniEmpleado;
		_fecha = fecha;
	}

	public String get_tipoActividad() {
		return _tipoActividad;
	}

	public void set_tipoActividad(String tipoActividad) {
		_tipoActividad = tipoActividad;
	}

	public Date get_fecha() {
		return _fecha;
	}
	
	public int getIdSala() {
		return _idSala;
	}
	public void set_fecha(Date fecha) {
		_fecha = fecha;
	}

	public int get_id() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}
	
	public void setIdSala(int idSala) {
		_idSala = idSala;
	}

	public String get_dniEmpleado() {
		return _dniEmpleado;
	}

	public void set_dniEmpleado(String dniEmpleado) {
		_dniEmpleado = dniEmpleado;
	}


}
