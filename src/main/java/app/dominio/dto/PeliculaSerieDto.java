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

    @NotEmpty
    String titulo;
    LocalDate fechaCreacion;

    @Min(1)
    @Max(5)
    Short calificacion;
}
