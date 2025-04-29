package integracion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtActividad;

public class DAOActividadesImp implements DAOActividades{

	public int altaActividad(final DTOtActividad actividad) {
	    String query = "INSERT INTO ACTIVIDADES (tipoActividad, fecha, idSala, dniEmpleado) VALUES (?, ?, ?, ?)";
	    try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
	        stmt.setString(1, actividad.getTipoActividad());
	        stmt.setDate(2, actividad.getFecha());
	        stmt.setInt(3, actividad.getIdSala());
	        stmt.setString(4, actividad.getDniEmpleado());
	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	
	public int altaActividadCatalogo(final int idCatalogo, final DTOtActividad actividad) {
	    String query = "INSERT INTO ActividadesCatalogo (idCatalogo, tipoActividad, fechaActividad, idSala) VALUES (?, ?, ?, ?)";
	    try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
	        stmt.setInt(1, idCatalogo);
	        stmt.setString(2, actividad.getTipoActividad());
	        stmt.setDate(3, actividad.getFecha());
	        stmt.setInt(4, actividad.getIdSala());
	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	public DTOtActividad leerActividad(final String tipoActividad, final Date fecha, final int idSala) {
	    String query = "SELECT a.*, ac.idCatalogo FROM ACTIVIDADES a LEFT JOIN ActividadesCatalogo ac ON a.tipoActividad = ac.tipoActividad AND a.fecha = ac.fechaActividad AND a.idSala = ac.idSala WHERE a.tipoActividad = ? AND a.fecha = ? AND a.idSala = ?";
	    try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
	        stmt.setString(1, tipoActividad);
	        stmt.setDate(2, fecha);
	        stmt.setInt(3, idSala);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            String dniEmpleado = rs.getString("dniEmpleado");
	            int idCatalogo = rs.getInt("idCatalogo");
	            if (rs.wasNull()) idCatalogo = 0;
	            DTOtActividad a = new DTOtActividad(tipoActividad, idSala, fecha, dniEmpleado, idCatalogo);
	            return a;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public int actualizarActividad(final DTOtActividad actividad) {
		String query = "UPDATE ACTIVIDADES SET dniEmpleado = ? WHERE tipoActividad  = ? AND fecha = ? AND idSala = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, actividad.getDniEmpleado());
			stmt.setString(2, actividad.getTipoActividad());
			stmt.setDate(3, actividad.getFecha());
			stmt.setInt(4, actividad.getIdSala());
	        return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarActividad(final String tipoActividad, final Date fecha, final int idSala) {
	    String query = "DELETE FROM ACTIVIDADES WHERE tipoActividad = ? AND fecha = ? AND idSala = ?";
	    try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
	        stmt.setString(1, tipoActividad);
	        stmt.setDate(2, fecha);
	        stmt.setInt(3, idSala);
	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	public List<DTOtActividad> leerTodasActividades() {
	    ArrayList<DTOtActividad> actividades = new ArrayList<>();
	    String query = "SELECT a.*, ac.idCatalogo FROM ACTIVIDADES a LEFT JOIN ActividadesCatalogo ac ON a.tipoActividad = ac.tipoActividad AND a.fecha = ac.fechaActividad AND a.idSala = ac.idSala";
	    try (Statement stmt = BDConexion.getConnection().createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {
	        while (rs.next()) {
	            String tipoActividad = rs.getString("tipoActividad");
	            String dniEmpleado = rs.getString("dniEmpleado");
	            int idSala = rs.getInt("idSala");
	            Date fecha = rs.getDate("fecha");
	            int idCatalogo = rs.getInt("idCatalogo");
	            if (rs.wasNull()) idCatalogo = 0;
	            DTOtActividad a = new DTOtActividad(tipoActividad, idSala, fecha, dniEmpleado, idCatalogo);
	            actividades.add(a);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return actividades;
	}

}