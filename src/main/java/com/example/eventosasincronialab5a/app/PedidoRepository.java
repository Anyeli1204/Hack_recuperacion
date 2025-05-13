package com.example.eventosasincronialab5a.app;

import com.example.eventosasincronialab5a.app.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, String> {}