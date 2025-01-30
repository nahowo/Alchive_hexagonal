package com.Alchive.backend.application.command;

import com.Alchive.backend.adapter.in.web.dto.request.UserCreateRequestDTO;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SignUpCommand {
    private Long id;
    private String email;
    private String name;
    private String description;
    private Boolean autoSave;

    public static SignUpCommand of(UserCreateRequestDTO userCreateRequestDTO) {
        return SignUpCommand.builder()
                .email(userCreateRequestDTO.getEmail())
                .name(userCreateRequestDTO.getName())
                .build();
    }
}
