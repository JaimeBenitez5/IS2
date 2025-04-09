package integracion;

import java.util.List;

import negocio.tActividad;

public interface DAOActividades {
	
	int createActividad(tActividad actividad);

	tActividad readActividad(final int id);

	int updateActividad(final tActividad actividad);

	int deleteActividad(final int id);

	List<tActividad> readAllActividades();
}
