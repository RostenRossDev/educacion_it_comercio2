package app.infraestructure.controller;

import app.application.services.interfaces.IGeneroService;
import app.infraestructure.entity.Genero;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private IGeneroService generoService;


    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<Genero> generos = generoService.findAll();
        List<app.dominio.Genero> dominio = generos.stream().map(entity -> new app.dominio.Genero(entity.getNombre(), null)).collect(Collectors.toList());
        return ResponseEntity.ok(dominio);
    }
}
