package integracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configFiles.BDConexion;
import negocio.DTOtCliente;
import negocio.DTOtEmpleado;
import negocio.DTOtRol;

public class DAOEmpleadosImp implements DAOEmpleados {

	public int altaEmpleado(DTOtEmpleado empleado) {
		String insertEmpleado = "INSERT INTO Empleados (dniEmpleado, nombre) VALUES (?, ?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(insertEmpleado)){
			stmt.setString(1, empleado.getDni());
			stmt.setString(2, empleado.getNombre());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int altaEmpleadoRol(DTOtEmpleado empleado) {
		String insertRol = "INSERT INTO EmpleadosRoles (dniEmpleado, idRol) VALUES (?, ?)";
		try(PreparedStatement stmt = BDConexion.getConnection().prepareStatement(insertRol)){
			stmt.setString(1, empleado.getDni());
			stmt.setInt(2, empleado.getRolEmpleado().getIdRol());
			return stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double leerSalarioMantenimiento() {
		String query = "SELECT salario FROM Mantenimiento WHERE idRol  = 1";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getDouble("salario");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public double leerSalarioMonitores() {
		String query = "SELECT salario FROM Monitores WHERE idRol  = 2";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getDouble("salario");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public double leerSalarioNutricionistas() {
		String query = "SELECT salario FROM Nutricionistas WHERE idRol  = 3";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getDouble("salario");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public double leerSalarioRecepcion() {
		String query = "SELECT salario FROM Recepcion WHERE idRol  = 4";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getDouble("salario");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public DTOtEmpleado leerEmpleado(String dni) {
		String query = "SELECT * FROM Empleados WHERE dniEmpleado = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1,dni);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString ("nombre");
				DTOtEmpleado e = new DTOtEmpleado(dni, name, null);
				return e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String leerNombreRol(int id) {
		String query = "SELECT nombre FROM Roles WHERE idRol = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString("nombre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int leerEmpleadoRol(String dni) {
		String query = "SELECT * FROM EmpleadosRoles WHERE dniEmpleado = dni";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("idRol");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DTOtEmpleado> leerEmpleadosPorRol(String nombreRol) {
		List<DTOtEmpleado> empleados = new ArrayList<>();

	}

	public int actualizarEmpleado(DTOtEmpleado empleado) {
		String query = "UPDATE Empleados SET nombre = ? WHERE dniEmpleado = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, empleado.getNombre());
			stmt.setString(2, empleado.getDni());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarEmpleado(String dni) {
		String query = "DELETE FROM Empleados WHERE dniEmpleado = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, dni);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int borrarEmpleadoRol(String dni) {
		String query = "DELETE FROM EmpleadosRoles WHERE dniEmpleado = ?";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setString(1, dni);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<DTOtEmpleado> leerTodosEmpleados() {
		List<DTOtEmpleado> empleados = new ArrayList<>();
		String query = "SELECT * FROM Empleados e JOIN EmpleadosRoles er ON e.idEmpleado = er.idEmpleado";
		try (Statement stmt = BDConexion.getConnection().createStatement()) {
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String dni = rs.getString("dniEmpleado");
				String nombre = rs.getString("nombre");
				int idRolInt = rs.getInt("idRol");
				String nombreRol = rs.getString("nombreRol");
				double salario = rs.getDouble("salario");

				DTOtRol dtoRol = new DTOtRol(idRolInt, nombreRol, salario);
				DTOtEmpleado emp = new DTOtEmpleado(dni, nombre, dtoRol);

				empleados.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empleados;
	}
}