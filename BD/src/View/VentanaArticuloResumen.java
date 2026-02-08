package View;

import Model.Articulo;
import Model.ArticuloDAO;
import Model.RevistaDAO;

import javax.swing.*;
import java.awt.*;

public class VentanaArticuloResumen extends JDialog {

    private JTextArea txtResumen;
    private JButton btnGuardar;
    private JButton btnEditar;
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

        txtResumen = new JTextArea(10, 40);
        txtResumen.setLineWrap(true);
        txtResumen.setWrapStyleWord(true);

        add(new JScrollPane(txtResumen), BorderLayout.CENTER);

        btnEditar = new JButton("Editar información anterior");
        btnGuardar = new JButton("Guardar");

        btnEditar.addActionListener(e -> volver());
        btnGuardar.addActionListener(e -> guardar());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnEditar);
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void volver() {
        ventanaAnterior.setVisible(true);
        dispose();
    }

    private void guardar() {

        articulo.setResumen(txtResumen.getText());

        // crear lla revista
        RevistaDAO revistaDAO = new RevistaDAO();
        String nombreRevista = articulo.getRevista().getNombre();
        int idRevista = revistaDAO.obtenerOCrear(nombreRevista);

      //️⃣ Asignar el ID REAL a la revista
        articulo.getRevista().setId(idRevista);

        // 3️⃣ Guardar artículo
        ArticuloDAO dao = new ArticuloDAO();
        dao.insertar(articulo);

        JOptionPane.showMessageDialog(this, "Artículo guardado correctamente");
        dispose();
    }

    private void cancelar() {
        int op = JOptionPane.showConfirmDialog(this,
                "Si sale se perderán los datos.\n¿Desea continuar?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}
