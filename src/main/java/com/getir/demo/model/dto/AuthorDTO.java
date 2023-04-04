package com.getir.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthorDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String surName;
}
