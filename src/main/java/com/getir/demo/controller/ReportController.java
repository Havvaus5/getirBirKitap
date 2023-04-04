package com.getir.demo.controller;


import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/monthly-orders")
    public BaseResponse getOrdersById() {
        return BaseResponse.createSucessResponse(reportService.getMonthlyStatics());
    }

}
