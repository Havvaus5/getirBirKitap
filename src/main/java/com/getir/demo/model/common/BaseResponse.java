package com.getir.demo.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private Boolean success;
    private String message;
    private T data;

    public static <T> BaseResponse<T> createSucessResponse(String message) {
        return new BaseResponse(true, message, null);
    }

    public static <T> BaseResponse<T> createSucessResponse(T data) {
        return new BaseResponse(true, null, data);
    }

    public static <T> BaseResponse<T> createErrorResponse(String message) {
        return new BaseResponse(true, message, null);
    }

    public static <T> BaseResponse<T> createErrorResponse(T data) {
        return new BaseResponse(true, null, data);
    }



}
