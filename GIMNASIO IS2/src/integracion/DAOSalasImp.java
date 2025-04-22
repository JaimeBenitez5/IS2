package integracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.tSala;

public class DAOSalasImp implements DAOSalas {

	public int altaSala(tSala sala) {
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

	public tSala leerSala(final int id) {
		String query = "SELECT * FROM Sala WHERE idSala  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idSala = rs.getInt("idSala");
				int aforo = rs.getInt("aforo");
				tSala s = new tSala(idSala, aforo);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarSala(final tSala sala) {
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
		//HAY QUE BORRAR ANTES LOS PARES DE ACTIVIDAD Y DE CATALOGO
		//LLAMAR A LAS SA DE CADA SUBSISTEMA Y BORRARLO EN SU DAO
		tSala s = leerSala(id);
		if(s != null) {
			String query1 = "DELETE FROM Actividad_Catalogo WHERE idSala = ?";
			try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query1, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			String query2 = "DELETE FROM Actividad WHERE idSala = ?";
			try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query2, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String query3 = "DELETE FROM Sala WHERE idSala = ?";
			try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query3, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setInt(1, id);
				return stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public List<tSala> leerTodasSalas() {
		ArrayList<tSala> salas = new ArrayList<tSala>();
		String query = "SELECT * FROM Sala";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				int idSala = rs.getInt("idSala");
				int aforo = rs.getInt("aforo");
				tSala s = new tSala(idSala, aforo);
				salas.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salas;
	}

}