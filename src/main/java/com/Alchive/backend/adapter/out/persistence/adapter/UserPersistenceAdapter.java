package com.Alchive.backend.adapter.out.persistence.adapter;

import com.Alchive.backend.adapter.out.persistence.entity.UserEntity;
import com.Alchive.backend.adapter.out.persistence.repository.UserRepository;
import com.Alchive.backend.application.port.out.user.CreateUserPort;
import com.Alchive.backend.application.port.out.user.ExistUserPort;
import com.Alchive.backend.application.port.out.user.FindUserPort;
import com.Alchive.backend.application.port.out.user.UpdateUserPort;
import com.Alchive.backend.config.error.exception.user.NoSuchUserIdException;
import com.Alchive.backend.mapper.UserMapper;
import com.Alchive.backend.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements CreateUserPort, FindUserPort, ExistUserPort, UpdateUserPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
//        UserEntity userEntity = new UserEntity(user.getEmail(), user.getName());
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toDomain(savedUser);
    }

    @Override
    public User findUserByEmail(String email) {
        UserEntity userEntity = userRepository.findUserEntityByEmail(email)
                .orElseThrow(NoSuchUserIdException::new);
        return userMapper.toDomain(userEntity);
    }

    @Override
    public User findById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(NoSuchUserIdException::new);
        return userMapper.toDomain(userEntity);
    }

    @Override
    public Boolean ExistByUserEmail(String email) {
        return userRepository.existsUserEntityByEmail(email);
    }

    @Override
    public Boolean ExistByUserName(String name) {
        return userRepository.existsUserEntityByName(name);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user.getDescription(), user.getAutoSave(), user.getId());
    }
}
