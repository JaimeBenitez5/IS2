package integracion;

import java.util.List;

import negocio.DTOtFactura;

public interface DAOFacturas {
    
    int altaFactura(final DTOtFactura Factura);

    DTOtFactura leerFactura(final int id);

    int actualizarFactura(final DTOtFactura factura);

    int borrarFactura(final int id);

    List<DTOtFactura> leerTodasFacturas();
}