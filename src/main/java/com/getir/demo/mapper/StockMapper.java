package com.getir.demo.mapper;

import com.getir.demo.model.dto.StockDTO;
import com.getir.demo.model.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface StockMapper {

    List<StockDTO> map(List<Stock> stockList);

    @Mappings({@Mapping(source = "stock.book.name", target = "bookName"),
            @Mapping(source = "stock.book.id", target = "bookId")
    })
    StockDTO map(Stock stock);
}
