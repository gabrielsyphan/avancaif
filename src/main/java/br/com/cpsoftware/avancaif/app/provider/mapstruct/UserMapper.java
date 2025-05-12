package br.com.cpsoftware.avancaif.app.provider.mapstruct;

import br.com.cpsoftware.avancaif.app.provider.postgres.model.UserModel;
import br.com.cpsoftware.avancaif.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel entityToModel(UserEntity user);

    UserEntity modelToEntity(UserModel user);
}
