package app.infraestructure.controller;

import app.application.services.interfaces.IPersonajeService;
import app.dominio.dto.PersonajeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
GET /personajes Obtiene                 todos los personajes y sus correspondientes datos.
GET /personajes/{edad}                  Busca los personajes de cierta edad.
*/

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private IPersonajeService personajeService;

    @GetMapping("/{nombre}")
    public ResponseEntity<?> findByName(@PathVariable(name = "nombre") String nombrePersonaje){
        return ResponseEntity.ok(personajeService.findByName(nombrePersonaje));
    }

    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(personajeService.findAll());
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> findAllByEdad(@PathVariable(name = "edad") Short edadPersonaje){
        return ResponseEntity.ok(personajeService.finbAllByEdad(edadPersonaje));
    }

//Crear personaje
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PersonajeDto personajeDto){
        return ResponseEntity.ok(personajeService.create(personajeDto));
    }
}
