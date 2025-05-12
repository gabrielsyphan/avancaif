package br.com.cpsoftware.avancaif.app.handler.advisor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        ApiErrorAdvisorResponse apiErrorAdvisorResponse = new ApiErrorAdvisorResponse(ex.getStatusCode(), ex.getReason());
        return new ResponseEntity<>(apiErrorAdvisorResponse, ex.getStatusCode());
    }
}
