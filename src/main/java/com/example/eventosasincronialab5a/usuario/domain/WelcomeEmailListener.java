package com.example.eventosasincronialab5a.usuario.domain;

import com.example.eventosasincronialab5a.usuario.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEmailListener {
    @Autowired
    private EmailService emailService;

    @EventListener
    @Async
    public void sendWelcomeEmail(WelcomeEmailEvent welcomeEmailEvent) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("The Thread was interrupted", e);
        }
        emailService.sendEmail(welcomeEmailEvent.getEmail(),"Bienvenido","Hola " + welcomeEmailEvent.getNombre() + ", bienvenido a SpringBoot");
    }
}
