package com.Alchive.backend.mapper;

import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.adapter.out.persistence.entity.UserEntity;
import com.Alchive.backend.application.command.SignUpCommand;
import com.Alchive.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    // 도메인 -> 회원가입 응답 DTO
    UserResponseDTO domainToResponseDTO(User user);

    // command -> domain
    User commandToDomain(SignUpCommand signUpCommand);

    // entity -> domain
    User toDomain(UserEntity userEntity);

    // domain -> entity
    @Mapping(target = "autoSave", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    UserEntity toEntity(User user);
}
