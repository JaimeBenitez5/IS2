package integracion;

import java.util.List;

import negocio.DTOtEmpleado;

public interface DAOEmpleados {

    int altaEmpleado(DTOtEmpleado empleado);

    DTOtEmpleado leerEmpleado(final String dni);

    int actualizarEmpleado(final DTOtEmpleado empleado);

    int borrarEmpleado(final String dni);

    List<DTOtEmpleado> leerTodosEmpleados();
}