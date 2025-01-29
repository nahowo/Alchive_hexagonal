package com.Alchive.backend.model;

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

    public void createUser() {

    }

    public void getUserDetail() {

    }

    public void changeUserDetail() {

    }

    public void deleteUser() {

    }
}
