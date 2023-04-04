package com.getir.demo.service.impl;

import com.getir.demo.model.data.OrderStatics;
import com.getir.demo.repository.OrderRepository;
import com.getir.demo.service.ReportService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = Exception.class)
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderStatics> getMonthlyStatics() {
        List<OrderStatics> orders = orderRepository.getMonthlyStatics();
        return orders;
    }
}
