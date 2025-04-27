package integracion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import configFiles.BDConexion;
import negocio.DTOtSala;

public class DAOSalasImp implements DAOSalas {

    public int altaSala(final DTOtSala sala) {
        String insertSala = "INSERT INTO SALAS (aforo) VALUES (?)";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(insertSala, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, sala.getAforo());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int altaMantenedor(DTOtSala sala) {
        int filas = 0;
        String insertMantenedor = "INSERT INTO MANTIENEN (dniEmpleado, idSala) VALUES (?, ?)";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(insertMantenedor)) {
            for (String dni : sala.getDniEmpleados()) {
                stmt.setString(1, dni);
                stmt.setInt(2, sala.getId());
                filas += stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }

    public DTOtSala leerSala(final int id) {
        String leerSala = "SELECT m.dniEmpleado, s.idSala, s.aforo FROM MANTIENEN m JOIN SALAS s ON s.idSala = m.idSala WHERE s.idSala = ?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(leerSala)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            List<String> empleados = new ArrayList<>();
            int aforo = 0;
            while (rs.next()) {
                empleados.add(rs.getString("dniEmpleado"));
                aforo = rs.getInt("aforo");
            }
            if (!empleados.isEmpty()) {
                String[] dniEmpleadosArray = empleados.toArray(new String[0]);
                return new DTOtSala(id, aforo, dniEmpleadosArray);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int actualizarSala(final DTOtSala sala) {
        String query = "UPDATE SALAS SET aforo = ? WHERE idSala=?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, sala.getAforo());
            stmt.setInt(2, sala.getId());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int actualizarMantenedor(final DTOtSala sala) {
       //PARA AHORRA COMPARAR EL ARRAY VIEJO Y EL NUEVO SE BORRAN TODOS LOS MANTENEDORES ANTIGUOS Y SE INSERTAN LOS NUEVOS
        borrarMantenedoresSala(sala.getId());
        return altaMantenedor(sala);
    }
    
    private int borrarMantenedoresSala(final int idSala) {
        String query = "DELETE FROM MANTIENEN WHERE idSala = ?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idSala);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int borrarSala(final int id) {
        String query = "DELETE FROM SALAS WHERE idSala = ?";
        try (PreparedStatement stmt = BDConexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
    
    public List<DTOtSala> leerTodasSalas() {
        List<DTOtSala> salas = new ArrayList<>();
        String query = "SELECT s.idSala, s.aforo, m.dniEmpleado FROM SALAS s LEFT JOIN MANTIENEN m ON s.idSala = m.idSala ORDER BY s.idSala";
        try (Statement stmt = BDConexion.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            int lastSalaId = -1;
            DTOtSala salaActual = null;
            List<String> empleados = new ArrayList<>();
            while (rs.next()) {
                int idSala = rs.getInt("idSala");
                int aforo = rs.getInt("aforo");
                String dniEmpleado = rs.getString("dniEmpleado");
                if (idSala != lastSalaId) {
                    if (salaActual != null) {
                        salaActual.setDniEmpleados(empleados.toArray(new String[0]));
                        salas.add(salaActual);
                    }
                    empleados = new ArrayList<>();
                    salaActual = new DTOtSala(idSala, aforo, new String[0]);
                    lastSalaId = idSala;
                }
                if (dniEmpleado != null)
                    empleados.add(dniEmpleado);
            }
            if (salaActual != null) {
                salaActual.setDniEmpleados(empleados.toArray(new String[0]));
                salas.add(salaActual);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salas;
    }
}
