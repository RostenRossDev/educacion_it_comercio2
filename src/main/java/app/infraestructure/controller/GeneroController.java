package app.infraestructure.controller;

import app.application.services.interfaces.IGeneroService;
import app.dominio.dto.PeliculaSerieDto;
import app.infraestructure.entity.Genero;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    @Qualifier("generoService1")
    private IGeneroService generoService;


    @Autowired
    @Qualifier("generoService2")
    private IGeneroService generoService2;


    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Genero> generos = generoService.findAll();
        List<app.dominio.Genero> dominio = generos.stream().map(entity -> new app.dominio.Genero(entity.getNombre(), null)).collect(Collectors.toList());
        return ResponseEntity.ok(dominio);
    }

    //Crear un genero

    @PostMapping
    public ResponseEntity<?> create(@RequestParam(name = "nombre") String nombre){
        return ResponseEntity.ok(generoService.create(nombre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        generoService.deleteById(id);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("V2/{id}")
    public ResponseEntity<?> delete2(@PathVariable(name = "id") Long id){
        generoService2.deleteById(id);
        return ResponseEntity.ok("");
    }
}
