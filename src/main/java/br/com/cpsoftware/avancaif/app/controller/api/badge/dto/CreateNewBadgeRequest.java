package br.com.cpsoftware.avancaif.app.controller.api.badge.dto;

import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;

import java.util.List;

public record CreateNewBadgeRequest(
    String title,
    String description,
    List<String> technologies,
    String imageUrl
) {

    public BadgeEntity toBadgeEntity() {
        return new BadgeEntity(
            title,
            description,
            technologies,
            imageUrl
        );
    }
}
