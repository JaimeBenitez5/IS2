package negocio;

import java.sql.Date;

public class DTOtBasica extends DTOtSuscripcion {
	private int _idActividad;
	private Date _fecha;
	private int _idSala;
	
	public DTOtBasica(final int idActividad, final Date fecha, final int idSala) {
		_idSuscripcion = 1;
		_nombre = "BASICA";
		_duracion = 30;
		_idActividad = idActividad;
		_fecha = fecha;
		_idSala = idSala;
	}

	public int getidActividad() {
		return _idActividad;
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

	
	public void setIdActividad(int idActividad) {
		_idActividad = idActividad;
	}

	public void setIdSala(int idSala) {
		_idSala = idSala;
	}

}
