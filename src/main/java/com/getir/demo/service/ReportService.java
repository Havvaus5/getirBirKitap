package com.getir.demo.service;

import com.getir.demo.model.data.OrderStatics;

import java.util.List;

public interface ReportService {

    List<OrderStatics> getMonthlyStatics();
}
