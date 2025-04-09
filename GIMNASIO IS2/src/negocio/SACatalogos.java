package negocio;

import java.util.List;

public interface SACatalogos {
	int altaCatalogo(final tCatalogo catalogo);

    tCliente leerCatalogo(final int id);

    int actualizarCatalogo(final tCatalogo catalogo);

    int borrarCatalogo(final int id);

    List<tCatalogo> leerTodosCatalogos();
}
