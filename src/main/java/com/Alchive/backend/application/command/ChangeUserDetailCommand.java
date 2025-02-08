package com.Alchive.backend.application.command;

import com.Alchive.backend.adapter.in.web.dto.request.UserUpdateRequestDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ChangeUserDetailCommand {
    private final String description;
    @NotBlank
    private final Boolean autoSave;

    public static ChangeUserDetailCommand of(UserUpdateRequestDTO userUpdateRequestDTO) {
        return ChangeUserDetailCommand.builder()
                .description(userUpdateRequestDTO.getUserDescription())
                .autoSave(userUpdateRequestDTO.getAutoSave())
                .build();
    }
}
