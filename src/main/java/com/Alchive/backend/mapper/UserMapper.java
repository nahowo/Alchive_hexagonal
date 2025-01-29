package com.Alchive.backend.mapper;

import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.adapter.out.persistence.entity.UserEntity;
import com.Alchive.backend.application.command.SignUpCommand;
import com.Alchive.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    // 응답 도메인 -> 회원가입 응답 DTO
    UserResponseDTO domainToResponseDTO(User user);
    // domain -> entity
    UserEntity toEntity(User user);
    // command -> domain
    User commandToDomain(SignUpCommand signUpCommand);
    // entity -> domain
    User toDomain(UserEntity userEntity);
}
