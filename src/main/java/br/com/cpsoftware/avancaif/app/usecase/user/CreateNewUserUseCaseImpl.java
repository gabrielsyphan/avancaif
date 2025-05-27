package br.com.cpsoftware.avancaif.app.usecase.user;

import br.com.cpsoftware.avancaif.app.handler.exception.UserAlreadyExistsException;
import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;
import br.com.cpsoftware.avancaif.domain.provider.user.CheckIfUserExistsByEmailProvider;
import br.com.cpsoftware.avancaif.domain.provider.user.CreateNewUserProvider;
import br.com.cpsoftware.avancaif.domain.usecase.user.CreateNewUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreateNewUserUseCaseImpl implements CreateNewUserUseCase {

    private final Logger logger = Logger.getLogger(CreateNewUserUseCaseImpl.class.getName());

    private final CreateNewUserProvider createNewUserProvider;
    private final CheckIfUserExistsByEmailProvider checkIfUserExistsByEmailProvider;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CreateNewUserUseCaseImpl(
            CreateNewUserProvider createNewUserProvider,
            CheckIfUserExistsByEmailProvider checkIfUserExistsByEmailProvider,
            PasswordEncoder passwordEncoder
    ) {
        this.createNewUserProvider = createNewUserProvider;
        this.checkIfUserExistsByEmailProvider = checkIfUserExistsByEmailProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity apply(UserEntity user) {
        try {
            logger.info("Attempting to create a new user: " + user);

            if(Boolean.TRUE.equals(checkIfUserExistsByEmailProvider.apply(user.getEmail()))) {
                logger.warning("User with email " + user.getEmail() + " already exists.");
                throw new UserAlreadyExistsException("User with this email already exists.");
            }

            var passEncoded = passwordEncoder.encode(user.getPassword());
            return createNewUserProvider.apply(user.withPassword(passEncoded));
        } catch (UserAlreadyExistsException e) {
            logger.warning("User with email " + user.getEmail() + " already exists.");
            throw new UserAlreadyExistsException("User with this email already exists.");
        } catch (Exception e) {
            logger.severe("Error while creating a new user: " + e.getMessage());
            throw e;
        }
    }
}
