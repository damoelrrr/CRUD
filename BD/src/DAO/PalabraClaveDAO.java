package DAO;

import BD.ConexionBD;
import java.sql.*;

public class PalabraClaveDAO {

    public int obtenerOCrear(String palabra) {

        String buscar = "SELECT id FROM palabra_clave WHERE palabra = ?";
        String insertar = "INSERT INTO palabra_clave(palabra) VALUES (?)";

        try (Connection con = ConexionBD.getConexion()) {

            PreparedStatement ps = con.prepareStatement(buscar);
            ps.setString(1, palabra.trim());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

            PreparedStatement psInsert =
                    con.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, palabra.trim());
            psInsert.executeUpdate();

            ResultSet keys = psInsert.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("PalabraClaveDAO error: " + e.getMessage());
        }
        return -1;
    }
}
