package View;

import Model.Articulo;
import Model.ArticuloDAO;
import Model.RevistaDAO;

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

        // Botón cancelar arriba
        btnCancelar = new JButton("Cancelar y salir");
        btnCancelar.addActionListener(e -> cancelar());

        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTop.add(btnCancelar);
        add(panelTop, BorderLayout.NORTH);

        // Área de resumen
        txtResumen = new JTextArea(10, 40);
        txtResumen.setLineWrap(true);
        txtResumen.setWrapStyleWord(true);

        if (articulo.getResumen() != null) {
            txtResumen.setText(articulo.getResumen());
        }

        add(new JScrollPane(txtResumen), BorderLayout.CENTER);

        // Botón guardar abajo
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardar());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    // Guardar artículo completo
    private void guardar() {

        articulo.setResumen(txtResumen.getText());

        // Obtener o crear revista
        RevistaDAO revistaDAO = new RevistaDAO();
        String nombreRevista = articulo.getRevista().getNombre();
        int idRevista = revistaDAO.obtenerOCrear(nombreRevista);

        articulo.getRevista().setId(idRevista);

        // Guardar artículo
        ArticuloDAO dao = new ArticuloDAO();
        dao.insertar(articulo);

        JOptionPane.showMessageDialog(this, "Artículo guardado correctamente");

        ventanaAnterior.dispose(); // cerrar ventana datos
        dispose();                 // cerrar resumen
    }

    // Cancelar y salir
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
