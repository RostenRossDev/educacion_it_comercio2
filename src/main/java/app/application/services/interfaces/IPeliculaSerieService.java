package app.application.services.interfaces;

import app.dominio.dto.PeliculaSerieDto;
import app.infraestructure.entity.PeliculaSerie;

import java.time.LocalDate;
import java.util.List;

public interface IPeliculaSerieService {

    app.dominio.PeliculaSerie findByTtile(String nombre);
    List<app.dominio.PeliculaSerie> findAll();
    List<app.dominio.PeliculaSerie> finbAllByGender(String gender);

    PeliculaSerie create(PeliculaSerieDto peliculaSerieDto);

    List<app.dominio.PeliculaSerie> fromAndTo(LocalDate fechaDesde, LocalDate fechaHasta);

    List<app.dominio.PeliculaSerie> calificacionBetween(Short calificacionDesde, Short calificacionHasta);

    app.dominio.PeliculaSerie update(PeliculaSerieDto dto, Long id) throws Exception;
}
