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


    public void createUser(String email, String name) {
        if (!isUserEmailUnique(email)) {
            throw new UserEmailExistException();
        }
        if (!isUserNameUnique(name)) {
            throw new UserNameExistException();
        }
        this.email = email;
        this.name = name;
    }

    public boolean isUserEmailUnique(String email) {
        return true;
    }

    public boolean isUserNameUnique(String name) {
        return true;
    }

    public void getUserDetail() {

    }

    public void changeUserDetail() {

    }

    public void deleteUser() {

    }
}
