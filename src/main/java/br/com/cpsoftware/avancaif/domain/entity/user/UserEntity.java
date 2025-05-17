package br.com.cpsoftware.avancaif.domain.entity.user;

import br.com.cpsoftware.avancaif.domain.enums.Enabled;

import java.util.HashSet;
import java.util.Set;

public class UserEntity {

    private Long id;
    private String email;
    private String password;
    private String name;
    private Enabled enabled;
    private Set<String> authorities = new HashSet<>();

    public UserEntity() {}

    public UserEntity(String name, String email, String password, Enabled enabled, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.authorities.add(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enabled getEnabled() {
        return enabled;
    }

    public void setEnabled(Enabled enabled) {
        this.enabled = enabled;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public UserEntity withPassword(String password) {
        this.password = password;
        return this;
    }
}
