package com.example.peliculas.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeliculaDTO {
    //Atributos
    private String titulo;
    private String categoria;

    //Constructor vacio
    public PeliculaDTO() {
    }

    //Métodos accesores
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //Método toString
    @Override
    public String toString() {
        return "PeliculaDTO{" +
                "titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
