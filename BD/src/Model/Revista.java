package Model;

public class Revista {
// Atributos de la clase Revista
    private int id;
    private String nombre;
// Constructor vacío y constructor con parámetros
    public Revista() {}

    public Revista(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
// Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
// Método toString para mostrar la información de la revista
    @Override
    public String toString() {
        return "Revista [id=" + id + ", nombre=" + nombre + "]";
    }
    
}

