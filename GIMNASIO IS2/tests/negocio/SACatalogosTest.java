package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SACatalogosTest {

	@Test
	void test() {
		SACatalogos catalogos = new SACatalogosImp();
		
		ArrayList<DTOtActividad> actividades = new ArrayList();
		actividades.add(new DTOtActividad("Yoga",1,new Date(1,1,1),"11111111A"));
		actividades.add(new DTOtActividad("Pilates",2,new Date(1,1,1),"22222222B"));
		actividades.add(new DTOtActividad("Crossfit",1,new Date(2,1,1),"11111111A"));
		
		int id = catalogos.altaCatalogo(new DTOtCatalogo(3));
		catalogos.altaCatalogo(new DTOtCatalogo(id,actividades,3));
		
		assertEquals(new DTOtCatalogo(id,actividades,3),catalogos.leerCatalogo(id));
		
		actividades.remove(2);
		
		catalogos.actualizarCatalogo(new DTOtCatalogo(id,actividades,3));
		
		catalogos.altaCatalogo(new DTOtCatalogo(2,actividades,7));
		catalogos.altaCatalogo(new DTOtCatalogo(3,actividades,5));
		
		catalogos.borrarCatalogo(id);
		
		List<DTOtCatalogo> list = catalogos.leerTodosCatalogos();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtCatalogo e : list) {
			if (e.toString().equals("me da error")) a = true;
			else if(e.toString().equals("me da error")) b = true;
		}
		
		assertEquals(a,true);
		assertEquals(b,true);
		
		assertEquals(new DTOtCatalogo(2,actividades,7), list.get(0));
		assertEquals(new DTOtCatalogo(3,actividades,5),list.get(1));
	}

}
