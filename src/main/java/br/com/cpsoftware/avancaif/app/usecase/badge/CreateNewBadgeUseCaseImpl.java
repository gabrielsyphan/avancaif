package br.com.cpsoftware.avancaif.app.usecase.badge;

import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;
import br.com.cpsoftware.avancaif.domain.provider.badge.CreateNewBadgeProvider;
import br.com.cpsoftware.avancaif.domain.usecase.badge.CreateNewBadgeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreateNewBadgeUseCaseImpl implements CreateNewBadgeUseCase {

    private final Logger logger = Logger.getLogger(CreateNewBadgeUseCaseImpl.class.getName());
    private final CreateNewBadgeProvider createNewBadgeProvider;

    @Autowired
    public CreateNewBadgeUseCaseImpl(CreateNewBadgeProvider createNewBadgeProvider) {
        this.createNewBadgeProvider = createNewBadgeProvider;
    }

    @Override
    public BadgeEntity apply(BadgeEntity badgeEntity) {
        try {
            logger.info("Attempting to create a new badge: " + badgeEntity);
            return createNewBadgeProvider.apply(badgeEntity);
        } catch (Exception e) {
            logger.severe("Error while creating a new badge: " + e.getMessage());
            throw e;
        }
    }
}
