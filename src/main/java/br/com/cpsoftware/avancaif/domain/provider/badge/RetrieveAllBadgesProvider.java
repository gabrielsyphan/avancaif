package br.com.cpsoftware.avancaif.domain.provider.badge;

import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;

import java.util.List;

public interface RetrieveAllBadgesProvider {

    List<BadgeEntity> apply();
}
