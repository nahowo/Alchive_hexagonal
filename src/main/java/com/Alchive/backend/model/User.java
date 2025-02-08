package com.Alchive.backend.model;

import com.Alchive.backend.adapter.in.web.dto.request.UserCreateRequestDTO;
import com.Alchive.backend.config.error.exception.user.UserEmailExistException;
import com.Alchive.backend.config.error.exception.user.UserNameExistException;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends BaseModel {
    private Long id;
    private String email;
    private String name;
    private String description;
    private Boolean autoSave;

    // factory method
    public static User of(String email, String name) {
        return User.builder()
                .email(email)
                .name(name)
                .build();
    }


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

    public void getUserDetail() {

    }

    public void changeUserDetail(String description, Boolean autoSave) {
        // User authentication 과정 추가
        this.description = description;
        this.autoSave = autoSave;
    }

    public void deleteUser() {

    }
}
