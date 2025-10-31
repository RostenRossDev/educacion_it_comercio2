package app.dominio.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotFoundPersonajeId extends RuntimeException{

    private Long characterId;

    public NotFoundPersonajeId(Long id){
        super("No existe el personaje con el id solicitado: " + id);
        this.characterId = id;
    }
}
