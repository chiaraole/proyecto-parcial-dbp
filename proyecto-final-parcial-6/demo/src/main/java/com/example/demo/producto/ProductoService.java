package com.example.demo.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.usuario.domain.User;
import com.example.demo.usuario.repository.UserRepository;


@Service
public class ProductoService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductoRepository  productoRepository;
    
    public Producto saveProducto(Long userId, Producto producto) {
        User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        producto.setUserProfile(user);
        return productoRepository.save(producto);
    }   

    //guardar producto
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    //buscar producto por Id
    public Optional<Producto> findProductoById(Long id) {
        return productoRepository.findById(id);
    }

    //encontrar todos los productos
    public List<Producto> findAllProductos() {
        return productoRepository.findAll();
    }

    //encontrar los productos de cierto UserProfile?
    
    public List<Producto> findidProductos(Long id) {
        Optional<User> userOptional= userRepository.findById(id);
        
        return userOptional.get().getProducto();
    }

    //patchear producto
    public Optional<Producto> patchSong(Long id, Producto producto) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto existingProducto = optionalProducto.get();
            if (producto.getTitulo() != null) {
                existingProducto.setTitulo(producto.getTitulo());
            }
            if (producto.getAutor() != null) {
                existingProducto.setAutor(producto.getAutor());
            }
            if (producto.getGenero() != null) {
                existingProducto.setGenero(producto.getGenero());
            }
            if (producto.getSinopsis() != null) {
                existingProducto.setSinopsis(producto.getSinopsis());
            }
            if (producto.getAñoPublicacion()!= null) {
                existingProducto.setAñoPublicacion(producto.getAñoPublicacion());
            }
            if (producto.getImagenPortada()!= null) {
                existingProducto.setImagenPortada(producto.getImagenPortada());
            }
            if (producto.getEstado()!= null) {
                existingProducto.setEstado(producto.getEstado());
            }
            if (producto.getSeguro()!= -1) { //ver si funciona bien
                existingProducto.setSeguro(producto.getSeguro());
            }
            productoRepository.save(existingProducto);
            }
            return optionalProducto;

        }

        public Optional<Producto> deleteProducto(Long id) {
            Optional<Producto> optionalProducto = productoRepository.findById(id);
            if (optionalProducto.isPresent()) {
                Producto existingProducto = optionalProducto.get();
                
                List<Producto> productosDelUsuario = productoRepository.findByUser_firstName(existingProducto.getUser().getFirstName());
        
                for (Producto producto : productosDelUsuario) {
                    productoRepository.delete(producto);
                }
            }
            return optionalProducto;
        }

        public Optional<Producto> enviarSolicitud(Long id, Long userId) {
            return null;
        }
        
       
}