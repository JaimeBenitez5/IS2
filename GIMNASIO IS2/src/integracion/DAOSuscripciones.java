package integracion;

import java.util.List;

import negocio.DTOtBasica;
import negocio.DTOtPremium;
import negocio.DTOtSuscripcion;


public interface DAOSuscripciones {
	
	int altaSuscripcion(final DTOtSuscripcion suscripcion);
	int altaSuscripcionBasica(final DTOtBasica basica);
	int altaSuscripcionPremium(final DTOtPremium premium);
	
    DTOtSuscripcion leerSuscripcion(final int id);

    int actualizarSuscripcion(final DTOtSuscripcion suscripcion);
    int actualizarSuscripcionBasica(final DTOtBasica basica);
    int actualizarSuscripcionPremium(final DTOtPremium premium);
    
    int borrarSuscripcion(final int id);

    List<DTOtSuscripcion> leerTodasSuscripciones();
}
