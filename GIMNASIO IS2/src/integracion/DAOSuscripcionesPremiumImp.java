package integracion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import configFiles.BDConexion;
import negocio.DTOtBasica;
import negocio.DTOtPremium;
import negocio.DTOtSuscripcion;

public class DAOSuscripcionesPremiumImp implements DAOSuscripciones {

    public int altaSuscripcion(final DTOtSuscripcion suscripcion) {
        String query = "INSERT INTO Suscripciones (nombre, idTipoSuscripcion) VALUES (?, ?)";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, suscripcion.getNombre());
            stmt.setInt(2, suscripcion.getTipoSus());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int altaSuscripcionPremium(final DTOtPremium premium) {
        String query = "INSERT INTO Premium (idTipoSuscripcion, numSuscripcion, precio, duracion, dniEmpleado, idCatalogo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, premium.getTipoSus());
            stmt.setInt(2, premium.getIdSuscripcion());
            stmt.setDouble(3, premium.getPrecio());
            stmt.setInt(4, premium.getDuracion());
            stmt.setString(5, premium.getDniEmpleado());
            stmt.setInt(6, premium.getIdCatalogo());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public DTOtSuscripcion leerSuscripcion(final int id) {
        String query = "SELECT s.numSuscripcion, s.nombre, s.idTipoSuscripcion, p.precio, p.duracion, p.dniEmpleado, p.idCatalogo FROM Suscripciones s JOIN Premium p ON s.numSuscripcion = p.numSuscripcion WHERE s.numSuscripcion = ? ";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	int numSus = rs.getInt("numSuscripcion");
                String nombre = rs.getString("nombre");
                String dniEmp = rs.getString("dniEmpleado");
                int idCat = rs.getInt("idCatalogo");
            	DTOtPremium premium = new DTOtPremium(numSus, nombre, idCat, dniEmp);
                return premium;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int actualizarSuscripcion(final DTOtSuscripcion suscripcion) {
        String query = "UPDATE Suscripciones SET nombre = ?, idTipoSuscripcion = ? WHERE numSuscripcion = ?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setString(1, suscripcion.getNombre());
            stmt.setInt(2, suscripcion.getTipoSus());
            stmt.setInt(3, suscripcion.getIdSuscripcion());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int actualizarSuscripcionPremium(final DTOtPremium premium) {
        String query = "UPDATE Premium SET precio = ?, duracion = ?, dniEmpleado = ?, idCatalogo = ? WHERE numSuscripcion = ?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setDouble(1, premium.getPrecio());
            stmt.setInt(2, premium.getDuracion());
            stmt.setString(3, premium.getDniEmpleado());
            stmt.setInt(4, premium.getIdCatalogo());
            stmt.setInt(5, premium.getIdSuscripcion());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int borrarSuscripcion(final int id) {
        String query = "DELETE FROM Suscripciones WHERE numSuscripcion = ?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<DTOtSuscripcion> leerTodasSuscripciones() {
        List<DTOtSuscripcion> lista = new ArrayList<>();
        String query = "SELECT s.numSuscripcion, s.nombre, s.idTipoSuscripcion, p.precio, p.duracion, p.dniEmpleado, p.idCatalogo FROM Suscripciones s JOIN Premium p ON s.numSuscripcion = p.numSuscripcion";
        try (Statement stmt = BDConexion.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
            	int numSus = rs.getInt("numSuscripcion");
                String nombre = rs.getString("nombre");
                String dniEmp = rs.getString("dniEmpleado");
                int idCat = rs.getInt("idCatalogo");
            	DTOtPremium premium = new DTOtPremium(numSus, nombre, idCat, dniEmp);
                lista.add(premium);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

	public int altaSuscripcionBasica(final DTOtBasica basica) {
		return 0;
	}

	public int actualizarSuscripcionBasica(final DTOtBasica basica) {
		return 0;
	}
}
