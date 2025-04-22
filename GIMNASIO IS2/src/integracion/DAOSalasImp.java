package integracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtSala;

public class DAOSalasImp implements DAOSalas {

	public int altaSala(DTOtSala sala) {
		String query = "INSERT INTO Sala (aforo) VALUES (?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, String.valueOf(sala.getAforo()));
			stmt.executeUpdate();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int idSala = rs.getInt(1);
					return idSala;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DTOtSala leerSala(final int id) {
		String query = "SELECT * FROM Sala WHERE idSala  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idSala = rs.getInt("idSala");
				int aforo = rs.getInt("aforo");
				DTOtSala s = new DTOtSala(idSala, aforo);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarSala(final DTOtSala sala) {
		String query = "UPDATE Sala SET aforo = ? WHERE idSala=?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, String.valueOf(sala.getAforo()));
			stmt.setInt(2,sala.getId());
			return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarSala(final int id) {
		String query = "DELETE FROM Sala WHERE idSala = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DTOtSala> leerTodasSalas() {
		ArrayList<DTOtSala> salas = new ArrayList<DTOtSala>();
		String query = "SELECT * FROM Sala";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				int idSala = rs.getInt("idSala");
				int aforo = rs.getInt("aforo");
				DTOtSala s = new DTOtSala(idSala, aforo);
				salas.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salas;
	}

}