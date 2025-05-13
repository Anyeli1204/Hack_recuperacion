package com.example.eventosasincronialab5a.app;

import com.example.eventosasincronialab5a.app.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {}