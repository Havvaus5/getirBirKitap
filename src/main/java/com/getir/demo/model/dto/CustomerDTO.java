package com.getir.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String surName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String adres;
    @NotBlank
    private String mail;
}
