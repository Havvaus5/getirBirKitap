package com.getir.demo.model.dto;

import lombok.Data;

@Data
public class StockDTO {
    private Long bookId;
    private String bookName;
    private int stockQuantity;
}
