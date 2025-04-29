package integracion;

import java.util.List;

import negocio.DTOtBasica;
import negocio.DTOtPremium;
import negocio.DTOtSuscripcion;


public interface DAOSuscripciones {
	
	int altaSuscripcion(DTOtSuscripcion suscripcion);
	int altaSuscripcionBasica(DTOtBasica basica);
	int altaSuscripcionPremium(DTOtPremium premium);
	
    DTOtSuscripcion leerSuscripcion(final int id);

    int actualizarSuscripcion(final DTOtSuscripcion suscripcion);
    int actualizarSuscripcionBasica(DTOtBasica basica);
    int actualizarSuscripcionPremium(DTOtPremium premium);
    
    int borrarSuscripcion(final int id);

    List<DTOtSuscripcion> leerTodasSuscripciones();
}
