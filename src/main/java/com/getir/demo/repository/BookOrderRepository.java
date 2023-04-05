package com.getir.demo.repository;

import com.getir.demo.model.data.OrderStatics;
import com.getir.demo.model.entity.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {

    @Query(value = "select * from GETIR.BOOK_ORDER where CUSTOMER_ID = :customerId", nativeQuery = true)
    List<BookOrder> getCustomerOrders(@Param("customerId") Long customerId);

    @Query(value = "select MONTH(CREATED_TIME) as monthNumber, " +
            "count(*) as totalOrder, sum(ORDER_QUATITY) as totalBookCount, b.price * sum(ORDER_QUATITY) as totalPrice " +
            "from GETIR.BOOK_ORDER o INNER JOIN GETIR.BOOK b ON o.BOOK_ID = b.ID GROUP BY MONTH(CREATED_TIME)", nativeQuery = true)
    List<OrderStatics> getMonthlyStatics();

    List<BookOrder> findByCreatedTimeBetween(LocalDateTime startTime, LocalDateTime endDate);
}
