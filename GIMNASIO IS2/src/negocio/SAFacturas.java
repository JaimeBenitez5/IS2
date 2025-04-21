package negocio;

import java.util.List;

public interface SAFacturas {
	
    int altaFactura(final tFactura factura);

    tFactura leerFactura(final int id);

    int actualizarFactura(final tFactura factura);

    int borrarFactura(final int id);

    List<tFactura> leerTodasFacturas();

}
