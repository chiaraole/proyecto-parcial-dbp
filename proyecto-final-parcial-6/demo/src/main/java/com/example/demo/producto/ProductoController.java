package com.example.demo.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

//-----------------------------------------------------------------
//----------------------------------------------------------------

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.saveProducto(producto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> GradeId(@PathVariable Long id) {
        return new ResponseEntity<>(productoService.findProductoById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        return new ResponseEntity<>(productoService.findAllProductos(), HttpStatus.OK);
    }  

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Optional<Producto> patchedProducto = productoService.patchSong(id, producto);
        return patchedProducto.isPresent() ? ResponseEntity.status(200).body("Updated partially") : ResponseEntity.status(404).body("Not Found");
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        Optional<Producto> deletedProducto = productoService.deleteProducto(id);
        return deletedProducto.isPresent() ? ResponseEntity.status(200).body("Deleted") : ResponseEntity.status(404).body("Not Found");
    }
    

}
