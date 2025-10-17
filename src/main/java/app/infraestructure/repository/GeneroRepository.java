package app.infraestructure.repository;

import app.infraestructure.entity.Genero;
import app.infraestructure.entity.PeliculaSerie;
import app.infraestructure.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    List<Genero> findByNombre(String nombre);
}
