package com.Alchive.backend.mapper;

import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.adapter.out.persistence.entity.UserEntity;
import com.Alchive.backend.application.command.SignUpCommand;
import com.Alchive.backend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    // 응답 도메인 -> 회원가입 응답 DTO
    public UserResponseDTO domainToResponseDTO(User user, String accessToken, String refreshToken) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .description(user.getDescription())
                .autoSave(user.getAutoSave())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public UserResponseDTO domainToResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .description(user.getDescription())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .autoSave(user.getAutoSave())
                .isDeleted(user.getIsDeleted())
                .build();
    }

    // command -> domain
    public User commandToDomain(SignUpCommand signUpCommand) {
        return User.builder()
                .email(signUpCommand.getEmail())
                .name(signUpCommand.getName())
                .description(signUpCommand.getDescription())
                .build();
    }

    // entity -> domain
    public User toDomain(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .description(userEntity.getDescription())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .autoSave(userEntity.getAutoSave())
                .build();
    }

    // domain -> entity
    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .email(user.getEmail())
                .name(user.getName())
                .description(user.getDescription())
                .build();
    }
}
