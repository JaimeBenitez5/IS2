package negocio;

import java.util.List;

import integracion.DAOCatalogos;
import integracion.DAOCatalogosImp;
import integracion.DAOEmpleados;
import integracion.DAOEmpleadosImp;
import integracion.DAOSalas;
import integracion.DAOSalasImp;

public class SASalasImp implements SASalas {

	private static DAOSalas salasDAO = null;
	private static DAOEmpleados empleadosDAO = null;
	private static DAOCatalogos catalogosDAO = null;

	//USADO PATRON SINGLETON
	public static DAOSalas getDAOSalas(){
		if(salasDAO == null) salasDAO = new DAOSalasImp();
		return salasDAO;
	}
	public static DAOEmpleados getDAOEmpleados(){
		if(empleadosDAO == null) empleadosDAO = new DAOEmpleadosImp();
		return empleadosDAO;
	}
	public static DAOCatalogos getDAOCatalogos(){
		if(catalogosDAO == null) catalogosDAO = new DAOCatalogosImp();
		return catalogosDAO;
	}

	public int altaSala(final DTOtSala sala) {
		//compruebo que no existe
		DTOtSala s = leerSala(sala.getId());
		int idSala = 0;
		if (s == null) {
			String[] empleados = sala.getDniEmpleados();
			if (todosSonMantenimiento(empleados)) {
				idSala = getDAOSalas().altaSala(sala);
				sala.setId(idSala);
				if (idSala != 0) {
					getDAOSalas().altaMantenedor(sala);
				}
			}
		}
		return idSala;
	}

	private Boolean todosSonMantenimiento(String[] empleados) {
		boolean todosSonMantenimiento = true;
		int i = 0;
		while (i < empleados.length && todosSonMantenimiento) {
			String dni = empleados[i];
			int idRolEmp = getDAOEmpleados().leerEmpleadoRol(dni);
			if (idRolEmp != 1) todosSonMantenimiento = false;
			i++;
		}
		return todosSonMantenimiento;
	}
	
	public DTOtSala leerSala(final int id) {
		return getDAOSalas().leerSala(id);
	}

	public int actualizarSala(final DTOtSala sala) {
		DTOtSala s = leerSala(sala.getId());
		int exito = 0;
		if(s != null) {
			exito = getDAOSalas().actualizarSala(sala);
			if(exito != 0) getDAOSalas().actualizarMantenedor(sala);
		}
		return exito;
	}

	public int borrarSala(final int id) {
		DTOtSala s = leerSala(id);
		int exito = 0;
		if(s != null) {
			//EL ORDEN DE BORRADO DE AQUI ABAJO ES IMPORTANTE
			exito = getDAOCatalogos().borrarCatalogosSala(id);
			//LAS ACTIVIDADEDS SE BORRAN CON ON CASCADE
			if(exito == 1) exito = getDAOSalas().borrarSala(id);
		}
		return exito;
	}

	public List<DTOtSala> leerTodasSalas() {
		return getDAOSalas().leerTodasSalas();
	}

}
