package app.controller;

import app.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoRestController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping("/productos")
    public ResponseEntity<?> findProduct(){
        return productoService.findProducts();
    }
}
