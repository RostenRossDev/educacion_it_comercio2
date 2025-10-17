package app.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "pelicula_serie")
public class PeliculaSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String titulo;

    @Column(name = "fecha_creacion")
    LocalDate fechaCreacion;

    Byte calificacion;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Personaje> personajesAsiciados;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "genero_pelicula",
            joinColumns = @JoinColumn(name ="fk_pelicula_serie_id"),
            inverseJoinColumns = @JoinColumn(name ="fk_genero_id")
    )
    List<Genero> generos;
}
