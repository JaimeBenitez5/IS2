package negocio;

import java.util.List;

import integracion.DAOClientes;
import integracion.DAOClientesImp;
import integracion.DAOCompras;
import integracion.DAOComprasImp;

public class SAComprasImp implements SACompras {


	private static DAOCompras comprasDao = null;

	//USADO PATRON SINGLETON
	public static DAOCompras getDAOCompras(){
		if(comprasDao == null) comprasDao = new DAOComprasImp();
		return comprasDao;
	}

	public int altaCompra(final DTOtCompra compra) {
		DTOtCompra c = leerCompra(compra.getId());
		int exito = 0;
		if(c == null) {
			exito = getDAOCompras().altaCompra(compra); 
		}
		return exito;
	}


	public DTOtCompra leerCompra(int id) {
		return getDAOCompras().leerCompra(id);
	}


	public int actualizarCompra(DTOtCompra compra) {
		return getDAOCompras().actualizarCompra(compra);
	}


	public int borrarCompra(int id) {
		DTOtCompra c = leerCompra(id);
		int exito = 0;
		if(c != null ) exito = getDAOCompras().borrarCompra(id);
		return exito;
	}


	public List<DTOtCompra> leerTodasCompras() {
		return getDAOCompras().leerTodasCompras(); 
	}





	

}
