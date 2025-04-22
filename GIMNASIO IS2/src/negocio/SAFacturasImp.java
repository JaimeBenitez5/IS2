package negocio;

import java.util.List;
import integracion.DAOFacturas;
import integracion.DAOFacturasImp;

public class SAFacturasImp implements SAFacturas {

	private static DAOFacturas facturasDAO = null;

	//USADO PATRON SINGLETON
	public static DAOFacturas getDAOFacturas(){
		if(facturasDAO == null) facturasDAO = new DAOFacturasImp();
		return facturasDAO;
	}
	
	public int altaFactura(final DTOtFactura factura) {
		return getDAOFacturas().altaFactura(factura);
	}

	public DTOtFactura leerFactura(final int id) {
		return getDAOFacturas().leerFactura(id);
	}

	public int actualizarFactura(final DTOtFactura factura) {
		return getDAOFacturas().actualizarFactura(factura);
	}

	public int borrarFactura(final int id) {
		return getDAOFacturas().borrarFactura(id);
	}

	public List<DTOtFactura> leerTodasFacturas() {
		return getDAOFacturas().leerTodasFacturas();
	}

}