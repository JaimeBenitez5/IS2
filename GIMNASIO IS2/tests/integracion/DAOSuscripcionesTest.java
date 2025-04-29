package integracion;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import negocio.DTOtBasica;
import negocio.DTOtPremium;
import negocio.DTOtSuscripcion;

class DAOSuscripcionesTest {

	@SuppressWarnings("deprecation")
	@Test
	void test() {
		DAOSuscripciones daoBas = new DAOSuscripcionesBasicasImp();
		DAOSuscripciones daoPrem = new DAOSuscripcionesPremiumImp();
		
		int numBas = daoBas.altaSuscripcion(new DTOtBasica("Agapito", "Yoga",new Date(1,1,1), 1));
		int numPrem = daoPrem.altaSuscripcion(new DTOtPremium("Anacleto",1,"11111111A"));
		
		daoBas.altaSuscripcionBasica(new DTOtBasica(numBas,"Agapito", "Yoga",new Date(1,1,1), 1));
		daoPrem.altaSuscripcionPremium(new DTOtPremium(numPrem,"Anacleto",1,"11111111A"));
		
		Date d = new Date(1,1,1);
		
		assertEquals("1 1 30 30 Agapito Yoga " + d.toString() + " 1", daoBas.leerSuscripcion(1).toString());
		assertEquals("2 2 90 120 Anacleto 1 11111111A", daoPrem.leerSuscripcion(2));
		
		daoBas.actualizarSuscripcion(new DTOtBasica(numBas,"Josefa", "Crossfit", new Date(1,1,1), 1));
		daoBas.actualizarSuscripcionBasica(new DTOtBasica(numBas,"Josefa", "Crossfit", new Date(1,1,1), 1));
		
		assertEquals("1 1 30 30 Josefa Crossfit " + d.toString() + " 1", daoBas.leerSuscripcion(1));
		daoBas.borrarSuscripcion(1);
		
		daoPrem.actualizarSuscripcion(new DTOtPremium(numPrem,"Manuel",2,"22222222B"));
		daoPrem.actualizarSuscripcionPremium(new DTOtPremium(numPrem,"Manuel",2,"22222222B"));
		
		List<DTOtSuscripcion> list = daoPrem.leerTodasSuscripciones();
		
		assertEquals("2 2 90 120 Manuel 2 22222222B", list.get(0).toString());
	}

}
