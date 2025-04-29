package negocio;

import java.sql.Date;
import java.util.List;

public interface SAActividades {
	
	int altaActividad(final DTOtActividad actividad);

	DTOtActividad leerActividad(final String tipoActividad, final Date fecha, final int idSala);

    int actualizarActividad(final DTOtActividad actividad);
    
    int borrarActividad(final String tipoActividad, final Date fecha, final int idSala);

    List<DTOtActividad> leerTodasActividades();
}
