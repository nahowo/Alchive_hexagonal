package com.Alchive.backend.application.port.out.user;

import com.Alchive.backend.model.User;

public interface CreateUserPort {
    User createUser(User user);
}
