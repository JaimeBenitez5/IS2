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

	public int altaSala(final DTOtSala sala) {
		String insertSala = "INSERT INTO SALAS (aforo) VALUES (?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(insertSala, Statement.RETURN_GENERATED_KEYS)){
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
	
	public int altaMantenedor(DTOtSala sala) {
		String insertMantenedor = "INSERT INTO MANTIENEN (dniEmpleado, idSala) VALUES (?, ?)";
		try(PreparedStatement stmt = BDConexion.getConnection().prepareStatement(insertMantenedor)){
			stmt.setString(1, sala.getDniEmpleado());
			stmt.setInt(2, sala.getId());
			return stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public DTOtSala leerSala(final int id) {
		String leerSala = "SELECT e.dniEmpleado, s.idSala, s.aforo FROM Empleados e JOIN SALAS s JOIN MANTIENEN m ON e.dniEmpleado = m.dniEmpleado AND s.idSala = m.idSala WHERE s.idSala = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(leerSala)) {
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String dniEmp = rs.getString("dniEmpleado");
				int idSala = rs.getInt("idSala");
				int aforo = rs.getInt("aforo");
				
				DTOtSala s = new DTOtSala(idSala, aforo, dniEmp);
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
	
	public int actualizarMantenedor(final DTOtSala sala) {
		String query = "UPDATE MANTIENEN SET dniEmpleado = ? WHERE idSala=?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, sala.getDniEmpleado());
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
		String query = "SELECT e.dniEmpleado, s.idSala, s.aforo FROM Empleados e JOIN SALAS s JOIN MANTIENEN m ON e.dniEmpleado = m.dniEmpleado AND s.idSala = m.idSala";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				String dniEmp = rs.getString("dniEmpleado");
				int idSala = rs.getInt("idSala");
				int aforo = rs.getInt("aforo");
				DTOtSala s = new DTOtSala(idSala, aforo, dniEmp);
				salas.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salas;
	}

}