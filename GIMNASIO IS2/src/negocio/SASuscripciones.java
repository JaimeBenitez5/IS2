package negocio;

import java.util.List;

public interface SASuscripciones {
	
	int altaSuscripcion(final DTOtSuscripcion suscripcion);

    public DTOtSuscripcion leerSuscripcion(final int id);

    int actualizarSuscripcion(final DTOtSuscripcion suscripcion);

    int borrarSuscripcion(final int id);

    List<DTOtSuscripcion> leerTodasSuscripciones();

}
