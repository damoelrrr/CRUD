package Model;

public class Autor {
// Atributos de la clase Autor
    private int id;
    private String nombre;
// Constructor vacío y constructor con parámetros
    public Autor() {}

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
// Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
// Método toString para mostrar la información del autor
    @Override
    public String toString() {
        return "Autor [id=" + id + ", nombre=" + nombre + "]";
    }
}

