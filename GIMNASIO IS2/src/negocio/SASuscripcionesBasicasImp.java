package negocio;

import java.util.List;

import integracion.DAOSuscripciones;
import integracion.DAOSuscripcionesBasicasImp;

public class SASuscripcionesBasicasImp implements SASuscripciones {

    private static DAOSuscripciones suscripcionesDAO = null;

    public static DAOSuscripciones getDAOSuscripciones() {
        if (suscripcionesDAO == null) suscripcionesDAO = new DAOSuscripcionesBasicasImp();
        return suscripcionesDAO;
    }

    public int altaSuscripcion(final DTOtSuscripcion suscripcion) {
        DTOtBasica basica = (DTOtBasica) suscripcion;
        
        int numSuscripcion = getDAOSuscripciones().altaSuscripcion(basica);
        if (numSuscripcion != 0) {
        	basica.setIdSuscripcion(numSuscripcion);
            int resultado = getDAOSuscripciones().altaSuscripcionBasica(basica);
            if (resultado != 0) return numSuscripcion;
        }
        return 0;
    }

    public DTOtSuscripcion leerSuscripcion(final int id) {
        return getDAOSuscripciones().leerSuscripcion(id);
    }

    public int actualizarSuscripcion(final DTOtSuscripcion suscripcion) {
    	DTOtBasica basica = (DTOtBasica) suscripcion;

        int resultadoPadre = getDAOSuscripciones().actualizarSuscripcion(basica);
        int resultadoBasica = getDAOSuscripciones().actualizarSuscripcionBasica(basica);

        if (resultadoPadre != 0 && resultadoBasica != 0) return 1;
        return 0;
    }

    public int borrarSuscripcion(final int id) {
    	DTOtBasica basica = (DTOtBasica) getDAOSuscripciones().leerSuscripcion(id);
    	int exito = 0;
    	if(basica != null) exito = getDAOSuscripciones().borrarSuscripcion(id);
        return exito;
    }

    public List<DTOtSuscripcion> leerTodasSuscripciones() {
        return getDAOSuscripciones().leerTodasSuscripciones();
    }
}
