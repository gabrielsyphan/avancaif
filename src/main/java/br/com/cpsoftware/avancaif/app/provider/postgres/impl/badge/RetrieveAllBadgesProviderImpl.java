package br.com.cpsoftware.avancaif.app.provider.postgres.impl.badge;

import br.com.cpsoftware.avancaif.app.provider.mapstruct.BadgeMapper;
import br.com.cpsoftware.avancaif.app.provider.postgres.repository.BadgeRepository;
import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;
import br.com.cpsoftware.avancaif.domain.provider.badge.RetrieveAllBadgesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveAllBadgesProviderImpl implements RetrieveAllBadgesProvider {

    private final BadgeMapper mapper = BadgeMapper.INSTANCE;
    private final BadgeRepository badgeRepository;

    @Autowired
    public RetrieveAllBadgesProviderImpl(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    @Override
    public List<BadgeEntity> apply() {
        return badgeRepository.findAll().stream()
                .map(mapper::toEntity)
                .toList();
    }
}
