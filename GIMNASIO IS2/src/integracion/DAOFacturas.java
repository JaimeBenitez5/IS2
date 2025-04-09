package integracion;

import java.util.List;

import negocio.tFactura;

public interface DAOFacturas {
	
    int createFactura(tFactura Factura);

    tFactura readFactura();

    int updateFactura(final tFactura factura);

    int deleteFactura(final String idFactura);

    List<tFactura> readAllFacturas();
}
