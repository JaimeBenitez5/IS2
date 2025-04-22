package negocio;

import java.util.List;

public interface SAEmpleados {
	
	public int altaEmpleado(final DTOtEmpleado empleado);

	public DTOtEmpleado leerEmpleado(final int id);

	public int actualizarEmpleado(final DTOtEmpleado tEmpleado);
	
	public int borrarEmpleado(final int id);
	
	public List<DTOtEmpleado> leerTodosEmpleados();
}
