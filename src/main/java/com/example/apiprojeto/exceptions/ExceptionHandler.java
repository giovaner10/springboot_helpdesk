package com.example.apiprojeto.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Object> handlerObjectNotFoundException(ObjectNotFoundException ex,  WebRequest request){

        BadRequestExceptionDetails exceptionDetails = createException(HttpStatus.NOT_FOUND,
                ExceptionType.ENITDADE_NAO_ENCONTRADA,
                ex.getLocalizedMessage()).developerMessage(ex.getClass().getName()).build();


        return handleExceptionInternal(ex,exceptionDetails, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

    }

    public BadRequestExceptionDetails.BadRequestExceptionDetailsBuilder createException(HttpStatus status
            , ExceptionType exceptionType, String detail){

        return BadRequestExceptionDetails.builder()
                .status(status.value())
                .details(exceptionType.getUri())
                .title(exceptionType.getTitle())
                .timestamp(LocalDateTime.now());

    }
}
