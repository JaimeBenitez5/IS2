package integracion;

import java.util.List;

import negocio.tFactura;

public interface DAOFacturas {
    
    int altaFactura(tFactura Factura);

    tFactura leerFactura(int id);

    int actualizarFactura(final tFactura factura);

    int borrarFactura(final int id);

    List<tFactura> leerTodasFacturas();
}
