package com.getir.demo.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "AUTHOR", schema = "GETIR")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = true)
public class Author extends AbstractBaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> bookList;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
