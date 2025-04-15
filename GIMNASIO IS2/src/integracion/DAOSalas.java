package integracion;

import java.util.List;
import negocio.tSala;

public interface DAOSalas {
	
    int altaSala(tSala Sala);

    tSala leerSala(final int id);

    int actualizarSala(final tSala sala);

    int borrarSala(final int id);

    List<tSala> leerTodasSalas();

}