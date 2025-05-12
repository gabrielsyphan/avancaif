package br.com.cpsoftware.avancaif.domain.provider;

import br.com.cpsoftware.avancaif.domain.entity.UserEntity;

public interface CreateNewUserProvider {

    UserEntity apply(UserEntity user);
}
