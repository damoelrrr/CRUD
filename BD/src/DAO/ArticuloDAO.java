package DAO;

import BD.ConexionBD;
import Model.Articulo;
import Model.Revista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {

    public int insertar(Articulo articulo) {

    String sql = "INSERT INTO articulo (titulo, resumen, anio, id_revista) VALUES (?, ?, ?, ?)";

    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, articulo.getTitulo());
        ps.setString(2, articulo.getResumen());
        ps.setInt(3, articulo.getAnio());
        ps.setInt(4, articulo.getRevista().getId());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); 
        }

    } catch (SQLException e) {
        System.out.println("Error al insertar artículo: " + e.getMessage());
    }
    return -1;
}


    public List<Articulo> buscarPorTitulo(String filtro) {

        List<Articulo> lista = new ArrayList<>();

        String sql = """
SELECT a.id, a.titulo, a.resumen, a.anio,
       r.nombre AS revista,
       GROUP_CONCAT(DISTINCT au.nombre SEPARATOR ' -- ') AS autores,
       GROUP_CONCAT(DISTINCT p.palabra SEPARATOR ' -- ') AS palabras
FROM articulo a
JOIN revista r ON a.id_revista = r.id
LEFT JOIN articulo_autor aa ON a.id = aa.id_articulo
LEFT JOIN autor au ON aa.id_autor = au.id
LEFT JOIN articulo_palabra_clave ap ON a.id = ap.id_articulo
LEFT JOIN palabra_clave p ON ap.id_palabra = p.id
WHERE a.titulo LIKE ?
GROUP BY a.id
ORDER BY a.anio DESC, a.id DESC
""";


        try (Connection con = ConexionBD.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + filtro + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Articulo a = new Articulo();
                a.setId(rs.getInt("id"));
                a.setTitulo(rs.getString("titulo"));
                a.setResumen(rs.getString("resumen"));
                a.setAnio(rs.getInt("anio"));

                Revista r = new Revista();
                r.setNombre(rs.getString("revista"));
                a.setRevista(r);

                a.setAutoresTexto(rs.getString("autores"));
                a.setPalabrasTexto(rs.getString("palabras"));

                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Error buscar artículos: " + e.getMessage());
        }

        return lista;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM articulo WHERE id = ?";
        try (Connection con = ConexionBD.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminar artículo: " + e.getMessage());
        }
    }

    public void actualizar(Articulo articulo) {

    String sql = """
        UPDATE articulo
        SET titulo = ?, resumen = ?, anio = ?, id_revista = ?
        WHERE id = ?
    """;

    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, articulo.getTitulo());
        ps.setString(2, articulo.getResumen());
        ps.setInt(3, articulo.getAnio());
        ps.setInt(4, articulo.getRevista().getId());
        ps.setInt(5, articulo.getId());

        ps.executeUpdate();

    } catch (SQLException e) {
        System.out.println("Error al actualizar artículo: " + e.getMessage());
    }
}

    
}
