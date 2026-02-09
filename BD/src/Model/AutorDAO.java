package Model;

import BD.ConexionBD;
import java.sql.*;

public class AutorDAO {

    public int obtenerOCrear(String nombre) {

        String buscar = "SELECT id FROM autor WHERE nombre = ?";
        String insertar = "INSERT INTO autor(nombre) VALUES (?)";

        try (Connection con = ConexionBD.getConexion()) {

            PreparedStatement ps = con.prepareStatement(buscar);
            ps.setString(1, nombre.trim());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

            PreparedStatement psInsert =
                    con.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, nombre.trim());
            psInsert.executeUpdate();

            ResultSet keys = psInsert.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("AutorDAO error: " + e.getMessage());
        }
        return -1;
    }
}
