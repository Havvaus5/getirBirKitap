package com.getir.demo.service;

import com.getir.demo.model.dto.BookDTO;
import com.getir.demo.model.dto.StockDTO;
import com.getir.demo.model.dto.UpdateBookDTO;

import java.util.List;

public interface BookService {
    String save(BookDTO bookDTO);

    List<StockDTO> getStocks();

    String updateStock(UpdateBookDTO bookDTO);
}
