package Model;

import BD.ConexionBD;
import java.sql.*;

public class RevistaDAO {

    public int obtenerOCrear(String nombre) {
        String buscar = "SELECT id FROM revista WHERE nombre = ?";
        String insertar = "INSERT INTO revista(nombre) VALUES (?)";

        try (Connection con = ConexionBD.getConexion()) {

            PreparedStatement ps = con.prepareStatement(buscar);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id"); 
            }

            PreparedStatement psInsert = con.prepareStatement(
                    insertar, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, nombre);
            psInsert.executeUpdate();

            ResultSet keys = psInsert.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1); // id nuevo
            }

        } catch (SQLException e) {
            System.out.println("RevistaDAO error: " + e.getMessage());
        }
        return -1;
    }
}
