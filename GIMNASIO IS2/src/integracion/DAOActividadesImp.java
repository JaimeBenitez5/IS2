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

	public int altaActividad(DTOtActividad actividad) {
		String query = "INSERT INTO ACTIVIDADES (tipoActividad, fecha, idSala, dniEmpleado) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, actividad.getTipoActividad());
			stmt.setDate(2, actividad.getFecha());
			stmt.setInt(3, actividad.getIdSala());
			String dni = actividad.getDniEmpleado();
			if(dni != null && dni != "") stmt.setString(4, actividad.getDniEmpleado());
			else stmt.setString(4, "");
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DTOtActividad leerActividad(final String tipoActividad, final Date fecha, final int idSala) {
		String query = "SELECT * FROM ACTIVIDADES WHERE tipoActividad  = ? AND fecha = ? AND idSala = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, tipoActividad);
			stmt.setDate(2, fecha);
			stmt.setInt(3, idSala);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String dniEmpleado = rs.getString("dniEmpleado");
				DTOtActividad a = new DTOtActividad(tipoActividad, dniEmpleado, idSala, fecha);
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarActividad(DTOtActividad actividad) {
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

	public int borrarActividadesSala(int idSala) {
		String query = "DELETE FROM ACTIVIDADES WHERE idSala = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, idSala);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int borrarActividad(final String tipoActividad, final Date fecha, final int idSala) {
		String query = "DELETE FROM ACTIVIDADES WHERE tipoActividad = ? AND fecha = ? AND idSala = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, tipoActividad);
			stmt.setDate(2, fecha);
			stmt.setInt(3, idSala);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DTOtActividad> leerTodasActividades() {
		ArrayList<DTOtActividad> actividades = new ArrayList<DTOtActividad>();
		String query = "SELECT * FROM ACTIVIDADES";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				String tipoActividad = rs.getString("tipoActividad");
				String dniEmpleado = rs.getString("dniEmpleado");
				int idSala = rs.getInt("idSala");
				Date fecha = rs.getDate("fecha");
				DTOtActividad a = new DTOtActividad(tipoActividad, dniEmpleado, idSala, fecha);
				actividades.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
	}

}