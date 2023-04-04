package com.getir.demo.controller;


import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.service.BookOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
    public BaseResponse queryByDate(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return BaseResponse.createSucessResponse(bookOrderService.queryByDate(startDate, endDate));
    }

}
