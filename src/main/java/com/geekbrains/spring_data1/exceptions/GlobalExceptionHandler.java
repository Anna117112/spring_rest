package com.geekbrains.spring_data1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    //хотитм перехватить исключение
    @ExceptionHandler
    // перехватываем исключение ResourceNotFoundException e или его наследников
    public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundException e) {
        // если перхватили 404 ошибку возвращаем сообщение об ошибке вытаскиваем его из exception e.getMessage()
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
