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
		//compruebo que no existe
		DTOtEmpleado e = leerEmpleado(empleado.getDni());
		int exito = 0;
		if(e == null) exito = getDAOEmpleados().altaEmpleado(empleado);
		//si se ha añadido, añado tambien en tabla Empleado-Rol
		if(exito == 1) exito = getDAOEmpleados().altaEmpleadoRol(empleado);
		return exito;
	}

	public DTOtEmpleado leerEmpleado(final String dni) {
		//saco el empleado (Tabla Empleados)
		DTOtEmpleado e = getDAOEmpleados().leerEmpleado(dni);
		//si existe saco el idRol del empleado (Tabla EmpleadosRol)
		if(e != null) {
			int idRol = getDAOEmpleados().leerEmpleadoRol(dni);
			//si existe saco el nombre del rol (Tabla Roles)
			String nombreRol = getDAOEmpleados().leerNombreRol(idRol);
			//me falta el salario del rol (Tabla Monitor/Recep/....)
			double salarioRol = getSalarioPorRol(idRol);
			DTOtRol rol = new DTOtRol(idRol, nombreRol, salarioRol);
			//junto el empleado y el rol
			e.setRolEmpleado(rol);
		} 
		return e;
	}
	
	private double getSalarioPorRol(final int idRol) {
		double salario;
		if(idRol == 1) salario = getDAOEmpleados().leerSalarioMantenimiento();
		else if (idRol == 2) salario = getDAOEmpleados().leerSalarioMonitores();
		else if(idRol == 3) salario = getDAOEmpleados().leerSalarioNutricionistas();
		else if(idRol == 4) salario = getDAOEmpleados().leerSalarioRecepcion();
		else salario = 0;
		return salario;
	}

	public int actualizarEmpleado(final DTOtEmpleado empleado) {
		//compruebo que si que existia ya
		//del empleado solo podemos editar el nombre asiq con esto sobra
		DTOtEmpleado e = leerEmpleado(empleado.getDni());
		int exito = 0;
		if(e != null) exito = getDAOEmpleados().actualizarEmpleado(empleado);
		return exito;
	}

	public int borrarEmpleado(final String dni) {
		//compruebo que existia
		DTOtEmpleado e = leerEmpleado(dni);
		int exito = 0;
		if(e != null) {
			//falta por hacer borrar de la sala, actividad o asesoramiento
			//borrado de la lista de empleados, como empleados roles tiene 
			//on cascade, se borra de la lista de empleados-roles autopmaticamente
			exito = getDAOEmpleados().borrarEmpleado(dni);
		}
		return exito;
	}

	public List<DTOtEmpleado> leerTodosEmpleados() {
		List<DTOtEmpleado> emps = getDAOEmpleados().leerTodosEmpleados();
		for(DTOtEmpleado e : emps) {
			int idRol = e.getRolEmpleado().getIdRol();
			e.getRolEmpleado().setSalario(getSalarioPorRol(idRol));
		}
		return emps;
	}
}