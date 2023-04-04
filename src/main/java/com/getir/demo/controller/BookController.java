package com.getir.demo.controller;

import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.model.dto.BookDTO;
import com.getir.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BaseResponse save(@RequestBody @Valid BookDTO bookDTO) {
        return BaseResponse.createSucessResponse(bookService.save(bookDTO));
    }
}
