package integracion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtActividad;
import negocio.DTOtCatalogo;

public class DAOCatalogosImp implements DAOCatalogos {

	public int altaCatalogo(final DTOtCatalogo catalogo) {
		String query = "INSERT INTO CATALOGOS (numActividades) VALUES (?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, catalogo.getNumActividades());
			stmt.executeUpdate();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DTOtCatalogo leerCatalogo(final int id) {
	    String query = """
	        SELECT c.idCatalogo, c.numActividades,
	               a.tipoActividad, a.fecha, a.idSala, a.dniEmpleado
	        FROM CATALOGOS c
	        LEFT JOIN ActividadesCatalogo ac ON c.idCatalogo = ac.idCatalogo
	        LEFT JOIN Actividades a ON ac.tipoActividad = a.tipoActividad AND ac.fechaActividad = a.fecha AND ac.idSala = a.idSala
	        WHERE c.idCatalogo = ?
	    """;
	    DTOtCatalogo catalogo = null;
	    ArrayList<DTOtActividad> actividades = new ArrayList<>();
	    try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            if (catalogo == null) {
	                int numActividades = rs.getInt("numActividades");
	                catalogo = new DTOtCatalogo(id, numActividades);
	            }
	            String tipoActividad = rs.getString("tipoActividad");
	            Date fecha = rs.getDate("fecha");
	            int idSala = rs.getInt("idSala");
	            String dniEmpleado = rs.getString("dniEmpleado");
	            if (tipoActividad != null && fecha != null) {
	                DTOtActividad actividad = new DTOtActividad(tipoActividad, idSala, fecha, dniEmpleado, id);
	                actividades.add(actividad);
	            }
	        }
	        if (catalogo != null) {
	            catalogo.setActividades(actividades);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return catalogo;
	}

	public int actualizarCatalogo(final DTOtCatalogo catalogo) {
		String query = "UPDATE CATALOGOS SET numActividades = ? WHERE idCatalogo = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, catalogo.getNumActividades());
			stmt.setInt(2, catalogo.getId());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarCatalogo(final int id) {
		String query = "DELETE FROM CATALOGOS WHERE idCatalogo = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarCatalogosSala(final int idSala) {
		String query = "DELETE FROM ACTIVIDADESCATALOGO WHERE idSala = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, idSala);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarActividadesCatalogo(final int idCatalogo) {
		String query = "DELETE FROM ActividadesCatalogo WHERE idCatalogo = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, idCatalogo);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DTOtCatalogo> leerTodosCatalogos() {
	    List<DTOtCatalogo> catalogos = new ArrayList<>();
	    String query = """
	        SELECT c.idCatalogo, c.numActividades, a.tipoActividad, a.fecha, a.idSala, a.dniEmpleado
	        FROM CATALOGOS c LEFT JOIN ActividadesCatalogo ac ON c.idCatalogo = ac.idCatalogo
	        LEFT JOIN Actividades a ON ac.tipoActividad = a.tipoActividad AND ac.fechaActividad = a.fecha AND ac.idSala = a.idSala
	        ORDER BY c.idCatalogo
	    """;
	    try (Statement stmt = BDConexion.getConnection().createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {
	        int catalogoActual = -1;
	        DTOtCatalogo catalogo = null;
	        ArrayList<DTOtActividad> actividades = new ArrayList<>();
	        while (rs.next()) {
	            int idCatalogo = rs.getInt("idCatalogo");
	            int numActividades = rs.getInt("numActividades");
	            if (idCatalogo != catalogoActual) {
	                if (catalogo != null) {
	                    catalogo.setActividades(actividades);
	                    catalogos.add(catalogo);
	                }
	                catalogo = new DTOtCatalogo(idCatalogo, numActividades);
	                actividades = new ArrayList<>();
	                catalogoActual = idCatalogo;
	            }
	            String tipoActividad = rs.getString("tipoActividad");
	            Date fecha = rs.getDate("fecha");
	            int idSala = rs.getInt("idSala");
	            String dniEmpleado = rs.getString("dniEmpleado");
	            if (tipoActividad != null && fecha != null) {
	                DTOtActividad actividad = new DTOtActividad(tipoActividad, idSala, fecha, dniEmpleado, idCatalogo);
	                actividades.add(actividad);
	            }
	        }
	        if (catalogo != null) {
	            catalogo.setActividades(actividades);
	            catalogos.add(catalogo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return catalogos;
	}
}
