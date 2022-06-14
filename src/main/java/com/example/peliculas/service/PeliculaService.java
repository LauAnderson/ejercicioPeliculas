package com.example.peliculas.service;

import com.example.peliculas.DTO.PeliculaDTO;
import com.example.peliculas.model.Pelicula;
import com.example.peliculas.repository.IRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaService {
    //Atributo
    private IRepository<Pelicula> peliculaRepository;


    //Constructor
    public PeliculaService(IRepository<Pelicula> peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    //Métodos
    public Pelicula agregarPelicula(Pelicula pelicula){
        return this.peliculaRepository.agregar(pelicula);
    }
    public List<PeliculaDTO> buscarTodas(){
        ObjectMapper mapper = new ObjectMapper();
        List<Pelicula> peliculas = peliculaRepository.buscar();
        List<PeliculaDTO> peliculasDTO = new ArrayList<PeliculaDTO>();

        for(Pelicula pelicula : peliculas) {
            PeliculaDTO peliculaDTO = mapper.convertValue(pelicula,PeliculaDTO.class);
            peliculasDTO.add(peliculaDTO);
        }

        return peliculasDTO;
    }

    public Boolean eliminar(Integer id){
        return peliculaRepository.eliminar(id);
    }

    public Pelicula actualizar(Pelicula pelicula){return peliculaRepository.actualizar(pelicula);}

    public Pelicula buscar(Integer id){return peliculaRepository.buscar(id);}
}
