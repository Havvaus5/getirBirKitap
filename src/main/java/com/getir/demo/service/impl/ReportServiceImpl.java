package com.getir.demo.service.impl;

import com.getir.demo.model.data.OrderStatics;
import com.getir.demo.repository.BookOrderRepository;
import com.getir.demo.service.ReportService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = Exception.class)
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final BookOrderRepository bookOrderRepository;

    @Override
    public List<OrderStatics> getMonthlyStatics() {
        List<OrderStatics> orders = bookOrderRepository.getMonthlyStatics();
        return orders;
    }
}
