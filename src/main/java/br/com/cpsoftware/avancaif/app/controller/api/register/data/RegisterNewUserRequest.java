package br.com.cpsoftware.avancaif.app.controller.api.register.data;

import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;
import br.com.cpsoftware.avancaif.domain.enums.Enabled;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterNewUserRequest(
        @NotBlank(message = "Login is required")
        String name,

        @NotBlank(message = "Email is required")
        @Email
        String email,

        @NotBlank(message = "Password is required")
        String password,

        @NotBlank(message = "Role is required")
        String role
) {

    public UserEntity toUserEntity() {
        return new UserEntity(name, email, password, Enabled.Y, role);
    }
}
