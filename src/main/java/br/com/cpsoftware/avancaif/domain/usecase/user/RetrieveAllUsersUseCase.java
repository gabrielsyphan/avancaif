package br.com.cpsoftware.avancaif.domain.usecase.user;

import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;

import java.util.List;

public interface RetrieveAllUsersUseCase {

    List<UserEntity> apply();
}
