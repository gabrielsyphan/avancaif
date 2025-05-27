package br.com.cpsoftware.avancaif.app.usecase.badge;

import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;
import br.com.cpsoftware.avancaif.domain.provider.badge.RetrieveAllBadgesProvider;
import br.com.cpsoftware.avancaif.domain.usecase.badge.RetrieveAllBadgesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class RetrieveAllBadgesUseCaseImpl implements RetrieveAllBadgesUseCase {

    private final Logger logger = Logger.getLogger(RetrieveAllBadgesUseCaseImpl.class.getName());
    private final RetrieveAllBadgesProvider retrieveAllUsersProvider;

    @Autowired
    public RetrieveAllBadgesUseCaseImpl(RetrieveAllBadgesProvider retrieveAllUsersProvider) {
        this.retrieveAllUsersProvider = retrieveAllUsersProvider;
    }

    @Override
    public List<BadgeEntity> apply() {
        try {
            logger.info("Retrieving all badges...");
            return retrieveAllUsersProvider.apply();
        } catch (Exception e) {
            logger.severe("Error while retrieving all badges: " + e.getMessage());
            throw e;
        }
    }
}
