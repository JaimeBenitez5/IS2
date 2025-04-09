package negocio;

import java.util.List;
import integracion.DAOCatalogos;
import integracion.DAOCatalogosImp;


public class SACatalogosImp implements SACatalogos {

	private static DAOCatalogos catalogosDAO = new DAOCatalogosImp();
	
	public int altaCatalogo(tCatalogo catalogo) {
		return 0;
	}
	
	public tCliente leerCatalogo(int id) {
		return null;
	}

	public int actualizarCatalogo(tCatalogo catalogo) {
		return 0;
	}

	public int borrarCatalogo(int id) {
		return 0;
	}

	public List<tCatalogo> leerTodosCatalogos() {
		return null;
	}

}
