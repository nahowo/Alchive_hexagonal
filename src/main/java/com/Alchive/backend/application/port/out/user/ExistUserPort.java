package com.Alchive.backend.application.port.out.user;

public interface ExistUserPort {
    Boolean ExistByUserEmail(String email);
    Boolean ExistByUserName(String name);
}
