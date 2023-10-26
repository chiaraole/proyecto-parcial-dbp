package com.example.demo.producto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.example.demo.usuario.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",nullable=false)
    private Long id; 

    private String titulo;
    private String autor;
    private String genero;
    private String sinopsis;
    private Date añoPublicacion;
    private String imagenPortada;
    private String estado; 
    private int seguro;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //linkear al user profile(un usuario varios libros- un libro un usuario)

    public Producto(){}
    public Producto(Long id, String titulo, String autor, String genero, String sinopsis, Date añoPublicacion, String imagenPortada, String estado, int seguro, User user) {
        //poner dueño al final
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.añoPublicacion = añoPublicacion;
        this.imagenPortada = imagenPortada;
        this.estado = estado;
        this.seguro = seguro;
        this.user= user;

    }

    
    public void setUser(User user) {
        this.user = user;
    }

    //getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getSeguro() {
        return seguro;
    }

    public void setSeguro(int seguro) {
        this.seguro = seguro;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Date getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(Date añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getImagenPortada() {
        return imagenPortada;
    }

    public void setImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    public User getUserProfile() {
        return user;
    }

    public void setUserProfile(User user) {
        this.user = user;
    }
    public User getUser() {
        return null;
    }
    

}
