package com.Alchive.backend.application.command;

import com.Alchive.backend.adapter.in.web.dto.request.UserCreateRequestDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpCommand {
    private String email;
    private String name;

    public static SignUpCommand of(UserCreateRequestDTO userCreateRequestDTO) {
        return SignUpCommand.builder()
                .email(userCreateRequestDTO.getEmail())
                .name(userCreateRequestDTO.getName())
                .build();
    }
}
