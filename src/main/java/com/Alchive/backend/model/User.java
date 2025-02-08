package com.Alchive.backend.model;

import com.Alchive.backend.adapter.in.web.dto.request.UserCreateRequestDTO;
import com.Alchive.backend.config.error.exception.user.UserEmailExistException;
import com.Alchive.backend.config.error.exception.user.UserNameExistException;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends BaseModel {
    private Long id;
    private String email;
    private String name;
    private String description;
    private Boolean autoSave;

    public void createUser(String email, String name, Boolean isEmailExist, Boolean isNameExist) {
        if (isEmailExist) {
            throw new UserEmailExistException();
        }
        if (isNameExist) {
            throw new UserNameExistException();
        }
        this.email = email;
        this.name = name;
    }

    public void changeUserDetail(String description, Boolean autoSave) {
        // User authentication 과정 추가
        this.description = description;
        this.autoSave = autoSave;
    }
}
