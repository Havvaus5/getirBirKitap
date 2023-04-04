package com.getir.demo.controller;


import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.model.dto.CustomerDTO;
import com.getir.demo.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public BaseResponse save(@RequestBody @Valid CustomerDTO customerDTO) {
        return BaseResponse.createSucessResponse(customerService.save(customerDTO));
    }
}
