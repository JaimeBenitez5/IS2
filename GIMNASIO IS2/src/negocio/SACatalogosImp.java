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
	
	public int altaCatalogo(final DTOtCatalogo catalogo) {
		return getDAOCatalogos().altaCatalogo(catalogo);
	}

	public DTOtCatalogo leerCatalogo(final int id) {
		return getDAOCatalogos().leerCatalogo(id);
	}

	public int actualizarCatalogo(final DTOtCatalogo catalogo) {
		DTOtCatalogo c = leerCatalogo(catalogo.getId());
		int exito = 0;
		if(c != null) exito = getDAOCatalogos().actualizarCatalogo(catalogo);
		return exito;
	}
	
	public int borrarCatalogosSala(final int idSala) {
		return getDAOCatalogos().borrarCatalogosSala(idSala);
	}
	
	public int borrarCatalogo(final int id) {
		DTOtCatalogo c = leerCatalogo(id);
		int exito = 0;
		if(c != null) exito = getDAOCatalogos().borrarCatalogo(id);
		return exito;
	}

	public List<DTOtCatalogo> leerTodosCatalogos() {
		return getDAOCatalogos().leerTodosCatalogos();
	}

}