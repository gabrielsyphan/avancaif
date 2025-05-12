package br.com.cpsoftware.avancaif.app.usecase;

import br.com.cpsoftware.avancaif.domain.entity.UserEntity;
import br.com.cpsoftware.avancaif.domain.provider.CreateNewUserProvider;
import br.com.cpsoftware.avancaif.domain.usecase.CreateNewUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreateNewUserUseCaseImpl implements CreateNewUserUseCase {

    private final CreateNewUserProvider createNewUserProvider;
    private final Logger logger = Logger.getLogger(CreateNewUserUseCaseImpl.class.getName());

    @Autowired
    public CreateNewUserUseCaseImpl(CreateNewUserProvider createNewUserProvider) {
        this.createNewUserProvider = createNewUserProvider;
    }

    @Override
    public UserEntity apply(UserEntity user) {
        try {
            logger.info("Attempting to create a new user: " + user);
            return createNewUserProvider.apply(user);
        } catch (Exception e) {
            logger.severe("Error while creating a new user: " + e.getMessage());
            throw e;
        }
    }
}
