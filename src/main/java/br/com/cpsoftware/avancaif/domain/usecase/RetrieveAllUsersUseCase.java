package br.com.cpsoftware.avancaif.domain.usecase;

import br.com.cpsoftware.avancaif.domain.entity.UserEntity;

import java.util.List;

public interface RetrieveAllUsersUseCase {

    List<UserEntity> apply();
}
