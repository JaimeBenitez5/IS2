package integracion;

import java.util.List;

import negocio.DTOtEmpleado;

public interface DAOEmpleados {

    int altaEmpleado(DTOtEmpleado empleado);

    DTOtEmpleado leerEmpleado(final int id);

    int actualizarEmpleado(final DTOtEmpleado empleado);

    int borrarEmpleado(final int id);

    List<DTOtEmpleado> leerTodosEmpleados();
}