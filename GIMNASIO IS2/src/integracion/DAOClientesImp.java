package integracion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtCliente;

public class DAOClientesImp implements DAOClientes {

	public int altaCliente(final DTOtCliente cliente) {
		String query = "INSERT INTO CLIENTES (dniCliente, nombre, direccion) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, cliente.getDni());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getDir());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DTOtCliente leerCliente(final String dni) {
		String query = "SELECT * FROM CLIENTES WHERE dniCliente  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1,dni);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString ("nombre");
				String direccion = rs.getString ("direccion");
				int activo = rs.getInt("activo");
				boolean act = activo == 1 ? true : false;
				DTOtCliente c = new DTOtCliente(dni, name, direccion, act);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarCliente(final DTOtCliente cliente) {
		String query = "UPDATE CLIENTES SET nombre = ?, direccion = ?, activo = ? WHERE dniCliente = ? ";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getDir());
			int activo = cliente.getActivo() == true ? 1 : 0;
			stmt.setInt(3, activo);
			stmt.setString(4, cliente.getDni());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarCliente(final String dni) {
		String query = "UPDATE CLIENTES SET activo = 0 WHERE dniCliente = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, dni);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DTOtCliente> leerTodosClientes() {
		ArrayList<DTOtCliente> clientes = new ArrayList<DTOtCliente>();
		String query = "SELECT * FROM CLIENTES";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				String name = rs.getString ("nombre");
				String dni = rs.getString ("dniCliente");
				String direccion = rs.getString ("direccion");
				int activo = rs.getInt("activo");
				boolean act;
				if(activo == 1) act = true;
				else act = false;
				DTOtCliente c = new DTOtCliente(dni , name , direccion ,act);
				clientes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
}