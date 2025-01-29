package com.Alchive.backend.adapter.out.persistence.adapter;

import com.Alchive.backend.adapter.out.persistence.entity.UserEntity;
import com.Alchive.backend.adapter.out.persistence.repository.UserRepository;
import com.Alchive.backend.application.port.out.user.CreateUserPort;
import com.Alchive.backend.mapper.UserMapper;
import com.Alchive.backend.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements CreateUserPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toDomain(savedUser);
    }
}
