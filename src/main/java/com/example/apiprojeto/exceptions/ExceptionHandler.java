package com.example.apiprojeto.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String detail = "O item que apresenta erros no seu corpo, verifique e tente novamenete";

        BindingResult bindingResult = ex.getBindingResult();

        List<BadRequestExceptionDetails.Field> problemField = bindingResult
                .getFieldErrors()
                .stream()
                .map(fieldError ->

                        BadRequestExceptionDetails.Field.builder()
                            .name(fieldError.getField())
                            .UserMesage(fieldError.getDefaultMessage())
                            .build()
                )
                .collect(Collectors.toList());

        BadRequestExceptionDetails exception = createException(status, ExceptionType.DADOS_INVALIDOS, detail)
                .fields(problemField)
                .build();

        return handleExceptionInternal(ex,exception, new HttpHeaders(), status, request);
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
