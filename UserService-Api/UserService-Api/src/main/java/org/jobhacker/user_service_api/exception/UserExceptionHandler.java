package org.jobhacker.user_service_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> userNotFound(UserNotFoundException ex){
        UserException userException = new UserException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(userException, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> userAlreadyExists(UserAlreadyExistsException ex){
        UserException userException = new UserException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.CONFLICT
        );

        return new ResponseEntity<>(userException, HttpStatus.CONFLICT);
    }
}
