package negocio;

import java.sql.Date;
import java.util.List;
import integracion.DAOActividades;
import integracion.DAOActividadesImp;

public class SAActividadesImp implements SAActividades {
	
	private static DAOActividades actividadesDao = null;
	
	//USADO PATRON SINGLETON
	private static DAOActividades getDAOActividad(){
		if(actividadesDao == null) actividadesDao = new DAOActividadesImp();
		return actividadesDao;
	}
	
	public int altaActividad(final tActividad actividad) {
		return getDAOActividad().altaActividad(actividad);
	}

	public tActividad leerActividad(final String tipoActividad, final Date fecha, final int idSala) {
		return getDAOActividad().leerActividad(tipoActividad, fecha, idSala);
	}

	public int actualizarActividad(tActividad actividad) {
		return getDAOActividad().actualizarActividad(actividad);
	}

	public int borrarActividad(final String tipoActividad, final Date fecha, final int idSala) {
		return getDAOActividad().borrarActividad(tipoActividad, fecha, idSala);
	}

	public List<tActividad> leerTodasActividades() {
		return getDAOActividad().leerTodasActividades();
	}

}