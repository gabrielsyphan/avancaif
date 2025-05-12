package br.com.cpsoftware.avancaif.app.provider.postgres.model;

import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank(message = "User email cannot be blank.")
    private String email;

    @NotBlank(message = "User password cannot be blank.")
    private String password;

    @NotBlank(message = "Username cannot be blank.")
    private String username;

    @Column(nullable = false, length = 1)
    private String enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "authority")
    private Set<String> authorities = new HashSet<>();

    public Long getId() {
        return id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
