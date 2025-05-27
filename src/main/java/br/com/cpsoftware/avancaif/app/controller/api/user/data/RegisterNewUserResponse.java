package br.com.cpsoftware.avancaif.app.controller.api.user.data;

import java.util.Set;

public record RegisterNewUserResponse(
    String username,
    String email,
    Set<String> authorities
) {
}
