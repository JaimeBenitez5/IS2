package integracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtCatalogo;

public class DAOCatalogosImp implements DAOCatalogos{

	public int altaCatalogo(DTOtCatalogo catalogo) {
		String query = "INSERT INTO Catalogo (numActividades) VALUES (?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, catalogo.getNumActividades());
			stmt.executeUpdate();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int idCatalogo = rs.getInt(1);
					return idCatalogo;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DTOtCatalogo leerCatalogo(int id) {
		String query = "SELECT * FROM Catalogo WHERE idCatalogo  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idCatalogo = rs.getInt("idCatalogo");
				int numActividades = rs.getInt("numActividades");
				DTOtCatalogo s = new DTOtCatalogo(idCatalogo, numActividades);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarCatalogo(DTOtCatalogo catalogo) {
		String query = "UPDATE Catalogo SET numActividades = ? WHERE idCatalogo = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, catalogo.getNumActividades());
			stmt.setInt(2, catalogo.getId());
	        return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int borrarCatalogosSala(int idSala) {
		String query = "DELETE FROM Actividad_Catalogo WHERE idSala = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, idSala);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int borrarCatalogo(int id) {
		String query1 = "DELETE FROM Catalogo WHERE idCatalogo = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query1, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<DTOtCatalogo> leerTodosCatalogos() {
		ArrayList<DTOtCatalogo> catalogos = new ArrayList<DTOtCatalogo>();
		String query = "SELECT * FROM Sala";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				int idCatalogo = rs.getInt("idCatalogo");
				int numActividades = rs.getInt("numActividades");
				DTOtCatalogo c = new DTOtCatalogo(idCatalogo, numActividades);
				catalogos.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catalogos;
	}
}