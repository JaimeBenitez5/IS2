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

	public int altaSala(final tSala sala) {
		return getDAOSalas().altaSala(sala);
	}

	public tSala leerSala(final int id) {
		return getDAOSalas().leerSala(id);
	}

	public int actualizarSala(final tSala sala) {
		tSala s = leerSala(sala.getId());
		int exito = 0;
		if(s != null) exito = getDAOSalas().actualizarSala(sala);
		return exito;
	}

	public int borrarSala(final int id) {
		tSala s = leerSala(id);
		int exito = 0;
		if(s != null) exito = getDAOSalas().borrarSala(id);
		return exito;
	}

	public List<tSala> leerTodasSalas() {
		return getDAOSalas().leerTodasSalas();
	}

}
