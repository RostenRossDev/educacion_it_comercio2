package app.dominio.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PeliculaSerieDto {
    private Long id;
    String titulo;
    LocalDate fechaCreacion;
    Short calificacion;
}
