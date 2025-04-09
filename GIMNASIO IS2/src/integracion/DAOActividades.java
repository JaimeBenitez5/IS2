package integracion;

import java.util.List;

import negocio.tActividad;

public interface DAOActividades {
	
	int altaActividad(tActividad actividad);

	tActividad leerActividad(final int id);

	int actualizarActividad(final tActividad actividad);

	int borrarActividad(final int id);

	List<tActividad> leerTodasActividades();
}
