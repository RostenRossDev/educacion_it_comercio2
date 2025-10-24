package app.dominio.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PersonajeDto {
    private Long id;

    private Short edad;

    private String nombre;

    private Integer peso;

    private String historia;
}
