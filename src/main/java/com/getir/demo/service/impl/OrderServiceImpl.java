package com.getir.demo.service.impl;

import com.getir.demo.exception.GetirException;
import com.getir.demo.mapper.OrderMapper;
import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.model.entity.Order;
import com.getir.demo.model.entity.Stock;
import com.getir.demo.model.type.OrderStatus;
import com.getir.demo.repository.OrderRepository;
import com.getir.demo.service.CustomerService;
import com.getir.demo.service.OrderService;
import com.getir.demo.service.StockService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = Exception.class)
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderedMapper;

    private final StockService stockService;

    private final CustomerService customerService;

    @Override
    public String save(OrderDTO orderDTO) {
        Stock stock = stockService.getStock(orderDTO.getBookId());
        if (stock.getStockNumber() < orderDTO.getAdet()) {
            throw new GetirException("Yeteri Kadar stok bulunamadı");
        }

        Order order = orderedMapper.map(orderDTO);
        order.setOrderStatus(OrderStatus.RECEIVED);
        order.setBook(stock.getBook());
        order.setCustomer(customerService.getCustomerById(orderDTO.getCustomerId()));

        order = orderRepository.save(order);
        stock.updateStockNumber(order.getOrderQuantity());
        return String.format("%s numaralı siparişiniz alınmıştır.", order.getId());
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) {
        List<Order> customerOrders = orderRepository.getCustomerOrders(customerId);
        return orderedMapper.map(customerOrders);
    }

    @Override
    public OrderDTO getByOrderId(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.map(order -> orderedMapper.map(order))
                .orElseThrow(() -> new GetirException("Sipariş bulunamadı"));
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
