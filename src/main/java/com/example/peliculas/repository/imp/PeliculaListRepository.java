package com.example.peliculas.repository.imp;

import com.example.peliculas.model.Pelicula;
import com.example.peliculas.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PeliculaListRepository implements IRepository<Pelicula> {
    //Atributo
    private List<Pelicula> peliculas;

    //Constructor
    public PeliculaListRepository() {
        this.peliculas = cargarPeliculas();
    }

    //Método cargarPeliculas (se las harcodeamos)
    private List<Pelicula> cargarPeliculas(){
        List<Pelicula> peliculasCargadas = new ArrayList<>();
        peliculasCargadas.add(new Pelicula(1,"Star Wars" , "Ficcion",7));
        peliculasCargadas.add(new Pelicula(2,"It" , "Terror",0));
        peliculasCargadas.add(new Pelicula(3,"Titanic" , "Drama",10));
        return peliculasCargadas;
    }

    //Sobreescribiendo los métodos de la interfaz
    @Override
    public Pelicula agregar(Pelicula pelicula) {
        if(pelicula.getId() == null)
            pelicula.setId(new Random().nextInt());
        this.peliculas.add(pelicula);
        return pelicula;
    }

    @Override
    public List<Pelicula> buscar() {
        return this.peliculas;
    }

    @Override
    public Pelicula actualizar(Pelicula pelicula) {
        eliminar(pelicula.getId());
        agregar(pelicula);
        return pelicula;
    }

    @Override
    public Boolean eliminar(Integer id) {
        for(Pelicula pelicula : peliculas){
            if(pelicula.getId().equals(id)){
                peliculas.remove(pelicula);
                return true;
            }
        }
        return false;
    }

    @Override
    public Pelicula buscar(Integer id) {
        for(Pelicula pelicula : peliculas){
            if(pelicula.getId().equals(id)){
                return pelicula;
            }
        }
        return null;
    }

}
