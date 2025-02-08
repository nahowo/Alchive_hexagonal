package com.Alchive.backend.application.port.in;

import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.application.command.ChangeUserDetailCommand;
import com.Alchive.backend.application.command.SignUpCommand;
import com.Alchive.backend.model.User;

public interface UserUseCase {
    UserResponseDTO signUp(SignUpCommand signUpCommand);
    UserResponseDTO changeUserDetail(Long id, ChangeUserDetailCommand changeDescriptionCommand);
}
