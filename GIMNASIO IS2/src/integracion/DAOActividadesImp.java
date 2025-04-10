package integracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import configFiles.BDConexion;
import negocio.tActividad;

public class DAOActividadesImp implements DAOActividades{

	public int altaActividad(tActividad actividad) {
		String query = "INSERT INTO Actividad (tipoActividad, fecha, idSala, dniEmpleado) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, actividad.get_tipoActividad());
			stmt.setDate(2, actividad.get_fecha());
			stmt.setInt(3, actividad.getIdSala());
			stmt.setString(4, actividad.get_dniEmpleado());
			stmt.executeUpdate();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int idActividad = rs.getInt(1);
					return idActividad;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public tActividad leerActividad(int id) {
		return null;
	}

	public int actualizarActividad(tActividad actividad) {
		return 0;
	}

	public int borrarActividad(int id) {
		return 0;
	}

	public List<tActividad> leerTodasActividades() {
		return null;
	}

}
