package br.com.cpsoftware.avancaif.app.provider.mapstruct;

import br.com.cpsoftware.avancaif.app.controller.api.register.data.RegisterNewUserResponse;
import br.com.cpsoftware.avancaif.app.provider.postgres.model.UserModel;
import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel toModel(UserEntity user);

    UserEntity toEntity(UserModel user);

    RegisterNewUserResponse toNewUserResponse(UserEntity user);
}
