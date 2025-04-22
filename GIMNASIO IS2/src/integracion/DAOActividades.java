package integracion;

import java.sql.Date;
import java.util.List;

import negocio.DTOtActividad;

public interface DAOActividades {
	
	int altaActividad(DTOtActividad actividad);

	DTOtActividad leerActividad(final String tipoActividad, final Date fecha, final int idSala);

	int actualizarActividad(final DTOtActividad actividad);
	
	int borrarActividadesSala(int idSala);

	int borrarActividad(final String tipoActividad, final Date fecha, final int idSala);

	List<DTOtActividad> leerTodasActividades();
}