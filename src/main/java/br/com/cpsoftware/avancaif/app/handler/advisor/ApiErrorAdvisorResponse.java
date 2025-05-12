package br.com.cpsoftware.avancaif.app.handler.advisor;

import org.springframework.http.HttpStatusCode;

public record ApiErrorAdvisorResponse(HttpStatusCode status, String message) {
}