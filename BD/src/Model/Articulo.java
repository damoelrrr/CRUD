
package Model;

import java.io.Serializable;

/**
 * Model class representing a research article
 */
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String titulo;
    private String autores;
    private int anio;
    private String fuente;
    private String resumen;
    private String palabrasClave;
    private String formato_APA;
    private String baseDatos;
    
    // Constructors
    public Articulo() {
    }
    
    public Articulo(String titulo, String autores, int anio, String fuente, 
                   String resumen, String palabrasClave, String formato_APA) {
        this.titulo = titulo;
        this.autores = autores;
        this.anio = anio;
        this.fuente = fuente;
        this.resumen = resumen;
        this.palabrasClave = palabrasClave;
        this.formato_APA = formato_APA;
    }
    
    // Getters and Setters
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
    
    public String getAutores() {
        return autores;
    }
    
    public void setAutores(String autores) {
        this.autores = autores;
    }
    
    public int getAnio() {
        return anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public String getFuente() {
        return fuente;
    }
    
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }
    
    public String getResumen() {
        return resumen;
    }
    
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
    public String getPalabrasClave() {
        return palabrasClave;
    }
    
    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
    
    public String getFormato_APA() {
        return formato_APA;
    }
    
    public void setFormato_APA(String formato_APA) {
        this.formato_APA = formato_APA;
    }
    
    public String getBaseDatos() {
        return baseDatos;
    }
    
    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }
    
    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores='" + autores + '\'' +
                ", anio=" + anio +
                ", fuente='" + fuente + '\'' +
                ", baseDatos='" + baseDatos + '\'' +
                '}';
    }
}
