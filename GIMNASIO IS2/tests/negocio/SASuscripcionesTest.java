package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import integracion.DAOSuscripciones;
import integracion.DAOSuscripcionesBasicasImp;
import integracion.DAOSuscripcionesPremiumImp;

class SASuscripcionesTest {

	@Test
	void test() {
		SASuscripcionesBasicasImp basicas = new SASuscripcionesBasicasImp();
		SASuscripcionesPremiumImp premium = new SASuscripcionesPremiumImp();
		
		int numBas = basicas.altaSuscripcion(new DTOtBasica("Agapito", "Yoga",new Date(1,1,1), 1));
		int numPrem = premium.altaSuscripcion(new DTOtPremium("Anacleto",1,"11111111A"));
		
		SASuscripcionesBasicasImp.getDAOSuscripciones().altaSuscripcionBasica(new DTOtBasica(numBas,"Agapito", "Yoga",new Date(1,1,1), 1));
		SASuscripcionesPremiumImp.getDAOSuscripciones().altaSuscripcionPremium(new DTOtPremium(numPrem,"Anacleto",1,"11111111A"));
		
		Date d = new Date(1,1,1);
		
		assertEquals("1 1 30 30 Agapito Yoga " + d.toString() + " 1", basicas.leerSuscripcion(1).toString());
		assertEquals("2 2 90 120 Anacleto 1 11111111A", premium.leerSuscripcion(2));
		
		basicas.actualizarSuscripcion(new DTOtBasica(numBas,"Josefa", "Crossfit", new Date(1,1,1), 1));
		SASuscripcionesBasicasImp.getDAOSuscripciones().actualizarSuscripcionBasica(new DTOtBasica(numBas,"Josefa", "Crossfit", new Date(1,1,1), 1));
		
		assertEquals("1 1 30 30 Josefa Crossfit " + d.toString() + " 1", basicas.leerSuscripcion(1));
		basicas.borrarSuscripcion(1);
		
		premium.actualizarSuscripcion(new DTOtPremium(numPrem,"Manuel",2,"22222222B"));
		SASuscripcionesPremiumImp.getDAOSuscripciones().actualizarSuscripcionPremium(new DTOtPremium(numPrem,"Manuel",2,"22222222B"));
		
		List<DTOtSuscripcion> list = premium.leerTodasSuscripciones();
		
		assertEquals("2 2 90 120 Manuel 2 22222222B", list.get(0).toString());
	}

}
