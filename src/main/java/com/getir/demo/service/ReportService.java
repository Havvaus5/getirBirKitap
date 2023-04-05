package com.getir.demo.service;

import com.getir.demo.model.dto.OrderStaticsDTO;

import java.util.List;

public interface ReportService {

    List<OrderStaticsDTO> getMonthlyStatics();
}
