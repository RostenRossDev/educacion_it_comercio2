package app.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "character")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age")
    private Short edad;

    @Column(name = "name")
    private String nombre;

    @Column(name = "weight")
    private Integer peso;

    @Column(name = "lore")
    private String historia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_peliculaserie_id")
    private PeliculaSerie peliculaSerie;
}