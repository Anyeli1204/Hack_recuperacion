package com.example.eventosasincronialab5a.app.controller;

import com.example.eventosasincronialab5a.app.domain.Pedido;
import com.example.eventosasincronialab5a.app.PedidoRepository;
import com.example.eventosasincronialab5a.app.domain.Usuario;
import com.example.eventosasincronialab5a.app.UsuarioRepository;
import com.example.eventosasincronialab5a.app.event.OrderCreatedEvent;
import com.example.eventosasincronialab5a.app.service.createOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private createOrderService createOrderServices;

    @PostMapping
    public String createOrder(@RequestParam String email, @RequestParam List<String> productos) {
        return createOrderServices.createOrder(email, productos);
    }
}
