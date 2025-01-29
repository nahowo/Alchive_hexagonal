package com.Alchive.backend.application.port.in;

import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.application.command.SignUpCommand;

public interface UserUseCase {
    UserResponseDTO signUp(SignUpCommand signUpCommand);
}
