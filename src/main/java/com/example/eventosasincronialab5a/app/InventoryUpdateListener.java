package com.example.eventosasincronialab5a.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {
    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);

    @Autowired
    private StockRepository stockRepository;

    @Async
    @EventListener
    public void handle(OrderCreatedEvent event) {
        for (String producto : event.getProductos()) {
            Stock stock = stockRepository.findById(producto).orElse(new Stock(producto, 10));
            stock.setCantidadDisponible(Math.max(0, stock.getCantidadDisponible() - 1));
            stockRepository.save(stock);
            logger.info("📦 Stock actualizado: {} → {}", producto, stock.getCantidadDisponible());
        }
    }
}
