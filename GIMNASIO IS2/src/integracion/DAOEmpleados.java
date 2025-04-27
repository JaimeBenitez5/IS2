package integracion;

import java.util.List;

import negocio.DTOtEmpleado;

public interface DAOEmpleados {

    int altaEmpleado(DTOtEmpleado empleado);
    int altaEmpleadoRol(final DTOtEmpleado empleado);
    
    
    DTOtEmpleado leerEmpleado(final String dni);
	double leerSalarioMantenimiento();
    double leerSalarioMonitores();
    double leerSalarioNutricionistas();
    double leerSalarioRecepcion();
    String leerNombreRol(final int id);
    int leerEmpleadoRol(final String dni);

    int actualizarEmpleado(final DTOtEmpleado empleado);
    //los pares empleado-rol y rol-salario no se actualizan
    
    int borrarEmpleado(final String dni);
    int borrarEmpleadoRol(final String dni);
    //los pares rol-salario no se borran

    List<DTOtEmpleado> leerTodosEmpleados();
    //leerTodosEmpleadosRoles()????
}

//Rol rol = empleado.getRolEmpleado().getIdRol();
//String nombreRol = empleado.getRolEmpleado().getNombreRol();
//double salario = empleado.getRolEmpleado().getSalario();
//
//
//
//private String _dni;
//private String _nombre;
//private DTOtRol _rolEmpleado{
//	private Rol _idRol;
//	private String _nombreRol;
//	private double _salario;
//}

//en empleados veo si el empleado existe
//en empleados roles veo si es de verdad de mantenimiento





//en mantenimiento veo su salario


//con idRol cojo de tabla Roles el nombre
//insertar empleado
//insertarRolEmpleado
//con idRol cojo de su tabla de rol especifica el salario