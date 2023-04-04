package com.getir.demo.controller;


import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public BaseResponse save(@RequestBody @Valid OrderDTO orderDTO) {
        return BaseResponse.createSucessResponse(orderService.save(orderDTO));
    }

    @GetMapping("by-customerId/{customerId}")
    public BaseResponse getOrdersByCustomerId(@PathVariable Long customerId) {
        return BaseResponse.createSucessResponse(orderService.getOrdersByCustomerId(customerId));
    }

    @GetMapping("/{orderId}")
    public BaseResponse getOrdersById(@PathVariable Long orderId) {
        return BaseResponse.createSucessResponse(orderService.getByOrderId(orderId));
    }

}
