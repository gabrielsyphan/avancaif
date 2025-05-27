package br.com.cpsoftware.avancaif.domain.enums;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;

import java.util.List;

public enum Role {

    ROLE_STUDENT(1, "Estudante", PathWebConstants.STUDENT_PATH),
    ROLE_TEACHER(2, "Professor", PathWebConstants.TEACHER_PATH),
    ROLE_ADMIN(3, "Administrador", PathWebConstants.ADMIN_PATH);

    private final int id;
    private final String description;
    private final String path;

    Role(int id, String description, String path) {
        this.id = id;
        this.description = description;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPath() {
        return path;
    }

    public static List<Role> getAllRoles() {
        return List.of(values());
    }
}
