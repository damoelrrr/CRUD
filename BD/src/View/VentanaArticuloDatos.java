package View;

import Model.Articulo;
import Model.Revista;
import javax.swing.*;
import java.awt.*;

public class VentanaArticuloDatos extends JDialog {

    private JTextField txtTitulo;
    private JTextField txtAnio;
    private JTextField txtRevista;
    private JTextField txtAutores;
    private JTextField txtPalabras;

    private JButton btnSiguiente;
    private JButton btnCancelar;

    private Articulo articulo;

    public VentanaArticuloDatos(JFrame parent) {
        super(parent, "Datos del Artículo", true);
        articulo = new Articulo();
        inicializar(parent);
    }

    public VentanaArticuloDatos(JFrame parent, Articulo articuloExistente) {
        super(parent, "Actualizar Artículo", true);
        this.articulo = articuloExistente;
        inicializar(parent);
        cargarDatos();
    }

    private void inicializar(JFrame parent) {

        setSize(500, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(5, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelCampos.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelCampos.add(txtTitulo);

        panelCampos.add(new JLabel("Año de publicación:"));
        txtAnio = new JTextField();
        panelCampos.add(txtAnio);

        panelCampos.add(new JLabel("Revista:"));
        txtRevista = new JTextField();
        panelCampos.add(txtRevista);

        panelCampos.add(new JLabel("Autores (separados por coma):"));
        txtAutores = new JTextField();
        panelCampos.add(txtAutores);

        panelCampos.add(new JLabel("Palabras clave (separadas por coma):"));
        txtPalabras = new JTextField();
        panelCampos.add(txtPalabras);

        add(panelCampos, BorderLayout.CENTER);

        btnSiguiente = new JButton("Siguiente");
        btnCancelar = new JButton("Cancelar");

        btnSiguiente.addActionListener(e -> siguiente());
        btnCancelar.addActionListener(e -> cancelar());

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnCancelar);
        panelBotones.add(btnSiguiente);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        txtTitulo.setText(articulo.getTitulo());
        txtAnio.setText(String.valueOf(articulo.getAnio()));
        txtRevista.setText(articulo.getRevista().getNombre());
        txtAutores.setText(articulo.getAutoresTexto());
        txtPalabras.setText(articulo.getPalabrasTexto());
    }

    private void siguiente() {

        if (txtTitulo.getText().isEmpty()
                || txtAnio.getText().isEmpty()
                || txtRevista.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Debe completar al menos Título, Año y Revista",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            articulo.setTitulo(txtTitulo.getText());
            articulo.setAnio(Integer.parseInt(txtAnio.getText()));

            Revista revista = new Revista();
            revista.setNombre(txtRevista.getText());
            articulo.setRevista(revista);

            articulo.setAutoresTexto(txtAutores.getText());
            articulo.setPalabrasTexto(txtPalabras.getText());

            VentanaArticuloResumen resumen =
                    new VentanaArticuloResumen(
                            (JFrame) getParent(),
                            articulo,
                            this
                    );

            resumen.setVisible(true);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "El año debe ser un número válido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void cancelar() {
        int op = JOptionPane.showConfirmDialog(
                this,
                "¿Desea cancelar el registro del artículo?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );

        if (op == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}
