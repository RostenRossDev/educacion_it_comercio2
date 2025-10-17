package app.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "gender")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @ManyToMany(mappedBy = "generos") //en el mappedBy se coloca el nombre del ATRIBUTO de la otra clase
    private List<PeliculaSerie> peliculasSeries;
}
