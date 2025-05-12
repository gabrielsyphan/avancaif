package br.com.cpsoftware.avancaif.app.usecase;

import br.com.cpsoftware.avancaif.domain.entity.UserEntity;
import br.com.cpsoftware.avancaif.domain.provider.RetrieveAllUsersProvider;
import br.com.cpsoftware.avancaif.domain.usecase.RetrieveAllUsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class RetrieveAllUsersUseCaseImpl implements RetrieveAllUsersUseCase {

    private final RetrieveAllUsersProvider retrieveAllUsersProvider;
    private final Logger logger = Logger.getLogger(RetrieveAllUsersUseCaseImpl.class.getName());

    @Autowired
    public RetrieveAllUsersUseCaseImpl(RetrieveAllUsersProvider retrieveAllUsersProvider) {
        this.retrieveAllUsersProvider = retrieveAllUsersProvider;
    }

    @Override
    public List<UserEntity> apply() {
        try {
            logger.info("Retrieving all users...");
            return retrieveAllUsersProvider.apply();
        } catch (Exception e) {
            logger.severe("Error while retrieving all users: " + e.getMessage());
            throw e;
        }
    }
}
