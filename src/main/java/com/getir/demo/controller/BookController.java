package com.getir.demo.controller;

import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.model.dto.BookDTO;
import com.getir.demo.model.dto.UpdateBookDTO;
import com.getir.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BaseResponse save(@RequestBody @Valid BookDTO bookDTO) {
        return BaseResponse.createSucessResponse(bookService.save(bookDTO));
    }

    @PostMapping("/update-stock")
    public BaseResponse updateStock(@RequestBody @Valid UpdateBookDTO bookDTO) {
        return BaseResponse.createSucessResponse(bookService.updateStock(bookDTO));
    }

    @GetMapping("/stocks")
    public BaseResponse getBookStocks() {
        return BaseResponse.createSucessResponse(bookService.getStocks());
    }
}
