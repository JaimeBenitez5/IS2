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
		DTOtEmpleado e = leerEmpleado(empleado.getId());
		int exito = 0;
		if(e != null) exito = getDAOEmpleados().actualizarEmpleado(empleado);
		return exito;
	}

	public int borrarEmpleado(final int id) {
		DTOtEmpleado e = leerEmpleado(id);
		int exito = 0;
		if(e != null) {
			//falta por hacer borrar de la sala, actividad o asesoramiento
			exito = getDAOEmpleados().borrarEmpleado(id);
		}
		return exito;
	}

	public List<DTOtEmpleado> leerTodosEmpleados() {
		return getDAOEmpleados().leerTodosEmpleados();
	}

}