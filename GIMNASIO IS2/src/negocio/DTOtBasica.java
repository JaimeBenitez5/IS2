package negocio;

import java.sql.Date;

public class DTOtBasica extends DTOtSuscripcion {
	private String _tipoActividad;
	private Date _fecha;
	private int _idSala;
	
	public DTOtBasica(final String nombre, final String tipoActividad, final Date fecha, final int idSala) {
		_idSuscripcion = 0;
		_tipoSus = 1;
		_duracion = 30;
		_nombre = nombre;
		_tipoActividad = tipoActividad;
		_fecha = fecha;
		_idSala = idSala;
	}

	public String getTipoActividad() {
		return _tipoActividad;
	}

	public Date getFecha() {
		return _fecha;
	}
	
	public int getIdSala() {
		return _idSala;
	}
	
	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public void setTipoActividad(String tipoActividad) {
		_tipoActividad = tipoActividad;
	}

	public void setIdSala(int idSala) {
		_idSala = idSala;
	}
}