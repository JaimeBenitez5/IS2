package negocio;

import java.util.List;

public interface SAFactura {
	
    int altaFactura(final tFactura factura);

    tFactura leerFactura();

    int actualizarFactura(final tFactura factura);

    int borrarFactura(final String id);

    List<tFactura> leerTodasFacturas();

}
