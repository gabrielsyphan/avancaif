package br.com.cpsoftware.avancaif.app.controller.api.badge.dto;

import java.util.List;

public record CreateNewBadgeResponse(
    Long id,
    String title,
    String description,
    List<String> technologies,
    String imageUrl
) {}
