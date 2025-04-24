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

	public DTOtEmpleado leerEmpleado(final String dni) {
		return getDAOEmpleados().leerEmpleado(dni);
	}

	public int actualizarEmpleado(final DTOtEmpleado empleado) {
		DTOtEmpleado e = leerEmpleado(empleado.getDni());
		int exito = 0;
		if(e != null) exito = getDAOEmpleados().actualizarEmpleado(empleado);
		return exito;
	}

	public int borrarEmpleado(final String dni) {
		DTOtEmpleado e = leerEmpleado(dni);
		int exito = 0;
		if(e != null) {
			//falta por hacer borrar de la sala, actividad o asesoramiento
			exito = getDAOEmpleados().borrarEmpleado(dni);
		}
		return exito;
	}

	public List<DTOtEmpleado> leerTodosEmpleados() {
		return getDAOEmpleados().leerTodosEmpleados();
	}

}