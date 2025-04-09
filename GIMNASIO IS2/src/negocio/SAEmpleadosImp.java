package negocio;

import java.util.List;

import integracion.DAOEmpleados;
import integracion.DAOEmpleadosImp;

public class SAEmpleadosImp implements SAEmpleados {

	private static DAOEmpleados empleadosDAO = new DAOEmpleadosImp();
	
	public int altaEmpleado(final tEmpleado empleado) {
		return empleadosDAO.altaEmpleado(empleado);
	}

	public tEmpleado leerEmpleado(final int id) {
		return empleadosDAO.leerEmpleado(id);
	}

	public int actualizarEmpleado(final tEmpleado empleado) {
		return empleadosDAO.actualizarEmpleado(empleado);
	}

	public int borrarEmpleado(final int id) {
		return empleadosDAO.borrarEmpleado(id);
	}

	public List<tEmpleado> leerTodosEmpleados() {
		return empleadosDAO.leerTodosEmpleados();
	}

}
