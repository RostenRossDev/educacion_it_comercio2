package app.application.services.impl;

import app.application.services.interfaces.IPersonajeService;
import app.dominio.PeliculaSerie;
import app.dominio.PersonajeDominio;
import app.dominio.dto.PersonajeDto;
import app.infraestructure.entity.Personaje;
import app.infraestructure.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public PersonajeDominio findByName(String nombre) {
        List<app.infraestructure.entity.Personaje> personajesEntity =  personajeRepository.findByNombre(nombre);

        if(!personajesEntity.isEmpty()) {
            app.infraestructure.entity.Personaje p = personajesEntity.get(0);
            app.infraestructure.entity.PeliculaSerie ps = p.getPeliculaSerie();
            List<app.infraestructure.entity.Personaje> personajes = ps.getPersonajesAsiciados();
            PeliculaSerie peliculaSerie = new PeliculaSerie(ps.getTitulo(), ps.getFechaCreacion(), ps.getCalificacion(), null);
            return new PersonajeDominio(p.getEdad(), p.getPeso(), p.getHistoria(), peliculaSerie);
        }
        return new PersonajeDominio(null,null,null,null);
    }

    @Override
    public List<PersonajeDominio> findAll() {
        List<app.infraestructure.entity.Personaje> personajes  = personajeRepository.findAll();
        List<PersonajeDominio> personajesDom = new ArrayList<>();

        personajes.forEach(p -> {
            PersonajeDominio personajeDominio = new PersonajeDominio(p.getEdad(), p.getPeso(), p.getHistoria(), null);
            personajesDom.add(personajeDominio);
        });

        return personajesDom;
    }

    @Override
    public List<PersonajeDominio> finbAllByEdad(Short edad) {
        if (edad == null)
            return new ArrayList<>();

        List<app.infraestructure.entity.Personaje> personajes  = personajeRepository.findAll()
                .stream().filter(p -> edad.equals(p.getEdad())  ).toList();

        List<PersonajeDominio> personajesDom = new ArrayList<>();

        personajes.forEach(p -> {
            PersonajeDominio personajeDominio = new PersonajeDominio(p.getEdad(), p.getPeso(), p.getHistoria(), null);
            personajesDom.add(personajeDominio);
        });

        return personajesDom;
    }

    @Override
    public Personaje create(PersonajeDto personajeDto) {
        Personaje newPersonaje = new Personaje();
        newPersonaje.setEdad(personajeDto.getEdad());
        newPersonaje.setPeso(personajeDto.getPeso());
        newPersonaje.setHistoria(personajeDto.getHistoria());
        newPersonaje.setNombre(personajeDto.getNombre());
        return personajeRepository.save(newPersonaje);
    }

}
