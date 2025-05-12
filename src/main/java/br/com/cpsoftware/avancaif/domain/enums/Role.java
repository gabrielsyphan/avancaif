package br.com.cpsoftware.avancaif.domain.enums;

import java.util.List;

public enum Role {

    ROLE_ADMIN(1, "Admin"),
    ROLE_USER(2, "Usuário");

    private final int id;
    private final String description;

    Role(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static List<Role> getAllRoles() {
        return List.of(values());
    }
}
