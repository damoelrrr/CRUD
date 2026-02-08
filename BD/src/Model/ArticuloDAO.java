package Model;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {

    public boolean insertar(Articulo articulo) {
        String sql = "INSERT INTO articulo (titulo, resumen, anio, id_revista) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, articulo.getTitulo());
            ps.setString(2, articulo.getResumen());
            ps.setInt(3, articulo.getAnio());
            ps.setInt(4, articulo.getRevista().getId());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar artículo: " + e.getMessage());
            return false;
        }
    }

    public List<Articulo> listar() {
        List<Articulo> lista = new ArrayList<>();
        String sql = "SELECT * FROM articulo";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Articulo a = new Articulo();
                a.setId(rs.getInt("id"));
                a.setTitulo(rs.getString("titulo"));
                a.setResumen(rs.getString("resumen"));
                a.setAnio(rs.getInt("anio"));

                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar artículos: " + e.getMessage());
        }

        return lista;
    }
}