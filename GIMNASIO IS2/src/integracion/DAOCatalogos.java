package integracion;

import java.util.List;

import negocio.tCatalogo;

public interface DAOCatalogos {
	
	int altaCatalogo(tCatalogo catalogo);

	tCatalogo leerCatalogo(final int id);

	int actualizarCatalogo(final tCatalogo catalogo);

	int borrarCatalogo(final int id);

	List<tCatalogo> leerTodosCatalogos();
}