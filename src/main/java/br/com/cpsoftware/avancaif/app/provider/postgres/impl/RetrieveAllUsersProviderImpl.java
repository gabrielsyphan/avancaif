package br.com.cpsoftware.avancaif.app.provider.postgres.impl;

import br.com.cpsoftware.avancaif.app.provider.mapstruct.UserMapper;
import br.com.cpsoftware.avancaif.app.provider.postgres.repository.UserRepository;
import br.com.cpsoftware.avancaif.domain.entity.UserEntity;
import br.com.cpsoftware.avancaif.domain.provider.RetrieveAllUsersProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveAllUsersProviderImpl implements RetrieveAllUsersProvider {

    private final UserRepository userRepository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public RetrieveAllUsersProviderImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> apply() {
        return userRepository.findAll().stream().map(mapper::modelToEntity).toList();
    }
}
