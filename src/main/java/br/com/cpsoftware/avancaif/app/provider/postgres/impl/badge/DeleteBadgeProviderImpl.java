package br.com.cpsoftware.avancaif.app.provider.postgres.impl.badge;

import br.com.cpsoftware.avancaif.app.provider.postgres.repository.BadgeRepository;
import br.com.cpsoftware.avancaif.domain.provider.badge.DeleteBadgeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBadgeProviderImpl implements DeleteBadgeProvider {

    private final BadgeRepository badgeRepository;

    @Autowired
    public DeleteBadgeProviderImpl(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    @Override
    public void apply(Long id) {
        var badgeModel = badgeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Badge not found with id: " + id));
        badgeRepository.delete(badgeModel);
    }
}
