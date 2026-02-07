package Model;

public class Tema {

// Identificador técnico de persistencia
    private int id;

// Identidad conceptual
    private String nombre;
    private String descripcion;

// Constructor vacío y constructores con parámetros
    public Tema() {}

    public Tema(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Tema(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
// Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
// Método toString para mostrar la información del tema
    @Override
    public String toString() {
        return "Tema [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }

}

