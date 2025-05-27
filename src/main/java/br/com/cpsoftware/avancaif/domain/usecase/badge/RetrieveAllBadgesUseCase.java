package br.com.cpsoftware.avancaif.domain.usecase.badge;

import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;

import java.util.List;

public interface RetrieveAllBadgesUseCase {

    List<BadgeEntity> apply();
}
