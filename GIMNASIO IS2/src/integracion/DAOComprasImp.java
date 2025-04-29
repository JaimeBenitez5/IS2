package integracion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtCompra;

public class DAOComprasImp implements DAOCompras {

	public int altaCompra(final DTOtCompra compra) {
		String insertCompra = "INSERT INTO Compras (numSuscripcion, dniCliente, fecha, metodoPago, dniEmpleado, numFactura) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(insertCompra, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, compra.getSuscripcion());
			stmt.setString(2, compra.getDniCliente());
			stmt.setDate(3, compra.getFecha());
			stmt.setString(4, compra.getMetodoPago());
			stmt.setString(5, compra.getDniEmpleado());
			stmt.setInt(6, compra.getIdFactura());
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
	
	public DTOtCompra leerCompra(final int id) {
		String query = "SELECT * FROM COMPRAS WHERE idCompra = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idCompra = rs.getInt("idCompra");
				int numSuscripcion = rs.getInt("numSuscripcion");
				String dniCliente = rs.getString("dniCliente");
				Date fecha = rs.getDate("fecha");
				String metodoPago = rs.getString("metodoPago");
				String dniEmpleado = rs.getString("dniEmpleado");
				int numFactura = rs.getInt("numFactura");
				DTOtCompra compra = new DTOtCompra(idCompra, numSuscripcion, dniCliente, fecha, metodoPago, dniEmpleado, numFactura);
				return compra;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int actualizarCompra(final DTOtCompra compra) {
		String query = "UPDATE COMPRAS SET numSuscripcion = ?, dniCliente = ?, fecha = ?, metodoPago = ?, dniEmpleado = ? WHERE idCompra = ? ";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, compra.getSuscripcion());
			stmt.setString(2, compra.getDniCliente());
			stmt.setDate(3, compra.getFecha());
			stmt.setString(4, compra.getMetodoPago());
			stmt.setString(5, compra.getDniEmpleado());
			stmt.setInt(6, compra.getId());
			return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int borrarCompra(final int id) {
		String query = "DELETE FROM Compras WHERE idCompra = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<DTOtCompra> leerTodasCompras() {
		List<DTOtCompra> compras = new ArrayList<>();
		String query = "SELECT * FROM Compras ORDER BY idCompra";
		try (Statement stmt = BDConexion.getConnection().createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				int idCompra = rs.getInt("idCompra");
				int numSuscripcion = rs.getInt("numSuscripcion");
				String dniCliente = rs.getString("dniCliente");
				Date fecha = rs.getDate("fecha");
				String metodoPago = rs.getString("metodoPago");
				String dniEmpleado = rs.getString("dniEmpleado");
				int numFactura = rs.getInt("numFactura");
				DTOtCompra compra = new DTOtCompra(idCompra, numSuscripcion, dniCliente, fecha, metodoPago, dniEmpleado, numFactura);
				compras.add(compra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compras;
	}
}
