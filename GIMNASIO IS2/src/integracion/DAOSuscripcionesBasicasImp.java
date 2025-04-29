package integracion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtBasica;
import negocio.DTOtPremium;
import negocio.DTOtSuscripcion;

public class DAOSuscripcionesBasicasImp implements DAOSuscripciones {
	
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
	
	public int altaSuscripcionBasica(final DTOtBasica basica) {
	    String query = "INSERT INTO Basica (idTipoSuscripcion, numSuscripcion, precio, duracion, tipoActividad, fecha, idSala) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
	        stmt.setInt(1, basica.getTipoSus());
	        stmt.setInt(2, basica.getIdSuscripcion());
	        stmt.setDouble(3, basica.getPrecio());
	        stmt.setInt(4, basica.getDuracion());
	        stmt.setString(5, basica.getTipoActividad());
	        stmt.setDate(6, basica.getFecha());
	        stmt.setInt(7, basica.getIdSala());
	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}


    public DTOtSuscripcion leerSuscripcion(final int id) {
    	String query = "SELECT s.numSuscripcion, s.nombre, s.idTipoSuscripcion, b.precio, b.duracion, b.tipoActividad, b.fecha, b.idSala FROM Suscripciones s JOIN Basica b ON s.numSuscripcion = b.numSuscripcion WHERE s.numSuscripcion = ?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	int numSus = rs.getInt("numSuscripcion");
                String nombre = rs.getString("nombre");
                String tipoAct = rs.getString("tipoActividad");
                Date fecha = rs.getDate("fecha");
                int idSala = rs.getInt("idSala");
                DTOtBasica basica = new DTOtBasica(numSus, nombre, tipoAct, fecha, idSala);
                return basica;
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
    
    public int actualizarSuscripcionBasica(final DTOtBasica basica) {
        String query = "UPDATE Basica SET precio = ?, duracion = ?, tipoActividad = ?, fecha = ?, idSala = ? WHERE numSuscripcion = ?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setDouble(1, basica.getPrecio());
            stmt.setInt(2, basica.getDuracion());
            stmt.setString(3, basica.getTipoActividad());
            stmt.setDate(4, basica.getFecha());
            stmt.setInt(5, basica.getIdSala());
            stmt.setInt(6, basica.getIdSuscripcion());
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
        String query = "SELECT s.numSuscripcion, s.nombre, s.idTipoSuscripcion, b.precio, b.duracion, b.tipoActividad, b.fecha, b.idSala FROM Suscripciones s JOIN Basica b ON s.numSuscripcion = b.numSuscripcion";
        try (Statement stmt = BDConexion.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int numSus = rs.getInt("numSuscripcion");
                String nombre = rs.getString("nombre");
                String tipoAct = rs.getString("tipoActividad");
                Date fecha = rs.getDate("fecha");
                int idSala = rs.getInt("idSala");
                DTOtBasica basica = new DTOtBasica(numSus, nombre, tipoAct, fecha, idSala);
                lista.add(basica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

	public int altaSuscripcionPremium(final DTOtPremium premium) {
		return 0;
	}

	public int actualizarSuscripcionPremium(final DTOtPremium premium) {
		return 0;
	}

}
