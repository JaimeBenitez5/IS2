package configFiles;
import java.sql.*;

public class BDConexion {
	/**Parametros de conexion**/
	
	
	static String bd = "gimnasio";
	static String login = "root";
	static String password = "equipo2";
	static String url = "jdbc:mysql://localhost:3306/" + bd;
	private static Connection connection = null;
	
	public BDConexion() {
		
	}
	
	//USADO PATRON SINGLETON
	public static Connection getConnection(){
		if(connection == null) {
			try {
				connection = DriverManager.getConnection (url, login,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public void desconectar(){
		connection = null;
	}
	
	public void executeQuery() throws SQLException {
		String query = "SELECT * FROM CLIENTE";
		try ( Statement stmt = connection.createStatement ()) {
			ResultSet rs = stmt.executeQuery ( query );
			while (rs.next ()) {
				int idCliente = rs.getInt("idCliente");
				String name = rs.getString ("nombre");
				String direccion = rs.getString ("direccion");
				int activo = rs.getInt("activo");
				System.out.println ( "(" + idCliente + " " + name + " " + direccion + " " + activo+")");
			}
		}
	}
	
	public void updateQuery() throws SQLException {
		String query = "UPDATE Provincias SET poblacion=45000 WHERE id=1";
		try ( Statement stmt = connection.createStatement ()) {
			int rowCount = stmt.executeUpdate ( query );
		}
	}
	
	public void preparedStatement() throws SQLException {
		String query = "UPDATE Ventas SET compras=? WHERE nombre=?";
		try ( PreparedStatement st = connection.prepareStatement ( query )) {
			// Se insertan los valores en la consulta :
			st. setInt (1, 750) ;
			st. setString (2, " Naranjas ");
			// Se invoca a executeUpdate sin parametro :
			st. executeUpdate ();
		}
	}
}