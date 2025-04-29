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
		if(facturasDao == null) facturasDao = new DAOFacturasImp();
		return facturasDao;
	}

	public int altaCompra(final DTOtCompra compra) {
		//FALTA CALCULAR EL NUEVO IMPORTE DE LA FACTURA
		DTOtCompra c = leerCompra(compra.getId());
		int exito = 0;
		if(c == null) exito = getDAOCompras().altaCompra(compra);
		if(exito == 1) {
			DTOtFactura = new DTOtFactura(compra.getIdFactura(), compra.getFecha(), compra);
			getDAOFacturas().altaFactura(compra.get);
		}
		return exito;
	}

	public DTOtCompra leerCompra(final int id) {
		return getDAOCompras().leerCompra(id);
	}

	public int actualizarCompra(DTOtCompra compra) {
		//FALTA CALCULAR LA NUEVA FECHA Y EL NUEVO IMPORTE DE LA FACTURA
		int exito = 0;
		exito = getDAOCompras().actualizarCompra(compra);
		if(exito == 1) {
			DTOtFactura f = leerFactura(compra.getIdFactura());
			if(f != null) exito = getDAOFacturas().actualizarFactura(f);
			else exito = 0;
		}
		return exito;
	}
	
	public int borrarCompra(final int id) {
		DTOtCompra c = leerCompra(id);
		int exito = 0;
		if(c != null) exito = getDAOCompras().borrarCompra(id);
		DTOtFactura f = leerFactura(c.getIdFactura());
		if(f != null) {
			exito = getDAOFacturas().borrarFactura(f.getId());
		}
		return exito;
	}

	public List<DTOtCompra> leerTodasCompras() {
		return getDAOCompras().leerTodasCompras(); 
	}

	public DTOtFactura leerFactura(final int id) {
		return getDAOFacturas().leerFactura(id);
	}

	public List<DTOtFactura> leerTodasFacturas() {
		return getDAOFacturas().leerTodasFacturas();
	}

}
