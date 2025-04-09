package negocio;

import java.util.List;

import integracion.DAOSalas;
import integracion.DAOSalasImp;

public class SASalasImp implements SASalas {

	private static DAOSalas salasDAO = new DAOSalasImp();

	public int altaSala(final tSala sala) {
		return salasDAO.altaSala(sala);
	}

	public tSala leerSala(final int id) {
		return salasDAO.leerSala(id);
	}

	public int actualizarSala(final tSala sala) {
		return salasDAO.actualizarSala(sala);
	}

	public int borrarSala(final int id) {
		return salasDAO.borrarSala(id);
	}

	public List<tSala> leerTodasSalas() {
		return salasDAO.leerTodasSalas();
	}

}
