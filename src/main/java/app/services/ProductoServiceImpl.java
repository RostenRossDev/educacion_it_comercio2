package app.services;

import app.entities.Producto;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl {

    public ResponseEntity<?> findProducts(){
        Producto p = new Producto(1L, "Yerba De Menta"); // simulacion de busqueda de productos
        return ResponseEntity.ok(List.of(p));
    }
}
