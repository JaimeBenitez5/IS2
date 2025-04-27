package integracion;

import java.util.List;
import negocio.DTOtSala;

public interface DAOSalas {
	
    int altaSala(final DTOtSala Sala);
    int altaMantenedor(final DTOtSala sala);

    DTOtSala leerSala(final int id);

    int actualizarSala(final DTOtSala sala);
    int actualizarMantenedor(final DTOtSala sala);

    int borrarSala(final int id);

    List<DTOtSala> leerTodasSalas();
}