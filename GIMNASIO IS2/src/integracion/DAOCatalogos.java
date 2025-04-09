package integracion;

import java.util.List;

import negocio.tCatalogo;

public interface DAOCatalogos {
	
	int createCatalogo(tCatalogo catalogo);

	tCatalogo readCatalogo(final int id);

	int updateCatalogo(final tCatalogo catalogo);

	int deleteCatalogo(final int id);

	List<tCatalogo> readAllCatalogos();
}
