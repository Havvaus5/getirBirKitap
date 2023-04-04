package com.getir.demo.mapper;

import com.getir.demo.model.dto.BookDTO;
import com.getir.demo.model.dto.StockDTO;
import com.getir.demo.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface BookMapper {

    Book map(BookDTO bookDTO);

    List<StockDTO> map(List<Book> books);

    @Mappings({@Mapping(source = "name", target = "bookName"),
            @Mapping(source = "id", target = "bookId")
    })
    StockDTO map(Book book);
}
