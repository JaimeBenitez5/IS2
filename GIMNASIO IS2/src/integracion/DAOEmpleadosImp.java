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
		String query = "INSERT INTO EMPLEADOS (dniEmpleado, nombre) VALUES (?, ?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, empleado.getDni());
			stmt.setString(2, empleado.getNombre());
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

	public DTOtEmpleado leerEmpleado(String dni) {
		String query = "SELECT * FROM EMPLEADOS WHERE dniEmpleado  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1,dni);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String nombre = rs.getString ("nombre");
				DTOtEmpleado emp = new DTOtEmpleado(dni, nombre);
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int actualizarEmpleado(DTOtEmpleado empleado) {
		String query = "UPDATE EMPLEADOS SET nombre = ? WHERE dniEmpleado = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, empleado.getNombre());
	        stmt.setString(2, empleado.getDni());
	        return stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarEmpleado(String dni) {
		String query = "DELETE FROM EMPLEADOS WHERE dniEmpleado = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, dni);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DTOtEmpleado> leerTodosEmpleados() {
		ArrayList<DTOtEmpleado> clientes = new ArrayList<DTOtEmpleado>();
		String query = "SELECT * FROM EMPLEADOS";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				String dniEmpleado = rs.getString("dniEmpleado");
				String name = rs.getString ("nombre");
				DTOtEmpleado emp = new DTOtEmpleado(dniEmpleado, name);
				clientes.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
}