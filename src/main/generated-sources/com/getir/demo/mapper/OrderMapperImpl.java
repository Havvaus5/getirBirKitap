package com.getir.demo.mapper;

import com.getir.demo.model.dto.OrderDTO;
import com.getir.demo.model.dto.OrderDetailDTO;
import com.getir.demo.model.entity.Book;
import com.getir.demo.model.entity.BookOrder;
import com.getir.demo.model.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public BookOrder map(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        BookOrder bookOrder = new BookOrder();

        bookOrder.setOrderQuantity( orderDTO.getOrderQuantity() );

        return bookOrder;
    }

    @Override
    public OrderDetailDTO map(BookOrder bookOrder) {
        if ( bookOrder == null ) {
            return null;
        }

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

        orderDetailDTO.setCustomerName( bookOrderCustomerName( bookOrder ) );
        orderDetailDTO.setCustomerSurname( bookOrderCustomerSurname( bookOrder ) );
        orderDetailDTO.setBookName( bookOrderBookName( bookOrder ) );
        orderDetailDTO.setOrderQuantity( bookOrder.getOrderQuantity() );

        return orderDetailDTO;
    }

    @Override
    public List<OrderDTO> map(List<BookOrder> customerBookOrders) {
        if ( customerBookOrders == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( customerBookOrders.size() );
        for ( BookOrder bookOrder : customerBookOrders ) {
            list.add( bookOrderToOrderDTO( bookOrder ) );
        }

        return list;
    }

    private String bookOrderCustomerName(BookOrder bookOrder) {
        if ( bookOrder == null ) {
            return null;
        }
        Customer customer = bookOrder.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String name = customer.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String bookOrderCustomerSurname(BookOrder bookOrder) {
        if ( bookOrder == null ) {
            return null;
        }
        Customer customer = bookOrder.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String surname = customer.getSurname();
        if ( surname == null ) {
            return null;
        }
        return surname;
    }

    private String bookOrderBookName(BookOrder bookOrder) {
        if ( bookOrder == null ) {
            return null;
        }
        Book book = bookOrder.getBook();
        if ( book == null ) {
            return null;
        }
        String name = book.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected OrderDTO bookOrderToOrderDTO(BookOrder bookOrder) {
        if ( bookOrder == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderQuantity( bookOrder.getOrderQuantity() );

        return orderDTO;
    }
}
