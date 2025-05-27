package br.com.cpsoftware.avancaif.app.provider.mapstruct;

import br.com.cpsoftware.avancaif.app.controller.api.badge.dto.CreateNewBadgeResponse;
import br.com.cpsoftware.avancaif.app.provider.postgres.model.BadgeModel;
import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BadgeMapper {

    BadgeMapper INSTANCE = Mappers.getMapper(BadgeMapper.class);

    BadgeModel toModel(BadgeEntity badgeEntity);

    BadgeEntity toEntity(BadgeModel badgeModel);

    CreateNewBadgeResponse toCreateNewBadgeResponse(BadgeEntity badgeEntity);
}
