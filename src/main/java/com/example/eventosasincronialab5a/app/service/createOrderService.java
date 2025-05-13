package com.example.eventosasincronialab5a.app.service;

import com.example.eventosasincronialab5a.app.PedidoRepository;
import com.example.eventosasincronialab5a.app.UsuarioRepository;
import com.example.eventosasincronialab5a.app.domain.Pedido;
import com.example.eventosasincronialab5a.app.domain.Usuario;
import com.example.eventosasincronialab5a.app.event.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
public class createOrderService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    public String createOrder(@RequestParam String email, @RequestParam List<String> productos) {
        // Verificar usuario o crearlo
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseGet(() -> usuarioRepository.save(new Usuario(email)));

        // Crear y guardar pedido
        String orderId = UUID.randomUUID().toString();
        Pedido pedido = new Pedido(orderId, usuario, productos);
        pedidoRepository.save(pedido);

        // Publicar evento
        publisher.publishEvent(new OrderCreatedEvent(this, orderId, email, productos));
        return "✅ Pedido creado y evento lanzado.";
    }
}
