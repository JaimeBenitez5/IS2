package negocio;

import java.util.List;

public interface SASalas {
	
    int altaSala(final DTOtSala sala);

    public DTOtSala leerSala(final int id);

    int actualizarSala(final DTOtSala sala);

    int borrarSala(final int id);

    List<DTOtSala> leerTodasSalas();

}
