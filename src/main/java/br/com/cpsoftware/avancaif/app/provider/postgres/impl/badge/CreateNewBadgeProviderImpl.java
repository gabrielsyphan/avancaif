package br.com.cpsoftware.avancaif.app.provider.postgres.impl.badge;

import br.com.cpsoftware.avancaif.app.provider.mapstruct.BadgeMapper;
import br.com.cpsoftware.avancaif.app.provider.postgres.repository.BadgeRepository;
import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;
import br.com.cpsoftware.avancaif.domain.provider.badge.CreateNewBadgeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateNewBadgeProviderImpl implements CreateNewBadgeProvider {

    private final BadgeRepository badgeRepository;
    private final BadgeMapper mapper = BadgeMapper.INSTANCE;

    @Autowired
    public CreateNewBadgeProviderImpl(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    @Override
    public BadgeEntity apply(BadgeEntity badgeEntity) {
    var badgeModel = mapper.toModel(badgeEntity);
        var badgeSaved = badgeRepository.save(badgeModel);
        return mapper.toEntity(badgeSaved);
    }
}
