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
	
	public int altaCatalogo(tCatalogo catalogo) {
		return getDAOCatalogos().altaCatalogo(catalogo);
	}

	public tCatalogo leerCatalogo(int id) {
		return getDAOCatalogos().leerCatalogo(id);
	}

	public int actualizarCatalogo(tCatalogo catalogo) {
		return getDAOCatalogos().actualizarCatalogo(catalogo);
	}

	public int borrarCatalogo(int id) {
		return getDAOCatalogos().borrarCatalogo(id);
	}

	public List<tCatalogo> leerTodosCatalogos() {
		return getDAOCatalogos().leerTodosCatalogos();
	}

}