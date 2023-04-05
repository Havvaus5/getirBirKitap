package com.getir.demo.service.impl;

import com.getir.demo.model.data.OrderStatics;
import com.getir.demo.model.dto.OrderStaticsDTO;
import com.getir.demo.repository.BookOrderRepository;
import com.getir.demo.service.ReportService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = Exception.class)
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final BookOrderRepository bookOrderRepository;

    @Override
    public List<OrderStaticsDTO> getMonthlyStatics() {
        List<OrderStatics> orderStatics = bookOrderRepository.getMonthlyStatics();
        return orderStatics.stream().map(orderStatic -> new OrderStaticsDTO(orderStatic)).collect(Collectors.toList());
    }
}
