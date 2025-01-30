package com.Alchive.backend.application.service;

import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.application.command.SignUpCommand;
import com.Alchive.backend.application.port.in.UserUseCase;
import com.Alchive.backend.application.port.out.user.CreateUserPort;
import com.Alchive.backend.application.port.out.user.FindUserPort;
import com.Alchive.backend.mapper.UserMapper;
import com.Alchive.backend.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService implements UserUseCase {
    private final UserMapper userMapper;
    private final CreateUserPort createUserPort;
    private final FindUserPort findUserPort;
    @Transactional
    @Override
    public UserResponseDTO signUp(SignUpCommand signUpCommand) {
        // 회원가입 요청 도메인 생성
        User user = userMapper.commandToDomain(signUpCommand);
        log.info("도메인 생성 완료");
        // 비즈니스 로직 호출
        user.createUser(user.getEmail(), user.getName());
        log.info("비즈니스 로직 호출 완료");
        // 회원정보 저장
        User savedUser = createUserPort.createUser(user);
        log.info("엔티티 저장 완료");
        // 저장된 회원 도메인을 응답 DTO로 변환
        return userMapper.domainToResponseDTO(user);
    }

    public User findByEmail(String email) {
        User user = findUserPort.findUserByEmail(email);
        return user;
    }
}
