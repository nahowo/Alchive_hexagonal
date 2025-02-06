package com.Alchive.backend.service;

import com.Alchive.backend.config.error.exception.user.UserEmailExistException;
import com.Alchive.backend.config.error.exception.user.UserNameExistException;
import com.Alchive.backend.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("사용자 생성 - 성공")
    @Test
    public void userCreateTestSuccess() {
        User sut = new User();

        sut.createUser("test@gmail.com", "test", false, false);

        Assertions.assertEquals("test@gmail.com", sut.getEmail());
        Assertions.assertEquals("test", sut.getName());
    }

    @DisplayName("사용자 생성 - 메일 중복 실패")
    @Test
    public void userCreateTestFailByEmailOverlap() {
        User sut = new User();

        Assertions.assertThrows(UserEmailExistException.class, () -> sut.createUser("test@gmail.com", "test", true, false));
    }

    @DisplayName("사용자 생성 - 사용자명 중복 실패")
    @Test
    public void userCreateTestFailByNameOverlap() {
        User sut = new User();

        Assertions.assertThrows(UserNameExistException.class, () -> sut.createUser("test@gmail.com", "test", false, true));
    }
}
