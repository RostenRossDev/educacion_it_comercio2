package app.application.services.impl;

import app.application.services.interfaces.IPeliculaSerieService;
import app.dominio.PersonajeDominio;
import app.dominio.dto.PeliculaSerieDto;
import app.infraestructure.entity.PeliculaSerie;
import app.infraestructure.entity.Personaje;
import app.infraestructure.repository.PeliculaSerieRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
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

    @Override
    public List<app.dominio.PeliculaSerie> fromAndTo(LocalDate fechaDesde, LocalDate fechaHasta) {
        List<PeliculaSerie> filtrado = peliculaSerieRepository.findByFechaCreacionBetween(fechaDesde, fechaHasta);
        return getPeliculaSeries(filtrado);
    }



    @Override
    public List<app.dominio.PeliculaSerie> calificacionBetween(Short calificacionDesde, Short calificacionHasta) {
        List<PeliculaSerie> filtrado = peliculaSerieRepository.findByCalificacionGreaterThanAndCalificacionLessThan(calificacionDesde, calificacionHasta);
        return getPeliculaSeries(filtrado);
    }

    @Override
    public app.dominio.PeliculaSerie update(PeliculaSerieDto dto, Long id) throws Exception {
        PeliculaSerie peliculaSerie = peliculaSerieRepository.findById(id).orElse(null);
        log.info("Informacion original de la pelicula: " + peliculaSerie);
        if (peliculaSerie != null){

            if (dto.getTitulo() != null && !dto.getTitulo().isEmpty())
                peliculaSerie.setTitulo(dto.getTitulo());

            if (dto.getCalificacion() != null && dto.getCalificacion() < 5 && dto.getCalificacion() > 0)
                peliculaSerie.setCalificacion(dto.getCalificacion());

            if (dto.getFechaCreacion() != null && dto.getFechaCreacion().isBefore(LocalDate.now()))
                peliculaSerie.setFechaCreacion(dto.getFechaCreacion());

            log.info("Informacion nueva de la pelicula: " + peliculaSerie);

            peliculaSerie = peliculaSerieRepository.save(peliculaSerie);

            return null;
        }

        throw new Exception("No existe la pelicula");
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

    public static List<app.dominio.PeliculaSerie> getPeliculaSeries(List<PeliculaSerie> filtrado) {
        List<app.dominio.PeliculaSerie> result = new ArrayList<>();
        filtrado.forEach(pelicula -> {

            List<PersonajeDominio> personaesDom = new ArrayList<>();
            pelicula.getPersonajesAsiciados().forEach(personaje -> {
                //convertir la entidad persoanje a dominio
                PersonajeDominio personajeDom = new PersonajeDominio(personaje.getEdad(), personaje.getPeso(), personaje.getHistoria(), null);
                //agregar el dominio personaje a la lista de personajes
                personaesDom.add(personajeDom);
            });

            //convertir la entidad pelicula a dominio
            app.dominio.PeliculaSerie peliDom = new app.dominio.PeliculaSerie(pelicula.getTitulo(), pelicula.getFechaCreacion(), pelicula.getCalificacion(), personaesDom);
            //agregar el dominio a la lista final (lista de peliculas y series)
            result.add(peliDom);
        });
        return result;
    }
}
