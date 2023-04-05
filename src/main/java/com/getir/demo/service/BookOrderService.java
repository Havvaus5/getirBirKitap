package com.getir.demo.service;

import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.model.dto.OrderDetailDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface BookOrderService {
    String save(OrderDTO orderDTO);

    List<OrderDTO> getOrdersByCustomerId(Long customerId, int page, int size);

    OrderDetailDTO getByOrderId(Long orderId);

    List<OrderDTO> queryByDate(LocalDateTime startDate, LocalDateTime endDate);
}
