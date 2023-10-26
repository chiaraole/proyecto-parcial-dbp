
package com.example.demo.transacciones;

import com.example.demo.usuario.domain.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

import  com.example.demo.producto.Producto;


@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Transacciones {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",nullable=false)
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String estado;


    @OneToOne
    private Producto producto; // Relación uno a uno con Producto

    @ManyToOne
    private User usuario; // Relación muchos a uno con Usuario

    public Transacciones(){}
    public Transacciones( LocalDate fechaInicio, LocalDate fechaFinal, Producto producto){
        this.fechaInicio=fechaInicio;
        this.fechaFinal=fechaFinal;
        this.producto=producto;
    
    }

    public Long getId() {
    return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getEstado(){
        return estado;
    }
   

}