package integracion;

import java.sql.Date;
import java.util.List;

import negocio.tActividad;

public interface DAOActividades {
	
	int altaActividad(tActividad actividad);

	tActividad leerActividad(final String tipoActividad, final Date fecha, final int idSala);

	int actualizarActividad(final tActividad actividad);

	int borrarActividad(final String tipoActividad, final Date fecha, final int idSala);

	List<tActividad> leerTodasActividades();
}