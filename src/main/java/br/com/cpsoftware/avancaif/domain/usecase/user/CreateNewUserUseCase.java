package br.com.cpsoftware.avancaif.domain.usecase.user;

import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;

public interface CreateNewUserUseCase {

    UserEntity apply(UserEntity user);
}
