package negocio;

import java.util.List;

import integracion.DAOFacturas;
import integracion.DAOFacturasImp;

public class SAFacturasImp implements SAFactura {

	private static DAOFacturas facturasDAO = new DAOFacturasImp();
	
    public int altaFactura(final tFactura factura) {
        return facturasDAO.altaFactura(factura);
    }

    public tFactura leerFactura(final int id) {
        return facturasDAO.leerFactura(id);
    }

    public int actualizarFactura(final tFactura factura) {
        return facturasDAO.actualizarFactura(factura);
    }

    public int borrarFactura(final int id) {
        return facturasDAO.borrarFactura(id);
    }

    public List<tFactura> leerTodasFacturas() {
    	return facturasDAO.leerTodasFacturas();
    }

}
