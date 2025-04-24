package integracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtEmpleado;

public class DAOEmpleadosImp implements DAOEmpleados {

	public int altaEmpleado(DTOtEmpleado empleado) {
		String query = "INSERT INTO Empleado (dni, nombre, sueldo, rol) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, empleado.getDni());
			stmt.setString(2, empleado.getNombre());
			stmt.setDouble(3, empleado.getSueldo());
			stmt.setString(4, "Monitor");
			stmt.executeUpdate();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int idEmpleado = rs.getInt(1);
					return idEmpleado;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DTOtEmpleado leerEmpleado(int id) {
		String query = "SELECT * FROM Empleado WHERE idEmpleado  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idEmpleado = rs.getInt("idEmpleado");
				String name = rs.getString ("dni");
				String dni = rs.getString ("nombre");
				double sueldo = rs.getDouble("sueldo");
				int rol = rs.getInt("rol");
				DTOtEmpleado emp = new DTOtEmpleado(idEmpleado, dni, name, sueldo, rol);
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarEmpleado(DTOtEmpleado empleado) {
		String query = "UPDATE Empleado SET dni = ?, nombre = ?, sueldo = ?, rol = ? WHERE idEmpleado = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, empleado.getNombre());
	        stmt.setString(2, empleado.getDni());
	        stmt.setDouble(3, empleado.getSueldo());
	        stmt.setInt(4, empleado.getRol());
	        stmt.setInt(5, empleado.getId());
	        return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarEmpleado(int id) {
		String query = "DELETE FROM Empleado WHERE idEmpleado = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DTOtEmpleado> leerTodosEmpleados() {
		ArrayList<DTOtEmpleado> clientes = new ArrayList<DTOtEmpleado>();
		String query = "SELECT * FROM CLIENTE WHERE activo = 1";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				int idEmpleado = rs.getInt("idEmpleado");
				String name = rs.getString ("dni");
				String dni = rs.getString ("nombre");
				double sueldo = rs.getInt("sueldo");
				int rol = rs.getInt("rol");
				DTOtEmpleado emp = new DTOtEmpleado(idEmpleado, dni, name, sueldo, rol);
				clientes.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
}