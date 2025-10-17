package app.dominio;

import java.time.LocalDate;
import java.util.List;

public record PeliculaSerie (String titulo, LocalDate fechaCreacion, Byte calificacion, List<Personaje> personajesAsociados) {
}