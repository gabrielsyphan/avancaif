package br.com.cpsoftware.avancaif.domain.provider.user;

import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;

import java.util.List;

public interface RetrieveAllUsersProvider {

    List<UserEntity> apply();
}
