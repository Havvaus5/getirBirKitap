package com.getir.demo.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBookDTO {
    @NotNull
    private Long bookId;

    @Min(value = 1, message = "En az bir stok olmalı")
    private int stockQuantity;

}
