package com.getir.demo.service.impl;

import com.getir.demo.exception.GetirException;
import com.getir.demo.mapper.StockMapper;
import com.getir.demo.model.dto.StockDTO;
import com.getir.demo.model.entity.Stock;
import com.getir.demo.repository.StockRepository;
import com.getir.demo.service.StockService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = Exception.class)
@AllArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    private final StockMapper stockMapper;

    @Override
    public List<StockDTO> getStocks() {
        List<Stock> stocks = stockRepository.findAll();
        return stockMapper.map(stocks);
    }

    @Override
    public Stock getStock(Long bookId) {
        Optional<Stock> optionalStock = stockRepository.findByBookId(bookId);
        optionalStock.orElseThrow(() -> new GetirException("Stok bulunamadı"));
        return optionalStock.get();
    }
}
