package integracion;

import java.util.List;

import negocio.tEmpleado;

public interface DAOEmpleados {

    int altaEmpleado(tEmpleado empleado);

    tEmpleado leerEmpleado(final int id);

    int actualizarEmpleado(final tEmpleado empleado);

    int borrarEmpleado(final int id);

    List<tEmpleado> leerTodosEmpleados();
}