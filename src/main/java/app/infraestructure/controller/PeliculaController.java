package app.infraestructure.controller;

import app.application.services.interfaces.IPeliculaSerieService;
import app.dominio.dto.PeliculaSerieDto;
import app.dominio.dto.PersonajeDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/pelicula-serie")
public class PeliculaController {

    @Autowired
    private IPeliculaSerieService peliculaSerieService;

    @GetMapping("/{titulo}")
    public ResponseEntity<?> findByName(@PathVariable(name = "titulo") String titulo){
        return ResponseEntity.ok(peliculaSerieService.findByTtile(titulo));
    }

    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(peliculaSerieService.findAll());
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<?> findAllByTitulo(@PathVariable(name = "genero") String genero){
        return ResponseEntity.ok(peliculaSerieService.finbAllByGender(genero));
    }

    //Crear Perlicula Serie
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PeliculaSerieDto peliculaSerieDto){
        return ResponseEntity.ok(peliculaSerieService.create(peliculaSerieDto));
    }

    @GetMapping("/películas/fechas")
    public ResponseEntity<?> fromAndTo(@RequestParam(name = "desde")LocalDate fechaDesde,
                                       @RequestParam(name = "hasta") LocalDate fechaHasta){

        return ResponseEntity.ok(peliculaSerieService.fromAndTo(fechaDesde, fechaHasta));
    }


    @GetMapping("/películas/calificacion")
    public ResponseEntity<?> byCalificacion(@RequestParam(name = "desde")Short calificacionDesde,
                                       @RequestParam(name = "hasta") Short calificacionHasta){

        return ResponseEntity.ok(peliculaSerieService.calificacionBetween(calificacionDesde, calificacionHasta));
    }


    @PutMapping("/películas/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody PeliculaSerieDto peliculaSerieDto, @PathVariable(name = "id") Long peliculaSerieId) throws Exception {
        return ResponseEntity.ok(peliculaSerieService.update(peliculaSerieDto, peliculaSerieId));
    }
}