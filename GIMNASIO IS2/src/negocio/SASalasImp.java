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
		return getDAOSalas().actualizarSala(sala);
	}

	public int borrarSala(final int id) {
		return getDAOSalas().borrarSala(id);
	}

	public List<tSala> leerTodasSalas() {
		return getDAOSalas().leerTodasSalas();
	}

}
