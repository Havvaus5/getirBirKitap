package com.getir.demo.service.impl;

import com.getir.demo.exception.GetirException;
import com.getir.demo.mapper.OrderMapper;
import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.model.dto.OrderDetailDTO;
import com.getir.demo.model.entity.Book;
import com.getir.demo.model.entity.BookOrder;
import com.getir.demo.model.type.OrderStatus;
import com.getir.demo.repository.BookOrderRepository;
import com.getir.demo.repository.BookRepository;
import com.getir.demo.service.BookOrderService;
import com.getir.demo.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = Exception.class)
@AllArgsConstructor
public class BookOrderServiceImpl implements BookOrderService {

    private final BookOrderRepository bookOrderRepository;

    private final BookRepository bookRepository;

    private final OrderMapper orderedMapper;

    private final CustomerService customerService;

    @Override
    public String save(OrderDTO orderDTO) {
        Optional<Book> optionalBook = bookRepository.findById(orderDTO.getBookId());
        optionalBook.orElseThrow(() -> new GetirException("Kitap Bulunamadı"));
        Book book = optionalBook.get();
        if (book.getStockQuantity() < orderDTO.getOrderQuantity()) {
            throw new GetirException("Yeteri Kadar stok bulunamadı");
        }

        BookOrder bookOrder = orderedMapper.map(orderDTO);
        bookOrder.setOrderStatus(OrderStatus.RECEIVED);
        bookOrder.setBook(book);
        bookOrder.setCustomer(customerService.getCustomerById(orderDTO.getCustomerId()));
        bookOrder = bookOrderRepository.save(bookOrder);
        book.updateStockNumber(bookOrder.getOrderQuantity());
        return String.format("%s numaralı siparişiniz alınmıştır.", bookOrder.getId());
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId, int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        List<BookOrder> customerBookOrders = bookOrderRepository.getCustomerOrders(customerId);
        return orderedMapper.map(customerBookOrders);
    }

    @Override
    public OrderDetailDTO getByOrderId(Long orderId) {
        Optional<BookOrder> optionalOrder = bookOrderRepository.findById(orderId);
        return optionalOrder.map(order -> orderedMapper.map(order))
                .orElseThrow(() -> new GetirException("Sipariş bulunamadı"));
    }

    @Override
    public List<OrderDTO> queryByDate(LocalDateTime startDate, LocalDateTime endDate) {
        List<BookOrder> bookOrderList = bookOrderRepository.findByCreatedTimeBetween(startDate, endDate);
        return orderedMapper.map(bookOrderList);
    }

}
