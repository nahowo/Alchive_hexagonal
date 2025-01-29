package com.Alchive.backend.config;

import com.Alchive.backend.adapter.out.persistence.entity.UserEntity;
import com.Alchive.backend.adapter.out.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (userRepository.count() > 0) {
            log.info("데이터가 이미 존재하므로 초기화 작업을 건너뜁니다. ");
            return;
        }
        // user
        UserEntity user1 = UserEntity.builder()
                .email("data1@gmail.com")
                .name("data1")
                .autoSave(true)
                .description("data1의 프로필입니다. ")
                .build();
        userRepository.save(user1);

        UserEntity user2 = UserEntity.builder()
                .email("data2@gmail.com")
                .name("data2")
                .autoSave(true)
                .description("data2의 프로필입니다. ")
                .build();
        userRepository.save(user2);
    }
}
