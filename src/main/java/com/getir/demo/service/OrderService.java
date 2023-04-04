package com.getir.demo.service;

import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.model.entity.Order;

import java.util.List;

public interface OrderService {
    String save(OrderDTO orderDTO);

    List<OrderDTO> getOrdersByCustomerId(Long customerId);

    OrderDTO getByOrderId(Long orderId);

    List<Order> findAll();
}
