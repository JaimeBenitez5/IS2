package integracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import configFiles.BDConexion;
import negocio.tCliente;
import negocio.tSala;

@objid ("df2cbaf5-307b-4f5e-9398-8db6fe856b10")
public class DAOSalasImp implements DAOSalas {
	@objid ("3df79827-c911-46a2-9aae-c38da28a8512")
	public int altaSala(tSala sala) {
		String query = "INSERT INTO Sala (aforo) VALUES (?)";
		try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, String.valueOf(sala.getAforo()));
			stmt.executeUpdate();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int idSala = rs.getInt(1);
					return idSala;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@objid ("5eb32012-231d-4434-8a74-4057f5926f04")
	public tSala leerSala(final int id) {
		String query = "SELECT * FROM Sala WHERE idSala  = ?";
		try ( PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idSala = rs.getInt("idSala");
				int aforo = rs.getInt("aforo");
				tSala s = new tSala(idSala, aforo);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@objid ("3c80588f-3bca-4098-aac9-a49c2d8ce1b1")
	public int actualizarSala(final tSala sala) {
		// TODO Auto-generated return
		return 0;
	}

	@objid ("93d5cca5-4fa4-4f5b-9c50-5612a7469e3c")
	public int borrarSala(final int id) {
		// TODO Auto-generated return
		return 0;
	}

	@objid ("7d2af3f4-2de1-4859-9867-71298a36987c")
	public List<tSala> leerTodasSalas() {
		ArrayList<tSala> salas = new ArrayList<tSala>();
		String query = "SELECT * FROM Sala";
		try ( Statement stmt = BDConexion.getConnection().createStatement ()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next ()) {
				int idSala = rs.getInt("idSala");
				int aforo = rs.getInt("aforo");
				tSala s = new tSala(idSala, aforo);
				salas.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salas;
	}

}
