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
    //los pares rol-salario no se borran

    List<DTOtEmpleado> leerTodosEmpleados();
    //leerTodosEmpleadosRoles()????
}