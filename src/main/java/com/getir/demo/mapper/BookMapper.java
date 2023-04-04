package com.getir.demo.mapper;

import com.getir.demo.model.dto.BookDTO;
import com.getir.demo.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    Book map(BookDTO bookDTO);
}
