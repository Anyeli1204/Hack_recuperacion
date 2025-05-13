package org.example.recuperacion.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.recuperacion.event.OrderCreatedEvent;
import org.example.recuperacion.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Slf4j // <-- Agregado aquí
public class OrderController {


    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        eventPublisher.publishEvent(new OrderCreatedEvent(this, order));
        log.info("Evento publicado para el pedido ID: {}", order.getId());
        return ResponseEntity.ok("Pedido recibido y evento publicado.");
    }
}
