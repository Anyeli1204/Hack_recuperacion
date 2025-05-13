package org.example.recuperacion.listener;

import lombok.extern.slf4j.Slf4j;
import org.example.recuperacion.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditLogListener {

    @EventListener
    public void handle(OrderCreatedEvent event) {
        log.info("Pedido registrado en logs: ID={} Email={}",
                event.getOrder().getId(), event.getOrder().getEmail());
    }
}