package tarea;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarea {
    private long id;
    private String titulo;
    private String descripcion;
    private Boolean finalizado;

    public Tarea(@JsonProperty("id") long id, @JsonProperty("titulo") String titulo, @JsonProperty("descripcion") String descripcion, @JsonProperty("finalizado") boolean finalizado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.finalizado = finalizado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
