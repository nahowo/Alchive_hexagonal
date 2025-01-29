package com.Alchive.backend.application.service;

import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.application.command.SignUpCommand;
import com.Alchive.backend.application.port.in.UserUseCase;
import com.Alchive.backend.application.port.out.user.CreateUserPort;
import com.Alchive.backend.mapper.UserMapper;
import com.Alchive.backend.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService implements UserUseCase {
    private final UserMapper userMapper;
    private final CreateUserPort createUserPort;
    @Transactional
    @Override
    public UserResponseDTO signUp(SignUpCommand signUpCommand) {
        // 회원가입 요청 도메인 생성
        User user = userMapper.commandToDomain(signUpCommand);

        // 비즈니스 로직 호출
        user.createUser(user.getEmail(), user.getName());

        // 회원정보 저장
        User savedUser = createUserPort.createUser(user);

        // 저장된 회원 도메인을 응답 DTO로 변환
        return userMapper.domainToResponseDTO(user);
    }
}
