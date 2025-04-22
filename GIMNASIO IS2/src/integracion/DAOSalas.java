package integracion;

import java.util.List;
import negocio.DTOtSala;

public interface DAOSalas {
	
    int altaSala(DTOtSala Sala);

    DTOtSala leerSala(final int id);

    int actualizarSala(final DTOtSala sala);

    int borrarSala(final int id);

    List<DTOtSala> leerTodasSalas();
}