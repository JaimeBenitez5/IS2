package integracion;

import java.util.List;

import negocio.DTOtCatalogo;

public interface DAOCatalogos {
	
	int altaCatalogo(DTOtCatalogo catalogo);

	DTOtCatalogo leerCatalogo(final int id);

	int actualizarCatalogo(final DTOtCatalogo catalogo);
	
	int borrarCatalogosSala(final int idSala);
	
	int borrarCatalogo(final int id);

	List<DTOtCatalogo> leerTodosCatalogos();
}