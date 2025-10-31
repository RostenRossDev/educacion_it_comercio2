package app.application.services.impl;

import app.application.services.interfaces.IGeneroService;
import app.infraestructure.entity.Genero;
import app.infraestructure.repository.GeneroRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
@Log4j2
@Service("generoService2")
public class GeneroServiceImpl2 implements IGeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> findAll() {
        return null;
    }

    @Override
    public List<Genero> findByName(String name) {
        return null;
    }

    @Override
    public Genero findById(Long id) {
        return null;
    }

    @Override
    public Genero save(Genero genero) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        log.info("No borre NADA xq todabia estoy en BETA");
    }

    @Override
    public Genero create(String nombre) {
        return null;
    }
}
