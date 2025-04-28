package negocio;

import java.util.List;

import integracion.DAOSuscripciones;
import integracion.DAOSuscripcionesPremiumImp;

public class SASuscripcionesPremiumImp implements SASuscripciones {

    private static DAOSuscripciones suscripcionesDAO = null;

	//USADO PATRON SINGLETON
	public static DAOSuscripciones getDAOSuscripciones(){
		if(suscripcionesDAO == null) suscripcionesDAO = new DAOSuscripcionesPremiumImp();
		return suscripcionesDAO;
	}

    public int altaSuscripcion(DTOtSuscripcion suscripcion) {
    	DTOtPremium premium = (DTOtPremium) suscripcion;
        int numSuscripcion = getDAOSuscripciones().altaSuscripcion(premium);
        if (numSuscripcion != 0) {
            int resultado = getDAOSuscripciones().altaSuscripcionPremium(premium);
            if (resultado != 0) return numSuscripcion;
        }
        return 0;
    }

    public DTOtSuscripcion leerSuscripcion(int id) {
        return getDAOSuscripciones().leerSuscripcion(id);
    }

    public int actualizarSuscripcion(DTOtSuscripcion suscripcion) {
    	DTOtPremium premium = (DTOtPremium) suscripcion;
    	int exito = 0;
        exito = getDAOSuscripciones().actualizarSuscripcion(premium);
        if(exito == 1) getDAOSuscripciones().actualizarSuscripcionPremium(premium);
        return exito;
    }
    public int borrarSuscripcion(int id) {
    	//si no lees para comprobara que existen, desde premium te deja borrar basicas y viceversa
    	DTOtPremium premium = (DTOtPremium) getDAOSuscripciones().leerSuscripcion(id);
    	int exito = 0;
    	if(premium != null) exito = getDAOSuscripciones().borrarSuscripcion(id);
        return exito;
    }
    
    public List<DTOtSuscripcion> leerTodasSuscripciones() {
        return getDAOSuscripciones().leerTodasSuscripciones();
    }
}
