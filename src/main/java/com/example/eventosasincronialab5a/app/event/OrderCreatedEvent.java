package com.example.eventosasincronialab5a.app.event;

import org.springframework.context.ApplicationEvent;
import java.util.List;

public class OrderCreatedEvent extends ApplicationEvent {

    private final String orderId;
    private final String email;
    private final List<String> productos;

    public OrderCreatedEvent(Object source, String orderId, String email, List<String> productos) {
        super(source);
        this.orderId = orderId;
        this.email = email;
        this.productos = productos;
    }
    public String getOrderId() { return orderId; }
    public String getEmail() { return email; }
    public List<String> getProductos() { return productos; }
}