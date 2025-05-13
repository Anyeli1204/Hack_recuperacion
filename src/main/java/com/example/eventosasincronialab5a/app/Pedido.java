package com.example.eventosasincronialab5a.app;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Pedido {

    @Id
    private String id;

    @ManyToOne
    private Usuario usuario;

    @ElementCollection
    private List<String> productos;

    public Pedido() {}

    public Pedido(String id, Usuario usuario, List<String> productos) {
        this.id = id;
        this.usuario = usuario;
        this.productos = productos;
    }

    // Getters y Setters
}