package integracion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtFactura;

public class DAOFacturasImp implements DAOFacturas {

	public int altaFactura(DTOtFactura Factura) {
		String query = "INSERT INTO Factura (fecha, importetotal) VALUES (?, ?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setDate(1, Factura.getFecha());
			stmt.setDouble(2, Factura.getImporte());
			stmt.executeUpdate();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int idFactura = rs.getInt(1);
					return idFactura;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DTOtFactura leerFactura(int id) {
		String query = "SELECT * FROM Factura WHERE numFactura = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int numFactura = rs.getInt("numFactura");
				Date fecha = rs.getDate("fecha");
				Double importe = rs.getDouble("importeTotal");

				DTOtFactura c = new DTOtFactura(numFactura, fecha , importe);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarFactura(DTOtFactura factura) {
		String query = "UPDATE Factura SET fecha = ?, importeTotal = ? WHERE numFactura = ? ";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setDate(1, factura.getFecha());
	        stmt.setDouble(2, factura.getImporte());
	        stmt.setInt(3, factura.getId());
	        return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarFactura(int id) {
		String query = "DELETE FROM Factura WHERE numFactura = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DTOtFactura> leerTodasFacturas() {
		ArrayList<DTOtFactura> facturas = new ArrayList<DTOtFactura>();
		String query = "SELECT * FROM Factura";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				int numFactura = rs.getInt("numFactura");
				Date fecha = rs.getDate("fecha");
				Double imp = rs.getDouble("importeTotal");
				DTOtFactura f = new DTOtFactura(numFactura, fecha, imp);
				facturas.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facturas;
	}
	
	public List<DTOtFactura> leerFacturasCliente(int idCliente){
		ArrayList<DTOtFactura> facturas = new ArrayList<DTOtFactura>();
		String query = "SELECT * FROM Factura WHERE numFactura = (SELECT numFactura FROM Compra WHERE idCliente = ?)";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, idCliente);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				int numFactura = rs.getInt("numFactura");
				Date fecha = rs.getDate("fecha");
				Double imp = rs.getDouble("importeTotal");
				DTOtFactura f = new DTOtFactura(numFactura, fecha, imp);
				facturas.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return facturas;
	}
}