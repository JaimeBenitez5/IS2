package integracion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.tActividad;

public class DAOActividadesImp implements DAOActividades{

	public int altaActividad(tActividad actividad) {
		String query = "INSERT INTO Actividad (tipoActividad, fecha, idSala, idEmpleado) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, actividad.getTipoActividad());
			stmt.setDate(2, actividad.getFecha());
			stmt.setInt(3, actividad.getIdSala());
			stmt.setInt(4, actividad.getIdEmpleado());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public tActividad leerActividad(final String tipoActividad, final Date fecha, final int idSala) {
		String query = "SELECT * FROM Actividad WHERE tipoActividad  = ? AND fecha = ? AND idSala = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, tipoActividad);
			stmt.setDate(2, fecha);
			stmt.setInt(3, idSala);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idEmpleado = rs.getInt("idEmpleado");
				tActividad a = new tActividad(tipoActividad, idEmpleado, idSala, fecha);
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarActividad(tActividad actividad) {
		String query = "UPDATE Actividad SET idEmpleado = ? WHERE tipoActividad  = ? AND fecha = ? AND idSala = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, actividad.getIdEmpleado());
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
		String query1 = "DELETE FROM Actividade WHERE tipoActividad = ?, fecha = ?, idSala = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query1, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, tipoActividad);
			stmt.setDate(2, fecha);
			stmt.setInt(3, idSala);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<tActividad> leerTodasActividades() {
		ArrayList<tActividad> actividades = new ArrayList<tActividad>();
		String query = "SELECT * FROM Actividad";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				String tipoActividad = rs.getString("tipoActividad");
				int idEmpleado = rs.getInt("idEmpleado");
				int idSala = rs.getInt("idSala");
				Date fecha = rs.getDate("fecha");
				tActividad a = new tActividad(tipoActividad, idEmpleado, idSala, fecha);
				actividades.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
	}

}