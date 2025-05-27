package br.com.cpsoftware.avancaif.domain.usecase.badge;

import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;

public interface CreateNewBadgeUseCase {

    BadgeEntity apply(BadgeEntity badgeEntity);
}
