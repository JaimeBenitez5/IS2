package negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SAComprasTest {
	
	static SACompras compras;
	static int idSuscripcion;
	static Date d1;
	
	@BeforeAll
	static void init() {
		compras = new SAComprasImp();
		d1 = new Date(25,25,25);
	}

	@Test
	void test() {
		compras.altaCompra(new DTOtCompra(idSuscripcion, "11111111A",d1,"Efectivo","99999999K"));
	}

}
