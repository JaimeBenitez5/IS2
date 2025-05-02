package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

class SAActividadesTest {

	@Test
	void test() {
		SAActividades actividades = new SAActividadesImp();
		SASalas salas = new SASalasImp();
		SAEmpleados empleados = new SAEmpleadosImp();
		
		Date d1 = new Date(1,1,1);
		Date d2 = new Date(2,2,2);
		
		empleados.altaEmpleado(new DTOtEmpleado("99999999X", "Test1", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("88888888K", "Test2", new DTOtRol("Monitor")));
		empleados.altaEmpleado(new DTOtEmpleado("77777777V", "Test3", new DTOtRol("Mantenimiento")));
		empleados.altaEmpleado(new DTOtEmpleado("66666666Z", "Test4", new DTOtRol("Mantenimiento")));
		
		int exito = actividades.altaActividad(new DTOtActividad("Yoga", 1, d1,"99999999X", 1));
		actividades.altaActividad(new DTOtActividad("Pilates", 2, d1,"88888888K", 2));
		actividades.altaActividad(new DTOtActividad("Crossfit", 1, d2,"99999999X", 1));
		
		assertEquals(actividades.leerActividad("Yoga", d1, 1).toString(), new DTOtActividad("Yoga", 1, d1, "99999999X", 1).toString());
		
		actividades.actualizarActividad(new DTOtActividad("Yoga",1, d1,"88888888K",1));
		
		assertEquals(actividades.leerActividad("Yoga", d1, 1),new DTOtActividad("Yoga",1,d1,"88888888K",1));
		
		actividades.borrarActividad("Crossfit", d2, 1);
		
		List<DTOtActividad> list = actividades.leerTodasActividades();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtActividad e : list) {
			if (e.toString().equals("Yoga 1 88888888K ")) a = true;
			else if(e.toString().equals("Pilates 2 88888888K")) b = true;
		}
		
		assertEquals(a,true);
		assertEquals(b,true);
		
	}

}
