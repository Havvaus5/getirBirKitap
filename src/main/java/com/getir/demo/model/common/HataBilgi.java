package com.getir.demo.model.common;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class HataBilgi {
    private HttpStatus durum;

    private String kod;

    private String hata;

    private List<String> hatalar;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
    private LocalDateTime zaman;

    private String hataDetay;
}
