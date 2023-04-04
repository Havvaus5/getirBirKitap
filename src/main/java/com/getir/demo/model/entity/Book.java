package com.getir.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "BOOK", schema = "GETIR")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = true)
public class Book extends AbstractBaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "book")
    private Stock stock;

}
