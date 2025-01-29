package com.Alchive.backend.adapter.in.web.controller;

import com.Alchive.backend.adapter.in.web.dto.request.UserCreateRequestDTO;
import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.application.command.SignUpCommand;
import com.Alchive.backend.application.port.in.UserUseCase;
import com.Alchive.backend.config.result.ResultCode;
import com.Alchive.backend.config.result.ResultResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "사용자", description = "사용자 관련 api입니다.")
@RequestMapping("/api/v2/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserUseCase userUseCase;

    @PostMapping("/signup")
    public ResponseEntity<ResultResponse> signUp(@RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        SignUpCommand signUpCommand = SignUpCommand.of(userCreateRequestDTO);
        UserResponseDTO userResponseDTO = userUseCase.signUp(signUpCommand);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.USER_CREATE_SUCCESS, userResponseDTO));
    }
}
