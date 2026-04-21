package br.com.camilaferreiranas.productservice.config;

import br.com.camilaferreiranas.productservice.exception.ProductNotFoundException;
import br.com.camilaferreiranas.productservice.exception.QuantityNotAcceptedException;
import br.com.camilaferreiranas.productservice.model.dto.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalRestExceptionHandler {



    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiErrors> handleProductNotFound(RuntimeException e) {
        var error = new ApiErrors();

        error.setTimestamp(LocalDateTime.now());
       error.setErrors(List.of(e.getMessage()));
       error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR );
    }


    @ExceptionHandler(QuantityNotAcceptedException.class)
    public ResponseEntity<ApiErrors> handleErrorQuantity(RuntimeException e) {
        var error = new ApiErrors();

        error.setTimestamp(LocalDateTime.now());
        error.setErrors(List.of(e.getMessage()));
        error.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST );
    }




}
