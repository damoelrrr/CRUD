package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuArticulos, menuAutores, menuRevistas, menuTemas, menuPalabrasClave, menuAyuda;

    public Menu() {
        // Configurar ventana
        setTitle("CRUD - Sistema de Gestión de Artículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);

        // Crear barra de menú
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Crear menús
        crearMenuArticulos();
        crearMenuAutores();
        crearMenuRevistas();
        crearMenuTemas();
        crearMenuPalabrasClave();
        crearMenuAyuda();

        // Agregar menús a la barra
        menuBar.add(menuArticulos);
        menuBar.add(menuAutores);
        menuBar.add(menuRevistas);
        menuBar.add(menuTemas);
        menuBar.add(menuPalabrasClave);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menuAyuda);

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        
        JLabel etiquetaBienvenida = new JLabel("Bienvenido al Sistema de Gestión de Artículos", SwingConstants.CENTER);
        etiquetaBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(etiquetaBienvenida, BorderLayout.CENTER);

        setContentPane(panelPrincipal);
    }

    /**
     * Crear menú para operaciones sobre Artículos
     */
    private void crearMenuArticulos() {
        menuArticulos = new JMenu("Artículos");
        menuArticulos.setMnemonic('A');

        JMenuItem itemCrear = new JMenuItem("Crear nuevo artículo");
        itemCrear.setActionCommand("articulo_crear");

        JMenuItem itemVer = new JMenuItem("Ver artículos");
        itemVer.setActionCommand("articulo_ver");

        JMenuItem itemActualizar = new JMenuItem("Actualizar artículo");
        itemActualizar.setActionCommand("articulo_actualizar");

        JMenuItem itemEliminar = new JMenuItem("Eliminar artículo");
        itemEliminar.setActionCommand("articulo_eliminar");

        JMenuItem itemBuscar = new JMenuItem("Buscar artículo");
        itemBuscar.setActionCommand("articulo_buscar");

        menuArticulos.add(itemCrear);
        menuArticulos.addSeparator();
        menuArticulos.add(itemVer);
        menuArticulos.add(itemBuscar);
        menuArticulos.addSeparator();
        menuArticulos.add(itemActualizar);
        menuArticulos.addSeparator();
        menuArticulos.add(itemEliminar);
    }

    /**
     * Crear menú para operaciones sobre Autores
     */
    private void crearMenuAutores() {
        menuAutores = new JMenu("Autores");
        menuAutores.setMnemonic('U');

        JMenuItem itemCrear = new JMenuItem("Crear nuevo autor");
        itemCrear.setActionCommand("autor_crear");

        JMenuItem itemVer = new JMenuItem("Ver autores");
        itemVer.setActionCommand("autor_ver");

        JMenuItem itemActualizar = new JMenuItem("Actualizar autor");
        itemActualizar.setActionCommand("autor_actualizar");

        JMenuItem itemEliminar = new JMenuItem("Eliminar autor");
        itemEliminar.setActionCommand("autor_eliminar");

        JMenuItem itemBuscar = new JMenuItem("Buscar autor");
        itemBuscar.setActionCommand("autor_buscar");

        menuAutores.add(itemCrear);
        menuAutores.addSeparator();
        menuAutores.add(itemVer);
        menuAutores.add(itemBuscar);
        menuAutores.addSeparator();
        menuAutores.add(itemActualizar);
        menuAutores.addSeparator();
        menuAutores.add(itemEliminar);
    }

    /**
     * Crear menú para operaciones sobre Revistas
     */
    private void crearMenuRevistas() {
        menuRevistas = new JMenu("Revistas");
        menuRevistas.setMnemonic('R');

        JMenuItem itemCrear = new JMenuItem("Crear nueva revista");
        itemCrear.setActionCommand("revista_crear");

        JMenuItem itemVer = new JMenuItem("Ver revistas");
        itemVer.setActionCommand("revista_ver");

        JMenuItem itemActualizar = new JMenuItem("Actualizar revista");
        itemActualizar.setActionCommand("revista_actualizar");

        JMenuItem itemEliminar = new JMenuItem("Eliminar revista");
        itemEliminar.setActionCommand("revista_eliminar");

        JMenuItem itemBuscar = new JMenuItem("Buscar revista");
        itemBuscar.setActionCommand("revista_buscar");

        menuRevistas.add(itemCrear);
        menuRevistas.addSeparator();
        menuRevistas.add(itemVer);
        menuRevistas.add(itemBuscar);
        menuRevistas.addSeparator();
        menuRevistas.add(itemActualizar);
        menuRevistas.addSeparator();
        menuRevistas.add(itemEliminar);
    }

    /**
     * Crear menú para operaciones sobre Temas
     */
    private void crearMenuTemas() {
        menuTemas = new JMenu("Temas");
        menuTemas.setMnemonic('T');

        JMenuItem itemCrear = new JMenuItem("Crear nuevo tema");
        itemCrear.setActionCommand("tema_crear");

        JMenuItem itemVer = new JMenuItem("Ver temas");
        itemVer.setActionCommand("tema_ver");

        JMenuItem itemActualizar = new JMenuItem("Actualizar tema");
        itemActualizar.setActionCommand("tema_actualizar");

        JMenuItem itemEliminar = new JMenuItem("Eliminar tema");
        itemEliminar.setActionCommand("tema_eliminar");

        menuTemas.add(itemCrear);
        menuTemas.addSeparator();
        menuTemas.add(itemVer);
        menuTemas.addSeparator();
        menuTemas.add(itemActualizar);
        menuTemas.addSeparator();
        menuTemas.add(itemEliminar);
    }

    /**
     * Crear menú para operaciones sobre Palabras Clave
     */
    private void crearMenuPalabrasClave() {
        menuPalabrasClave = new JMenu("Palabras Clave");
        menuPalabrasClave.setMnemonic('P');

        JMenuItem itemCrear = new JMenuItem("Crear nueva palabra clave");
        itemCrear.setActionCommand("palabra_crear");

        JMenuItem itemVer = new JMenuItem("Ver palabras clave");
        itemVer.setActionCommand("palabra_ver");

        JMenuItem itemActualizar = new JMenuItem("Actualizar palabra clave");
        itemActualizar.setActionCommand("palabra_actualizar");

        JMenuItem itemEliminar = new JMenuItem("Eliminar palabra clave");
        itemEliminar.setActionCommand("palabra_eliminar");

        menuPalabrasClave.add(itemCrear);
        menuPalabrasClave.addSeparator();
        menuPalabrasClave.add(itemVer);
        menuPalabrasClave.addSeparator();
        menuPalabrasClave.add(itemActualizar);
        menuPalabrasClave.addSeparator();
        menuPalabrasClave.add(itemEliminar);
    }

    /**
     * Crear menú de Ayuda
     */
    private void crearMenuAyuda() {
        menuAyuda = new JMenu("Ayuda");
        menuAyuda.setMnemonic('Y');

        JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe.setActionCommand("ayuda_acercade");

        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.setActionCommand("salir");

        menuAyuda.add(itemAcercaDe);
        menuAyuda.addSeparator();
        menuAyuda.add(itemSalir);
    }

    /**
     * Agregar un ActionListener a todos los ítems del menú
     * @param listener El listener que manejará las acciones
     */
    public void agregarListener(ActionListener listener) {
        agregarListenerAMenu(menuArticulos, listener);
        agregarListenerAMenu(menuAutores, listener);
        agregarListenerAMenu(menuRevistas, listener);
        agregarListenerAMenu(menuTemas, listener);
        agregarListenerAMenu(menuPalabrasClave, listener);
        agregarListenerAMenu(menuAyuda, listener);
    }

    /**
     * Método auxiliar para agregar listener a todos los ítems de un menú
     */
    private void agregarListenerAMenu(JMenu menu, ActionListener listener) {
        for (Component componente : menu.getMenuComponents()) {
            if (componente instanceof JMenuItem) {
                JMenuItem item = (JMenuItem) componente;
                item.addActionListener(listener);
            }
        }
    }

    /**
     * Mostrar la ventana
     */
    public void mostrar() {
        setVisible(true);
    }

    /**
     * Cerrar la ventana
     */
    public void cerrar() {
        setVisible(false);
        dispose();
    }
}
