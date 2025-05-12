package br.com.cpsoftware.avancaif.app.handler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundResponseException extends ResponseStatusException {

    public UserNotFoundResponseException() {
        super(HttpStatus.NOT_FOUND, "User not found.");
    }

    public UserNotFoundResponseException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
