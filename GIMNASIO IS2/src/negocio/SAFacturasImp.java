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
		DTOtFactura f = leerFactura(factura.getId());
		int exito = 0;
		if(f != null) exito = getDAOFacturas().actualizarFactura(factura);
		return exito;
	}

	public int borrarFactura(final int id) {
		DTOtFactura f = leerFactura(id);
		int exito = 0;
		if(f != null) {
			exito = getDAOFacturas().borrarFactura(id);
		}
		return exito;
	}

	public List<DTOtFactura> leerTodasFacturas() {
		return getDAOFacturas().leerTodasFacturas();
	}

}