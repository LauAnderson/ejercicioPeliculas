package com.example.peliculas.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepository <T>{
    T agregar(T t);
    List<T> buscar();
    T actualizar(T t);
    Boolean eliminar(Integer id);
    T buscar(Integer id);

}

