package app.application.services.interfaces;

import app.dominio.dto.PeliculaSerieDto;
import app.infraestructure.entity.PeliculaSerie;

import java.util.List;

public interface IPeliculaSerieService {

    app.dominio.PeliculaSerie findByTtile(String nombre);
    List<app.dominio.PeliculaSerie> findAll();
    List<app.dominio.PeliculaSerie> finbAllByGender(String gender);

    PeliculaSerie create(PeliculaSerieDto peliculaSerieDto);
}
