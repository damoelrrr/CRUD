package Controller;

import View.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {
    private Menu menu;

    public Control() {
        menu = new Menu();
        menu.agregarListener(new GestorAcciones());
    }

    public void run() {
        menu.mostrar();
    }

    /**
     * Clase interna para manejar las acciones del menú
     */
    private class GestorAcciones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();

            // Acciones para Artículos
            if (comando.equals("articulo_crear")) {
                onArticuloCrear();
            } else if (comando.equals("articulo_ver")) {
                onArticuloVer();
            } else if (comando.equals("articulo_actualizar")) {
                onArticuloActualizar();
            } else if (comando.equals("articulo_eliminar")) {
                onArticuloEliminar();
            } else if (comando.equals("articulo_buscar")) {
                onArticuloBuscar();
            }

            // Acciones para Autores
            else if (comando.equals("autor_crear")) {
                onAutorCrear();
            } else if (comando.equals("autor_ver")) {
                onAutorVer();
            } else if (comando.equals("autor_actualizar")) {
                onAutorActualizar();
            } else if (comando.equals("autor_eliminar")) {
                onAutorEliminar();
            } else if (comando.equals("autor_buscar")) {
                onAutorBuscar();
            }

            // Acciones para Revistas
            else if (comando.equals("revista_crear")) {
                onRevistaCrear();
            } else if (comando.equals("revista_ver")) {
                onRevistaVer();
            } else if (comando.equals("revista_actualizar")) {
                onRevistaActualizar();
            } else if (comando.equals("revista_eliminar")) {
                onRevistaEliminar();
            } else if (comando.equals("revista_buscar")) {
                onRevistaBuscar();
            }

            // Acciones para Temas
            else if (comando.equals("tema_crear")) {
                onTemaCrear();
            } else if (comando.equals("tema_ver")) {
                onTemaVer();
            } else if (comando.equals("tema_actualizar")) {
                onTemaActualizar();
            } else if (comando.equals("tema_eliminar")) {
                onTemaEliminar();
            }

            // Acciones para Palabras Clave
            else if (comando.equals("palabra_crear")) {
                onPalabraCrear();
            } else if (comando.equals("palabra_ver")) {
                onPalabraVer();
            } else if (comando.equals("palabra_actualizar")) {
                onPalabraActualizar();
            } else if (comando.equals("palabra_eliminar")) {
                onPalabraEliminar();
            }

            // Acciones de Ayuda
            else if (comando.equals("ayuda_acercade")) {
                onAcercaDe();
            } else if (comando.equals("salir")) {
                onSalir();
            }
        }
    }

    // ============ MÉTODOS PARA ARTÍCULOS ============
    private void onArticuloCrear() {
        // TODO: Llamar a métodos del modelo para crear un artículo
    }

    private void onArticuloVer() {
        // TODO: Llamar a métodos del modelo para obtener y mostrar artículos
    }

    private void onArticuloActualizar() {
        // TODO: Llamar a métodos del modelo para actualizar un artículo
    }

    private void onArticuloEliminar() {
        // TODO: Llamar a métodos del modelo para eliminar un artículo
    }

    private void onArticuloBuscar() {
        // TODO: Llamar a métodos del modelo para buscar un artículo
    }

    // ============ MÉTODOS PARA AUTORES ============
    private void onAutorCrear() {
        // TODO: Llamar a métodos del modelo para crear un autor
    }

    private void onAutorVer() {
        // TODO: Llamar a métodos del modelo para obtener y mostrar autores
    }

    private void onAutorActualizar() {
        // TODO: Llamar a métodos del modelo para actualizar un autor
    }

    private void onAutorEliminar() {
        // TODO: Llamar a métodos del modelo para eliminar un autor
    }

    private void onAutorBuscar() {
        // TODO: Llamar a métodos del modelo para buscar un autor
    }

    // ============ MÉTODOS PARA REVISTAS ============
    private void onRevistaCrear() {
        // TODO: Llamar a métodos del modelo para crear una revista
    }

    private void onRevistaVer() {
        // TODO: Llamar a métodos del modelo para obtener y mostrar revistas
    }

    private void onRevistaActualizar() {
        // TODO: Llamar a métodos del modelo para actualizar una revista
    }

    private void onRevistaEliminar() {
        // TODO: Llamar a métodos del modelo para eliminar una revista
    }

    private void onRevistaBuscar() {
        // TODO: Llamar a métodos del modelo para buscar una revista
    }

    // ============ MÉTODOS PARA TEMAS ============
    private void onTemaCrear() {
        // TODO: Llamar a métodos del modelo para crear un tema
    }

    private void onTemaVer() {
        // TODO: Llamar a métodos del modelo para obtener y mostrar temas
    }

    private void onTemaActualizar() {
        // TODO: Llamar a métodos del modelo para actualizar un tema
    }

    private void onTemaEliminar() {
        // TODO: Llamar a métodos del modelo para eliminar un tema
    }

    // ============ MÉTODOS PARA PALABRAS CLAVE ============
    private void onPalabraCrear() {
        // TODO: Llamar a métodos del modelo para crear una palabra clave
    }

    private void onPalabraVer() {
        // TODO: Llamar a métodos del modelo para obtener y mostrar palabras clave
    }

    private void onPalabraActualizar() {
        // TODO: Llamar a métodos del modelo para actualizar una palabra clave
    }

    private void onPalabraEliminar() {
        // TODO: Llamar a métodos del modelo para eliminar una palabra clave
    }

    // ============ MÉTODOS DE AYUDA ============
    private void onAcercaDe() {
        // TODO: Mostrar diálogo de información de la aplicación
    }

    private void onSalir() {
        menu.cerrar();
        System.exit(0);
    }
}

