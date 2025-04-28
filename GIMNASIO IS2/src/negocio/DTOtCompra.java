package negocio;

import java.util.Date;

public class DTOtCompra {
	private int _idCompra;
	private Integer[] _idSuscripciones;
	private String _dniCliente;
	private Date _fecha;
	private String _metodoPago;

	private String _dniEmpleado;
	private int _idFactura;
	
	public DTOtCompra(int idCompra, Integer[] idSuscripciones, String dniCliente, Date fecha, String metodoPago, String dniEmpleado, int idFactura) {
		_idCompra = idCompra;
		_idSuscripciones = idSuscripciones;
		_dniCliente = dniCliente;
		_fecha = fecha;
		_metodoPago = metodoPago;
		_dniEmpleado = dniEmpleado;
		_idFactura = idFactura;
	}
	
	public DTOtCompra(Integer[] idSuscripciones, String dniCliente, Date fecha, String metodoPago, String dniEmpleado, int idFactura) {
		_idCompra = 0;
		_idSuscripciones = idSuscripciones;
		_dniCliente = dniCliente;
		_fecha = fecha;
		_metodoPago = metodoPago;
		_dniEmpleado = dniEmpleado;
		_idFactura = 0;
	}
	
	public String getDniCliente() {
		return _dniCliente;
	}
	
	public String getDniEmpleado() {
		return _dniEmpleado;
	}

	public int getIdFactura() {
		return _idFactura;
	}
	
	public String getMetodoPago() {
		return _metodoPago;
	}
	
	public Date getFecha() {
		return _fecha;
	}
	
	public int getId() {
		return _idCompra;
	}
	
	public Integer[] getSuscripciones(){
		return _idSuscripciones;
	}
	
	public void setFecha(Date fecha) {
		this._fecha = fecha;
	}

	public void setMetodoPago(String metodoPago) {
		this._metodoPago = metodoPago;
	}
	
	public void setIdFactura(int idFactura) {
		this._idFactura = idFactura;
	}

	public void setIdCliente(String dniCliente) {
		this._dniCliente = dniCliente;
	}

	public void setId(int id) {
		_idCompra= id;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this._dniEmpleado = dniEmpleado;
	}
}
