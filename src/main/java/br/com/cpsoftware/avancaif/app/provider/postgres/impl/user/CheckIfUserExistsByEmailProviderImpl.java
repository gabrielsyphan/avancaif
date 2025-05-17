package br.com.cpsoftware.avancaif.app.provider.postgres.impl.user;

import br.com.cpsoftware.avancaif.app.provider.postgres.repository.UserRepository;
import br.com.cpsoftware.avancaif.domain.provider.user.CheckIfUserExistsByEmailProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckIfUserExistsByEmailProviderImpl implements CheckIfUserExistsByEmailProvider {

    private final UserRepository userRepository;

    @Autowired
    public CheckIfUserExistsByEmailProviderImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean apply(String email) {
        return userRepository.existsByEmail(email);
    }
}
