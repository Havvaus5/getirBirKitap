package com.getir.demo.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "STOCK", schema = "GETIR")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = true)
public class Stock extends AbstractBaseEntity {

    @Column(name = "NUMBER")
    private int stockNumber;

    @OneToOne
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private Book book;

    public void updateStockNumber(int orderQuantity) {
        this.stockNumber = this.stockNumber - orderQuantity;
    }
}
