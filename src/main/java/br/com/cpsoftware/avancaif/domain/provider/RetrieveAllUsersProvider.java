package br.com.cpsoftware.avancaif.domain.provider;

import br.com.cpsoftware.avancaif.domain.entity.UserEntity;

import java.util.List;

public interface RetrieveAllUsersProvider {

    List<UserEntity> apply();
}
