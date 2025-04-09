package negocio;

import java.util.List;

public interface SAEmpleados {
	
	public int altaEmpleado(final tFactura factura);

	public tFactura leerEmpleado();

	public int actualizarEmpleado(final tFactura factura);
	
	public int borrarEmpleado(final String id);
	
	public List<tEmpleado> leerTodosEmpleados();
}
