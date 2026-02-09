package View;

import Model.Articulo;
import Model.ArticuloDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaBuscarArticulos extends JDialog {

    private JTextField txtBuscar;
    private JPanel panelResultados;
    private ArticuloDAO dao;

    public VentanaBuscarArticulos(JFrame parent) {
        super(parent, "Artículos guardados", true);
        dao = new ArticuloDAO();

        setSize(800, 600);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel(new BorderLayout(5, 5));
        txtBuscar = new JTextField();
        JButton btnBuscar = new JButton("Buscar");

        btnBuscar.addActionListener(e -> cargarArticulos());

        panelTop.add(new JLabel("Buscar por título: "), BorderLayout.WEST);
        panelTop.add(txtBuscar, BorderLayout.CENTER);
        panelTop.add(btnBuscar, BorderLayout.EAST);

        add(panelTop, BorderLayout.NORTH);

        panelResultados = new JPanel();
        panelResultados.setLayout(new BoxLayout(panelResultados, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(panelResultados);
        add(scroll, BorderLayout.CENTER);

        cargarArticulos();
    }

    private void cargarArticulos() {

        panelResultados.removeAll();
        String filtro = txtBuscar.getText().trim();

        List<Articulo> lista = dao.buscarPorTitulo(filtro);

        if (lista.isEmpty()) {
            panelResultados.add(new JLabel("No se encontraron artículos."));
        } else {
            for (Articulo a : lista) {
                panelResultados.add(crearPanelArticulo(a));
                panelResultados.add(Box.createVerticalStrut(10));
            }
        }

        panelResultados.revalidate();
        panelResultados.repaint();
    }

    private JPanel crearPanelArticulo(Articulo a) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.setBackground(Color.WHITE);

        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setBackground(Color.WHITE);

        info.setText(
                "Título: " + a.getTitulo() + "\n" +
                "Año de publicación: " + a.getAnio() + "\n" +
                "Autores: " + a.getAutoresTexto() + "\n" +
                "Palabras clave: " + a.getPalabrasTexto() + "\n" +
                "Revista: " + a.getRevista().getNombre() + "\n\n" +
                "Resumen:\n" + a.getResumen()
        );

        panel.add(info, BorderLayout.CENTER);

        JButton btnEliminar = new JButton("Eliminar");
        JButton btnActualizar = new JButton("Actualizar");

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);

        panel.add(panelBotones, BorderLayout.SOUTH);

        btnEliminar.addActionListener(e -> eliminarArticulo(a));
        btnActualizar.addActionListener(e -> actualizarArticulo(a));

        return panel;
    }

    private void eliminarArticulo(Articulo articulo) {
        int op = JOptionPane.showConfirmDialog(
                this,
                "¿Desea eliminar este artículo?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (op == JOptionPane.YES_OPTION) {
            dao.eliminar(articulo.getId());
            cargarArticulos();
        }
    }

    private void actualizarArticulo(Articulo articulo) {
        VentanaArticuloDatos ventana =
                new VentanaArticuloDatos((JFrame) getParent(), articulo);
        ventana.setVisible(true);
        cargarArticulos();
    }
}
