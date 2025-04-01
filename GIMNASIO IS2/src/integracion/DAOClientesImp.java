package integracion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import configFiles.BDConexion;
import negocio.tCliente;

@objid ("5db6cbcc-d2d1-43b5-97ab-d524a2cfb365")
public class DAOClientesImp implements DAOClientes {

	@objid ("d33cffc0-4796-4963-86bf-890bea10be49")
	public int createCliente(tCliente cliente) {
		String query = "INSERT INTO Cliente (nombre, dni, direccion) VALUES (?, ?, ?)";
		try (PreparedStatement st = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			// Se insertan los valores en la consulta:
			st.setString(1, cliente.getNombre());
			st.setString(2, cliente.getDni());
			st.setString(3, cliente.getDir());

			// Se invoca a executeUpdate sin parámetro:
			st.executeUpdate();

			// Obtener la clave generada (idCliente)
			try (ResultSet rs = st.getGeneratedKeys()) {
				if (rs.next()) {
					int idCliente = rs.getInt(1);
					return idCliente;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@objid ("069139f7-3a72-4d97-b631-fc04b812eeca")
	public tCliente readCliente() {
		// TODO Auto-generated return
		return null;
	}

	@objid ("720d1674-b5db-4c58-b692-9948ff65f58d")
	public int updateCliente(final tCliente cliente) {
		// TODO Auto-generated return
		return 0;
	}

	@objid ("10927b9e-db74-426b-8da0-8b4adf615314")
	public int deleteCliente(final String dni) {
		// TODO Auto-generated return
		return 0;
	}

	@objid ("b2c3cc0f-18df-4728-9309-703997655f53")
	public List<tCliente> readAllClientes() {
		ArrayList<tCliente> clientes = new ArrayList<tCliente>();
		String query = "SELECT * FROM CLIENTE";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery (query);
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
