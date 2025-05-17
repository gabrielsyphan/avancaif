package br.com.cpsoftware.avancaif.domain.entity.user;

import br.com.cpsoftware.avancaif.domain.enums.Enabled;

import java.util.Set;

public class UserEntityBuilder {

    private final UserEntity userEntity;

    public UserEntityBuilder() {
        this.userEntity = new UserEntity();
    }

    public UserEntityBuilder withId(Long id) {
        this.userEntity.setId(id);
        return this;
    }

    public UserEntityBuilder withEmail(String email) {
        this.userEntity.setEmail(email);
        return this;
    }

    public UserEntityBuilder withPassword(String password) {
        this.userEntity.setPassword(password);
        return this;
    }

    public UserEntityBuilder withName(String name) {
        this.userEntity.setName(name);
        return this;
    }

    public UserEntityBuilder withEnabled(Enabled enabled) {
        this.userEntity.setEnabled(enabled);
        return this;
    }

    public UserEntityBuilder withAuthorities(Set<String> authorities) {
        this.userEntity.setAuthorities(authorities);
        return this;
    }

    public UserEntity build() {
        return this.userEntity;
    }
}
