package com.example.eventosasincronialab5a.usuario.domain;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class WelcomeEmailEvent extends ApplicationEvent {
    private String email;
    private String nombre;
    public WelcomeEmailEvent(Object source, String email, String nombre) {
        super(source);
        this.email = email;
        this.nombre = nombre;
    }
}
