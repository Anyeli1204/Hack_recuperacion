package com.example.eventosasincronialab5a.app;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Stock {

    @Id
    private String nombreProducto;

    private int cantidadDisponible;

    public Stock() {}

    public Stock(String nombreProducto, int cantidadDisponible) {
        this.nombreProducto = nombreProducto;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Getters y Setters
}