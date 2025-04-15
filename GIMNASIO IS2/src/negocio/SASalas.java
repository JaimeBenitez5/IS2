package negocio;

import java.util.List;

public interface SASalas {
	
    int altaSala(final tSala sala);

    public tSala leerSala(final int id);

    int actualizarSala(final tSala sala);

    int borrarSala(final int id);

    List<tSala> leerTodasSalas();

}
