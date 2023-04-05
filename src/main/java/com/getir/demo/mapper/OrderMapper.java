package com.getir.demo.mapper;

import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.model.dto.OrderDetailDTO;
import com.getir.demo.model.entity.BookOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface OrderMapper {

    BookOrder map(OrderDTO orderDTO);

    @Mappings({
            @Mapping(source = "bookOrder.customer.name", target = "customerName"),
            @Mapping(source = "bookOrder.customer.surname", target = "customerSurname"),
            @Mapping(source = "bookOrder.book.name", target = "bookName")
    })
    OrderDetailDTO map(BookOrder bookOrder);

    List<OrderDTO> map(List<BookOrder> customerBookOrders);
}
