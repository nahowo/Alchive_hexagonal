package com.Alchive.backend.adapter.in.web.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Builder
public class UserResponseDTO {
    private Long id;
    private String email;
    private String name;
    private String description;
    private Boolean autoSave;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
}
