package negocio;

import java.util.List;

public interface SACatalogos {
	
	int altaCatalogo(final DTOtCatalogo catalogo);

	DTOtCatalogo leerCatalogo(final int id);

    int actualizarCatalogo(final DTOtCatalogo catalogo);
    
    int borrarCatalogosSala(final int idSala);
    
    int borrarCatalogo(final int id);

    List<DTOtCatalogo> leerTodosCatalogos();
}
