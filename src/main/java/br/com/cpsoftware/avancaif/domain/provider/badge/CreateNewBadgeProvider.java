package br.com.cpsoftware.avancaif.domain.provider.badge;

import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;

public interface CreateNewBadgeProvider {

    BadgeEntity apply(BadgeEntity badgeEntity);
}
