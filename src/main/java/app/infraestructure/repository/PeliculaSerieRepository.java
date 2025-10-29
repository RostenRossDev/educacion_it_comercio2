package app.infraestructure.repository;

import app.infraestructure.entity.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {

    List<PeliculaSerie> findByTitulo(String titulo);

    List<PeliculaSerie> findByFechaCreacionBetween(LocalDate desde, LocalDate hasta);

    List<PeliculaSerie> findByCalificacionGreaterThanAndLessThan (Short desde, Short hasta);
}
