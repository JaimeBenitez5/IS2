package negocio;

import java.util.List;

import integracion.DAOCompras;
import integracion.DAOComprasImp;
import integracion.DAOFacturas;
import integracion.DAOFacturasImp;
import integracion.DAOSuscripciones;
import integracion.DAOSuscripcionesBasicasImp;
import integracion.DAOSuscripcionesPremiumImp;

public class SAComprasImp implements SACompras {

	private static DAOCompras comprasDao = null;
	private static DAOFacturas facturasDao = null;
	private static DAOSuscripciones suscripcionesBasicasDAO = null;
	private static DAOSuscripciones suscripcionesPremiumDAO = null;

	//USADO PATRON SINGLETON
	public static DAOCompras getDAOCompras(){
		if(comprasDao == null) comprasDao = new DAOComprasImp();
		return comprasDao;
	}
	public static DAOFacturas getDAOFacturas(){
		if(facturasDao == null) facturasDao = new DAOFacturasImp();
		return facturasDao;
	}
	public static DAOSuscripciones getDAOSuscripcionesBasicas() {
		if (suscripcionesBasicasDAO == null) suscripcionesBasicasDAO = new DAOSuscripcionesBasicasImp();
		return suscripcionesBasicasDAO;
	}
	public static DAOSuscripciones getDAOSuscripcionesPremium(){
		if(suscripcionesPremiumDAO == null) suscripcionesPremiumDAO = new DAOSuscripcionesPremiumImp();
		return suscripcionesPremiumDAO;
	}

	public int altaCompra(final DTOtCompra compra) {
		int idCompra = 0;
		if(leerCompra(compra.getId()) == null) {
			int idFact = 0;
			int idSus = compra.getSuscripcion();
			DTOtFactura factura;
			DTOtSuscripcion susBasica = getDAOSuscripcionesBasicas().leerSuscripcion(idSus);
			if(susBasica != null) factura = new DTOtFactura(compra.getFecha(), susBasica.getPrecio());
			else {
				DTOtSuscripcion susPremium = getDAOSuscripcionesPremium().leerSuscripcion(idSus);
				factura = new DTOtFactura(compra.getFecha(), susPremium.getPrecio());
			}
			idFact = getDAOFacturas().altaFactura(factura);
			compra.setIdFactura(idFact);
			idCompra = getDAOCompras().altaCompra(compra);
		}
		return idCompra;
	}

	public DTOtCompra leerCompra(final int id) {
		return getDAOCompras().leerCompra(id);
	}

	public int actualizarCompra(final DTOtCompra compra) {
		int exito = 0;
		DTOtCompra c = leerCompra(compra.getId());
		if(c != null) {
			int idSus = compra.getSuscripcion();
			DTOtFactura factura;
			DTOtSuscripcion susBasica = getDAOSuscripcionesBasicas().leerSuscripcion(idSus);
			if(susBasica != null) factura = new DTOtFactura(c.getIdFactura(), compra.getFecha(), susBasica.getPrecio());	
			else {
				DTOtSuscripcion susPremium = getDAOSuscripcionesPremium().leerSuscripcion(idSus);
				factura = new DTOtFactura(compra.getIdFactura(), compra.getFecha(), susPremium.getPrecio());
			}
			exito = getDAOFacturas().actualizarFactura(factura);
			if(exito == 1) exito = getDAOCompras().actualizarCompra(compra);
		}
		return exito;
	}

	public int borrarCompra(final int id) {
		DTOtCompra c = leerCompra(id);
		int exito = 0;
		if(c != null) {
			exito = getDAOCompras().borrarCompra(id);
			DTOtFactura f = leerFactura(c.getIdFactura());
			if(f != null) exito = getDAOFacturas().borrarFactura(f.getId());
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
