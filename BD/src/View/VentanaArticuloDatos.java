package View;

import Model.Articulo;
import Model.Autor;
import Model.Revista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaArticuloDatos extends JDialog {

    private JTextField txtTitulo;
    private JTextField txtAnio;
    private JTextField txtRevista;
    private JTextField txtPalabrasClave;
    private JPanel panelAutores;
    private List<JTextField> camposAutores;
    private JButton btnAgregarAutor;
    private JButton btnContinuar;
    private Articulo articulo; // objeto en memoria

    public VentanaArticuloDatos(JFrame parent) {
        super(parent, "Nuevo Artículo - Datos Generales", true);
        articulo = new Articulo();
        camposAutores = new ArrayList<>();

        setSize(600, 500);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Título
        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Título del artículo:"), c);

        txtTitulo = new JTextField();
        c.gridx = 1;
        panel.add(txtTitulo, c);

        // Autores
        c.gridx = 0;
        c.gridy++;
        panel.add(new JLabel("Autores:"), c);

        panelAutores = new JPanel();
        panelAutores.setLayout(new BoxLayout(panelAutores, BoxLayout.Y_AXIS));

        agregarCampoAutor(); // mínimo 1 autor

        btnAgregarAutor = new JButton("+");
        btnAgregarAutor.setForeground(Color.BLUE);
        btnAgregarAutor.setMargin(new Insets(2, 8, 2, 8));
        btnAgregarAutor.addActionListener(e -> agregarCampoAutor());

        JPanel autoresWrapper = new JPanel(new BorderLayout());
        autoresWrapper.add(panelAutores, BorderLayout.CENTER);
        autoresWrapper.add(btnAgregarAutor, BorderLayout.EAST);

        c.gridx = 1;
        panel.add(autoresWrapper, c);

        // Año
        c.gridx = 0;
        c.gridy++;
        panel.add(new JLabel("Año de publicación:"), c);

        txtAnio = new JTextField();
        c.gridx = 1;
        panel.add(txtAnio, c);

        // Revista
        c.gridx = 0;
        c.gridy++;
        panel.add(new JLabel("Revista de publicación:"), c);

        txtRevista = new JTextField();
        c.gridx = 1;
        panel.add(txtRevista, c);

        // Palabras clave
        c.gridx = 0;
        c.gridy++;
        panel.add(new JLabel("Palabras clave:"), c);

        txtPalabrasClave = new JTextField();
        c.gridx = 1;
        panel.add(txtPalabrasClave, c);

        // Botón continuar
        btnContinuar = new JButton("Guardar y continuar");
        btnContinuar.addActionListener(e -> continuar());

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnContinuar);

        add(panel, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    private void agregarCampoAutor() {
        JTextField txtAutor = new JTextField(20);
        camposAutores.add(txtAutor);
        panelAutores.add(txtAutor);
        panelAutores.revalidate();
        panelAutores.repaint();
    }

    private void continuar() {
        if (txtTitulo.getText().isEmpty() || camposAutores.get(0).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar al menos un título y un autor",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        articulo.setTitulo(txtTitulo.getText());
        articulo.setAnio(Integer.parseInt(txtAnio.getText()));
        articulo.setRevista(new Revista(0, txtRevista.getText()));
        articulo.setResumen(""); // se llena después

        // Autores
        for (JTextField campo : camposAutores) {
            if (!campo.getText().isEmpty()) {
                // aquí luego se guardan en BD
            }
        }

        VentanaArticuloResumen resumen = new VentanaArticuloResumen((JFrame) getParent(), articulo, this);
        resumen.setVisible(true);
        setVisible(false);
    }
}


