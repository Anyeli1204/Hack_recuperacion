package com.example.eventosasincronialab5a.app;

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
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
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
