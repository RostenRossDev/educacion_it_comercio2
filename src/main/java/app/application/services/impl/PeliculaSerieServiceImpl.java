package app.application.services.impl;

import app.application.services.interfaces.IPeliculaSerieService;
import app.dominio.PersonajeDominio;
import app.dominio.dto.PeliculaSerieDto;
import app.infraestructure.entity.PeliculaSerie;
import app.infraestructure.entity.Personaje;
import app.infraestructure.repository.PeliculaSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaSerieServiceImpl implements IPeliculaSerieService {

    @Autowired
    private PeliculaSerieRepository peliculaSerieRepository;

    @Override
    public app.dominio.PeliculaSerie findByTtile(String nombre) {
        List<PeliculaSerie> peliculaSeriesEntity =  peliculaSerieRepository.findByTitulo(nombre);
        if(!peliculaSeriesEntity.isEmpty()) {
            PeliculaSerie p = peliculaSeriesEntity.get(0);

            List<PersonajeDominio> personajesDom = getPersonajesDom(p.getPersonajesAsiciados());

            return new app.dominio.PeliculaSerie(p.getTitulo(), p.getFechaCreacion(), p.getCalificacion(), personajesDom);
        }
        return new app.dominio.PeliculaSerie(null,null,null,null);
    }


    @Override
    public List<app.dominio.PeliculaSerie> findAll() {
        List<PeliculaSerie> peliculasYSeries  = peliculaSerieRepository.findAll();
        List<app.dominio.PeliculaSerie> perliculasYSeriesDom = new ArrayList<>();

        peliculasYSeries.forEach(p -> {
            List<PersonajeDominio> personajesDom = getPersonajesDomList(p.getPersonajesAsiciados());
            app.dominio.PeliculaSerie peliculaSerie = new app.dominio.PeliculaSerie(p.getTitulo(), p.getFechaCreacion(), p.getCalificacion(), personajesDom);
            perliculasYSeriesDom.add(peliculaSerie);
        });

        return perliculasYSeriesDom;
    }



    @Override
    public List<app.dominio.PeliculaSerie> finbAllByGender(String gender) {
        if (gender == null || gender.isEmpty())
            return new ArrayList<>();
            
        List<PeliculaSerie> perliculasYSeries  = peliculaSerieRepository.findAll()
                .stream().filter(peliculaSerie -> {
                    List<String> generos = peliculaSerie.getGeneros().stream().map( genero -> genero.getNombre()).toList();
                    return generos.contains(gender);
                }).toList();

        List<app.dominio.PeliculaSerie> peliculasSeriesDom = new ArrayList<>();
        List<app.dominio.PeliculaSerie> perliculasYSeriesDom = new ArrayList<>();

        perliculasYSeries.forEach(p -> {
            List<PersonajeDominio> personajesDom = getPersonajesDomList(p.getPersonajesAsiciados());
            app.dominio.PeliculaSerie peliculasSerieDom = new app.dominio.PeliculaSerie(p.getTitulo(), p.getFechaCreacion(), p.getCalificacion(), personajesDom);
            peliculasSeriesDom.add(peliculasSerieDom);
        });

        return peliculasSeriesDom;
    }

    @Override
    public PeliculaSerie create(PeliculaSerieDto peliculaSerieDto) {
        PeliculaSerie newPeliculaSerie = new PeliculaSerie();
        newPeliculaSerie.setCalificacion(peliculaSerieDto.getCalificacion());
        newPeliculaSerie.setTitulo(peliculaSerieDto.getTitulo());
        newPeliculaSerie.setFechaCreacion(peliculaSerieDto.getFechaCreacion());

        return peliculaSerieRepository.save(newPeliculaSerie);
    }


    // Metodos Privados

    private List<PersonajeDominio> getPersonajesDom(List<Personaje> personajesAsiciados) {
        List<PersonajeDominio> personajesDom = new ArrayList<>();

        personajesAsiciados.forEach(item -> {
            PersonajeDominio personajeDominio = new PersonajeDominio(item.getEdad(),
                    item.getPeso(),
                    item.getHistoria(), null);
            personajesDom.add(personajeDominio);
        });

        return personajesDom;
    }

    private List<PersonajeDominio> getPersonajesDomList(   List <Personaje> personajes) {
        List<PersonajeDominio> personajesDom = getPersonajesDom(personajes);
        return personajesDom;
    }
}
