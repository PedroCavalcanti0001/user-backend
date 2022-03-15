package me.pedroeugenio.userbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsInterceptor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> checkExceptions(Exception exception) {
        String msg = exception.getLocalizedMessage() != null ? exception.getLocalizedMessage() : exception.getMessage();
        ErrorMessage error = new ErrorMessage(1, msg);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
