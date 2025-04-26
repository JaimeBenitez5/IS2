package integracion;

import java.util.List;

import negocio.DTOtSuscripcion;


public interface DAOSuscripciones {
	int altaSuscripcion(DTOtSuscripcion suscripcion);

    DTOtSuscripcion leerSuscripcion(final int id);

    int actualizarSuscripcion(final DTOtSuscripcion suscripcion);

    int borrarSuscripcion(final int id);

    List<DTOtSuscripcion> leerTodasSuscripciones();
}
