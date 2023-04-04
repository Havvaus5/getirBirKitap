package com.getir.demo.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDTO {
    @NotNull
    private Long customerId;
    @NotNull
    private Long bookId;

    @NotNull(message = "Sıfır sipariş verilemez")
    @Min(value = 1, message = "Sipariş sayısı en az bir olmalıdır")
    private int adet;

}
