package negocio;

import java.util.List;

public interface SAEmpleados {
	
	public int altaEmpleado(final tEmpleado empleado);

	public tEmpleado leerEmpleado(final int id);

	public int actualizarEmpleado(final tEmpleado tEmpleado);
	
	public int borrarEmpleado(final int id);
	
	public List<tEmpleado> leerTodosEmpleados();
}
