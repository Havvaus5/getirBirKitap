package com.getir.demo.controller;


import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.model.dto.CustomerDTO;
import com.getir.demo.service.BookOrderService;
import com.getir.demo.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    private final BookOrderService bookOrderService;

    @PostMapping
    public BaseResponse save(@RequestBody @Valid CustomerDTO customerDTO) {
        return BaseResponse.createSucessResponse(customerService.save(customerDTO));
    }

    @GetMapping("orders")
    public BaseResponse getOrdersByCustomerId(@RequestParam Long customerId, @PathVariable int page, @PathVariable int size) {
        return BaseResponse.createSucessResponse(bookOrderService.getOrdersByCustomerId(customerId, page, size));
    }

}
