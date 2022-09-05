package com.bridgelabz.techstackservice.exception.exceptionHandler;

import com.bridgelabz.techstackservice.exception.LMSException;
import com.bridgelabz.techstackservice.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
@ControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(LMSException.class)
    public ResponseEntity<Response> handleHiringException(LMSException he){
        Response response=new Response();
        response.setErrorCode(400);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Response> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        Response response = new Response();
        response.setErrorCode(400);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
