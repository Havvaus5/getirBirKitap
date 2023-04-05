package com.getir.demo.controller;


import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.service.BookOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class BookOrderController {

    private final BookOrderService bookOrderService;

    @PostMapping
    public BaseResponse save(@RequestBody @Valid OrderDTO orderDTO) {
        return BaseResponse.createSucessResponse(bookOrderService.save(orderDTO));
    }

    @GetMapping("/{orderId}")
    public BaseResponse getOrdersById(@PathVariable Long orderId) {
        return BaseResponse.createSucessResponse(bookOrderService.getByOrderId(orderId));
    }

    @GetMapping("/query-by-date")
    public BaseResponse queryByDate(@RequestParam String startDate, @RequestParam String endDate) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime start = LocalDate.parse(startDate, formatter).atStartOfDay();
        LocalDateTime end = LocalDate.parse(endDate, formatter).atStartOfDay().plusDays(1);
        return BaseResponse.createSucessResponse(bookOrderService.queryByDate(start, end));
    }

}
