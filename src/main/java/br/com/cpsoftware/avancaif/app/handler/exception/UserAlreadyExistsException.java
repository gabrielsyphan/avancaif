package br.com.cpsoftware.avancaif.app.handler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserAlreadyExistsException extends ResponseStatusException {

    public UserAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "User already exists");
    }

    public UserAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
