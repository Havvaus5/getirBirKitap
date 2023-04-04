package com.getir.demo.controller;


import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/book")
    public BaseResponse getBookStocks() {
        return BaseResponse.createSucessResponse(stockService.getStocks());
    }

}
