package Model;

public class Articulo {
// atributos de la clase Articulo

    private int id;
    private String titulo;
    private String resumen;
    private int anio;
    private Revista revista;
    private String autoresTexto;
    private String palabrasTexto;

// Constructor vacío y constructor con parámetros
    public Articulo() {
    }

    public Articulo(int id, String titulo, String resumen, int anio, Revista revista) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.anio = anio;
        this.revista = revista;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }

    // Método toString para mostrar la información del artículo
    @Override
    public String toString() {
        return "Articulo [id=" + id + ", titulo=" + titulo + ", resumen=" + resumen + ", anio=" + anio + ", revista="
                + revista + "]";
    }

    public String getAutoresTexto() {
        return autoresTexto;
    }

    public void setAutoresTexto(String autoresTexto) {
        this.autoresTexto = autoresTexto;
    }

    public String getPalabrasTexto() {
        return palabrasTexto;
    }

    public void setPalabrasTexto(String palabrasTexto) {
        this.palabrasTexto = palabrasTexto;
    }
}
