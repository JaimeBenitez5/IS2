package integracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtSala;
import negocio.DTOtSuscripcion;

public class DAOSuscripcionesImp implements DAOSuscripciones {
	public int altaSuscripcion(DTOtSuscripcion suscripcion) {
		String query = "INSERT INTO SUSCRIPCIONES (aforo) VALUES (?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, String.valueOf(suscripcion.getPrecio()));
			stmt.setString(2, String.valueOf(suscripcion.getDuracion()));
			stmt.executeUpdate();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int idSuscripcion = rs.getInt(1);
					return idSuscripcion;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DTOtSuscripcion leerSuscripcion(final int id) {
		String query = "SELECT * FROM SUSCRIPCIONES WHERE idSuscripcion  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idSuscripcion = rs.getInt("idSala");
				int duracion = rs.getInt("duracion");
				int precio = rs.getInt("precio");
				DTOtSuscripcion s = new DTOtSuscripcion(idSuscripcion, duracion,precio);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarSuscripcion	(final DTOtSuscripcion suscripcion) {
		String query = "UPDATE SUSCRIPCIONES SET aforo = ? WHERE idSuscripcion=?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, String.valueOf(suscripcion.getDuracion()));
			stmt.setString(3, String.valueOf(suscripcion.getPrecio()));
			stmt.setInt(2,suscripcion.getId());
			return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarSuscripcion(final int id) {
		String query = "DELETE FROM SUSCRIPCION WHERE idSuscripcion = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DTOtSuscripcion> leerTodasSuscripciones() {
		ArrayList<DTOtSuscripcion> suscripcion = new ArrayList<DTOtSuscripcion>();
		String query = "SELECT * FROM SUSCRIPCION";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				int idSuscripcion = rs.getInt("idSuscripcion");
				int duracion = rs.getInt("duracion");
				double precio = rs.getDouble("precio");
				DTOtSuscripcion s = new DTOtSuscripcion(idSuscripcion, duracion,(int) precio);
				suscripcion.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suscripcion;
	}

}
