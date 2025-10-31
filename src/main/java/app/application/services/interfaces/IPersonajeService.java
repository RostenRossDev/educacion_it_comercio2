package app.application.services.interfaces;

import app.dominio.PersonajeDominio;
import app.dominio.dto.PersonajeDto;
import app.infraestructure.entity.Personaje;

import java.util.List;

public interface IPersonajeService {

    PersonajeDominio findByName(String nombre);
    List<PersonajeDominio> findAll();
    List<PersonajeDominio> finbAllByEdad(Short edad);

    Personaje create(PersonajeDto personajeDto);

    List<PersonajeDominio> findEdadBetween(Short edadDesde, Short edadHasta);

    PersonajeDominio update(PersonajeDominio personaje, Long personajeId);
}
