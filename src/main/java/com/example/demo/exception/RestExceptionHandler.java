package com.example.demo.exception;

import com.example.demo.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ResponseDto> entityNotFound(EntityNotFoundException ex, WebRequest request) {
        log.debug ( "handling EntityNotFoundException..." );
        return ResponseEntity.ok ( ResponseDto
                .builder ()
                .message ( ex.getMessage () )
                .status ( false ).build () );
    }


    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ResponseDto> exception(RuntimeException ex, WebRequest request) {
        log.debug ( "Exception=" + ex.getMessage () );
        return ResponseEntity.ok ( ResponseDto
                .builder ()
                .message ( INTERNAL_SERVER_ERROR.getReasonPhrase () )
                .status ( false ).build () );
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ResponseDto> exception(Exception ex, WebRequest request) {
        log.debug ( "Exception=" + ex.getMessage () );
        return ResponseEntity.ok ( ResponseDto
                .builder ()
                .message ( INTERNAL_SERVER_ERROR.getReasonPhrase () )
                .status ( false ).build () );
    }


}
