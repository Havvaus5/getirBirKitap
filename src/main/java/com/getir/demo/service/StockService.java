package com.getir.demo.service;

import com.getir.demo.model.dto.StockDTO;
import com.getir.demo.model.entity.Stock;

import java.util.List;

public interface StockService {
    List<StockDTO> getStocks();

    Stock getStock(Long bookId);

}
