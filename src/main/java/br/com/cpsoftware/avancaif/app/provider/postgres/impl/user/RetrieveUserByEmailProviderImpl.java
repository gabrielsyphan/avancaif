package br.com.cpsoftware.avancaif.app.provider.postgres.impl.user;

import br.com.cpsoftware.avancaif.app.handler.exception.UserNotFoundException;
import br.com.cpsoftware.avancaif.app.provider.mapstruct.UserMapper;
import br.com.cpsoftware.avancaif.app.provider.postgres.repository.UserRepository;
import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;
import br.com.cpsoftware.avancaif.domain.provider.user.RetrieveUserByEmailProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetrieveUserByEmailProviderImpl implements RetrieveUserByEmailProvider {

    private final UserRepository userRepository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public RetrieveUserByEmailProviderImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity apply(String email) {
        var userModel = userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException("User not found with email: " + email)
        );
        return mapper.toEntity(userModel);
    }
}
