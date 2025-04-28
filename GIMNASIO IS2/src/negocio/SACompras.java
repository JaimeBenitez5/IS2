package negocio;

import java.util.List;

public interface SACompras {
	int altaCompra(final DTOtCompra compra);

	DTOtCompra leerCompra(final int id);

	int actualizarCompra(final DTOtCompra compra);

	int borrarCompra(final int id);

	List<DTOtCompra> leerTodasCompras();
}
