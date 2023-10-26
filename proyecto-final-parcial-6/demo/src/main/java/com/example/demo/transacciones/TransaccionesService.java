package com.example.demo.transacciones;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.producto.Producto;
import com.example.demo.producto.ProductoRepository;


public class TransaccionesService {

@Service
public class ProductoService {

     @Autowired
    private ProductoRepository productoRepository;

    public Optional<Producto> enviarSolicitud(Long productoId, Long userId) {
        Optional<Producto> optionalProducto = productoRepository.findById(productoId);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();

            if (producto.getUser().getId().equals(userId)) {
                throw new IllegalArgumentException("No puedes enviar una solicitud para tu propio producto.");
            }

            if ("disponible".equalsIgnoreCase(producto.getEstado())) {
                producto.setEstado("pendiente");
                productoRepository.save(producto);
            } else {
                throw new IllegalArgumentException("El producto no está disponible para enviar una solicitud.");
            }
        } else {
            throw new IllegalArgumentException("Producto no encontrado.");
        }
        return optionalProducto;
    }
}

}
