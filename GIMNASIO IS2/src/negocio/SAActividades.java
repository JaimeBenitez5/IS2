package negocio;

import java.util.List;

public interface SAActividades {
	int altaActividad(final tActividad actividad);

    tCliente leerActividad(final int id);

    int actualizarActividad(final tActividad actividad);

    int borrarActividad(final int id);

    List<tCatalogo> leerTodasActividades();
}
