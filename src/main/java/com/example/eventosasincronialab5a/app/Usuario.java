package com.example.eventosasincronialab5a.app;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Usuario {

    @Id
    private String id;

    @Column(unique = true)
    private String email;

    public Usuario() {
        this.id = UUID.randomUUID().toString();
    }

    public Usuario(String email) {
        this();
        this.email = email;
    }

    // Getters y Setters
}
