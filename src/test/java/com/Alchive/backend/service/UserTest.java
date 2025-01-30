package com.Alchive.backend.service;

import com.Alchive.backend.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("사용자 생성 - 성공")
    @Test
    public void userCreateTest() {
        User sut = new User();

        sut.createUser("test@gmail.com", "test", false, false);

        Assertions.assertEquals("test@gmail.com", sut.getEmail());
        Assertions.assertEquals("test", sut.getName());
    }
}
