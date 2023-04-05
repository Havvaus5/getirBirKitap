package com.getir.demo.mapper;

import com.getir.demo.model.dto.BookDTO;
import com.getir.demo.model.dto.StockDTO;
import com.getir.demo.model.entity.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book map(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setName( bookDTO.getName() );
        book.setPrice( bookDTO.getPrice() );
        book.setStockQuantity( bookDTO.getStockQuantity() );

        return book;
    }

    @Override
    public List<StockDTO> map(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<StockDTO> list = new ArrayList<StockDTO>( books.size() );
        for ( Book book : books ) {
            list.add( map( book ) );
        }

        return list;
    }

    @Override
    public StockDTO map(Book book) {
        if ( book == null ) {
            return null;
        }

        StockDTO stockDTO = new StockDTO();

        stockDTO.setBookName( book.getName() );
        stockDTO.setBookId( book.getId() );
        stockDTO.setStockQuantity( book.getStockQuantity() );

        return stockDTO;
    }
}
