package br.com.cpsoftware.avancaif.domain.provider.user;

import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;

public interface CreateNewUserProvider {

    UserEntity apply(UserEntity user);
}
