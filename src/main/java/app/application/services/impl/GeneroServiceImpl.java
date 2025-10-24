package app.application.services.impl;

import app.application.services.interfaces.IGeneroService;
import app.infraestructure.entity.Genero;
import app.infraestructure.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    @Override
    public List<Genero> findByName(String name) {
        return generoRepository.findByNombre(name);
    }

    @Override
    public Genero findById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    @Override
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }

    @Override
    public Genero create(String nombre) {
        Genero newGender = new Genero();
        newGender.setNombre(nombre);
        return generoRepository.save(newGender);
    }
}
