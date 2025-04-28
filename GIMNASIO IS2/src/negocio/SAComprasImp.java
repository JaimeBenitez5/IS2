package negocio;

import java.util.List;

import integracion.DAOCompras;
import integracion.DAOComprasImp;
import integracion.DAOFacturas;
import integracion.DAOFacturasImp;

public class SAComprasImp implements SACompras {

	private static DAOCompras comprasDao = null;
	private static DAOFacturas facturasDao = null;

	//USADO PATRON SINGLETON
	public static DAOCompras getDAOCompras(){
		if(comprasDao == null) comprasDao = new DAOComprasImp();
		return comprasDao;
	}
	public static DAOFacturas getDAOFacturas(){
		if(facturasDAO == null) facturasDAO = new DAOFacturasImp();
		return facturasDAO;
	}
	
	public int altaCompra(final DTOtCompra compra) {
		DTOtCompra c = leerCompra(compra.getId());
		int exito = 0;
		if(c == null) exito = getDAOCompras().altaCompra(compra); 
		return exito;
	}


	public DTOtCompra leerCompra(int id) {
		return getDAOCompras().leerCompra(id);
	}


	public int actualizarCompra(DTOtCompra compra) {
		return getDAOCompras().actualizarCompra(compra);
	}


	public int borrarCompra(DTOtCompra compra) {
		DTOtCompra c = leerCompra(compra.getId());
		int exito = 0;
		if(c != null ) exito = getDAOCompras().borrarCompra(id);
		return exito;
	}


	public List<DTOtCompra> leerTodasCompras() {
		return getDAOCompras().leerTodasCompras(); 
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
