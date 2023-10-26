package com.example.demo.transacciones;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.producto.Producto;
import com.example.demo.producto.ProductoService;


public class TransaccionesController {

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService; 

    @PostMapping("/solicitud/{id}")
    public ResponseEntity<String> enviarSolicitud(@PathVariable Long id, @RequestHeader("UserId") Long userId) {
        try {
            Optional<Producto> optionalProducto = productoService.enviarSolicitud(id, userId);
            if (optionalProducto.isPresent()) {
                return new ResponseEntity<>("Solicitud enviada, producto pendiente.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Producto no encontrado o no disponible.", HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

}
