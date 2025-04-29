package negocio;

import java.sql.Date;

public class DTOtCompra {
	private int _idCompra;
	private int _idSuscripcion;
	private String _dniCliente;
	private Date _fecha;
	private String _metodoPago;

	private String _dniEmpleado;
	private int _idFactura;
	
	public DTOtCompra(final int idCompra, final int idSuscripcion, final String dniCliente, final Date fecha, final String metodoPago, final String dniEmpleado, final int idFactura) {
		_idCompra = idCompra;
		_idSuscripcion = idSuscripcion;
		_dniCliente = dniCliente;
		_fecha = fecha;
		_metodoPago = metodoPago;
		_dniEmpleado = dniEmpleado;
		_idFactura = idFactura;
	}
	
	public DTOtCompra(final int idCompra, final int idSuscripcion, final String dniCliente, final Date fecha, final String metodoPago, final String dniEmpleado) {
		_idCompra = idCompra;
		_idSuscripcion = idSuscripcion;
		_dniCliente = dniCliente;
		_fecha = fecha;
		_metodoPago = metodoPago;
		_dniEmpleado = dniEmpleado;
		_idFactura = 0;
	}
	
	public DTOtCompra(final int idSuscripcion, final String dniCliente, final Date fecha, final String metodoPago, final String dniEmpleado) {
		_idCompra = 0;
		_idSuscripcion = idSuscripcion;
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
	
	public int getSuscripcion(){
		return _idSuscripcion;
	}
	
	public void setFecha(final Date fecha) {
		this._fecha = fecha;
	}

	public void setMetodoPago(final String metodoPago) {
		this._metodoPago = metodoPago;
	}
	
	public void setIdFactura(final int idFactura) {
		this._idFactura = idFactura;
	}

	public void setIdCliente(final String dniCliente) {
		this._dniCliente = dniCliente;
	}

	public void setId(final int id) {
		_idCompra= id;
	}

	public void setDniEmpleado(final String dniEmpleado) {
		this._dniEmpleado = dniEmpleado;
	}
}
