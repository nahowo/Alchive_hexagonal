package com.Alchive.backend.application.service;

import com.Alchive.backend.adapter.in.web.dto.response.UserResponseDTO;
import com.Alchive.backend.application.command.ChangeUserDetailCommand;
import com.Alchive.backend.application.command.SignUpCommand;
import com.Alchive.backend.application.port.in.UserUseCase;
import com.Alchive.backend.application.port.out.user.CreateUserPort;
import com.Alchive.backend.application.port.out.user.ExistUserPort;
import com.Alchive.backend.application.port.out.user.FindUserPort;
import com.Alchive.backend.application.port.out.user.UpdateUserPort;
import com.Alchive.backend.config.jwt.JwtTokenProvider;
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
    private  final JwtTokenProvider jwtTokenProvider;

    private final CreateUserPort createUserPort;
    private final FindUserPort findUserPort;
    private final ExistUserPort existUserPort;
    private final UpdateUserPort updateUserPort;
    @Transactional
    @Override
    public UserResponseDTO signUp(SignUpCommand signUpCommand) {
        // 회원가입 요청 도메인 생성
        User user = userMapper.commandToDomain(signUpCommand);
        // 비즈니스 로직 호출
        Boolean isEmailExist = existUserPort.ExistByUserEmail(user.getEmail());
        Boolean isNameExist = existUserPort.ExistByUserName(user.getName());

        user.createUser(user.getEmail(), user.getName(), isEmailExist, isNameExist);
        // 회원정보 저장
        User savedUser = createUserPort.createUser(user);

        // 토큰 발급
        String accessToken = jwtTokenProvider.createAccessToken(user.getEmail());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getEmail());

        // 저장된 회원 도메인을 응답 DTO로 변환
        return userMapper.domainToResponseDTO(savedUser, accessToken, refreshToken);
    }

    public User findByEmail(String email) {
        User user = findUserPort.findUserByEmail(email);
        return user;
    }

    @Transactional
    @Override
    public UserResponseDTO changeUserDetail(Long id, ChangeUserDetailCommand changeDescriptionCommand) {
        User targetUser = findUserPort.findById(id);

        targetUser.changeUserDetail(changeDescriptionCommand.getDescription(), changeDescriptionCommand.getAutoSave());
        // JPA update
        updateUserPort.updateUser(targetUser);

        return userMapper.domainToResponseDTO(targetUser);
    }
}
