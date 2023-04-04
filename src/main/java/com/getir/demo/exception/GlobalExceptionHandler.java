package com.getir.demo.exception;

import com.getir.demo.model.common.BaseResponse;
import com.getir.demo.model.common.HataBilgi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        LOG.error("Bad request", ex);
        final List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        final List<String> errors = fieldErrors
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return BaseResponse.createErrorResponse(HataBilgi.builder()
                .hatalar(errors)
                .zaman(LocalDateTime.now())
                .durum(HttpStatus.BAD_REQUEST)
                .hataDetay(this.getHataDetay(ex))
                .build());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public BaseResponse handleExceptions(Exception ex) {
        String errorMessage = ex.getClass().getSimpleName() + " " + ex.getMessage();
        LOG.error(errorMessage, ex);
        return BaseResponse.createErrorResponse(HataBilgi.builder()
                .hata(errorMessage)
                .zaman(LocalDateTime.now())
                .durum(HttpStatus.INTERNAL_SERVER_ERROR)
                .hataDetay(this.getHataDetay(ex))
                .build());
    }

    private String getHataDetay(Throwable t) {
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            t.printStackTrace(pw);
            return sw.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}