package com.getir.demo.model.dto;

import com.getir.demo.model.data.OrderStatics;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

@Data
public class OrderStaticsDTO {
    private String month;
    private int totalOrderCount;
    private int totalBookCount;
    private BigDecimal totalPuchasedAmount;

    public OrderStaticsDTO(OrderStatics orderStatics) {
        this.month = Month.of(orderStatics.getMonthNumber()).getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
        this.totalOrderCount = orderStatics.getTotalOrder();
        this.totalBookCount = orderStatics.getTotalBookCount();
        this.totalPuchasedAmount = orderStatics.getTotalPrice();
    }

}
