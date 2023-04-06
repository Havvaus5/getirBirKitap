package com.getir.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDetailDTO {
    private String customerName;
    private String customerSurname;
    private String bookName;
    private int orderQuantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime siparisZamani;
}
