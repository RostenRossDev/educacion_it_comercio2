package app.dominio;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genero {
    private String nombre;
    private List<PeliculaSerie> peliculasSeries;
}
