package org.jobhacker.user_service_api.exception;

import org.springframework.http.HttpStatus;

public class UserException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public UserException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }


    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
