package com.example.buoi6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> Exception(){
        return ResponseEntity.ok().body(new ExceptionCustom("Lỗi Không Xác Định!", HttpStatus.ALREADY_REPORTED));
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> NotFoundException(){
        return ResponseEntity.ok().body(new ExceptionCustom("Không tìm thấy id!!", HttpStatus.ALREADY_REPORTED));
    }
}
