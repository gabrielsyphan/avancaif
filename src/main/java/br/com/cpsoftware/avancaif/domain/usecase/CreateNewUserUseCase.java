package br.com.cpsoftware.avancaif.domain.usecase;

import br.com.cpsoftware.avancaif.domain.entity.UserEntity;

public interface CreateNewUserUseCase {

    UserEntity apply(UserEntity user);
}
