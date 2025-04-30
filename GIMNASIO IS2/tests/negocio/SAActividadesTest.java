package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

class SAActividadesTest {

	@Test
	void test() {
		SAActividadesImp actividades = new SAActividadesImp();
		
		actividades.altaActividad(new DTOtActividad("Yoga",1,new Date(1,1,1),"11111111A",1));
		actividades.altaActividad(new DTOtActividad("Pilates",2,new Date(1,1,1),"22222222B",2));
		actividades.altaActividad(new DTOtActividad("Crossfit",1,new Date(2,1,1),"11111111A",1));
		
		assertEquals(actividades.leerActividad("Yoga", new Date(1,1,1), 1),new DTOtActividad("Yoga",1,new Date(1,1,1),"11111111A",1));
		
		actividades.actualizarActividad(new DTOtActividad("Yoga",1,new Date(1,1,1),"22222222B",1));
		
		assertEquals(actividades.leerActividad("Yoga", new Date(1,1,1), 1),new DTOtActividad("Yoga",1,new Date(1,1,1),"22222222B",1));
		
		actividades.borrarActividad("Crossfit", new Date(2,1,1), 1);
		
		List<DTOtActividad> list = actividades.leerTodasActividades();
		
		assertEquals(new DTOtActividad("Yoga",1,new Date(1,1,1),"22222222B",1),list.get(0));
		assertEquals(new DTOtActividad("Pilates",2,new Date(1,1,1), "222222222B",2),list.get(1));
		
	}

}
