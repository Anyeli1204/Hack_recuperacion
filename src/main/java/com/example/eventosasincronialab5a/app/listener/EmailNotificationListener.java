package com.example.eventosasincronialab5a.app.listener;

import com.example.eventosasincronialab5a.app.event.OrderCreatedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {
    private static final Logger logger = LogManager.getLogger(EmailNotificationListener.class);

    @Async
    @EventListener
    public void handle(OrderCreatedEvent event) {
        logger.info("📧 Simulando envío de correo a: {} por pedido {}", event.getEmail(), event.getOrderId());
    }
}
