package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import integracion.DAOSuscripciones;
import integracion.DAOSuscripcionesBasicasImp;

class SASuscripcionesTest {
	
	static Date d1;
	
	@BeforeAll
	static void init() {
		d1 = Date.valueOf("2025-1-1");
	}

	@Test
	void test() {
		SASuscripciones basicas = new SASuscripcionesBasicasImp();
		SASuscripciones premium = new SASuscripcionesPremiumImp();
		
		DAOSuscripciones daoBas = SASuscripcionesBasicasImp.getDAOSuscripciones();
		DAOSuscripciones daoPrem = SASuscripcionesPremiumImp.getDAOSuscripciones();
		
		int numBas = basicas.altaSuscripcion(new DTOtBasica("Agapito", "Yoga",d1, 1));
		int numPrem = premium.altaSuscripcion(new DTOtPremium("Anacleto",1,"11111111A"));
		
		daoBas.altaSuscripcionBasica(new DTOtBasica(numBas,"Agapito", "Yoga",d1, 1));
		daoPrem.altaSuscripcionPremium(new DTOtPremium(numPrem,"Anacleto",1,"11111111A"));
		
		Date d = d1;
		
		assertEquals("1 1 30 30 Agapito Yoga " + d.toString() + " 1", basicas.leerSuscripcion(1).toString());
		assertEquals("2 2 90 120 Anacleto 1 11111111A", premium.leerSuscripcion(2));
		
		basicas.actualizarSuscripcion(new DTOtBasica(numBas,"Josefa", "Crossfit", d1, 1));
		daoBas.actualizarSuscripcionBasica(new DTOtBasica(numBas,"Josefa", "Crossfit",d1, 1));
		
		assertEquals("1 1 30 30 Josefa Crossfit " + d.toString() + " 1", basicas.leerSuscripcion(1));
		basicas.borrarSuscripcion(1);
		
		premium.actualizarSuscripcion(new DTOtPremium(numPrem,"Manuel",2,"22222222B"));
		daoPrem.actualizarSuscripcionPremium(new DTOtPremium(numPrem,"Manuel",2,"22222222B"));
		
		List<DTOtSuscripcion> list = premium.leerTodasSuscripciones();
		
		boolean a = false;
		boolean b = false;
		
		for(DTOtSuscripcion e : list) {
			if (e.toString().equals("2 2 90 120 Manuel 2 22222222B")) a = true;
			else if(e.toString().equals("")) b = true;
		}
		
		assertTrue(a);
		assertTrue(b);
		
		assertEquals("2 2 90 120 Manuel 2 22222222B", list.get(0).toString());
	}

}
