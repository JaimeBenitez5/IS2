package negocio;

import java.util.List;
import integracion.DAOCatalogos;
import integracion.DAOCatalogosImp;

public class SACatalogosImp implements SACatalogos {

	private static DAOCatalogos catalogosDAO = null;
	
	//USADO PATRON SINGLETON
	public static DAOCatalogos getDAOCatalogos(){
		if(catalogosDAO == null) catalogosDAO = new DAOCatalogosImp();
		return catalogosDAO;
	}
	
	public int altaCatalogo(DTOtCatalogo catalogo) {
		return getDAOCatalogos().altaCatalogo(catalogo);
	}

	public DTOtCatalogo leerCatalogo(int id) {
		return getDAOCatalogos().leerCatalogo(id);
	}

	public int actualizarCatalogo(DTOtCatalogo catalogo) {
		return getDAOCatalogos().actualizarCatalogo(catalogo);
	}
	
	public int borrarCatalogosSala(int idSala) {
		return getDAOCatalogos().borrarCatalogosSala(idSala);
	}
	
	public int borrarCatalogo(int id) {
		return getDAOCatalogos().borrarCatalogo(id);
	}

	public List<DTOtCatalogo> leerTodosCatalogos() {
		return getDAOCatalogos().leerTodosCatalogos();
	}

}