package com.getir.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO {
    @NotBlank
    private String name;
    @NotNull
    private Long authorId;
    @NotNull
    private BigDecimal price;

}
