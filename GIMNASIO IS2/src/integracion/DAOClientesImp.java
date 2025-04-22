package integracion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.tCliente;

public class DAOClientesImp implements DAOClientes {

	public int altaCliente(tCliente cliente) {
		tCliente c = leerCliente(cliente.getId());
		if(c == null){
			String query = "INSERT INTO Cliente (nombre, dni, direccion) VALUES (?, ?, ?)";
			try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setString(1, cliente.getNombre());
				stmt.setString(2, cliente.getDni());
				stmt.setString(3, cliente.getDir());
				stmt.executeUpdate();
				try (ResultSet rs = stmt.getGeneratedKeys()) {
					if (rs.next()) {
						int idCliente = rs.getInt(1);
						return idCliente;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if (!c.getActivo()) c.setActivo(true);
		return 0;
	}

	public tCliente leerCliente(final int id) {
		String query = "SELECT * FROM Cliente WHERE idCliente  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idCliente = rs.getInt("idCliente");
				String name = rs.getString ("nombre");
				String dni = rs.getString ("dni");
				String direccion = rs.getString ("direccion");
				int activo = rs.getInt("activo");
				boolean act = activo == 1 ? true : false;
				tCliente c = new tCliente(idCliente, dni , name, direccion, act);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarCliente(final tCliente cliente) {
		String query = "UPDATE CLIENTE SET nombre = ?, dni = ?, direccion = ? WHERE idCliente=? ";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getDni());
			stmt.setString(3, cliente.getDir());
			stmt.setInt(4, cliente.getId());
			return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarCliente(final int id) {
		tCliente c = leerCliente(id);
		if(c != null && c.getActivo()) {
			String query = "UPDATE Cliente SET activo = 0 WHERE idCliente = ?";
			try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setInt(1, id);
				return stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public List<tCliente> leerTodosClientes() {
		ArrayList<tCliente> clientes = new ArrayList<tCliente>();
		String query = "SELECT * FROM CLIENTE";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				int idCliente = rs.getInt("idCliente");
				String name = rs.getString ("nombre");
				String dni = rs.getString ("dni");
				String direccion = rs.getString ("direccion");
				int activo = rs.getInt("activo");
				boolean act;
				if(activo == 1) act = true;
				else act = false;
				tCliente c = new tCliente(idCliente, dni , name , direccion ,act);
				clientes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

}