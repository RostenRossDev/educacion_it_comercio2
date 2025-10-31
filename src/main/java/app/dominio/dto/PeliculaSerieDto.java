package app.dominio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PeliculaSerieDto {

    private Long id;

    @NotEmpty(message = "El titulo no puede estar vacio.")
    String titulo;
    LocalDate fechaCreacion;

    @Min(value = 1, message = "El valor debe ser positivo mayor a cero.")
    @Max(value = 5, message = "El valor debe ser menor a 6.")
    Short calificacion;
}
