package com.getir.demo.model.entity;


import com.getir.demo.model.type.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "BOOK_ORDER", schema = "GETIR")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = true)
public class BookOrder extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Column(name = "ORDER_STATUS", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @Column(name = "ORDER_QUATITY")
    private int orderQuantity;


}
