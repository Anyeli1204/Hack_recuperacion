package org.example.recuperacion.listener;

import org.example.recuperacion.EmailService;
import org.example.recuperacion.event.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    @Autowired
    private EmailService emailService;

    @Async
    @EventListener
    public void handle(OrderCreatedEvent event) {
        var order = event.getOrder();
        String to = order.getEmail();
        String subject = "Confirmación de pedido";
        String body = "Hola, tu pedido con ID " + order.getId() + " fue recibido con éxito. Gracias por comprar.";
        emailService.sendEmail(to, subject, body);
    }
}
