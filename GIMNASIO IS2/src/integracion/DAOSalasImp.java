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
		String insertSala = "INSERT INTO SALAS (aforo) VALUES (?)";
		String insertMantenedor = "INSERT INTO MANTIENEN (dniEmpleado, idSala) VALUES (?, ?)";
		try (PreparedStatement stmt1 = BDConexion.getConnection().prepareStatement(insertSala);
				PreparedStatement stmt2 = BDConexion.getConnection().prepareStatement(insertMantenedor)){
			stmt1.setString(1, String.valueOf(sala.getAforo()));
			stmt1.executeUpdate();
			try (ResultSet rs = stmt1.getGeneratedKeys()) {
				if (rs.next()) {
					int idSala = rs.getInt(1);
					stmt2.setString(1, sala.getDniEmpleado());
					stmt2.setInt(2, idSala);
					return idSala;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DTOtSala leerSala(final int id) {
		String leerSala = "SELECT * FROM SALAS WHERE idSala  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(leerSala)) {
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
	
	//LEER SALAS POR EMPLEADO

	public int actualizarSala(final DTOtSala sala) {
		String query = "UPDATE SALAS SET aforo = ? WHERE idSala=?";
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
		String query = "DELETE FROM SALAS WHERE idSala = ?";
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
		String query = "SELECT * FROM SALAS";
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