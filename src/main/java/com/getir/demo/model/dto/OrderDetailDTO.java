package com.getir.demo.model.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private String customerName;
    private String customerSurname;
    private String bookName;
    private int orderQuantity;
}
