package br.com.cpsoftware.avancaif.app.provider.postgres.impl.user;

import br.com.cpsoftware.avancaif.app.provider.mapstruct.UserMapper;
import br.com.cpsoftware.avancaif.app.provider.postgres.repository.UserRepository;
import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;
import br.com.cpsoftware.avancaif.domain.provider.user.CreateNewUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateNewUserProviderImpl implements CreateNewUserProvider {

    private final UserRepository userRepository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public CreateNewUserProviderImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity apply(UserEntity user) {
        var userModel = mapper.toModel(user);
        var userSaved = userRepository.save(userModel);
        return mapper.toEntity(userSaved);
    }
}
