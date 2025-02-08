package com.Alchive.backend.application.port.out.user;

import com.Alchive.backend.model.User;

public interface FindUserPort {
    User findUserByEmail(String email);
    User findById(Long id);
}
