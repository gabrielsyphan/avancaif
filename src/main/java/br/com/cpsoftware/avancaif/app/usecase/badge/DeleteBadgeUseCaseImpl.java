package br.com.cpsoftware.avancaif.app.usecase.badge;

import br.com.cpsoftware.avancaif.domain.provider.badge.DeleteBadgeProvider;
import br.com.cpsoftware.avancaif.domain.usecase.badge.DeleteBadgeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DeleteBadgeUseCaseImpl implements DeleteBadgeUseCase {

    private final Logger logger = Logger.getLogger(DeleteBadgeUseCaseImpl.class.getName());
    private final DeleteBadgeProvider deleteBadgeProvider;

    @Autowired
    public DeleteBadgeUseCaseImpl(DeleteBadgeProvider deleteBadgeProvider) {
        this.deleteBadgeProvider = deleteBadgeProvider;
    }

    @Override
    public void apply(Long id) {
        logger.info("Deleting badge with ID: " + id);
        deleteBadgeProvider.apply(id);
        logger.info("Badge with ID " + id + " deleted successfully.");
    }
}
