package negocio;

import java.util.List;

import integracion.DAOSalas;
import integracion.DAOSalasImp;

public class SASalasImp implements SASalas {

	private static DAOSalas salasDAO = null;

	//USADO PATRON SINGLETON
	public static DAOSalas getDAOSalas(){
		if(salasDAO == null) salasDAO = new DAOSalasImp();
		return salasDAO;
	}

	public int altaSala(final DTOtSala sala) {
		return getDAOSalas().altaSala(sala);
	}

	public DTOtSala leerSala(final int id) {
		return getDAOSalas().leerSala(id);
	}

	public int actualizarSala(final DTOtSala sala) {
		DTOtSala s = leerSala(sala.getId());
		int exito = 0;
		if(s != null) exito = getDAOSalas().actualizarSala(sala);
		return exito;
	}

	public int borrarSala(final int id) {
		DTOtSala s = leerSala(id);
		int exito = 0;
		if(s != null) {
			SACatalogos cat = new SACatalogosImp();
			SAActividades act = new SAActividadesImp();
			//NS COMO SERIA PARA ACCEDER AL METODO DE LA SA, DE MOMENTO LO DEJO ASI
			//EL ORDEN DE BORRADO DE AQUI ABAJO ES IMPORTANTE
			cat.borrarCatalogosSala(id);
			act.borrarActividadesSala(id);
			exito = getDAOSalas().borrarSala(id);
		}
		return exito;
	}

	public List<DTOtSala> leerTodasSalas() {
		return getDAOSalas().leerTodasSalas();
	}

}
