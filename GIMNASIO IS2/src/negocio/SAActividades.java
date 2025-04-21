package negocio;

import java.sql.Date;
import java.util.List;

public interface SAActividades {
	
	int altaActividad(final tActividad actividad);

	tActividad leerActividad(final String tipoActividad, final Date fecha, final int idSala);

    int actualizarActividad(final tActividad actividad);

    int borrarActividad(final String tipoActividad, final Date fecha, final int idSala);

    List<tActividad> leerTodasActividades();
}
