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

        // 🔍 Panel búsqueda
        JPanel panelTop = new JPanel(new BorderLayout());
        txtBuscar = new JTextField();
        JButton btnBuscar = new JButton("Buscar");

        btnBuscar.addActionListener(e -> cargarArticulos());

        panelTop.add(new JLabel("Buscar por título: "), BorderLayout.WEST);
        panelTop.add(txtBuscar, BorderLayout.CENTER);
        panelTop.add(btnBuscar, BorderLayout.EAST);

        add(panelTop, BorderLayout.NORTH);

        // 📄 Resultados
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

        for (Articulo a : lista) {
            panelResultados.add(crearPanelArticulo(a));
        }

        panelResultados.revalidate();
        panelResultados.repaint();
    }

    private JPanel crearPanelArticulo(Articulo a) {

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        panel.add(new JLabel("Título: " + a.getTitulo()));
        panel.add(new JLabel("Año de publicación: " + a.getAnio()));
        panel.add(new JLabel("Autores: " + a.getAutoresTexto()));
        panel.add(new JLabel("Palabras clave: " + a.getPalabrasTexto()));
        panel.add(new JLabel("Revista: " + a.getRevista().getNombre()));

        JTextArea resumen = new JTextArea(a.getResumen());
        resumen.setLineWrap(true);
        resumen.setWrapStyleWord(true);
        resumen.setEditable(false);
        resumen.setBackground(new Color(245, 245, 245));

        panel.add(new JLabel("Resumen:"));
        panel.add(resumen);

        panel.add(Box.createVerticalStrut(10));

        return panel;
    }
}
