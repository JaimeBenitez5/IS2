package negocio;

import java.util.List;

public interface SAEmpleados {
	
	public int altaEmpleado(final DTOtEmpleado empleado);

	public DTOtEmpleado leerEmpleado(final String dni);

	public int actualizarEmpleado(final DTOtEmpleado tEmpleado);
	
	public int borrarEmpleado(final String dni);
	
	public List<DTOtEmpleado> leerTodosEmpleados();
}
