package com.getir.demo.mapper;

import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.model.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    Order map(OrderDTO orderDTO);

    OrderDTO map(Order order);

    List<OrderDTO> map(List<Order> customerOrders);
}
