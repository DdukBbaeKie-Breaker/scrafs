package com.scarfs.shortloin.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ UserNotFoundException.class })
    protected ResponseEntity<Object> userNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "User not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ InvalidBodyException.class })
    protected ResponseEntity<Object> invalidBody(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Invalid Boody",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ InvalidTokenException.class })
    protected ResponseEntity<Object> invalidToken(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Invalid TokenResponse",
                new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler({ ExpiredTokenException.class })
    protected ResponseEntity<Object> expiredToken(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Expired token",
                new HttpHeaders(), HttpStatus.GONE, request);
    }

    @ExceptionHandler({ UserAlreadyExistsException.class })
    protected ResponseEntity<Object> userAlreadyExits(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "User Already Exits",
                new HttpHeaders(), HttpStatus.GONE, request);
    }
}
