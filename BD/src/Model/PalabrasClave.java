package Model;

public class PalabrasClave {
// Atributos de la clase PalabrasClave
    private int id;
    private String nombre;

// Constructor vacío y constructores con parámetros
    public PalabrasClave() {}
    
    public PalabrasClave(String nombre) {
        this.nombre = nombre;
    }
    public PalabrasClave(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
// Método toString para mostrar la información de las palabras clave
    @Override
    public String toString() {
        return "PalabrasClave [id=" + id + ", nombre=" + nombre + "]";
    }
    
}
