package negocio;

import java.util.List;

import integracion.DAOActividades;
import integracion.DAOActividadesImp;
import integracion.DAOCatalogos;
import integracion.DAOCatalogosImp;

public class SACatalogosImp implements SACatalogos {

	private static DAOCatalogos catalogosDAO = null;
	private static DAOActividades actividadesDAO = null;

	public static DAOCatalogos getDAOCatalogos() {
		if (catalogosDAO == null) catalogosDAO = new DAOCatalogosImp();
		return catalogosDAO;
	}

	public static DAOActividades getDAOActividades() {
		if (actividadesDAO == null) actividadesDAO = new DAOActividadesImp();
		return actividadesDAO;
	}

	public int altaCatalogo(final DTOtCatalogo catalogo) {
		int idCatalogo = getDAOCatalogos().altaCatalogo(catalogo);
		if (idCatalogo > 0 && catalogo.getActividades() != null) {
			for (DTOtActividad actividad : catalogo.getActividades()) {
				if (actividad.getDniEmpleado() == null || actividad.getDniEmpleado().isBlank()) {
					DTOtActividad original = getDAOActividades().leerActividad(actividad.getTipoActividad(),actividad.getFecha(),actividad.getIdSala());
					if (original != null) actividad.setDniEmpleado(original.getDniEmpleado());
				}
				getDAOActividades().altaActividadCatalogo(idCatalogo, actividad);
				actividad.setIdCatalogo(idCatalogo);
				getDAOActividades().actualizarActividad(actividad);
			}
		}
		return idCatalogo;
	}

	public DTOtCatalogo leerCatalogo(final int id) {
		return getDAOCatalogos().leerCatalogo(id);
	}
	
	public int actualizarCatalogo(final DTOtCatalogo catalogo) {
		DTOtCatalogo c = leerCatalogo(catalogo.getId());
		int exito = 0;
		if (c != null) {
			exito = getDAOCatalogos().actualizarCatalogo(catalogo);
			getDAOCatalogos().borrarActividadesCatalogo(catalogo.getId());
			if (catalogo.getActividades() != null) {
				for (DTOtActividad actividad : catalogo.getActividades()) {
					if (actividad.getDniEmpleado() == null || actividad.getDniEmpleado().isBlank()) {
						DTOtActividad original = getDAOActividades().leerActividad(actividad.getTipoActividad(), actividad.getFecha(),actividad.getIdSala());
						if (original != null) actividad.setDniEmpleado(original.getDniEmpleado());
					}
					getDAOActividades().altaActividadCatalogo(catalogo.getId(), actividad);
					actividad.setIdCatalogo(catalogo.getId());
					getDAOActividades().actualizarActividad(actividad);
				}
			}
		}
		return exito;
	}

	public int borrarCatalogo(final int id) {
		DTOtCatalogo c = leerCatalogo(id);
		int exito = 0;
		if (c != null) {
			exito = getDAOCatalogos().borrarCatalogo(id);
		}
		return exito;
	}

	public int borrarCatalogosSala(final int idSala) {
		return getDAOCatalogos().borrarCatalogosSala(idSala);
	}

	public List<DTOtCatalogo> leerTodosCatalogos() {
		return getDAOCatalogos().leerTodosCatalogos();
	}
}
