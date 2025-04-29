package configFiles;
import java.sql.*;

public class BDConexion {
	/**Parametros de conexion**/
	static String bd = "gimnasio";
	static String login = "root";
	static String password = "equipo2";
	static String url = "jdbc:mysql://localhost:3306/" + bd;
	private static Connection connection = null;
	
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
}