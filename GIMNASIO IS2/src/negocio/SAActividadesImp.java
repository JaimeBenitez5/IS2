package negocio;

import java.util.List;
import integracion.DAOActividades;
import integracion.DAOActividadesImp;

public class SAActividadesImp implements SAActividades {
	
	private static DAOActividades actividadesDao = null;
	
	//USADO PATRON SINGLETON
	public static DAOActividades getDAOClientes(){
		if(actividadesDao == null) actividadesDao = new DAOActividadesImp();
		return actividadesDao;
	}
	
	public int altaActividad(tActividad actividad) {
		return getDAOClientes().altaActividad(actividad);
	}

	public tActividad leerActividad(int id) {
		return getDAOClientes().leerActividad(id);
	}

	public int actualizarActividad(tActividad actividad) {
		return getDAOClientes().actualizarActividad(actividad);
	}

	public int borrarActividad(int id) {
		return getDAOClientes().borrarActividad(id);
	}

	public List<tActividad> leerTodasActividades() {
		return getDAOClientes().leerTodasActividades();
	}

}