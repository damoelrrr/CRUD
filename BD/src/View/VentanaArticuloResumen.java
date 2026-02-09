package View;

import BD.ConexionBD;
import Model.Articulo;
import DAO.ArticuloDAO;
import DAO.AutorDAO;
import DAO.PalabraClaveDAO;
import Model.Revista;
import DAO.RevistaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;

public class VentanaArticuloResumen extends JDialog {

    private JTextArea txtResumen;
    private JButton btnGuardar;
    private JButton btnCancelar;

    private Articulo articulo;
    private VentanaArticuloDatos ventanaAnterior;

    public VentanaArticuloResumen(JFrame parent, Articulo articulo, VentanaArticuloDatos anterior) {
        super(parent, "Resumen del Artículo", true);
        this.articulo = articulo;
        this.ventanaAnterior = anterior;

        setSize(600, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        btnCancelar = new JButton("Cancelar y salir");
        btnCancelar.addActionListener(e -> cancelar());

        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTop.add(btnCancelar);
        add(panelTop, BorderLayout.NORTH);

        txtResumen = new JTextArea(10, 40);
        txtResumen.setLineWrap(true);
        txtResumen.setWrapStyleWord(true);

        if (articulo.getResumen() != null) {
            txtResumen.setText(articulo.getResumen());
        }

        add(new JScrollPane(txtResumen), BorderLayout.CENTER);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardar());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);
    }

   private void guardar() {

    articulo.setResumen(txtResumen.getText());

    RevistaDAO revistaDAO = new RevistaDAO();
    AutorDAO autorDAO = new AutorDAO();
    PalabraClaveDAO palabraDAO = new PalabraClaveDAO();
    ArticuloDAO articuloDAO = new ArticuloDAO();

    // 1. Obtener o crear revista
    int idRevista = revistaDAO.obtenerOCrear(
            articulo.getRevista().getNombre()
    );
    articulo.getRevista().setId(idRevista);

    // 2. Insertar o actualizar artículo
    int idArticulo;
    if (articulo.getId() == 0) {
        idArticulo = articuloDAO.insertar(articulo);
        articulo.setId(idArticulo);
    } else {
        articuloDAO.actualizar(articulo);
        idArticulo = articulo.getId();
    }

    // 3. Guardar autores
    if (articulo.getAutoresTexto() != null
            && !articulo.getAutoresTexto().isBlank()) {

        String[] autores = articulo.getAutoresTexto().split(",");

        for (String nombre : autores) {
            int idAutor = autorDAO.obtenerOCrear(nombre.trim());
            insertarArticuloAutor(idArticulo, idAutor);
        }
    }

    // 4. Guardar palabras clave
    if (articulo.getPalabrasTexto() != null
            && !articulo.getPalabrasTexto().isBlank()) {

        String[] palabras = articulo.getPalabrasTexto().split(",");

        for (String palabra : palabras) {
            int idPalabra = palabraDAO.obtenerOCrear(palabra.trim());
            insertarArticuloPalabra(idArticulo, idPalabra);
        }
    }

    JOptionPane.showMessageDialog(
            this,
            "Artículo guardado correctamente",
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE
    );

    ventanaAnterior.dispose();
    dispose();
}


    private void insertarArticuloAutor(int idArticulo, int idAutor) {
        String sql = "INSERT INTO articulo_autor(id_articulo, id_autor) VALUES (?, ?)";
        try (Connection con = ConexionBD.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idArticulo);
            ps.setInt(2, idAutor);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error articulo_autor: " + e.getMessage());
        }
    }
    
    private void insertarArticuloPalabra(int idArticulo, int idPalabra) {
    String sql = "INSERT INTO articulo_palabra_clave(id_articulo, id_palabra) VALUES (?, ?)";

    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idArticulo);
        ps.setInt(2, idPalabra);
        ps.executeUpdate();

    } catch (SQLException e) {
        System.out.println("Error articulo_palabra: " + e.getMessage());
    }
}

    private void cancelar() {
        int op = JOptionPane.showConfirmDialog(
                this,
                "Si sale se perderán los datos.\n¿Desea continuar?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );

        if (op == JOptionPane.YES_OPTION) {
            ventanaAnterior.dispose();
            dispose();
        }
    }
}
