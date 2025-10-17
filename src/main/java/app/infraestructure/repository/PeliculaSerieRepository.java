package app.infraestructure.repository;

import app.infraestructure.entity.PeliculaSerie;
import app.infraestructure.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {

    List<Personaje> findByTitulo(String titulo);
}
