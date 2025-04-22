package negocio;

import java.util.List;

public interface SAFacturas {
	
    int altaFactura(final DTOtFactura factura);

    DTOtFactura leerFactura(final int id);

    int actualizarFactura(final DTOtFactura factura);

    int borrarFactura(final int id);

    List<DTOtFactura> leerTodasFacturas();

}
