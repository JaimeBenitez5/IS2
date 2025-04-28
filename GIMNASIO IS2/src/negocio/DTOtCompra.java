package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTOtCompra {
	
	int _idCompra;
	int _numSuscripcion;
	int _dniEmpleado;
	int _idFactura;
	List<Integer> _idSuscripciones;
	String _dniCliente;
	Date _fecha;
	String _metodoPago; //mirar bbdd
	
	public DTOtCompra(int dniEmpleado, int idFactura, List<Integer> idSuscripciones, String dniCliente, Date fecha, String metodoPago) {
		_dniEmpleado = dniEmpleado ;
		_idFactura = idFactura;
		_idSuscripciones = idSuscripciones;
	}
	
	public DTOtCompra(int dniEmpleado, int idFactura, int idSuscripcion, String dniCliente, Date fecha, String metodoPago) {
		_dniEmpleado = dniEmpleado ;
		_idFactura = idFactura;
		_idSuscripciones = new ArrayList<Integer>();
		_dniCliente = dniCliente;
		_fecha = fecha;
		_metodoPago = metodoPago;
	}
	
	public DTOtCompra(int idCompra, int numSuscripcion, int dniEmpleado, int idFactura, List<Integer> idSuscripciones, String dniCliente, Date fecha, String metodoPago) {
		_idCompra = idCompra;
		_dniEmpleado = dniEmpleado ;
		_idFactura = idFactura;
		_idSuscripciones = idSuscripciones;
	}
	
	public DTOtCompra(int idCompra, int numSuscripcion, int dniEmpleado, int idFactura, int idSuscripcion, String dniCliente, Date fecha, String metodoPago) {
		_idCompra=idCompra;
		_dniEmpleado = dniEmpleado ;
		_idFactura = idFactura;
		_idSuscripciones = new ArrayList<Integer>();
		_dniCliente = dniCliente;
		_fecha = fecha;
		_metodoPago = metodoPago;
	}
	
	public String getDniCliente() {
		return _dniCliente;
	}
	
	public int getDniEmpleado() {
		return _dniEmpleado;
	}

	public int getIdFactura() {
		return _idFactura;
	}

	public String getIdCliente() {
		return _dniCliente;
	}
	
	public Date getFecha() {
		return _fecha;
	}

	public String getMetodoPago() {
		return _metodoPago;
	}
	
	public int getId() {
		return _idCompra;
	}
	
	public void setDniEmpleado(int dniEmpleado) {
		_dniEmpleado = dniEmpleado;
	}
	
	public void setIdFactura(int idFactura) {
		_idFactura = idFactura;
	}
	
	public void setIdCliente(String dniCliente) {
		_dniCliente = dniCliente;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public void setMetodoPago(String metodoPago) {
		_metodoPago = metodoPago;
	}
}
