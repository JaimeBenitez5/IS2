package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTOtCompra {
	
	int _idCompra;
	String _dniEmpleado;
	int _idFactura;
	List<Integer> _idSuscripciones;
	String _dniCliente;
	Date _fecha;
	String _metodoPago;//mirar bbdd
	
	public DTOtCompra(String dniEmpleado,int idFactura,List<Integer> idSuscripciones,String dniCliente,Date fecha,String metodoPago) {
		_dniEmpleado = dniEmpleado ;
		_idFactura= idFactura;
		_idSuscripciones = idSuscripciones;
		_dniCliente = dniCliente;
		_fecha=fecha;
		_metodoPago=metodoPago;
	}
	public DTOtCompra(int idCompra,String dniEmpleado,int idFactura,List<Integer> idSuscripciones,String dniCliente,Date fecha,String metodoPago) {
		_idCompra= idCompra;
		_dniEmpleado = dniEmpleado ;
		_idFactura= idFactura;
		_idSuscripciones = idSuscripciones;
		_dniCliente = dniCliente;
		_fecha=fecha;
		_metodoPago=metodoPago;
		
	}
	
	public DTOtCompra(int idCompra,int numSuscripcion,String dniEmpleado,int idFactura,List<Integer> idSuscripciones,String dniCliente,Date fecha,String metodoPago) {
		_idCompra=idCompra;
		_dniEmpleado = dniEmpleado ;
		_idFactura= idFactura;
		_idSuscripciones = idSuscripciones;
	}
	public DTOtCompra(int idCompra,int numSuscripcion,String dniEmpleado,int idFactura,int idSuscripcion,String dniCliente,Date fecha,String metodoPago) {
		_idCompra=idCompra;
		_dniEmpleado = dniEmpleado ;
		_idFactura= idFactura;
		_idSuscripciones = new ArrayList<Integer>();
		_dniCliente = dniCliente;
		_fecha=fecha;
		_metodoPago=metodoPago;
	}
	
	public String getDniCliente() {
		return _dniCliente;
	}
	
	public String getDniEmpleado() {
		return _dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this._dniEmpleado = dniEmpleado;
	}

	public int getIdFactura() {
		return _idFactura;
	}

	public void setIdFactura(int idFactura) {
		this._idFactura = idFactura;
	}

	public void setIdCliente(String dniCliente) {
		this._dniCliente = dniCliente;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		this._fecha = fecha;
	}

	public String getMetodoPago() {
		return _metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this._metodoPago = metodoPago;
	}

	public int getId() {
		return _idCompra;
	}
	
	public void setId(int id) {
		_idCompra= id;
	}

	public List<Integer> getSuscripciones(){
		return _idSuscripciones;
	}

	
	
}
