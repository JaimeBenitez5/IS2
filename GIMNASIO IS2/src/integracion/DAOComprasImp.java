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


	public int altaCompra(DTOtCompra compra) {
		String insertCompra = "INSERT INTO Compras (numSuscripcion, dniCliente, fecha,metodoPago,numFactura ,dniEmpleado) VALUES (?,?,?,?,?,?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(insertCompra, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, null);
			stmt.setString(2, compra.getDniCliente());
			stmt.setDate(3, (Date) compra.getFecha());
			stmt.setString(4, compra.getMetodoPago());
			stmt.setInt(5, compra.getIdFactura());
			stmt.setString(6,compra.getDniEmpleado());
			
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int idSuscripcion = rs.getInt(1);
					return idSuscripcion;
				}
			}
			stmt.executeUpdate();
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return 0;
	}

	public DTOtCompra leerCompra(int id) {
		String leerCompra = "SELECT * FROM SUSCRIPCIONES s JOIN COMPRAS c ON s.numSuscripcion = c.numSuscripcion WHERE c.idCompra = ?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(leerCompra)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            List<Integer> suscripciones = new ArrayList<>();
            int aforo = 0;
            while (rs.next()) {
                suscripciones.add(rs.getInt("numSuscripcion"));
            }
            if (!suscripciones.isEmpty()) {
				String idCliente= rs.getString("dniCliente");
				Date date = rs.getDate("fecha");
				String metodoPago= rs.getString("metodoPago");
				int idFactura = rs.getInt("numFactura");
				String dniEmpleado=rs.getString("dniEmpleado");
                String[] dniEmpleadosArray = suscripciones.toArray(new String[0]);
                return new DTOtCompra(id,dniEmpleado,idFactura,suscripciones,idCliente,date,metodoPago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
	}

	@Override
	public int actualizarCompra(DTOtCompra compra) {
		String query = "UPDATE COMPRAS SET  dniCliente = ? , fecha = ? , metodoPago = ?, numFactura = ? , dniEmpleado = ? WHERE numSuscripcion = ? ";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, compra.getIdCliente());
			stmt.setDate(2, (Date) compra.getFecha());
			stmt.setString(3, compra.getMetodoPago());
			stmt.setInt(4, compra.getIdFactura());
			stmt.setString(5,compra.getIdCliente());
			return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarCompra(int id) {
		String query = "DELETE FROM Compras WHERE numSuscripcion = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<DTOtCompra> leerTodasCompras() {
		ArrayList<DTOtCompra> compra = new ArrayList<DTOtCompra>();
		String query = "SELECT * FROM COMPRAS";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				List<Integer> numSuscripcion= new ArrayList<Integer>() ;
						//rs.getInt("numSuscripcion");
				String idCliente= rs.getString("dniCliente");
				Date date = rs.getDate("fecha");
				String metodoPago= rs.getString("metodoPago");
				int idFactura = rs.getInt("numFactura");
				String dniEmpleado=rs.getString("dniEmpleado");
				DTOtCompra e = new DTOtCompra(dniEmpleado,idFactura,numSuscripcion,idCliente,date,metodoPago);
				compra.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compra;
	}

}
