package com.getir.demo.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER", schema = "GETIR")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = true)
public class Customer extends AbstractBaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<CustomerContact> customerContacts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<BookOrder> bookOrderList;

}
