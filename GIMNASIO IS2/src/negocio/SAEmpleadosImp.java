package negocio;

import java.util.List;
import integracion.DAOEmpleados;
import integracion.DAOEmpleadosImp;

public class SAEmpleadosImp implements SAEmpleados {

	private static DAOEmpleados empleadosDAO = null;

	//USADO PATRON SINGLETON
	public static DAOEmpleados getDAOEmpleados(){
		if(empleadosDAO == null) empleadosDAO = new DAOEmpleadosImp();
		return empleadosDAO;
	}
	
	public int altaEmpleado(final DTOtEmpleado empleado) {
		return getDAOEmpleados().altaEmpleado(empleado);
	}

	public DTOtEmpleado leerEmpleado(final int id) {
		return getDAOEmpleados().leerEmpleado(id);
	}

	public int actualizarEmpleado(final DTOtEmpleado empleado) {
		return getDAOEmpleados().actualizarEmpleado(empleado);
	}

	public int borrarEmpleado(final int id) {
		return getDAOEmpleados().borrarEmpleado(id);
	}

	public List<DTOtEmpleado> leerTodosEmpleados() {
		return getDAOEmpleados().leerTodosEmpleados();
	}

}