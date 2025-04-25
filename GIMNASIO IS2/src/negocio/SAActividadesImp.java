package negocio;

import java.sql.Date;
import java.util.List;
import integracion.DAOActividades;
import integracion.DAOActividadesImp;

public class SAActividadesImp implements SAActividades {
	
	private static DAOActividades actividadesDao = null;
	
	//USADO PATRON SINGLETON
	public static DAOActividades getDAOActividades(){
		if(actividadesDao == null) actividadesDao = new DAOActividadesImp();
		return actividadesDao;
	}
	
	public int altaActividad(final DTOtActividad actividad) {
		return getDAOActividades().altaActividad(actividad);
	}

	public DTOtActividad leerActividad(final String tipoActividad, final Date fecha, final int idSala) {
		return getDAOActividades().leerActividad(tipoActividad, fecha, idSala);
	}

	public int actualizarActividad(DTOtActividad actividad) {
		DTOtActividad a = leerActividad(actividad.getTipoActividad(), actividad.getFecha(), actividad.getIdSala());
		int exito = 0;
		if(a != null) exito = getDAOActividades().actualizarActividad(actividad);
		return exito;
	}
	
	public int borrarActividadesSala(int idSala) {
		return getDAOActividades().borrarActividadesSala(idSala);
	}
	
	public int borrarActividad(final String tipoActividad, final Date fecha, final int idSala) {
		DTOtActividad a = leerActividad(tipoActividad, fecha, idSala);
		int exito = 0;
		if(a != null) {
			exito = getDAOActividades().borrarActividad(tipoActividad, fecha, idSala);
		}
		return exito;
	}

	public List<DTOtActividad> leerTodasActividades() {
		return getDAOActividades().leerTodasActividades();
	}

}