package com.getir.demo.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderStaticsDTO {
    private String mounth;
    private int totalOrderCount;
    private int totalBookCount;
    private BigDecimal totalPuchasedAmount;

}
