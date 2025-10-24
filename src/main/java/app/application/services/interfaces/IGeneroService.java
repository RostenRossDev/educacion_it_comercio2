package app.application.services.interfaces;

import app.infraestructure.entity.Genero;

import java.util.List;

public interface IGeneroService {

    List<Genero> findAll();
    List<Genero> findByName(String name);
    Genero findById(Long id);
    Genero save(Genero genero);
    void deleteById(Long id);

    Genero create(String nombre);
}
