package com.Alchive.backend.adapter.in.web.controller;

import com.Alchive.backend.adapter.in.web.dto.request.UserCreateRequestDTO;
import com.Alchive.backend.adapter.in.web.dto.request.UserUpdateRequestDTO;
import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.application.command.ChangeUserDetailCommand;
import com.Alchive.backend.application.command.SignUpCommand;
import com.Alchive.backend.application.port.in.UserUseCase;
import com.Alchive.backend.config.result.ResultCode;
import com.Alchive.backend.config.result.ResultResponse;
import com.Alchive.backend.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name = "사용자", description = "사용자 관련 api입니다.")
@RequestMapping("/api/v2/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserUseCase userUseCase;

    @Operation(summary = "회원가입", description = "회원가입 메서드입니다. ")
    @PostMapping
    public ResponseEntity<ResultResponse> signUp(@RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        SignUpCommand signUpCommand = SignUpCommand.of(userCreateRequestDTO);
        UserResponseDTO userResponseDTO = userUseCase.signUp(signUpCommand);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.USER_CREATE_SUCCESS, userResponseDTO));
    }

    @Operation(summary = "회원정보 수정", description = "회원 설명글과 자동 저장 설정을 변경하는 메서드입니다. ")
    @PostMapping("/{id}")
    public ResponseEntity<ResultResponse> changeUser(@RequestBody UserUpdateRequestDTO userUpdateRequestDTO, @PathVariable Long id) {
        ChangeUserDetailCommand changeUserDetailCommand = ChangeUserDetailCommand.of(userUpdateRequestDTO);
        UserResponseDTO userResponseDTO = userUseCase.changeUserDetail(id, changeUserDetailCommand);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.USER_UPDATE_SUCCESS, userResponseDTO));
    }
}
